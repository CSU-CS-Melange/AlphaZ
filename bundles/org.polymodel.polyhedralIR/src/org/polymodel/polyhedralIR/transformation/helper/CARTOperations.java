package org.polymodel.polyhedralIR.transformation.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.matrix.impl.PolymodelMatrixOperation;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

public class CARTOperations {

	private static PolymodelDefaultFactory _polyFact = PolymodelComponent.INSTANCE.getFactory();
	private static PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	
	// Option to select which mode of computation we take for kmin/kmax
	// 	* 0 = compute a kMin/kMax for every possible values of "b".
	// 	* 1 = compute a tighter kMin/kMax by assuming that "b" is "big enough".
	private static int _kMinMaxOption = 0;
	
	/**
	 * Function to change the mode of computation of kmin/kmax:
	 * 	* 0 = compute a kMin/kMax for every possible values of "b".
	 * 	* 1 = compute a tighter kMin/kMax by assuming that "b" is "big enough".
	 * 
	 * @param newOption
	 */
	public static void changekMinMaxOption(int newOption) {
		_kMinMaxOption = newOption;
	}
	
	/**
	 * Transform a domain D = { \vec{i} | ... } into a domain (probably union of poly) D' = {\vec{\alpha}, \vec{ii} | ... }
	 * 		such that \vec{i} = b.D.\vec{\alpha} + \vec{ii} where:
	 * 				* \vec{\alpha} is given by "blockInd"
	 * 				* \vec{ii} is given by "localInd"
	 * 				* \vec{\rho} (the blocked parameters) is given by "blockParam"
	 *				* \vec{pp} (the local parameters) is given by "localParam"
	 * 				* D is a diagonal matrix of positive integer coefficient, given by "scale"
	 * 				* b is the block size parameter.
	 * [Correspond to the "square case" : only one block size parameter]
	 * 
	 * In order to perform the computation of k^{min} and k^{max} correctly, we need to assume that the actual value of b
	 * 				will be greater than any values of the constant part of the constraints
	 * 
	 * @param domScalar
	 * @param blockInd
	 * @param localInd
	 * @param blockParam
	 * @param localParam
	 * @param scale
	 * @param blSizeParam
	 * @return
	 */
	public static FastISLDomain getTiledDomain(Domain domScalar, List<Variable> blockInd, List<Variable> localInd, List<Variable> blockParam, List<Variable> localParam,
			List<Integer> scale, Variable blSizeParam, boolean areParamDiv, int minBlSizeParam, List<Integer> minParamValues) {
		assert(domScalar.getNIndices()==blockInd.size());
		assert(domScalar.getNIndices()==localInd.size());
		assert(domScalar.getNIndices()==scale.size());
		assert(blockParam.size()==localParam.size());
		assert(minBlSizeParam>=1);
		assert(minParamValues.size()==blockParam.size());
		
		// Dimensions to build the corresponding domain
		EList<Variable> newParams = new BasicEList<Variable>();		// List of parameters of the newly build domain
		newParams.addAll(blockParam);
		newParams.addAll(localParam);
		newParams.add(blSizeParam);
		EList<Variable> newIndexes = new BasicEList<Variable>();		// List of indexes of the newly build domain
		newIndexes.addAll(blockInd);
		newIndexes.addAll(localInd);
		DomainDimensions domDims = _polyFact.createDomainDimensions(newIndexes, newParams);
		
		if (domScalar.getNIndices()==0) {	// The polyhedron has no dimension
			long[][] matDomLong = new long[1][2+domScalar.getNParams()+domScalar.getNIndices()];
			Matrix inputConstrDom = _polyFact.createMatrix(matDomLong);
			IntConstraintSystem inputSystem = inputConstrDom.toDomain(newParams, newIndexes);
			List<IntConstraintSystem> lSystCond = new BasicEList<IntConstraintSystem>();
			lSystCond.add(inputSystem);
			return _polyIRFact.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(domDims, lSystCond));
		}
		
		
		
		List<IntConstraintSystem> lpolyScalar = domScalar.getPMdomain().getPolyhedra();
		
