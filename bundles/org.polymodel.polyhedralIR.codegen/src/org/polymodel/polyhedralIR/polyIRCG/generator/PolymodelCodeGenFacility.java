package org.polymodel.polyhedralIR.polyIRCG.generator;


import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.Relation;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.bridge.clast.JNIClastToScopModel;

import fr.irisa.cairn.jnimap.cloog.jni.CloogException;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastRoot;
import fr.irisa.cairn.jnimap.cloog.jni.JNICloogOptions;
import fr.irisa.cairn.jnimap.cloog.jni.JNICloogState;
import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;
import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;

/**
 * This class was copied from what was previously implemented in prefetch project.
 * Something like this probably should go in to its own project.
 * 
 * @author yuki
 *
 */
public class PolymodelCodeGenFacility {
	
	private static final PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	
	public static class CodeGenStatement {

		public final String name;
		public final Domain domain;
		public final AbstractRelation schedule;
		
		public CodeGenStatement(String name, Domain domain, AbstractRelation schedule) {
			this.name = name;
			this.domain = domain.simplify();
			this.schedule = schedule;
		}
		
		public AbstractRelation getScattering() {
			AbstractRelation scattering = schedule.intersectDomain(domain);
			for (BasicRelation br : scattering.getBasicRelations()) {
				br.setIn(factory.createLabel(name));
			}
			return scattering;
		}
	}
	
	public static ScopRoot generate(DimensionsManager manager, Domain context, List<CodeGenStatement> statements) {
		CloogOptionSpecifier options = CloogOptionSpecifier.getDefault();
		options.otl = 1;
		options.strides = 1;
		
		return generate(manager, context, statements, options);
	}
	
	public static ScopRoot generate(DimensionsManager manager, Domain context, List<CodeGenStatement> statements, CloogOptionSpecifier options) {
		String ctxStr = PolymodelPrettyPrinter.print(context, OUTPUT_FORMAT.ISL);
		
		List<ISLMap> scatterings = new ArrayList<ISLMap>();
		int order = 0;
		for (CodeGenStatement stmt : statements) {
			scatterings.add(addConstantDimension(manager, stmt.getScattering(), order));
			order++;
		}
		String scanDomainStr = ISLNativeBinder.islUnionMap(scatterings).toString();
		//simplify TODO no need to go through string twice
		scanDomainStr = ISLFactory.islUnionMap(scanDomainStr).coalesce().toString();
		JNICloogState state = JNICloogState.malloc();

		JNIClastRoot root = null;
		try {
			JNICloogOptions opts = options.getJNIObject(state);
			root = (JNIClastRoot) JNIClastRoot.fromUnionMap(state, opts,
					ctxStr, scanDomainStr);
//			root.pprint(opts);
			opts.free();
//			System.out.println(ClastPrettyPrinter.pp(root));
			
		} catch (CloogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JNIClastToScopModel.adapt(root);
	}


	@Deprecated
	public static ISLMap addConstantDimension(DimensionsManager manager, AbstractRelation relation, int constant) {
		return addConstantDimension(manager, relation, relation.getNbOutputs(), constant);
	}
	
	@Deprecated
	public static ISLMap addConstantDimension(DimensionsManager manager, AbstractRelation relation, int dimension, int constant) {

		List<OutputDimension> origOutputDims   = relation.getDimensions().getOutputs();
		IntConstraintSystem inputSystem = IntExpressionBuilder.constraintSystem();
		IntConstraintSystem outputSystem = IntExpressionBuilder.constraintSystem();
		IntConstraintSystem relationSystem = IntExpressionBuilder.constraintSystem();
		
		List<Variable> inputs = new ArrayList<Variable>(origOutputDims.size());
		List<Variable> outputs = new ArrayList<Variable>(origOutputDims.size()+1);
		for (OutputDimension outDim : origOutputDims) {
			inputs.add(outDim.getDimension());
			outputs.add(outDim.getDimension());
		}
		List<InputDimension> inputDims = manager.getInputsDimensionsFor(inputs);
		List<OutputDimension> outputDims = manager.getOutputsDimensionsFor(outputs);
		//add another dimension for outputs
		OutputDimension lastDim = manager.getOutputDimension(manager.getDimension(outputDims.size(), "last"));
		outputDims.add(lastDim);
		
		//all dimensions in the original space are equated
		for (int d = 0; d < inputDims.size(); d++) {
			//equated dimension depends on where the new dimension is inserted
			int equatedDim = (d<dimension)?d:d+1;
			
			relationSystem.getConstraints().add(constraint(
					affine(term(inputDims.get(d))),
					affine(term(outputDims.get(equatedDim))),
							ComparisonOperator.EQ));
		}
		
		
		//equate the inserted dim with specified constant
		relationSystem.getConstraints().add(constraint(
				affine(term(outputDims.get(dimension))),
				affine(term(constant)),
						ComparisonOperator.EQ));

		RelationDimensions rdim = factory.createRelationDimensions(
				inputDims, outputDims, relation.getDimensions().getParameters());
		BasicRelation baseRel = factory.createBasicRelation(inputSystem, outputSystem, relationSystem);
		Relation relT = factory.createRelation(rdim, baseRel);
		
		return applyRange(manager, relation, relT);
	}

	@Deprecated
	public static ISLMap applyRange(DimensionsManager manager, AbstractRelation map1, AbstractRelation map2) {
		//TODO remove once the method is introduced in the model
		JNIISLMap jniMap1 = ISLNativeBinder.jniIslMapNoString(map1);
		JNIISLMap jniMap2 = ISLNativeBinder.jniIslMapNoString(map2);
		JNIISLMap jniRes = JNIISLMap.applyRange(jniMap1, jniMap2);
		return ISLNativeBinder.islMap(jniRes, manager);
	}
}