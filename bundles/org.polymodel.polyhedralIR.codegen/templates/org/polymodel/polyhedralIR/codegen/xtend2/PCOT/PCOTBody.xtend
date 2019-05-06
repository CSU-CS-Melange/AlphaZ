package org.polymodel.polyhedralIR.codegen.xtend2.PCOT

import java.util.ArrayList
import java.util.Comparator
import java.util.List
import java.util.Set
import java.util.TreeSet
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
import org.polymodel.polyhedralIR.polyIRCG.Function
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody
import org.polymodel.polyhedralIR.polyIRCG.Struct

/**
 * 
 * 
 * Note: some +1 to the band index is because tile bands are indexed from 0,
 *       but tile parameters starts from 1.
 */
class PCOTBody extends BaseBody {
		
	def dispatch code(RecursionBody body){
		//assumes no multi-level PCOT 
		val recurS = body.recurStructs.get(0)
		val tileWidth = body.tileWidth(recurS);
		
		'''
			//Return if width of the orthant is 0
			if («body.bandRange.join(" || ", [i|tileWidth.get(i).eq0])») {
				return;
			}
			
			//Call the base function
			if («body.bandRange.join(" && ", [i|body.TwLETs(tileWidth, i)])») {
				«body.baseFunction.fcall»
				return;
			}

			//Recursion
			
			//Half Tile Width
			«FOR i : body.bandRange»
				«body.htw(tileWidth, i)»
			«ENDFOR»
			
			//Recurse
			«body.recursionCalls(recurS)»
			
		'''
	}
	
	def eq0 (AbstractVariable p) '''«p.name» == 0'''
	
	//Tile width less than or equal to Tile size
	def TwLETs(RecursionBody rb, List<AbstractVariable> tileWidth, int i) {
		'''«tileWidth.get(i).name» <= «rb.tileSizes.get(i)»'''
	}
	
	def fcall(Function f) {
		'''«f.name»(«f.parameters.join(", ", [p|p.name])»);'''
	}
	
	def htw(RecursionBody rb, List<AbstractVariable> tileWidth, int dim) {
		val ts  = rb.tileSizes.get(dim);
		val tw =  tileWidth.get(dim).name;
		
		'''int «halfTW(dim)» = («tw» > «ts») ? «tw»/2 : «tw»;'''
	}
	
	def recursionCalls(RecursionBody rb, Struct recurS) {
		val range = rb.bandRange;
		val maxDim = recurS.maxBandWidth;
		val product = new TreeSet<List<Boolean>>(
			//This comparator sorts by the lex. order of the boolean vector
			// that denote which side of the half space the recursion corresponds to
			// prepended by the number of 'true' in the vector. (which = WF time)
			new Comparator<List<Boolean>> () {
				override compare(List<Boolean> o1, List<Boolean> o2) {
					val o1count = o1.filter[x|x].size;
					val o2count = o2.filter[x|x].size;
					
					val o1str = o1count + o1.toString();
					val o2str = o2count + o2.toString();
					
					return o1str.compareTo(o2str);
				}
			}
		);
		
		productRecur(product, maxDim, range, new ArrayList<Boolean>());
		
		'''
			«FOR wf : (0..maxDim)»
				«FOR c : product.filter([p|p.filter[x|x].size==wf])»
					«rb.recursionCall(recurS, c)» 
				«ENDFOR»
				«IF rb.parallel»#pragma omp taskwait«ENDIF»
			«ENDFOR»
		'''
	}
	
	
	def recursionCall(RecursionBody rb, Struct recurS, List<Boolean> side) {
		val tileWidth = rb.tileWidth(recurS);
		val tileIndex = rb.tileIndex(recurS);
		'''
		«IF rb.parallel»#pragma omp task«ENDIF»
		{
			«recurS.name» «newRecur» = «curRecur»;
		«FOR s : side.indexed.filter[x|x.value==true]» «val ti = tileIndex.get(s.key).name»
			«newRecur».«ti» = «curRecur».«ti» + «halfTW(s.key)»;
		«ENDFOR»
		«FOR s : side.indexed» «val tw = tileWidth.get(s.key).name»
			«IF s.value»
				«newRecur».«tw» = «curRecur».«tw» - «halfTW(s.key)»;
			«ELSE»
				«newRecur».«tw» = «halfTW(s.key)»;
			«ENDIF»
		«ENDFOR»
			«rb.function.name»(«rb.function.parameters.join(", ", [p|if (p.name.contentEquals(curRecur)) { newRecur } else { p.name } ])»);
		}
		'''
	}
	
	private def curRecur() '''recurStruct'''
	private def newRecur() '''newRecur'''
	private def halfTW(int dim) '''htw«dim+1»'''
	
	private def bandRange(RecursionBody rb) { return (rb.bandStart .. rb.bandEnd); }
	private def maxBandWidth(Struct recurS) {
		return recurS.members.length/2;
	}
	private def tileWidth(RecursionBody rb, Struct recurS) {
		val bandWidth = recurS.maxBandWidth
		val tileWidth = recurS.members.subList(rb.bandStart+bandWidth, rb.bandEnd+bandWidth+1)
		return tileWidth;
	}
	private def tileIndex(RecursionBody rb, Struct recurS) {
		val tileIndex = recurS.members.subList(rb.bandStart, rb.bandEnd+1)
		return tileIndex;
	}
	
	private def void productRecur(Set<List<Boolean>> result, int maxDim, IntegerRange range, List<Boolean> current) {
		if (maxDim == current.size) {
			result.add(current);
			return;
		}
		
		if (range.contains(current.size)) {
			val next = new ArrayList<Boolean>();
			next.addAll(current);
			next.add(true);
			productRecur(result, maxDim, range, next);
		}
		{
			val next = new ArrayList<Boolean>();
			next.addAll(current);
			next.add(false);
			productRecur(result, maxDim, range, next);
			
		}
		return;
	}
}