		// We treat each polyhedron separately
		List<FastISLDomain> resDom = new BasicEList<FastISLDomain>();
		for (IntConstraintSystem polyScalar : lpolyScalar) {
			Matrix linConstScalConstr = _polyFact.createMatrixWithoutEqualities(polyScalar, domScalar.getIndices());	// [Linear+Constant] part at the end
			Matrix paramConstScalConstr = _polyFact.createMatrixWithoutEqualities(polyScalar, domScalar.getParams());	// [Parameter+Constant] part at the end
			
			// Getting linPart, constPart and paramPart (such that the inequality is linPart.\vec{i} + paramPart.\vec{p} + constPart \geq \vec{0} )
			long[][] linConstPart = linConstScalConstr.toLongArray();
			int[] lastColumnArray = {linConstPart[0].length-1};
			long[][] linPart = MatrixOperations.removeColumns(linConstPart, lastColumnArray);
			long[] constPart = new long[linPart.length];
			for (int i=0; i<linConstPart.length; i++)
				constPart[i] = linConstPart[i][linConstPart[0].length-1];
			long[][] paramConstPart = paramConstScalConstr.toLongArray();
			lastColumnArray[0] = paramConstScalConstr.getNbCols()-1;
			long[][] paramPart = MatrixOperations.removeColumns(paramConstPart, lastColumnArray);
			
			
			// First of all, we need to get $k^{min}$ and $k^{max}$ for every constraints.
			//		We have k^{max} = ( \sum_i Q+_i ) + ( \sum_i Qp+_i ) + |_ ( q-card(Q+)-card(Qp+) )/b _|
			//		   and  k^{min} = ( \sum_i Q-_i ) + ( \sum_i Qp-_i ) + |_ ( q+card(Q-)+card(Qp+) )/b _|
			//		=> We assume that b is big enough such that the floor expressions will be either -1 or 0.
			long[] kmax = new long[linPart.length];
			long[] kmin = new long[linPart.length];
			
			for (int i=0; i<linPart.length; i++) {
				long tempkmin = 0;		// ( \sum_i QD-_i + \sum_i Q^p-_i )
				long tempkmax = 0;		// ( \sum_i QD+_i + \sum_i Q^p+_i )
				
				for (int j=0; j<linPart[i].length; j++) {
					if (linPart[i][j]>0)
						tempkmax += scale.get(j) * linPart[i][j];
					else if (linPart[i][j]<0)
						tempkmin += scale.get(j) * linPart[i][j];
				}
				
				for (int j=0; j<blockParam.size(); j++) {
					if (paramPart[i][j]>0)
						tempkmax += paramPart[i][j];
					else if (paramPart[i][j]<0)
						tempkmin += paramPart[i][j];
				}
				
				// kmax
				if (constPart[i]-tempkmax>=0) {
					if (_kMinMaxOption==0)
						kmax[i] = tempkmax + (long) Math.floor( ((double) (constPart[i] - tempkmax)) / ((double) minBlSizeParam) );
					else
						kmax[i] = tempkmax;
				} else
					kmax[i] = tempkmax-1;
				
				// kmin
				if (constPart[i]-tempkmin>=0)
					kmin[i] = tempkmin;
				else {
					if (_kMinMaxOption==0)
						kmin[i] = tempkmin + (long) Math.floor( ((double) (constPart[i] - tempkmin)) / ((double) minBlSizeParam) );
					else
						kmin[i] = tempkmin-1;
				}
			}
			
			/* DEBUG - kmin / kmax
			System.out.println("DEBUG: kmin - kmax");
			for (int i=0; i<linPart.length; i++)
				System.out.println("kmin[" + i + "] = " + kmin[i] + "  |  kmax[" + i + "] = " + kmax[i]);
			System.out.println();
			//*/
			
			
			List<FastISLDomain> domList = new BasicEList<FastISLDomain>();
			for (int i=0; i<linPart.length; i++) {				// We consider the ith constraint (outer intersection)
				List<IntConstraintSystem> tempSyst = new BasicEList<IntConstraintSystem>();
				
				for (long k=kmin[i]+1; k<=kmax[i]; k++) {		// We consider all the different cases arising with the constraint (inner union)
					
					if (!areParamDiv) {
						// In Polylib format, the matrix of constraint is:
						//
						// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
						//
						// [ 0    Qp_i,*    0      0    Q_i,*.D   0     k   ]
						// [ 1      0     Qp_i,*  -k        0     Q     q   ]
						// [ 1      0       0      0        0     Id    0   ]
						// [ 1      0       0     D.1       0    -Id   -1   ]
						// [ 1      0       0      1        0     0   -minb ]
						// [ 1      Id      0      0        0     0   -minP ]
						//
						// First column: 1=inequality / 0 = equality
						
						long[][] blockedConstr = new long[3+blockParam.size()+2*localInd.size()]
								[3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
						
						// (First line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[0][j+1] = paramPart[i][j];
						}
						for (int j=0; j<blockInd.size(); j++)
							blockedConstr[0][j+2+blockParam.size()+localParam.size()] = linPart[i][j] * ((long) scale.get(j));
						blockedConstr[0][blockedConstr[0].length-1] = k;
						
						// (Second line)
						blockedConstr[1][0] = 1;
						for (int j=0; j<localParam.size(); j++)
							blockedConstr[1][j+1+blockParam.size()] = paramPart[i][j];
						blockedConstr[1][1+blockParam.size()+localParam.size()] = -k;
						for (int j=0; j<localInd.size(); j++)
							blockedConstr[1][2+blockParam.size()+localParam.size()+blockInd.size()+j] = linPart[i][j];
						blockedConstr[1][blockedConstr[0].length-1] = constPart[i];
						
						// (Third lines)
						for (int j=0; j<localInd.size(); j++) {
							blockedConstr[2+j][0] = 1;
							blockedConstr[2+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = 1;
						}
						
						// (Fourth lines)
						for (int j=0; j<localInd.size(); j++) {
							blockedConstr[2+localInd.size()+j][0] = 1;
							blockedConstr[2+localInd.size()+j][1+blockParam.size()+localParam.size()] = ((long) scale.get(j));
							blockedConstr[2+localInd.size()+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -1;
							blockedConstr[2+localInd.size()+j][blockedConstr[0].length-1] = -1;
						}
						
						// (Fifth line)
						blockedConstr[2+2*localInd.size()][0] = 1;
						blockedConstr[2+2*localInd.size()][1+blockParam.size()+localParam.size()] = 1;
						blockedConstr[2+2*localInd.size()][blockedConstr[0].length-1] = -minBlSizeParam;

						// (Sixth line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[3+2*localInd.size()+j][0] = 1;
							blockedConstr[3+2*localInd.size()+j][1+j] = 1;
							blockedConstr[3+2*localInd.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
						}
						
						// Go back to the matrix and get the domain from it
						Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
						IntConstraintSystem domk = blockedConstrMat.toDomain(newParams, newIndexes);
						
						/* DEBUG - domk
						System.out.println("[ Const : " + i + " - k=" + k + " ] => " + domk.toString(OUTPUT_FORMAT.ALPHABETS));
						//*/
						tempSyst.add(domk);
					} else {
						// In Polylib format, the matrix of constraint is:
						//
						// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
						//
						// [ 0    Qp_i,*    0      0    Q_i,*.D   0     k   ]
						// [ 1      0     Qp_i,*  -k        0     Q     q   ]
						// [ 1      0       0      0        0     Id    0   ]
						// [ 1      0       0     D.1       0    -Id   -1   ]
						// [ 0      0      Id      0        0     0     0   ]
						// [ 1      0       0      1        0     0   -minb ]
						// [ 1      Id      0      0        0     0   -minP ]
						//
						// First column: 1=inequality / 0 = equality
						
						long[][] blockedConstr = new long[3+2*localInd.size()+2*localParam.size()]
								[3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
						
						// (First line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[0][j+1] = paramPart[i][j];
						}
						for (int j=0; j<blockInd.size(); j++)
							blockedConstr[0][j+2+blockParam.size()+localParam.size()] = linPart[i][j] * ((long) scale.get(j));
						blockedConstr[0][blockedConstr[0].length-1] = k;
						
						// (Second line)
						blockedConstr[1][0] = 1;
						for (int j=0; j<localParam.size(); j++)
							blockedConstr[1][j+1+blockParam.size()] = paramPart[i][j];
						blockedConstr[1][1+blockParam.size()+localParam.size()] = -k;
						for (int j=0; j<localInd.size(); j++)
							blockedConstr[1][2+blockParam.size()+localParam.size()+blockInd.size()+j] = linPart[i][j];
						blockedConstr[1][blockedConstr[0].length-1] = constPart[i];
						
						// (Third lines)
						for (int j=0; j<localInd.size(); j++) {
							blockedConstr[2+j][0] = 1;
							blockedConstr[2+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = 1;
						}
						
						// (Fourth lines)
						for (int j=0; j<localInd.size(); j++) {
							blockedConstr[2+localInd.size()+j][0] = 1;
							blockedConstr[2+localInd.size()+j][1+blockParam.size()+localParam.size()] = ((long) scale.get(j));
							blockedConstr[2+localInd.size()+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -1;
							blockedConstr[2+localInd.size()+j][blockedConstr[0].length-1] = -1;
						}
						
						// (Fifth lines)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[2+2*localInd.size()+j][1+blockParam.size()+j] = 1;
						}
						
						// (Sixth line)
						blockedConstr[2+2*localInd.size()+localParam.size()][0] = 1;
						blockedConstr[2+2*localInd.size()+localParam.size()][1+blockParam.size()+localParam.size()] = 1;
						blockedConstr[2+2*localInd.size()+localParam.size()][blockedConstr[0].length-1] = -minBlSizeParam;
						
						// (Seventh line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[3+2*localInd.size()+localParam.size()+j][0] = 1;
							blockedConstr[3+2*localInd.size()+localParam.size()+j][1+j] = 1;
							blockedConstr[3+2*localInd.size()+localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
						}
						
						
						// Go back to the matrix and get the domain from it
						Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
						IntConstraintSystem domk = blockedConstrMat.toDomain(newParams, newIndexes);
						
						/* DEBUG - domk
						System.out.println("[ Const : " + i + " - k=" + k + " ] => " + domk.toString(OUTPUT_FORMAT.ALPHABETS));
						//*/
						tempSyst.add(domk);
					}
				}
				
				// * Case k = kmin
				
				if (!areParamDiv) {
					// In Polylib format, the matrix of constraint is:
					//
					// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
					//
					// [ 1    Qp_i,*     0     0    Q_i,*.D   0    kmin ]
					// [ 1      0        0     0        0     Id    0   ]
					// [ 1      0        0    D.1       0    -Id   -1   ]
					// [ 1      0        0     1        0     0   -minb ]
					// [ 1      Id      0      0        0     0   -minP ]
					//
					// First column: 1=inequality / 0 = equality
	
					long[][] blockedConstr = new long[2+2*localInd.size()+blockParam.size()]
							[3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
					
					// (First line)
					blockedConstr[0][0] = 1;
					for (int j=0; j<blockParam.size(); j++)
						blockedConstr[0][1+j] = paramPart[i][j];
					for (int j=0; j<blockInd.size(); j++)
						blockedConstr[0][2+blockParam.size()+localParam.size()+j]= linPart[i][j] * ((long) scale.get(j));
					blockedConstr[0][blockedConstr[0].length-1] = kmin[i];
					
					// (Second lines)
					for (int j=0; j<localInd.size(); j++) {
						blockedConstr[1+j][0] = 1;
						blockedConstr[1+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = 1;
					}
					
					// (Third lines)
					for (int j=0; j<localInd.size(); j++) {
						blockedConstr[1+localInd.size()+j][0] = 1;
						blockedConstr[1+localInd.size()+j][1+blockParam.size()+localParam.size()] = ((long) scale.get(j));
						blockedConstr[1+localInd.size()+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -1;
						blockedConstr[1+localInd.size()+j][blockedConstr[0].length-1] = -1;
					}
					
					// (Fourth line)
					blockedConstr[1+2*localInd.size()][0] = 1;
					blockedConstr[1+2*localInd.size()][1+blockParam.size()+localParam.size()] = 1;
					blockedConstr[1+2*localInd.size()][blockedConstr[0].length-1] = -minBlSizeParam;
					
					// (Fifth line)
					for (int j=0; j<blockParam.size(); j++) {
						blockedConstr[2+2*localInd.size()+j][0] = 1;
						blockedConstr[2+2*localInd.size()+j][1+j] = 1;
						blockedConstr[2+2*localInd.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
					}
					
					
					// Go back to the matrix and get the domain from it
					Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
					IntConstraintSystem domkMin = blockedConstrMat.toDomain(newParams, newIndexes);
					
					/* DEBUG - domkmin
					System.out.println("[ Const : " + i + " - k=" + kmin[i] + " ] => " + domkMin.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println();
					//*/
					
					tempSyst.add(domkMin);
				} else {
					// In Polylib format, the matrix of constraint is:
					//
					// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
					//
					// [ 1    Qp_i,*     0     0    Q_i,*.D   0    kmin ]
					// [ 1      0        0     0        0     Id    0   ]
					// [ 1      0        0    D.1       0    -Id   -1   ]
					// [ 0      0       Id     0        0     0     0   ]
					// [ 1      0        0     1        0     0   -minb ]
					// [ 1      Id      0      0        0     0   -minP ]
					//
					// First column: 0=inequality / 1 = equality
	
					long[][] blockedConstr = new long[2+2*localInd.size()+2*localParam.size()]
							[3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
					
					// (First line)
					blockedConstr[0][0] = 1;
					for (int j=0; j<blockParam.size(); j++)
						blockedConstr[0][1+j] = paramPart[i][j];
					for (int j=0; j<blockInd.size(); j++)
						blockedConstr[0][2+blockParam.size()+localParam.size()+j]= linPart[i][j] * ((long) scale.get(j));
					blockedConstr[0][blockedConstr[0].length-1] = kmin[i];
					
					// (Second lines)
					for (int j=0; j<localInd.size(); j++) {
						blockedConstr[1+j][0] = 1;
						blockedConstr[1+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = 1;
					}
					
					// (Third lines)
					for (int j=0; j<localInd.size(); j++) {
						blockedConstr[1+localInd.size()+j][0] = 1;
						blockedConstr[1+localInd.size()+j][1+blockParam.size()+localParam.size()] = ((long) scale.get(j));
						blockedConstr[1+localInd.size()+j][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -1;
						blockedConstr[1+localInd.size()+j][blockedConstr[0].length-1] = -1;
					}
					
					// (Fourth lines)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[1+2*localInd.size()+j][1+blockParam.size()+j] = 1;
					}
					
					// (Fifth line)
					blockedConstr[1+2*localInd.size()+localParam.size()][0] = 1;
					blockedConstr[1+2*localInd.size()+localParam.size()][1+blockParam.size()+localParam.size()] = 1;
					blockedConstr[1+2*localInd.size()+localParam.size()][blockedConstr[0].length-1] = -minBlSizeParam;
					
					// (Sixth line)
					for (int j=0; j<blockParam.size(); j++) {
						blockedConstr[2+2*localInd.size()+localParam.size()+j][0] = 1;
						blockedConstr[2+2*localInd.size()+localParam.size()+j][1+j] = 1;
						blockedConstr[2+2*localInd.size()+localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
					}
					
					// Go back to the matrix and get the domain from it
					Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
					IntConstraintSystem domkMin = blockedConstrMat.toDomain(newParams, newIndexes);
					
					/* DEBUG - domkmin
					System.out.println("[ Const : " + i + " - k=" + kmin[i] + " ] => " + domkMin.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println();
					//*/
					
					tempSyst.add(domkMin);
				}
				
				// * We form the domain
				FastISLDomain domConstr = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(domDims.copy(), tempSyst));
				
				domList.add(domConstr);
			}	// [end of the loop across all the different case of k]
			
			// At this point, we just have to take the intersection of all the polyhedra added into the list "domList".
			FastISLDomain blockedDom = domList.get(0);
			
			for (int i=1; i<domList.size(); i++)
				blockedDom = (FastISLDomain) blockedDom.intersection(domList.get(i));
			blockedDom.simplify();
			
			resDom.add(blockedDom);
		}	// [end of the loop across all the different polyhedral set inside the input domain]
		
		FastISLDomain result = resDom.get(0);
		for (int i=1; i<resDom.size(); i++)
			result = (FastISLDomain) result.union(resDom.get(i));
		// result.simplify(); TODO: avoid coalescing
		//result.simplifyInContext(context);
		
		return result;
	}
	
	/**
	 * Transform an affine function f:(i -> ... ) into a piecewise affine function \phi:(\vec{\alpha}, \vec{ii} -> ... , ... )
	 * 		such that \vec{i} = b.D.\vec{\alpha} + \vec{ii} where:
	 * 				* \vec{\alpha} is given by "blockInd"
	 * 				* \vec{ii} is given by "localInd"
	 * 				* \vec{\rho} (the blocked parameters) is given by "blockParam" and the local parameters are given by "localParam"
	 * 				* D is a diagonal matrix of positive integer coefficient, given by "scale"
	 * 				* D' is a diagonal matrix of positive integer coefficient, given by "scaleIm"
	 * 				* b is the block size parameter.
	 * [Correspond to the "square case" : only one block size parameter]
	 * 
	 * In order to perform the computation of k^{min} and k^{max} correctly, we need to assume that the actual value of b
	 * 				will be greater than any values of the constant part of the constraints
	 * 
	 * MOREOVER, this function corresponds to the polyhedral case...
	 * 
	 * @param affScalar
	 * @param blockInd
	 * @param localInd
	 * @param blockParam
	 * @param localParam
	 * @param scale
	 * @param scaleIm
	 * @param blSizeParam
	 * @return
	 */
	public static Map<FastISLDomain,FastISLMap> getTiledFunction(AffineFunction affScalar, List<Variable> blockInd, List<Variable> localInd,
			List<Variable> blockParam, List<Variable> localParam, List<Integer> scale, List<Integer> scaleIm, Variable blSizeParam, boolean areParamDiv, int minBlSizeParam) {
		assert(affScalar.getNIndices()==blockInd.size());
		assert(affScalar.getNIndices()==localInd.size());
		assert(affScalar.getNIndices()==scale.size());
		assert(affScalar.getExpressions().size()==scaleIm.size());
		assert(blockParam.size()==localParam.size());
		assert(minBlSizeParam>=1);
		
		// Dimensions (index and parameters) for the solution
		EList<Variable> lparam = new BasicEList<Variable>();
		lparam.addAll(blockParam); lparam.addAll(localParam); lparam.add(blSizeParam);
		EList<Variable> linput = new BasicEList<Variable>();
		linput.addAll(blockInd); linput.addAll(localInd);
		DomainDimensions dimDomCond = _polyFact.createDomainDimensions(linput, lparam);
		
		
		// Special case in which affScalar is (\vec{i} |-> 0 )
		if (affScalar.getExpressions().size()==0) {
			Map<FastISLDomain, FastISLMap> result = new HashMap<FastISLDomain, FastISLMap>();
			
			long[][] matDomLong = new long[1][2+affScalar.getNParams()+affScalar.getNIndices()];
			Matrix inputConstrDom = _polyFact.createMatrix(matDomLong);
			IntConstraintSystem inputSystem = inputConstrDom.toDomain(lparam, linput);
			List<IntConstraintSystem> lSystCond = new BasicEList<IntConstraintSystem>();
			lSystCond.add(inputSystem);
			FastISLDomain domCond = _polyIRFact.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(dimDomCond, lSystCond));
			
			List<IntExpression> exprFunc = new BasicEList<IntExpression>();
			Function func = _polyFact.createFunction(dimDomCond, exprFunc);
			FastISLMap affFunc = _polyIRFact.createFastISLMap(func);
			
			result.put(domCond, affFunc);
			return result;
		}
		
		Matrix affFuncMat = affScalar.getPMmapping().toMatrix();	// [ Param / Indexes / Constant ]
		
		long[][] paramPart = new long[affFuncMat.getNbRows()][affScalar.getNParams()];
		long[][] linPart = new long[affFuncMat.getNbRows()][affScalar.getNIndices()];
		long[] constPart = new long[affFuncMat.getNbRows()];
		for (int i=0; i<affFuncMat.getNbRows(); i++) {
			MatrixRow matRowi = affFuncMat.getRows().get(i);
			for (int j=0; j<affScalar.getNParams(); j++)
				paramPart[i][j] = matRowi.get(j);
			for (int j=0; j<affScalar.getNIndices(); j++)
				linPart[i][j] = matRowi.get(j+affScalar.getNParams());
			constPart[i] = matRowi.get(matRowi.getSize()-1);
		}
		
		/* DEBUG
		System.out.println("paramPart = ");
		MatrixOperations.printMatrix(paramPart);
		System.out.println("linPart = ");
		MatrixOperations.printMatrix(linPart);
		System.out.print("constPart = ");
		MatrixOperations.printVector(constPart, System.out);
		//*/
		
		
		// We compute kmin and kmax (in the same manner (and with the same limitation) than for the domains -cf comments in "getTiledDomain")
		long[] kmax = new long[linPart.length];
		long[] kmin = new long[linPart.length];
		
		for (int i=0; i<linPart.length; i++) {
			long tempkmin = 0;		// ( \sum_i QD-_i + \sum_i Q^p-_i )
			long tempkmax = 0;		// ( \sum_i QD+_i + \sum_i Q^p+_i )
			
			for (int j=0; j<linPart[i].length; j++) {
				if (linPart[i][j]>0)
					tempkmax += scale.get(j) * linPart[i][j];
				else if (linPart[i][j]<0)
					tempkmin += scale.get(j) * linPart[i][j];
			}
			for (int j=0; j<paramPart[i].length; j++) {
				if (paramPart[i][j]>0)
					tempkmax += paramPart[i][j];
				else if (paramPart[i][j]<0)
					tempkmin += paramPart[i][j];
			}
			
			// kmax
			if (constPart[i]-tempkmax>=0) {
				if (_kMinMaxOption==0)
					kmax[i] = tempkmax + (long) Math.floor( ((double) (constPart[i] - tempkmax)) / ((double) minBlSizeParam) );
				else
					kmax[i] = tempkmax;
			} else
				kmax[i] = tempkmax-1;
			
			// kmin
			if (constPart[i]-tempkmin>=0)
				kmin[i] = tempkmin;
			else {
				if (_kMinMaxOption==0)
					kmin[i] = tempkmin + (long) Math.floor( ((double) (constPart[i] - tempkmin)) / ((double) minBlSizeParam) );
				else
					kmin[i] = tempkmin-1;
			}
			
			// scaleIm management: we have to divide kmin/kmax by scaleIm[i] and take the lower bound...
			kmax[i] = (long) Math.floor( ((double) kmax[i]) / (double) scaleIm.get(i) );
			kmin[i] = (long) Math.floor( ((double) kmin[i]) / (double) scaleIm.get(i) );
		}
		/* DEBUG - kmin / kmax
		for (int i=0; i<linPart.length; i++)
			System.out.println("kmin[" + i + "] = " + kmin[i] + "  |  kmax[" + i + "] = " + kmax[i]);
		System.out.println();
		//*/
		
		
		// Now, we build our new blocked affine functions: we have a part of piece-wise affine function per \vec{k},
		//		which is: \phi(\alpha,ii) = (Q.D.\alpha + Q_p.\rho + k  ,  Q.ii + q - b.k) when  b.k <= Q.ii+q < b.(k+1)
		// Thus, we iterate on the multi-dimensional vector k
		long[] kCurr = new long[linPart.length];		// Multi-dimensional iterator
		for (int i=0; i<linPart.length; i++)
			kCurr[i] = kmin[i];
		
		Map<FastISLDomain, FastISLMap> result = new HashMap<FastISLDomain, FastISLMap>();
		
		while (kCurr[linPart.length-1]<=kmax[linPart.length-1]) {
			
			FastISLDomain cond;
			if (!areParamDiv) {
				// We build the piece-wise part corresponding to the vector "kCurr"
				// In Polylib format, the matrix of input constraints is:
				// 
				// ( eq | \rho  | pp |    b   | \alpha | ii |  const )    <= Row to know which column corresponds to what...
				// 
				// [ 1      0     Qp    -D'.k     0       Q      q     ]
				// [ 1      0    -Qp   D'.(k+1)   0      -Q    -1-q    ]
				// [ 1      0      0      0       0      Id      0     ]
				// [ 1      0      0     D.1      0     -Id     -1     ]
				// [ 1      0      0      1       0       0    -minb   ]
				// 
				// And the matrix of relations is:
				// 
				// (     \rho    |   pp   |     b    |    \alpha    | ii | const)    <= Row to know which column corresponds to what...
				//
				// [  D'^{-1}.Qp     0          0       D'^{-1}Q.D    0      k  ]
				// [      0          Qp    -D'^{-1}k        0         Q      q  ]
				//
				
				// First column: 1=inequality / 0 = equality
				long[][] inputConstrLongMat = new long[1+2*linPart.length+2*localInd.size()][3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
				
				for (int i=0; i<linPart.length; i++) {
					inputConstrLongMat[i][0] = 1;
					for (int j=0; j<paramPart[0].length;j++)
						inputConstrLongMat[i][1+blockParam.size()+j] = paramPart[i][j];
					inputConstrLongMat[i][1+blockParam.size()+localParam.size()] = -kCurr[i] * scaleIm.get(i);
					for (int j=0; j<localInd.size(); j++)
						inputConstrLongMat[i][2+blockParam.size()+localParam.size()+blockInd.size()+j] = linPart[i][j];
					inputConstrLongMat[i][inputConstrLongMat[0].length-1] = constPart[i];
				}
				for (int i=linPart.length; i<2*linPart.length; i++) {
					inputConstrLongMat[i][0] = 1;
					for (int j=0; j<paramPart[0].length; j++)
						inputConstrLongMat[i][1+blockParam.size()+j] = -paramPart[i-linPart.length][j];
					inputConstrLongMat[i][1+blockParam.size()+localParam.size()] = scaleIm.get(i-linPart.length)* ( kCurr[i-linPart.length]+1 );
					for (int j=0; j<localInd.size(); j++)
						inputConstrLongMat[i][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -linPart[i-linPart.length][j];
					inputConstrLongMat[i][inputConstrLongMat[0].length-1] = -1-constPart[i-linPart.length];
				}
				for (int i=0; i<localInd.size(); i++) {
					inputConstrLongMat[i+2*linPart.length][0] = 1;
					inputConstrLongMat[i+2*linPart.length][2+blockParam.size()+localParam.size()+blockInd.size()+i] = 1;
				}
				for (int i=0; i<localInd.size(); i++) {
					inputConstrLongMat[i+2*linPart.length+localInd.size()][0] = 1;
					inputConstrLongMat[i+2*linPart.length+localInd.size()][1+blockParam.size()+localParam.size()] = (long) scale.get(i);
					inputConstrLongMat[i+2*linPart.length+localInd.size()][2+blockParam.size()+localParam.size()+blockInd.size()+i] = -1;
					inputConstrLongMat[i+2*linPart.length+localInd.size()][inputConstrLongMat[0].length-1] = -1;
				}
				inputConstrLongMat[2*linPart.length+2*localInd.size()][0] = 1;
				inputConstrLongMat[2*linPart.length+2*localInd.size()][1+blockParam.size()+localParam.size()] = 1;
				inputConstrLongMat[2*linPart.length+2*localInd.size()][inputConstrLongMat[0].length-1] = -minBlSizeParam;
				
				/* DEBUG
				System.out.println(" * inputConstrLongMat:");
				for (int i=0; i<inputConstrLongMat.length; i++) {
					for (int j=0; j<inputConstrLongMat[0].length; j++)
						System.out.print(inputConstrLongMat[i][j] + " ");
					System.out.println();
				}
				System.out.println();
				//*/
				
				Matrix inputConstrMat = PolymodelMatrixOperation.toMatrix(inputConstrLongMat);
				IntConstraintSystem inputSystem = inputConstrMat.toDomain(lparam, linput);
				List<IntConstraintSystem> lSystCond = new BasicEList<IntConstraintSystem>();
				lSystCond.add(inputSystem);
				cond = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(dimDomCond, lSystCond));
				cond.simplify();
				
			} else {
				// We build the piece-wise part corresponding to the vector "kCurr"
				// In Polylib format, the matrix of input constraints is:
				// 
				// ( eq | \rho  | pp |    b   | \alpha | ii |  const )    <= Row to know which column corresponds to what...
				// 
				// [ 1      0     Qp    -D'.k     0       Q      q     ]
				// [ 1      0    -Qp   D'.(k+1)   0      -Q    -1-q    ]
				// [ 1      0      0      0       0      Id      0     ]
				// [ 1      0      0     D.1      0     -Id     -1     ]
				// [ 0      0     Id      0       0       0      0     ]
				// [ 1      0      0      1       0       0    -minb   ]
				// 
				// And the matrix of relations is:
				// 
				// (     \rho    |   pp   |     b    |    \alpha    | ii | const)    <= Row to know which column corresponds to what...
				//
				// [  D'^{-1}.Qp     0          0       D'^{-1}Q.D    0      k  ]
				// [      0          Qp    -D'^{-1}k        0         Q      q  ]
				//
				
				// First column: 1=inequality / 0 = equality
				long[][] inputConstrLongMat = new long[1+2*linPart.length+2*localInd.size()+blockParam.size()][3+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
				
				// (First line)
				for (int i=0; i<linPart.length; i++) {
					inputConstrLongMat[i][0] = 1;
					for (int j=0; j<paramPart[0].length;j++)
						inputConstrLongMat[i][1+blockParam.size()+j] = paramPart[i][j];
					inputConstrLongMat[i][1+blockParam.size()+localParam.size()] = -kCurr[i] * scaleIm.get(i);
					for (int j=0; j<localInd.size(); j++)
						inputConstrLongMat[i][2+blockParam.size()+localParam.size()+blockInd.size()+j] = linPart[i][j];
					inputConstrLongMat[i][inputConstrLongMat[0].length-1] = constPart[i];
				}

				// (Second line)
				for (int i=linPart.length; i<2*linPart.length; i++) {
					inputConstrLongMat[i][0] = 1;
					for (int j=0; j<paramPart[0].length; j++)
						inputConstrLongMat[i][1+blockParam.size()+j] = -paramPart[i-linPart.length][j];
					inputConstrLongMat[i][1+blockParam.size()+localParam.size()] = scaleIm.get(i-linPart.length)* ( kCurr[i-linPart.length]+1 );
					for (int j=0; j<localInd.size(); j++)
						inputConstrLongMat[i][2+blockParam.size()+localParam.size()+blockInd.size()+j] = -linPart[i-linPart.length][j];
					inputConstrLongMat[i][inputConstrLongMat[0].length-1] = -1-constPart[i-linPart.length];
				}

				// (Third line)
				for (int i=0; i<localInd.size(); i++) {
					inputConstrLongMat[i+2*linPart.length][0] = 1;
					inputConstrLongMat[i+2*linPart.length][2+blockParam.size()+localParam.size()+blockInd.size()+i] = 1;
				}
				
				// (Fourth line)
				for (int i=0; i<localInd.size(); i++) {
					inputConstrLongMat[i+2*linPart.length+localInd.size()][0] = 1;
					inputConstrLongMat[i+2*linPart.length+localInd.size()][1+blockParam.size()+localParam.size()] = (long) scale.get(i);
					inputConstrLongMat[i+2*linPart.length+localInd.size()][2+blockParam.size()+localParam.size()+blockInd.size()+i] = -1;
					inputConstrLongMat[i+2*linPart.length+localInd.size()][inputConstrLongMat[0].length-1] = -1;
				}

				// (Fifth line)
				for (int i=0; i<blockParam.size(); i++) {
					inputConstrLongMat[i+2*linPart.length+2*localInd.size()][1+blockParam.size()+i] = 1;
				}
				
				// (Sixth line)
				inputConstrLongMat[2*linPart.length+2*localInd.size()+blockParam.size()][0] = 1;
				inputConstrLongMat[2*linPart.length+2*localInd.size()+blockParam.size()][1+blockParam.size()+localParam.size()] = 1;
				inputConstrLongMat[2*linPart.length+2*localInd.size()+blockParam.size()][inputConstrLongMat[0].length-1] = -minBlSizeParam;
				
				/* DEBUG
				System.out.println(" * inputConstrLongMat:");
				for (int i=0; i<inputConstrLongMat.length; i++) {
					for (int j=0; j<inputConstrLongMat[0].length; j++)
						System.out.print(inputConstrLongMat[i][j] + " ");
					System.out.println();
				}
				System.out.println();
				//*/
				
				Matrix inputConstrMat = PolymodelMatrixOperation.toMatrix(inputConstrLongMat);
				IntConstraintSystem inputSystem = inputConstrMat.toDomain(lparam, linput);
				List<IntConstraintSystem> lSystCond = new BasicEList<IntConstraintSystem>();
				lSystCond.add(inputSystem);
				cond = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(dimDomCond, lSystCond));
				cond.simplify();
			}
			
			long[][] relationConstrLongMat = new long[2*linPart.length][2+blockParam.size()+localParam.size()+blockInd.size()+localInd.size()];
			for (int i=0; i<linPart.length; i++) {
				for (int j=0; j<blockParam.size(); j++) {
					long temp = (long) (paramPart[i][j]/scaleIm.get(i));
					if (temp*scaleIm.get(i) != paramPart[i][j])
						throw new RuntimeException("The resulting affine function has Z-polyhedral constraints (param | i = " + i + " | j = " + j + " )");
					relationConstrLongMat[i][j] = temp;
				}
				for (int j=0; j<blockInd.size(); j++) {
					long temp = (long) (linPart[i][j] * scale.get(j) / scaleIm.get(i));
					if (temp*scaleIm.get(i) != linPart[i][j] * scale.get(j))
						throw new RuntimeException("The resulting affine function has Z-polyhedral constraints (linear | i = " + i + " | j = " + j + " )");
					relationConstrLongMat[i][1+blockParam.size()+localParam.size()+j] = temp;
				}
				relationConstrLongMat[i][relationConstrLongMat[0].length-1] = kCurr[i];
			}
			for (int i=linPart.length; i<2*linPart.length; i++) {
				for (int j=0; j<paramPart[0].length;j++)
					relationConstrLongMat[i][blockParam.size()+j] = paramPart[i-linPart.length][j];
				relationConstrLongMat[i][blockParam.size()+localParam.size()] = -scaleIm.get(i-linPart.length)*kCurr[i-linPart.length];
				for (int j=0; j<localInd.size(); j++)
					relationConstrLongMat[i][1+blockParam.size()+localParam.size()+blockInd.size()+j] = linPart[i-linPart.length][j];
				relationConstrLongMat[i][relationConstrLongMat[0].length-1] = constPart[i-linPart.length];
			}
			
			/* DEBUG
			System.out.println(" * relationConstrLongMat:");
			for (int i=0; i<relationConstrLongMat.length; i++) {
				for (int j=0; j<relationConstrLongMat[0].length; j++)
					System.out.print(relationConstrLongMat[i][j] + " ");
				System.out.println();
			}
			System.out.println();
			//*/
			
			Matrix relationConstrMat = PolymodelMatrixOperation.toMatrix(relationConstrLongMat);
			List<IntExpression> exprFunc = relationConstrMat.toFunction(lparam, linput);
			Function func = _polyFact.createFunction(dimDomCond, exprFunc);
			FastISLMap affFunc = _polyIRFact.createFastISLMap(func);
			
			result.put(cond, affFunc);
			
			
			// We increase the multi-dimensional iterator, starting from the first dimension and propagating the overflows
			kCurr[0]++;
			for (int i=0; i<linPart.length-1; i++)
				if (kCurr[i]>kmax[i]) {
					kCurr[i] = kmin[i];
					kCurr[i+1]++;
				}
		} // End of multi-dimensional loop
		
		return result;
	}
	
	/* ------------------------------------------------------------------------------- */	
	
	// Auxilliary function to manage ParameterDomain (ie, domains with no indexes and only parameters)
	public static ParameterDomain getTiledParameterDomain(ParameterDomain parDom, List<Variable> blockParam, List<Variable> localParam,
			Variable blSizeParam, boolean paramDiv, int minblSizeParam, List<Integer> minParamValues) {
		assert(parDom.getNIndices()==0);
		assert(blockParam.size()==localParam.size());
		assert(minParamValues.size()==blockParam.size());
		assert(minblSizeParam>=1);
		
		List<IntConstraintSystem> lpolyScalar = parDom.getPMdomain().getPolyhedra();
		
		// We treat each polyhedron separately
		List<org.polymodel.polyhedralIR.Domain> resDom = new BasicEList<org.polymodel.polyhedralIR.Domain>();
		for (IntConstraintSystem polyScalar : lpolyScalar) {
			Matrix paramConstScalConstr = _polyFact.createMatrixWithoutEqualities(polyScalar, parDom.getParams());	// [Parameter+Constant] part at the end
			
			// Getting constPart and paramPart (such that the inequality is paramPart.\vec{p} + constPart \geq \vec{0} )
			long[][] paramConstPart = paramConstScalConstr.toLongArray();
			int[] lastColumnArray = { paramConstScalConstr.getNbCols()-1 };
			long[][] paramPart = MatrixOperations.removeColumns(paramConstPart, lastColumnArray);
			
			long[] constPart = new long[paramConstPart.length];
			for (int i=0; i<paramConstPart.length; i++)
				constPart[i] = paramConstPart[i][paramConstPart[0].length-1];
			
			
			// First of all, we need to get $k^{min}$ and $k^{max}$ for every constraints.
			//		We have k^{max} = ( \sum_i Q+_i ) + ( \sum_i Qp+_i ) + |_ ( q-card(Q+)-card(Qp+) )/b _|
			//		   and  k^{min} = ( \sum_i Q-_i ) + ( \sum_i Qp-_i ) + |_ ( q+card(Q-)+card(Qp+) )/b _|
			//		=> We assume that b is big enough such that the floor expressions will be either -1 or 0.
			long[] kmax = new long[paramPart.length];
			long[] kmin = new long[paramPart.length];
			
			for (int i=0; i<paramPart.length; i++) {
				long tempkmin = 0;		// ( \sum_i QD-_i + \sum_i Q^p-_i )
				long tempkmax = 0;		// ( \sum_i QD+_i + \sum_i Q^p+_i )
				
				for (int j=0; j<blockParam.size(); j++) {
					if (paramPart[i][j]>0)
						tempkmax += paramPart[i][j];
					else if (paramPart[i][j]<0)
						tempkmin += paramPart[i][j];
				}
				
				// kmax
				if (constPart[i]-tempkmax>=0) {
					if (_kMinMaxOption==0)
						kmax[i] = tempkmax + (long) Math.floor( ((double) (constPart[i] - tempkmax)) / ((double) minblSizeParam) );
					else
						kmax[i] = tempkmax;
				} else
					kmax[i] = tempkmax-1;
				
				// kmin
				if (constPart[i]-tempkmin>=0)
					kmin[i] = tempkmin;
				else {
					if (_kMinMaxOption==0)
						kmin[i] = tempkmin + (long) Math.floor( ((double) (constPart[i] - tempkmin)) / ((double) minblSizeParam) );
					else
						kmin[i] = tempkmin-1;
				}
			}
			
			/* DEBUG - kmin / kmax
			System.out.println("DEBUG: kmin - kmax");
			for (int i=0; i<paramPart.length; i++)
				System.out.println("kmin[" + i + "] = " + kmin[i] + "  |  kmax[" + i + "] = " + kmax[i]);
			System.out.println();
			//*/
			
			// For each constraints, we build the corresponding domain
			EList<Variable> newParams = new BasicEList<Variable>();		// List of parameters of the newly build domain
			newParams.addAll(blockParam);
			newParams.addAll(localParam);
			newParams.add(blSizeParam);
			DomainDimensions domDims = _polyFact.createDomainDimensions(new BasicEList<Variable>(), newParams);
			
			List<Domain> domList = new BasicEList<Domain>();
			for (int i=0; i<paramPart.length; i++) {				// We consider the ith constraint (outer intersection)
				List<IntConstraintSystem> tempSyst = new BasicEList<IntConstraintSystem>();
				
				for (long k=kmin[i]+1; k<=kmax[i]; k++) {		// We consider all the different cases arising with the constraint (inner union)
					
					if (!paramDiv) {
						// In Polylib format, the matrix of constraint is:
						//
						// ( eq | \rho   |  pp  |  b  | const)    <= Row to know which column corresponds to what...
						//
						// [ 0    Qp_i,*    0      0     k   ]
						// [ 1      0     Qp_i,*  -k     q   ]
						// [ 1      0       0      1   -minb ]
						// [ 1      0       Id     0      0  ]
						// [ 1      0      -Id     1     -1  ]
						// [ 1      Id      0      0   -minP ]
						//
						// First column: 1=inequality / 0 = equality
						
						long[][] blockedConstr = new long[3+3*localParam.size()][3+2*blockParam.size()];
						
						// (First line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[0][j+1] = paramPart[i][j];
						}
						blockedConstr[0][blockedConstr[0].length-1] = k;
						
						// (Second line)
						blockedConstr[1][0] = 1;
						for (int j=0; j<localParam.size(); j++)
							blockedConstr[1][j+1+blockParam.size()] = paramPart[i][j];
						blockedConstr[1][1+blockParam.size()+localParam.size()] = -k;
						blockedConstr[1][blockedConstr[0].length-1] = constPart[i];
						
						// (Third line)
						blockedConstr[2][0] = 1;
						blockedConstr[2][1+blockParam.size()+localParam.size()] = 1;
						blockedConstr[2][blockedConstr[0].length-1] = -minblSizeParam;
						
						// (Fourth line)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[3+j][0] = 1;
							blockedConstr[3+j][1+blockParam.size()+j] = 1;
						}
						
						// (Fifth line)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[3+localParam.size()+j][0] = 1;
							blockedConstr[3+localParam.size()+j][1+blockParam.size()+j] = -1;
							blockedConstr[3+localParam.size()+j][1+blockParam.size()+localParam.size()] = 1;
							blockedConstr[3+localParam.size()+j][blockedConstr[0].length-1] = -1;
						}
						
						// (Sixth line)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[3+2*localParam.size()+j][0] = 1;
							blockedConstr[3+2*localParam.size()+j][1+j] = 1;
							blockedConstr[3+2*localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
						}
						
						
						// Go back to the matrix and get the domain from it
						Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
						IntConstraintSystem domk = blockedConstrMat.toDomain(newParams, new BasicEList<Variable>());
						
						/* DEBUG - domk
						System.out.println("[ Const : " + i + " - k=" + k + " ] => " + domk.toString(OUTPUT_FORMAT.ALPHABETS));
						//*/
						tempSyst.add(domk);
					} else {
						// If [paramDiv], the constraints are, in PolyLib format:
						//
						// ( eq | \rho   |  pp  |  b  | const)    <= Row to know which column corresponds to what...
						//
						// [ 0    Qp_i,*    0      0     k   ]
						// [ 1      0     Qp_i,*  -k     q   ]
						// [ 1      0       0      1   -minb ]
						// [ 0      0       Id     0      0  ]
						// [ 1      Id      0      0   -minP ]
						
						long[][] blockedConstr = new long[3+2*localParam.size()][3+2*blockParam.size()];
						
						// (First line)
						for (int j=0; j<blockParam.size(); j++) {
							blockedConstr[0][j+1] = paramPart[i][j];
						}
						blockedConstr[0][blockedConstr[0].length-1] = k;
						
						// (Second line)
						blockedConstr[1][0] = 1;
						for (int j=0; j<localParam.size(); j++)
							blockedConstr[1][j+1+blockParam.size()] = paramPart[i][j];
						blockedConstr[1][1+blockParam.size()+localParam.size()] = -k;
						blockedConstr[1][blockedConstr[0].length-1] = constPart[i];
						
						// (Third line)
						blockedConstr[2][0] = 1;
						blockedConstr[2][1+blockParam.size()+localParam.size()] = 1;
						blockedConstr[2][blockedConstr[0].length-1] = -minblSizeParam;
						
						// (Fourth line)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[3+j][1+blockParam.size()+j] = 1;
						}
						
						// (Fifth line)
						for (int j=0; j<localParam.size(); j++) {
							blockedConstr[3+localParam.size()+j][0] = 1;
							blockedConstr[3+localParam.size()+j][1+j] = 1;
							blockedConstr[3+localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
						}
						
						
						// Go back to the matrix and get the domain from it
						Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
						IntConstraintSystem domk = blockedConstrMat.toDomain(newParams, new BasicEList<Variable>());
						
						/* DEBUG - domk
						System.out.println("[ Const : " + i + " - k=" + k + " ] => " + domk.toString(OUTPUT_FORMAT.ALPHABETS));
						//*/
						tempSyst.add(domk);
					}
				}
				
				// * Case k = kmin
				if (!paramDiv) {
					// In Polylib format, the matrix of constraint is:
					//
					// ( eq | \rho   |  pp  |  b  | const)    <= Row to know which column corresponds to what...
					//
					// [ 1    Qp_i,*     0     0    kmin ]
					// [ 1      0        0     1   -minb ]
					// [ 1      0       Id     0      0  ]
					// [ 1      0      -Id     1     -1  ]
					// [ 1      Id      0      0   -minP ]
					//
					// First column: 1=inequality / 0 = equality
					
					long[][] blockedConstr = new long[2+3*localParam.size()][3+2*blockParam.size()];
					
					// (First line)
					blockedConstr[0][0] = 1;
					for (int j=0; j<blockParam.size(); j++)
						blockedConstr[0][1+j] = paramPart[i][j];
					blockedConstr[0][blockedConstr[0].length-1] = kmin[i];
					
					// (Second line)
					blockedConstr[1][0] = 1;
					blockedConstr[1][1+blockParam.size()+localParam.size()] = 1;
					blockedConstr[1][blockedConstr[0].length-1] = -minblSizeParam;
					
					// (Third line)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[2+j][0] = 1;
						blockedConstr[2+j][1+blockParam.size()+j] = 1;
					}
					
					// (Fourth line)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[2+localParam.size()+j][0] = 1;
						blockedConstr[2+localParam.size()+j][1+blockParam.size()+j] = -1;
						blockedConstr[2+localParam.size()+j][1+blockParam.size()+localParam.size()] = 1;
						blockedConstr[2+localParam.size()+j][blockedConstr[0].length-1] = -1;
					}
					
					// (Fifth line)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[2+2*localParam.size()+j][0] = 1;
						blockedConstr[2+2*localParam.size()+j][1+j] = 1;
						blockedConstr[2+2*localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
					}
					
					// Go back to the matrix and get the domain from it
					Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
					IntConstraintSystem domkMin = blockedConstrMat.toDomain(newParams, new BasicEList<Variable>());
					
					/* DEBUG - domkmin
					System.out.println("[ Const : " + i + " - k=" + kmin[i] + " ] => " + domkMin.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println();
					//*/
					tempSyst.add(domkMin);
					
				} else {
					// If [paramDiv], the constraints are, in PolyLib format:
					//
					// ( eq | \rho   |  pp  |  b  | const)    <= Row to know which column corresponds to what...
					//
					// [ 1    Qp_i,*     0     0    kmin ]
					// [ 1      0        0     1   -minb ]
					// [ 0      0       Id     0      0  ]
					// [ 1      Id      0      0   -minP ]
					//
					// First column: 1=inequality / 0 = equality
					
					long[][] blockedConstr = new long[2+2*localParam.size()][3+2*blockParam.size()];
					
					// (First line)
					blockedConstr[0][0] = 1;
					for (int j=0; j<blockParam.size(); j++)
						blockedConstr[0][1+j] = paramPart[i][j];
					blockedConstr[0][blockedConstr[0].length-1] = kmin[i];
					
					// (Second line)
					blockedConstr[1][0] = 1;
					blockedConstr[1][1+blockParam.size()+localParam.size()] = 1;
					blockedConstr[1][blockedConstr[0].length-1] = -minblSizeParam;
					
					// (Third line)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[2+j][1+blockParam.size()+j] = 1;
					}
					
					// (Third line)
					for (int j=0; j<localParam.size(); j++) {
						blockedConstr[2+localParam.size()+j][0] = 1;
						blockedConstr[2+localParam.size()+j][1+j] = 1;
						blockedConstr[2+localParam.size()+j][blockedConstr[0].length-1] = -minParamValues.get(j);
					}
					
					
					
					// Go back to the matrix and get the domain from it
					Matrix blockedConstrMat = PolymodelMatrixOperation.toMatrix(blockedConstr);
					IntConstraintSystem domkMin = blockedConstrMat.toDomain(newParams, new BasicEList<Variable>());
					
					/* DEBUG - domkmin
					System.out.println("[ Const : " + i + " - k=" + kmin[i] + " ] => " + domkMin.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println();
					//*/
					
					tempSyst.add(domkMin);
				}
				
				
				// * We form the domain
				Domain domConstr = PolyhedralIRUserFactory.eINSTANCE.createDomain(_polyFact.createDomain(domDims.copy(), tempSyst));
				domList.add(domConstr);
			}	// [end of the loop across all the different case of k]
			
			// At this point, we just have to take the intersection of all the polyhedra added into the list "domList".
			Domain blockedDom = domList.get(0);
			
			for (int i=1; i<domList.size(); i++)
				blockedDom = blockedDom.intersection(domList.get(i));
			blockedDom.simplify();
			
			resDom.add(blockedDom);
		}	// [end of the loop across all the different polyhedral set inside the input domain]
		
		Domain result = resDom.get(0);
		for (int i=1; i<resDom.size(); i++)
			result.union(resDom.get(i));
		
		return _polyIRFact.createParameterDomain(result.getPMdomain());
	}
	
	/* -------------------------------------------------------------------------------- */
	
	// CART on polyhedron / affine function while doing an explicit indexes separation between the blocked and local indexes
	
	public static List<Pair<FastISLDomain,FastISLDomain>> getTiledDomainSplit(Domain domScalar, List<Variable> blockInd, List<Variable> localInd,
			List<Variable> blockParam, List<Variable> localParam,
			List<Integer> scale, Variable blSizeParam,
			boolean areParamDiv, int minBlSizeParam, List<Integer> minParamValues) {
		
		// Assertions on the inputs
		assert(domScalar.getNIndices()==blockInd.size());
		assert(domScalar.getNIndices()==localInd.size());
		assert(domScalar.getNIndices()==scale.size());
		assert(blockParam.size()==localParam.size());
		assert(minBlSizeParam>=1);
		assert(minParamValues.size()==blockParam.size());
		
		int nInd = domScalar.getNIndices();
		int nParam = domScalar.getNParams();
		
		
		// Dimensions to build the corresponding domains
		EList<Variable> nParamLocal = new BasicEList<Variable>();
		nParamLocal.addAll(localParam); nParamLocal.add(blSizeParam);
		DomainDimensions domDimsBlock = _polyFact.createDomainDimensions(blockInd, blockParam);
		DomainDimensions domDimsLocal = _polyFact.createDomainDimensions(localInd, nParamLocal);
		
		
		// Special case: no dimension
		if (domScalar.getNIndices()==0) {	// The polyhedron has no dimension
			FastISLDomain domBlocked = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(blockParam, blockInd).getPMdomain());
			FastISLDomain domLocal = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(nParamLocal, localInd).getPMdomain());
			
			List<Pair<FastISLDomain,FastISLDomain>> lRet = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
			lRet.add(Pair.with(domBlocked, domLocal));
			
			return lRet;
		}
		
		// We treat each polyhedron separately
		List<Pair<FastISLDomain,FastISLDomain>> resDom = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
		for (IntConstraintSystem polyScalar : domScalar.getPMdomain().getPolyhedra()) {
			
			Matrix linConstScalConstr = _polyFact.createMatrixWithoutEqualities(polyScalar, domScalar.getIndices());	// [Linear+Constant] part at the end
			Matrix paramConstScalConstr = _polyFact.createMatrixWithoutEqualities(polyScalar, domScalar.getParams());	// [Parameter+Constant] part at the end
			
			// Getting linPart, constPart and paramPart (such that the inequality is linPart.\vec{i} + paramPart.\vec{p} + constPart \geq \vec{0} )
			long[][] linConstPart = linConstScalConstr.toLongArray();
			int[] lastColumnArray = {linConstPart[0].length-1};
			long[][] linPart = MatrixOperations.removeColumns(linConstPart, lastColumnArray);
			long[] constPart = new long[linPart.length];
			for (int i=0; i<linConstPart.length; i++)
				constPart[i] = linConstPart[i][linConstPart[0].length-1];
			long[][] paramConstPart = paramConstScalConstr.toLongArray();
			lastColumnArray[0] = paramConstScalConstr.getNbCols()-1;
			long[][] paramPart = MatrixOperations.removeColumns(paramConstPart, lastColumnArray);
			
			
			// First of all, we need to get $k^{min}$ and $k^{max}$ for every constraints.
			//		We have k^{max} = ( \sum_i Q+_i ) + ( \sum_i Qp+_i ) + |_ ( q-card(Q+)-card(Qp+) )/b _|
			//		   and  k^{min} = ( \sum_i Q-_i ) + ( \sum_i Qp-_i ) + |_ ( q+card(Q-)+card(Qp+) )/b _|
			//		=> We assume that b is big enough such that the floor expressions will be either -1 or 0.
			long[] kmax = new long[linPart.length];
			long[] kmin = new long[linPart.length];
			
			for (int i=0; i<linPart.length; i++) {
				long tempkmin = 0;		// ( \sum_i QD-_i + \sum_i Q^p-_i )
				long tempkmax = 0;		// ( \sum_i QD+_i + \sum_i Q^p+_i )
				
				for (int j=0; j<linPart[i].length; j++) {
					if (linPart[i][j]>0)
						tempkmax += scale.get(j) * linPart[i][j];
					else if (linPart[i][j]<0)
						tempkmin += scale.get(j) * linPart[i][j];
				}
				
				for (int j=0; j<blockParam.size(); j++) {
					if (paramPart[i][j]>0)
						tempkmax += paramPart[i][j];
					else if (paramPart[i][j]<0)
						tempkmin += paramPart[i][j];
				}
				
				// kmax
				if (constPart[i]-tempkmax>=0) {
					if (_kMinMaxOption==0)
						kmax[i] = tempkmax + (long) Math.floor( ((double) (constPart[i] - tempkmax)) / ((double) minBlSizeParam) );
					else
						kmax[i] = tempkmax;
				} else
					kmax[i] = tempkmax-1;
				
				// kmin
				if (constPart[i]-tempkmin>=0)
					kmin[i] = tempkmin;
				else {
					if (_kMinMaxOption==0)
						kmin[i] = tempkmin + (long) Math.floor( ((double) (constPart[i] - tempkmin)) / ((double) minBlSizeParam) );
					else
						kmin[i] = tempkmin-1;
				}
			}
			
			/* DEBUG - kmin / kmax
			System.out.println("DEBUG: kmin - kmax");
			for (int i=0; i<linPart.length; i++)
				System.out.println("kmin[" + i + "] = " + kmin[i] + "  |  kmax[" + i + "] = " + kmax[i]);
			System.out.println();
			//*/
			
			
			List<List<Pair<FastISLDomain,FastISLDomain>>> domList = new BasicEList<List<Pair<FastISLDomain,FastISLDomain>>>();
			for (int i=0; i<linPart.length; i++) {				// We consider the ith constraint (outer intersection)
				List<Pair<FastISLDomain,FastISLDomain>> tempSyst = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
				
				for (long k=kmin[i]+1; k<=kmax[i]; k++) {		// We consider all the different cases arising with the constraint (inner union)
					// In Polylib format, the matrix of constraint is:
					//
					// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
					//
					// [ 0    Qp_i,*    0      0    Q_i,*.D   0     k   ]
					// [ 1     Id       0      0        0     0   -minP ]
					// [ 1      0     Qp_i,*  -k        0     Q     q   ]
					// [ 1      0       0      0        0     Id    0   ]
					// [ 1      0       0     D.1       0    -Id   -1   ]
					// [ 1      0       0      1        0     0   -minb ]
					// 
					// [ 0      0      Id      0        0     0     0   ]  (if "areParamDiv" = true)
					//
					// [ 1      0      Id      0        0     0     0   ]  (if "areParamDiv" = false)
					// [ 1      0     -Id      1        0     0    -1   ]  (if "areParamDiv" = false)
					//
					// First column: 1=inequality / 0 = equality
					
					// Constraints on \alpha
					long[][] blockedConstrBlocked = new long[1+nParam][2+nParam+nInd];
					for (int j=0; j<nParam; j++)
						blockedConstrBlocked[0][j+1] = paramPart[i][j];
					for (int j=0; j<nInd; j++)
						blockedConstrBlocked[0][j+1+nParam] = linPart[i][j] * ((long) scale.get(j));
					blockedConstrBlocked[0][blockedConstrBlocked[0].length-1] = k;
					
					for (int j=0; j<nParam; j++) {
						blockedConstrBlocked[1+j][0] = 1;
						blockedConstrBlocked[1+j][1+j] = 1;
						blockedConstrBlocked[1+j][blockedConstrBlocked[0].length-1] = -minParamValues.get(j);
					}
					
					
					// Constraints on ii
					long[][] blockedConstrLocal;
					if (areParamDiv)
						blockedConstrLocal = new long[2+2*nInd+nParam][3+nParam+nInd];
					else
						blockedConstrLocal = new long[2+2*nInd+2*nParam][3+nParam+nInd];
					
					// (First line)
					blockedConstrLocal[0][0] = 1;
					for (int j=0; j<nParam; j++)
						blockedConstrLocal[0][j+1] = paramPart[i][j];
					blockedConstrLocal[0][1+nParam] = -k;
					for (int j=0; j<nInd; j++)
						blockedConstrLocal[0][2+nParam+j] = linPart[i][j];
					blockedConstrLocal[0][blockedConstrLocal[0].length-1] = constPart[i];
					
					// (Second lines)
					for (int j=0; j<nInd; j++) {
						blockedConstrLocal[1+j][0] = 1;
						blockedConstrLocal[1+j][2+nParam+j] = 1;
					}
					
					// (Third lines)
					for (int j=0; j<nInd; j++) {
						blockedConstrLocal[1+nInd+j][0] = 1;
						blockedConstrLocal[1+nInd+j][1+nParam] = ((long) scale.get(j));
						blockedConstrLocal[1+nInd+j][2+nParam+j] = -1;
						blockedConstrLocal[1+nInd+j][blockedConstrLocal[0].length-1] = -1;
					}
					
					// (Fourth line)
					blockedConstrLocal[1+2*nInd][0] = 1;
					blockedConstrLocal[1+2*nInd][1+nParam] = 1;
					blockedConstrLocal[1+2*nInd][blockedConstrLocal[0].length-1] = -minBlSizeParam;
					
					// (areParamDiv branch case) (Fifth lines)
					if (areParamDiv)
						for (int j=0; j<nParam; j++)
							blockedConstrLocal[2+2*nInd+j][1+j] = 1;
					else {
						for (int j=0; j<nParam; j++) {
							blockedConstrLocal[2+2*nInd+j][0] = 1;
							blockedConstrLocal[2+2*nInd+j][1+j] = 1;
						}
						
						for (int j=0; j<nParam; j++) {
							blockedConstrLocal[2+2*nInd+nParam+j][0] = 1;
							blockedConstrLocal[2+2*nInd+nParam+j][1+j] = -1;
							blockedConstrLocal[2+2*nInd+nParam+j][1+nParam] = 1;
							blockedConstrLocal[2+2*nInd+nParam+j][blockedConstrLocal[0].length-1] = -1;
						}
					}
					
					List<long[][]> lMatLongDomk_Block = new BasicEList<long[][]>();
					lMatLongDomk_Block.add(blockedConstrBlocked);
					FastISLDomain domk_Block = _polyIRFact.createFastISLDomainMatLong(domDimsBlock, lMatLongDomk_Block);
					
					List<long[][]> lMatLongDomk_Local = new BasicEList<long[][]>();
					lMatLongDomk_Local.add(blockedConstrLocal);
					FastISLDomain domk_Local = _polyIRFact.createFastISLDomainMatLong(domDimsLocal, lMatLongDomk_Local);
					
					// Go back to the matrix and get the domain from it
					//Matrix blockedConstrMatBlock = PolymodelMatrixOperation.toMatrix(blockedConstrBlocked);
					//IntConstraintSystem domk_Block = blockedConstrMatBlock.toDomain((EList<Variable>) blockParam, (EList<Variable>) blockInd);
					
					//Matrix blockedConstrMatLocal = PolymodelMatrixOperation.toMatrix(blockedConstrLocal);
					//IntConstraintSystem domk_Local = blockedConstrMatLocal.toDomain(nParamLocal, (EList<Variable>) localInd);
					
					/* DEBUG - domk
					System.out.println("[ Const : " + i + " - k=" + k + " ] => " + domk_Block.toString(OUTPUT_FORMAT.ALPHABETS));
					System.out.println("                                    => " + domk_Local.toString(OUTPUT_FORMAT.ALPHABETS));
					//*/
					
					tempSyst.add(Pair.with(domk_Block, domk_Local));
				}
				
				
				// * Case k = kmin
				// In Polylib format, the matrix of constraint is:
				//
				// ( eq | \rho   |  pp  |  b  |  \alpha | ii | const)    <= Row to know which column corresponds to what...
				//
				// [ 1    Qp_i,*     0     0    Q_i,*.D   0    kmin ]
				// [ 1     Id       0      0        0     0   -minP ]
				// [ 1      0        0     0        0     Id    0   ]
				// [ 1      0        0    D.1       0    -Id   -1   ]
				// [ 1      0        0     1        0     0   -minb ]
				// 
				// [ 0      0       Id     0        0     0     0   ]  (if "areParamDiv" is true)
				//
				// [ 1      0      Id      0        0     0     0   ]  (if "areParamDiv" = false)
				// [ 1      0     -Id      1        0     0    -1   ]  (if "areParamDiv" = false)
				//
				// First column: 1=inequality / 0 = equality

				long[][] blockedConstrBlocked = new long[1+nParam][2+nParam+nInd];
				blockedConstrBlocked[0][0] = 1;
				for (int j=0; j<nParam; j++)
					blockedConstrBlocked[0][1+j] = paramPart[i][j];
				for (int j=0; j<nInd; j++)
					blockedConstrBlocked[0][1+nParam+j]= linPart[i][j] * ((long) scale.get(j));
				blockedConstrBlocked[0][blockedConstrBlocked[0].length-1] = kmin[i];
				
				for (int j=0; j<nParam; j++) {
					blockedConstrBlocked[1+j][0] = 1;
					blockedConstrBlocked[1+j][1+j] = 1;
					blockedConstrBlocked[1+j][blockedConstrBlocked[0].length-1] = -minParamValues.get(j);
				}
				
				
				
				long[][] blockedConstrLocal;
				if (areParamDiv)
					blockedConstrLocal = new long[1+2*nInd+nParam][3+nParam+nInd];
				else
					blockedConstrLocal = new long[1+2*nInd+2*nParam][3+nParam+nInd];
				
				
				// (First lines)
				for (int j=0; j<nInd; j++) {
					blockedConstrLocal[j][0] = 1;
					blockedConstrLocal[j][2+nParam+j] = 1;
				}
				
				// (Second lines)
				for (int j=0; j<nInd; j++) {
					blockedConstrLocal[nInd+j][0] = 1;
					blockedConstrLocal[nInd+j][1+nParam] = ((long) scale.get(j));
					blockedConstrLocal[nInd+j][2+nParam+j] = -1;
					blockedConstrLocal[nInd+j][blockedConstrLocal[0].length-1] = -1;
				}
				
				// (Third line)
				blockedConstrLocal[2*nInd][0] = 1;
				blockedConstrLocal[2*nInd][1+nParam] = 1;
				blockedConstrLocal[2*nInd][blockedConstrLocal[0].length-1] = -minBlSizeParam;
				
				
				// (areParamDiv branch case) ) (Fourth lines)
				if (areParamDiv)
					for (int j=0; j<nParam; j++)
						blockedConstrLocal[1+2*nInd+j][1+j] = 1;
				else {
					for (int j=0; j<nParam; j++) {
						blockedConstrLocal[1+2*nInd+j][0] = 1;
						blockedConstrLocal[1+2*nInd+j][1+j] = 1;
					}
					
					for (int j=0; j<nParam; j++) {
						blockedConstrLocal[1+2*nInd+nParam+j][0] = 1;
						blockedConstrLocal[1+2*nInd+nParam+j][1+j] = -1;
						blockedConstrLocal[1+2*nInd+nParam+j][1+nParam] = 1;
						blockedConstrLocal[1+2*nInd+nParam+j][blockedConstrLocal[0].length-1] = -1;
					}
				}
				
				// Go back to the matrix and get the domain from it
				List<long[][]> lMatLongDomk_Block = new BasicEList<long[][]>();
				lMatLongDomk_Block.add(blockedConstrBlocked);
				FastISLDomain domk_Block = _polyIRFact.createFastISLDomainMatLong(domDimsBlock, lMatLongDomk_Block);
				
				List<long[][]> lMatLongDomk_Local = new BasicEList<long[][]>();
				lMatLongDomk_Local.add(blockedConstrLocal);
				FastISLDomain domk_Local = _polyIRFact.createFastISLDomainMatLong(domDimsLocal, lMatLongDomk_Local);
				
				
				//Matrix blockedConstrMatBlock = PolymodelMatrixOperation.toMatrix(blockedConstrBlocked);
				//IntConstraintSystem domk_Block = blockedConstrMatBlock.toDomain((EList<Variable>) blockParam, (EList<Variable>) blockInd);
				
				//Matrix blockedConstrMatLocal = PolymodelMatrixOperation.toMatrix(blockedConstrLocal);
				//IntConstraintSystem domk_Local = blockedConstrMatLocal.toDomain(nParamLocal, (EList<Variable>) localInd);
				
				/* DEBUG - domk
				System.out.println("[ Const : " + i + " - k=" + kmin[i] + " ] => " + domk_Block.toString(OUTPUT_FORMAT.ALPHABETS));
				System.out.println("                                    => " + domk_Local.toString(OUTPUT_FORMAT.ALPHABETS));
				//*/
				
				tempSyst.add(Pair.with(domk_Block, domk_Local));
				
				// tempSyst: we got an union at this point
				
				
				// * We form the domains
				//List<Pair<FastISLDomain,FastISLDomain>> lTempConstrk = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();	// Union of domain corresponding to the current value of \vec{k}
				//for (Pair<FastISLDomain,FastISLDomain> pSysts : tempSyst) {
					
					//FastISLDomain domBlock = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(_polyFact.createDomain(domDimsBlock.copy(), pSysts.getValue0()));
					//FastISLDomain domLocal = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(_polyFact.createDomain(domDimsLocal.copy(), pSysts.getValue1()));
					//lTempConstrk.add(Pair.with(domBlock, domLocal));
				//}
				domList.add(tempSyst);
			}	// [end of the loop across all the different case of \vec{k} ]
			
			// At this point, we just have to take the intersection of all the polyhedra added into the list "domList".
			List<Pair<FastISLDomain,FastISLDomain>> listPairDom = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
			listPairDom = intersectionListPairDom(domList);
			
			resDom.addAll(listPairDom);
		}	// [end of the loop across all the different polyhedral set inside the input domain]
		
		return resDom;
	}
	
	public static List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> getTiledFunctionSplit(AffineFunction affScalar, List<Variable> blockInd, List<Variable> localInd,
			List<Variable> blockParam, List<Variable> localParam, List<Integer> scale, List<Integer> scaleIm, Variable blSizeParam,
			boolean areParamDiv, int minBlSizeParam, List<Integer> minParamValues) {
		assert(affScalar.getNIndices()==blockInd.size());
		assert(affScalar.getNIndices()==localInd.size());
		assert(affScalar.getNIndices()==scale.size());
		assert(affScalar.getExpressions().size()==scaleIm.size());
		assert(blockParam.size()==localParam.size());
		assert(minBlSizeParam>=1);
		assert(minParamValues.size()==blockParam.size());
		
		int nIndAnt = affScalar.getNIndices();
		int nIndIm = affScalar.getExpressions().size();
		int nParam = blockParam.size();
		
		
		// Dimensions (index and parameters) for the solution
		DomainDimensions domDimsBlock = _polyFact.createDomainDimensions(blockInd, blockParam);
		
		EList<Variable> nParamLocal = new BasicEList<Variable>();
		nParamLocal.addAll(localParam); nParamLocal.add(blSizeParam);
		DomainDimensions domDimsLocal = _polyFact.createDomainDimensions(localInd, nParamLocal);
		
		EList<Variable> lparam = new BasicEList<Variable>();
		lparam.addAll(blockParam); lparam.addAll(localParam); lparam.add(blSizeParam);
		EList<Variable> linput = new BasicEList<Variable>();
		linput.addAll(blockInd); linput.addAll(localInd);
		DomainDimensions dimDomFunc = _polyFact.createDomainDimensions(linput, lparam);
		
		
		
		// Special case in which affScalar is (\vec{i} |-> )
		if (nIndIm==0) {
			List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> result = new BasicEList<Triplet<FastISLDomain,FastISLDomain,FastISLMap>>();
			
			FastISLDomain domCondBlock = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(blockParam, blockInd).getPMdomain());
			FastISLDomain domCondLocal = _polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(nParamLocal, localInd).getPMdomain());
			
			List<IntExpression> exprFunc = new BasicEList<IntExpression>();
			Function func = _polyFact.createFunction(dimDomFunc.copy(), exprFunc);
			FastISLMap affFunc = _polyIRFact.createFastISLMap(func);
			
			result.add(Triplet.with(domCondBlock, domCondLocal, affFunc));
			return result;
		}
		
		Matrix affFuncMat = affScalar.getPMmapping().toMatrix();	// [ Param / Indexes / Constant ]
		
		long[][] paramPart = new long[nIndIm][nParam];
		long[][] linPart = new long[nIndIm][nIndAnt];
		long[] constPart = new long[nIndIm];
		for (int i=0; i<nIndIm; i++) {
			MatrixRow matRowi = affFuncMat.getRows().get(i);
			for (int j=0; j<nParam; j++)
				paramPart[i][j] = matRowi.get(j);
			for (int j=0; j<nIndAnt; j++)
				linPart[i][j] = matRowi.get(j+nParam);
			constPart[i] = matRowi.get(matRowi.getSize()-1);
		}
		
		/* DEBUG
		System.out.println("paramPart = ");
		MatrixOperations.printMatrix(paramPart);
		System.out.println("linPart = ");
		MatrixOperations.printMatrix(linPart);
		System.out.print("constPart = ");
		MatrixOperations.printVector(constPart, System.out);
		//*/
		
		
		// We compute kmin and kmax (in the same manner (and with the same limitation) than for the domains -cf comments in "getTiledDomain")
		long[] kmax = new long[linPart.length];
		long[] kmin = new long[linPart.length];
		
		for (int i=0; i<linPart.length; i++) {
			long tempkmin = 0;		// ( \sum_i QD-_i + \sum_i Q^p-_i )
			long tempkmax = 0;		// ( \sum_i QD+_i + \sum_i Q^p+_i )
			
			for (int j=0; j<linPart[i].length; j++) {
				if (linPart[i][j]>0)
					tempkmax += scale.get(j) * linPart[i][j];
				else if (linPart[i][j]<0)
					tempkmin += scale.get(j) * linPart[i][j];
			}
			for (int j=0; j<paramPart[i].length; j++) {
				if (paramPart[i][j]>0)
					tempkmax += paramPart[i][j];
				else if (paramPart[i][j]<0)
					tempkmin += paramPart[i][j];
			}
			
			// kmax
			if (constPart[i]-tempkmax>=0) {
				if (_kMinMaxOption==0)
					kmax[i] = tempkmax + (long) Math.floor( ((double) (constPart[i] - tempkmax)) / ((double) minBlSizeParam) );
				else
					kmax[i] = tempkmax;
			} else
				kmax[i] = tempkmax-1;
			
			// kmin
			if (constPart[i]-tempkmin>=0)
				kmin[i] = tempkmin;
			else {
				if (_kMinMaxOption==0)
					kmin[i] = tempkmin + (long) Math.floor( ((double) (constPart[i] - tempkmin)) / ((double) minBlSizeParam) );
				else
					kmin[i] = tempkmin-1;
			}
			
			// scaleIm management: we have to divide kmin/kmax by scaleIm[i] and take the lower bound...
			kmax[i] = (long) Math.floor( ((double) kmax[i]) / (double) scaleIm.get(i) );
			kmin[i] = (long) Math.floor( ((double) kmin[i]) / (double) scaleIm.get(i) );
		}
		/* DEBUG - kmin / kmax
		for (int i=0; i<linPart.length; i++)
			System.out.println("kmin[" + i + "] = " + kmin[i] + "  |  kmax[" + i + "] = " + kmax[i]);
		System.out.println();
		//*/
		
		
		// Now, we build our new blocked affine functions: we have a part of piece-wise affine function per \vec{k},
		//		which is: \phi(\alpha,ii) = (Q.D.\alpha + Q_p.\rho + k  ,  Q.ii + q - b.k) when  b.k <= Q.ii+q < b.(k+1)
		// Thus, we iterate on the multi-dimensional vector k
		long[] kCurr = new long[linPart.length];		// Multi-dimensional iterator
		for (int i=0; i<linPart.length; i++)
			kCurr[i] = kmin[i];
		
		List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> result = new BasicEList<Triplet<FastISLDomain,FastISLDomain,FastISLMap>>();
		
		while (kCurr[linPart.length-1]<=kmax[linPart.length-1]) {
			// We build the piece-wise part corresponding to the vector "kCurr"
			// In Polylib format, the matrix of input constraints is:
			// 
			// ( eq | \rho  | pp |    b   | \alpha | ii |  const )    <= Row to know which column corresponds to what...
			// 
			// [ 1      Id     0      0       0       0    -minP   ]
			// [ 1      0     Qp    -D'.k     0       Q      q     ]
			// [ 1      0    -Qp   D'.(k+1)   0      -Q    -1-q    ]
			// [ 1      0      0      0       0      Id      0     ]
			// [ 1      0      0     D.1      0     -Id     -1     ]
			// [ 1      0      0      1       0       0    -minb   ]
			// 
			// [ 0      0     Id      0       0       0      0     ]    (if areParamDiv = true)
			//
			// [ 1      0     Id      0       0       0      0     ]    (if areParamDiv = false)
			// [ 1      0    -Id      1       0       0     -1     ]    (if areParamDiv = false)
			
			// First column: 1=inequality / 0 = equality

			// *** Blocked constraint matrix => No constraints
			long[][] inputBlConstrLongMat = new long[nParam][2+nParam+nIndAnt];
			
			for (int j=0; j<nParam; j++) {
				inputBlConstrLongMat[j][0] = 1;
				inputBlConstrLongMat[j][1+j] = 1;
				inputBlConstrLongMat[j][inputBlConstrLongMat[0].length-1] = -minParamValues.get(j);
			}
			
			Matrix inputConstrBlMat = PolymodelMatrixOperation.toMatrix(inputBlConstrLongMat);
			IntConstraintSystem inputSystemBl = inputConstrBlMat.toDomain( (EList<Variable>) blockParam, (EList<Variable>) blockInd);
			List<IntConstraintSystem> lSystCondBl = new BasicEList<IntConstraintSystem>();
			lSystCondBl.add(inputSystemBl);
			FastISLDomain condBlock = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain((org.polymodel.Domain)_polyFact.createDomain(domDimsBlock.copy(), lSystCondBl));
			
			
			long[][] inputConstrLongMat;	// Local constraints
			if (areParamDiv)
				inputConstrLongMat= new long[1+2*nIndIm+2*nIndAnt+nParam][3+nParam+nIndAnt];
			else
				inputConstrLongMat = new long[1+2*nIndIm+2*nIndAnt+2*nParam][3+nParam+nIndAnt];
			
			// (First lines)
			for (int i=0; i<nIndIm; i++) {
				inputConstrLongMat[i][0] = 1;
				for (int j=0; j<nParam;j++)
					inputConstrLongMat[i][1+j] = paramPart[i][j];
				inputConstrLongMat[i][1+nParam] = -kCurr[i] * scaleIm.get(i);
				for (int j=0; j<nIndAnt; j++)
					inputConstrLongMat[i][2+nParam+j] = linPart[i][j];
				inputConstrLongMat[i][inputConstrLongMat[0].length-1] = constPart[i];
			}

			// (Second lines)
			for (int i=nIndIm; i<2*nIndIm; i++) {
				inputConstrLongMat[i][0] = 1;
				for (int j=0; j<nParam; j++)
					inputConstrLongMat[i][1+j] = -paramPart[i-nIndIm][j];
				inputConstrLongMat[i][1+nParam] = scaleIm.get(i-nIndIm)* ( kCurr[i-nIndIm]+1 );
				for (int j=0; j<nIndAnt; j++)
					inputConstrLongMat[i][2+nParam+j] = -linPart[i-nIndIm][j];
				inputConstrLongMat[i][inputConstrLongMat[0].length-1] = -1-constPart[i-nIndIm];
			}
			

			// (Third lines)
			for (int i=0; i<nIndAnt; i++) {
				inputConstrLongMat[i+2*nIndIm][0] = 1;
				inputConstrLongMat[i+2*nIndIm][2+nParam+i] = 1;
			}
			
			// (Fourth lines)
			for (int i=0; i<nIndAnt; i++) {
				inputConstrLongMat[i+2*nIndIm+nIndAnt][0] = 1;
				inputConstrLongMat[i+2*nIndIm+nIndAnt][1+nParam] = (long) scale.get(i);
				inputConstrLongMat[i+2*nIndIm+nIndAnt][2+nParam+i] = -1;
				inputConstrLongMat[i+2*nIndIm+nIndAnt][inputConstrLongMat[0].length-1] = -1;
			}
			
			// (Fifth lines)
			inputConstrLongMat[2*nIndIm+2*nIndAnt][0] = 1;
			inputConstrLongMat[2*nIndIm+2*nIndAnt][1+nParam] = 1;
			inputConstrLongMat[2*nIndIm+2*nIndAnt][inputConstrLongMat[0].length-1] = -minBlSizeParam;
			
			// (optional) (Sixth lines)
			if (areParamDiv)
				for (int i=0; i<nParam; i++)
					inputConstrLongMat[i+2*nIndIm+2*nIndAnt+1][1+i] = 1;
			else {
				for (int j=0; j<nParam; j++) {
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+j][0] = 1;
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+j][1+j] = 1;
				}
				
				for (int j=0; j<nParam; j++) {
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+nParam+j][0] = 1;
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+nParam+j][1+j] = -1;
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+nParam+j][1+nParam] = 1;
					inputConstrLongMat[2*nIndIm+2*nIndAnt+1+nParam+j][inputConstrLongMat[0].length-1] = -1;
				}
			}
			
			/* DEBUG
			System.out.println(" * inputConstrLongMat:");
			for (int i=0; i<inputConstrLongMat.length; i++) {
				for (int j=0; j<inputConstrLongMat[0].length; j++)
					System.out.print(inputConstrLongMat[i][j] + " ");
				System.out.println();
			}
			System.out.println();
			//*/
			
			List<long[][]> linputConstrLongMat = new BasicEList<long[][]>();
			linputConstrLongMat.add(inputConstrLongMat);
			FastISLDomain cond = _polyIRFact.createFastISLDomainMatLong(domDimsLocal, linputConstrLongMat);
			
			
			//Matrix inputConstrMat = PolymodelMatrixOperation.toMatrix(inputConstrLongMat);
			//IntConstraintSystem inputSystem = inputConstrMat.toDomain(nParamLocal, (EList<Variable>) localInd);
			//List<IntConstraintSystem> lSystCond = new BasicEList<IntConstraintSystem>();
			//lSystCond.add(inputSystem);
			//FastISLDomain cond = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(_polyFact.createDomain(domDimsLocal.copy(), lSystCond));
			//cond.simplify();
			
			
			
			// The matrix of relations is:
			// 
			// (     \rho    |   pp   |     b    |    \alpha    | ii | const)    <= Row to know which column corresponds to what...
			//
			// [  D'^{-1}.Qp     0          0       D'^{-1}Q.D    0      k  ]
			// [      0          Qp    -D'^{-1}k        0         Q      q  ]
			long[][] relationConstrLongMat = new long[2*nIndIm][2+2*nParam+2*nIndAnt];
			
			// (First line)
			for (int i=0; i<nIndIm; i++) {
				for (int j=0; j<nParam; j++) {
					long temp = (long) (paramPart[i][j]/scaleIm.get(i));
					if (temp*scaleIm.get(i) != paramPart[i][j])
						throw new RuntimeException("The resulting affine function has Z-polyhedral constraints (param | i = " + i + " | j = " + j + " )");
					relationConstrLongMat[i][j] = temp;
				}
				for (int j=0; j<nIndAnt; j++) {
					long temp = (long) (linPart[i][j] * scale.get(j) / scaleIm.get(i));
					if (temp*scaleIm.get(i) != linPart[i][j] * scale.get(j))
						throw new RuntimeException("The resulting affine function has Z-polyhedral constraints (linear | i = " + i + " | j = " + j + " )");
					relationConstrLongMat[i][1+2*nParam+j] = temp;
				}
				relationConstrLongMat[i][relationConstrLongMat[0].length-1] = kCurr[i];
			}
			
			// (Second line)
			for (int i=nIndIm; i<2*nIndIm; i++) {
				for (int j=0; j<nParam;j++)
					relationConstrLongMat[i][nParam+j] = paramPart[i-nIndIm][j];
				relationConstrLongMat[i][2*nParam] = -scaleIm.get(i-nIndIm)*kCurr[i-nIndIm];
				for (int j=0; j<nIndAnt; j++)
					relationConstrLongMat[i][1+2*nParam+nIndAnt+j] = linPart[i-nIndIm][j];
				relationConstrLongMat[i][relationConstrLongMat[0].length-1] = constPart[i-nIndIm];
			}
			
			/* DEBUG
			System.out.println(" * relationConstrLongMat:");
			for (int i=0; i<relationConstrLongMat.length; i++) {
				for (int j=0; j<relationConstrLongMat[0].length; j++)
					System.out.print(relationConstrLongMat[i][j] + " ");
				System.out.println();
			}
			System.out.println();
			//*/
			
			FastISLMap affFunc = _polyIRFact.createFastISLMapMatLong(dimDomFunc, relationConstrLongMat);
			
			//Matrix relationConstrMat = PolymodelMatrixOperation.toMatrix(relationConstrLongMat);
			//List<IntExpression> exprFunc = relationConstrMat.toFunction(lparam, linput);
			//Function func = _polyFact.createFunction(dimDomFunc.copy(), exprFunc);
			//FastISLMap affFunc = _polyIRFact.createFastISLMap(func);
			
			if (!cond.isEmpty())
				result.add(Triplet.with(condBlock,cond, affFunc));
			
			
			// We increase the multi-dimensional iterator, starting from the first dimension and propagating the overflows
			kCurr[0]++;
			for (int i=0; i<linPart.length-1; i++)
				if (kCurr[i]>kmax[i]) {
					kCurr[i] = kmin[i];
					kCurr[i+1]++;
				}
		} // End of multi-dimensional loop
		
		return result;
	}
	
	/* ---------------------------------------------------------------- */
	
	/**
	 * Takes as an input an intersection of union of [pair of domains], and get the corresponding union of pair of domains
	 * 
	 * @param lDomInput
	 * @return
	 */
	private static List<Pair<FastISLDomain,FastISLDomain>> intersectionListPairDom(List<List<Pair<FastISLDomain,FastISLDomain>>> lDomInput) {
		assert(lDomInput.size()>0);
		
		List<Pair<FastISLDomain,FastISLDomain>> lpResult = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();	// Union of pair of domain, corresponding to the result
		lpResult.add(Pair.with(
				_polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(lDomInput.get(0).get(0).getValue0().getParams(),
						lDomInput.get(0).get(0).getValue0().getIndices()).getPMdomain()),
						_polyIRFact.createFastISLDomain(PolyhedralIRUtility.createUniverseDomain(lDomInput.get(0).get(0).getValue1().getParams(),
						lDomInput.get(0).get(0).getValue1().getIndices() ).getPMdomain()) ));
		
		for (List<Pair<FastISLDomain,FastISLDomain>> pDomInputi : lDomInput) {
			List<Pair<FastISLDomain,FastISLDomain>> nlpResult = new BasicEList<Pair<FastISLDomain,FastISLDomain>>();
			
			// Intersecting
			for (Pair<FastISLDomain,FastISLDomain> pdomResult : lpResult)
				for (Pair<FastISLDomain,FastISLDomain> pdomInpi : pDomInputi)
					nlpResult.add(intersectionPairDom(pdomResult, pdomInpi));
			
			// Cleaning
			lpResult.clear();
			for (Pair<FastISLDomain,FastISLDomain> pdom : nlpResult) {
				if (!pdom.getValue0().isEmpty())
					if (!pdom.getValue1().isEmpty())
						lpResult.add(pdom);
			}
		}
		
		return lpResult;
	}
	
	public static Pair<FastISLDomain,FastISLDomain> intersectionPairDom(Pair<FastISLDomain,FastISLDomain> pdom1, Pair<FastISLDomain,FastISLDomain> pdom2) {
		FastISLDomain pdomInterbl = (FastISLDomain) pdom1.getValue0().intersection(pdom2.getValue0());
		FastISLDomain pdomInterloc = (FastISLDomain) pdom1.getValue1().intersection(pdom2.getValue1());
		//pdomInterbl.simplify();
		//pdomInterloc.simplify();
		
		return Pair.with(pdomInterbl, pdomInterloc);
	}
	
} // CARTOperations
