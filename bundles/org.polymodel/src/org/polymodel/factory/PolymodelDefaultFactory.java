package org.polymodel.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.Function;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelFactory;
import org.polymodel.Relation;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.impl.DomainImpl;
import org.polymodel.impl.FunctionImpl;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixFactory;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.util.PolymodelException;

import com.google.inject.Inject;

import fr.irisa.cairn.tools.ecore.query.EMFUtils;

public class PolymodelDefaultFactory {
	@Inject
	protected PolymodelFactory factory;

	public PolymodelDefaultFactory(PolymodelFactory factory) {
		this.factory = factory;
	}

	public PolymodelDefaultFactory() {
		this(PolymodelFactory.eINSTANCE);
	}

	public <D extends Domain> D createDomain(Domain domain) {
		DomainDimensions dimensions = domain.getDimensions();
		DomainDimensions dimensionsCopy = dimensions.copy();
		D created = createDomain(dimensionsCopy);
		EList<IntConstraintSystem> polyhedra = domain.getPolyhedra();
		
		for (IntConstraintSystem intConstraintSystem : polyhedra) {
			IntConstraintSystem copy = EcoreUtil.copy(intConstraintSystem);

			for (int j = 0; j < dimensions.getExistential().size(); j++) {
				ExistentialVariable eVar = dimensions.getExistential().get(j);
				ExistentialVariable newEVar = dimensionsCopy.getExistential().get(j);
				if (!(eVar.getName().equals(newEVar.getName())))
					throw new RuntimeException();
				
				copy = copy.substitute(eVar, newEVar);
			}
			created.getPolyhedra().add(copy);
		}
		
		if (domain.getLabel() != null)
			created.setLabel(createLabel(domain.getLabel().getName()));
		return created;
	}

	@SuppressWarnings("unchecked")
	public <D extends Domain> D createDomain(DomainDimensions dims, IntConstraintSystem... systems) {
		DomainImpl d = (DomainImpl) factory.createDomain();
		d.setDimensions(dims);
		if (systems.length == 1 && systems[0] == null) {
			d.getPolyhedra();
		} else {
			Set<ExistentialVariable> existentials = new LinkedHashSet<ExistentialVariable>();
			for (IntConstraintSystem s : systems) {
				EList<AffineTerm> eAllContentsFirstInstancesOf = EMFUtils.eAllContentsFirstInstancesOf(s, AffineTerm.class);
				for (AffineTerm term : eAllContentsFirstInstancesOf)
					if (term.getVariable() instanceof ExistentialVariable)
						existentials.add((ExistentialVariable)(term.getVariable()));
				d.getPolyhedra().add(s);
			}
			d.getDimensions().getExistential().addAll(existentials);
		}
		d.setFactory(this);
		return (D) d;
	}

	public <D extends Domain> D createDomain(List<? extends Variable> dimensions, List<? extends Variable> parameters, List<ExistentialVariable> existentialVars, List<IntConstraintSystem> systems) {
		DomainDimensions ddimensions = factory.createDomainDimensions();
		if (dimensions != null)
			ddimensions.getIndices().addAll(dimensions);
		if (parameters != null)
			ddimensions.getParameters().addAll(parameters);
		if ( existentialVars != null )
			ddimensions.getExistential().addAll(existentialVars);
		return createDomain(ddimensions, systems.toArray(new IntConstraintSystem[systems.size()]));
	}

	public <D extends Domain> D createDomain(List<? extends Variable> dimensions, List<? extends Variable> parameters, IntConstraintSystem... systems) {
		DomainDimensions ddimensions = createDomainDimensions(dimensions, parameters);
		return createDomain(ddimensions, systems);
	}

	public <D extends Domain> D createDomain(List<? extends Variable> dimensions, List<? extends Variable> parameters, List<IntConstraintSystem> systems) {
		return createDomain(dimensions, parameters, systems.toArray(new IntConstraintSystem[systems.size()]));
	}

	public <D extends Domain> D createDomain(DomainDimensions dims, List<IntConstraintSystem> systems) {
		return createDomain(dims, systems.toArray(new IntConstraintSystem[systems.size()]));
	}

	public <D extends Domain> D createDomain(List<? extends Variable> dimensions, IntConstraintSystem... systems) {
		return createDomain(dimensions, null, systems);
	}

	public DomainDimensions createDomainDimensions(List<? extends Variable> dimensions, List<? extends Variable> parameters) {
		DomainDimensions ddimensions = factory.createDomainDimensions();
		if (dimensions != null)
			ddimensions.getIndices().addAll(dimensions);
		if (parameters != null)
			ddimensions.getParameters().addAll(parameters);
		return ddimensions;
	}

	@SuppressWarnings("unchecked")
	public <R extends BasicRelation> R createBasicRelation(IntConstraintSystem inputSystem, IntConstraintSystem outputSystem, IntConstraintSystem relationSystem) {
		BasicRelation relation = factory.createBasicRelation();
		relation.setInput(inputSystem);
		relation.setOutput(outputSystem);
		relation.setRelation(relationSystem);
		return (R) relation;
	}

	public <R extends BasicRelation> R createBasicRelation(BasicRelation relation) {
		IntConstraintSystem inputSystem = EcoreUtil.copy(relation.getInput());
		IntConstraintSystem outputSystem = EcoreUtil.copy(relation.getOutput());
		IntConstraintSystem relationSystem = EcoreUtil.copy(relation.getRelation());

		R created = createBasicRelation(inputSystem, outputSystem, relationSystem);
		created.setIn(EcoreUtil.copy(relation.getIn()));
		created.setOut(EcoreUtil.copy(relation.getOut()));
		return created;
	}

	public <R extends Relation> R createRelation(RelationDimensions dims, BasicRelation... basicRelations) {
		return createRelation(dims, Arrays.asList(basicRelations));
	}

	@SuppressWarnings("unchecked")
	public <R extends Relation> R createRelation(RelationDimensions dims, List<BasicRelation> basicRelations) {
		Relation relation = factory.createRelation();
		relation.setDimensions(dims);
		for (BasicRelation br : basicRelations) {
			relation.getBasicRelations().add(br);
		}

		return (R) relation;
	}


	public <R extends Relation> R createRelation(List<InputDimension> inputs, List<OutputDimension> outputs, List<? extends Variable> parameters,
			BasicRelation... basicRelations) {
		return createRelation(createRelationDimensions(inputs, outputs, parameters), basicRelations);
	}

	public <R extends Relation> R createRelation(AbstractRelation r) {
		RelationDimensions relationDim = EcoreUtil.copy(r.getDimensions());
		R created = createRelation(relationDim);
		for (BasicRelation basicRelation : r.getBasicRelations()) {
			created.getBasicRelations().add(createBasicRelation(basicRelation));
		}
		return created;
	}

	public <R extends Relation> R createRelation(DimensionsManager manager, Function f) {
		return createRelation(f, manager);
	}

	public <R extends Relation> R createRelation(Function f, DimensionsManager manager) {
		List<InputDimension> inputs = new ArrayList<InputDimension>(f.getDimensions().getIndices().size());
		for (Variable v : f.getDimensions().getIndices()) {
			inputs.add(manager.getInputDimension(v));
		}

		List<OutputDimension> outputs = 
				//f.getOutputDimensions(); //deprecated
				new ArrayList<OutputDimension>(f.getExpressionsMap().size());
		for (Entry<OutputDimension, IntExpression> e : f.getExpressionsMap()) {
			outputs.add(e.getKey());
		}
		RelationDimensions rdims = createRelationDimensions(inputs, outputs, f
				.getDimensions().getParameters(), f.getDimensions()
				.getExistential());

		IntConstraintSystem relation = IntExpressionBuilder.constraintSystem();

		for (Entry<OutputDimension, IntExpression> e : f.getExpressionsMap()) {
			IntExpression expr = e.getValue().copy();
			for (InputDimension input : inputs) {
				expr = expr.substitute(input.getDimension(), input);
			}
			expr = expr.simplify();
			IntConstraint c = IntExpressionBuilder.constraint(IntExpressionBuilder.affine(IntExpressionBuilder.term(e.getKey())), expr, ComparisonOperator.EQ);
			relation.getConstraints().add(c);
		}

		BasicRelation br = createBasicRelation(IntExpressionBuilder.constraintSystem(), IntExpressionBuilder.constraintSystem(), relation);
		if (f.getIn() != null)
			br.setIn(createLabel(f.getIn().getName()));
		if (f.getOut() != null)
			br.setOut(createLabel(f.getOut().getName()));
		R createRelation = createRelation(rdims, br);
		
		return createRelation;
	}

	public RelationDimensions createRelationDimensions(List<InputDimension> inputs, List<OutputDimension> outputs, List<? extends Variable> parameters,
			List<ExistentialVariable> existential) {
		RelationDimensions rdims = factory.createRelationDimensions();
		rdims.getInputs().addAll(inputs);
		rdims.getOutputs().addAll(outputs);
		if (existential != null)
			rdims.getExistential().addAll(existential);
		if (parameters != null)
			rdims.getParameters().addAll(parameters);
		return rdims;
	}
	
	public ExistentialVariable createExistentialVariable(String name) {
		ExistentialVariable e = factory.createExistentialVariable(); 
		e.setName(name);		
		return e;
	}

	public RelationDimensions createRelationDimensions(List<InputDimension> inputs, List<OutputDimension> outputs) {
		return createRelationDimensions(inputs, outputs, null, null);
	}

	public RelationDimensions createRelationDimensions(List<InputDimension> inputs, List<OutputDimension> outputs, List<? extends Variable> parameters) {
		return createRelationDimensions(inputs, outputs, parameters, null);
	}

	// XXX
	// public <F extends Function> F createFunction(Function f) {
	// DomainDimensions dimensions = f.getDimensions();
	// DomainDimensions dimensionsCopy = EcoreUtil.copy(dimensions);
	// F created = createFunction(dimensionsCopy);
	//
	// for (Entry<Variable, IntExpression> e : f.getExpressions()) {
	// created.getExpressions().put(e.getKey(), e.getValue().copy());
	// }
	//
	// return created;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public <F extends Function> F createFunction(DomainDimensions dim) {
	// Function f = factory.createFunction();
	// f.setDimensions(dim);
	// f.getExpressions();
	// return (F) f;
	// }
	//
	// /**
	// * Create a function from an array defining the transformation expression
	// * for each input variable. Format of the array is
	// * <code>{inputVariable1,functionForInputVariable1,...}</code>
	// *
	// * @param dimensions
	// * @param relations
	// * Relations from input to output variables.
	// * @return
	// */
	// public <F extends Function> F createFunction(DomainDimensions dimensions,
	// Object relations[]) {
	// Map<OutputDimension, IntExpression> relationsMap = new
	// HashMap<OutputDimension, IntExpression>();
	//
	// try {
	// for (int i = 0; i < relations.length; i = i + 2) {
	// OutputDimension d = (OutputDimension) relations[i];
	// IntExpression value = (IntExpression) relations[i + 1];
	// relationsMap.put(d, value);
	// }
	// } catch (Exception e) {
	// throw new IllegalArgumentException(
	// "Illegal relation array. Format is {inputVariable1,functionForInputVariable1,...}");
	// }
	// return createFunction(dimensions, relationsMap);
	// }
	//
	// /**
	// *
	// * @param dims
	// * DimensionManager containing variables in indices
	// * @param indices
	// * Variables that will be used as input of the function
	// * @param exprsList
	// * Value of the output dimensions of the function.
	// * @return
	// */
	// public <F extends Function> F createFunction(
	// List<Variable> indices,
	// DimensionsManager dims,
	// List<IntExpression> exprsList) {
	//
	// //get output dimensions
	// List<OutputDimension> outDims = new
	// ArrayList<OutputDimension>(exprsList.size());
	// for (int i = 0; i < exprsList.size(); i++) {
	// outDims.add(dims.getOutputDimension(dims.getDimension(i)));
	// }
	//
	// //get input dimensions
	// List<InputDimension> inDims = new
	// ArrayList<InputDimension>(indices.size());
	// for (int i = 0; i < indices.size(); i++) {
	// inDims.add(dims.getInputDimension(indices.get(i)));
	// }
	//
	// //creat relation dimensions object
	// RelationDimensions rd = createRelationDimensions(inDims, outDims,
	// dims.getParameters());
	//
	// //create map associating output dimensions with their values
	// Map<OutputDimension, IntExpression> relationsMap = new
	// HashMap<OutputDimension, IntExpression>();
	// for (int i = 0; i < exprsList.size(); i++) {
	//
	// //replace occurrences of input variable in expression by their
	// InputDimension
	// IntExpression intExpression = exprsList.get(i);
	// for (Variable v : indices) {
	// intExpression = intExpression.substitute(v, dims.getInputDimension(v));
	// }
	//
	// relationsMap.put(outDims.get(i), intExpression);
	// }
	//
	// //delegate to another constructor
	// return createFunction(rd,relationsMap);
	// }
	//
	// @SuppressWarnings("unchecked")
	// public <F extends Function> F createFunction(DomainDimensions dimensions,
	// Map<Variable, IntExpression> relations) {
	// F function = (F) factory.createFunction();
	// IntConstraint constraints[] = new IntConstraint[relations.size()];
	// int i = 0;
	// for (Entry<OutputDimension, IntExpression> entry : relations.entrySet())
	// {
	// OutputDimension variable = entry.getKey();
	// IntExpression value = entry.getValue();
	// assert (checkFunctionValue(dimensions, value)) : "Expression "
	// + value + " isn't a valid relation for "
	// + variable.getName();
	// constraints[i] = eq(affine(term(1, variable)), value);
	// i++;
	// }
	// function.setDimensions(dimensions);
	// BasicRelation r = createBasicRelation(constraintSystem(),
	// constraintSystem(), constraintSystem(constraints));
	// function.getBasicRelations().add(r);
	// return function;
	// }
	//
	// /**
	// * Create a function from a variable mapping such as {i -> i + j ; j -> i}
	// * for example. Input and outputs variables are obtained from the
	// * {@link DimensionsManager}.
	// *
	// * @param manager
	// * @param relations
	// * @return
	// */
	// public <F extends Function> F createFunction(DimensionsManager manager,
	// Map<Variable, IntExpression> relations) {
	// return createFunction(manager, relations, new ArrayList<Variable>());
	// }
	//
	// /**
	// * Create a function from a variable mapping such as {i -> i + j ; j -> i}
	// * for example. Input and outputs variables are obtained from the
	// * {@link DimensionsManager}.
	// *
	// * @param manager
	// * @param relations
	// * @param parameters
	// * @return
	// */
	// public <F extends Function> F createFunction(DimensionsManager manager,
	// Map<Variable, IntExpression> relations, List<Variable> parameters) {
	// List<InputDimension> inputs = new ArrayList<InputDimension>();
	// List<OutputDimension> outputs = new ArrayList<OutputDimension>();
	//
	// // Create the map where each variable is replaced by the corresponding
	// // input variable
	// Map<OutputDimension, IntExpression> relationsMap = new
	// HashMap<OutputDimension, IntExpression>();
	//
	// for (Variable i : manager.getDimensions()) {
	// IntExpression value = relations.get(i);
	// if (value != null) {
	// InputDimension input = manager.getInputDimension(i);
	// inputs.add(input);
	// OutputDimension output = manager.getOutputDimension(i);
	// outputs.add(output);
	// }
	// }
	//
	// for (Entry<Variable, IntExpression> entry : relations.entrySet()) {
	// IntExpression value = entry.getValue().copy();
	// List<Variable> variables = EMFUtils.getAllReferencesOfType(value,
	// Variable.class);
	// for (Variable v : variables) {
	// EcoreUpdater.updateCrossReferencesInHierarchy(value, v,
	// manager.getInputDimension(v));
	// }
	// OutputDimension output = manager.getOutputDimension(entry.getKey());
	// relationsMap.put(output, value);
	// }
	//
	// RelationDimensions dimensions = createRelationDimensions(inputs,
	// outputs, parameters);
	// return createFunction(dimensions, relationsMap);
	// }
	// XXX

	public <F extends Function> F createFunction(Function f) {
		DomainDimensions dimensions = f.getDimensions();
		DomainDimensions dimensionsCopy = EcoreUtil.copy(dimensions);
		F created = createFunction(dimensionsCopy);
		for (Entry<OutputDimension, IntExpression> e : f.getExpressionsMap()) {
			created.getExpressionsMap().put(e.getKey(), e.getValue().copy());
		}
		if (f.getIn() != null)
			created.setIn(f.getIn().copy());
		if (f.getOut() != null)
			created.setOut(f.getOut().copy());
		return created;
	}

	@SuppressWarnings("unchecked")
	public <F extends Function> F createFunction(DomainDimensions dims) {
		FunctionImpl f = (FunctionImpl) factory.createFunction();
		f.setDimensions(dims.copy());
		f.getExpressionsMap();
		f.setFactory(this);
		return (F) f;
	}

	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends Variable> parameters) {
		DomainDimensions dims = createDomainDimensions(indices, parameters);
		return createFunction(dims);
	}

	/**
	 * Creates a function that associates to each OutputDimension in func an
	 * expression of the indices and parameters in the DomainDimensions. Make
	 * sure the Map is ordered.
	 */
	public <F extends Function> F createFunction(DomainDimensions dims, Map<OutputDimension, IntExpression> func, String in, String out) {
		F res = createFunction(dims);
		
		for (Entry<OutputDimension, IntExpression> e : func.entrySet()) {
			res.getExpressionsMap().put(e.getKey(), e.getValue().copy());
		}
		if (in != null)
			res.setIn(createLabel(in));
		if (out != null)
			res.setOut(createLabel(out));
		return (F) res;
	}

	public <F extends Function> F createFunction(DomainDimensions dims, Map<OutputDimension, IntExpression> func) {
		return createFunction(dims, func, null, null);
	}

	public <F extends Function> F createFunction(DomainDimensions dims, List<IntExpression> exprs, DimensionsManager manager, String in, String out) {
		Map<OutputDimension, IntExpression> func = new LinkedHashMap<OutputDimension, IntExpression>(exprs.size());
		int i;
		for (i = 0; i < exprs.size(); i++) {
			OutputDimension outputDimension = manager.getOutputDimension(manager.getDimension(i));
			IntExpression value = exprs.get(i);
			func.put(outputDimension, value);
		}
		return createFunction(dims, func, in, out);
	}

	public <F extends Function> F createFunction(DomainDimensions dims, List<IntExpression> exprs, DimensionsManager manager) {
		return createFunction(dims, exprs, manager, null, null);
	}

	public <F extends Function> F createFunction(DomainDimensions dims, List<IntExpression> exprs, String in, String out) {
		return createFunction(dims, exprs, PolymodelComponent.INSTANCE.getDefaultDimensionsManager(), in, out);
	}

	public <F extends Function> F createFunction(DomainDimensions dims, List<IntExpression> exprs) {
		return createFunction(dims, exprs, null, null);
	}

	/**
	 * Create a function using default {@link DimensionsManager} of
	 * {@link PolymodelComponent}. It map each expression to the index variable
	 * of the same rank.
	 * 
	 * @param indices
	 * @param parameters
	 * @param exprs
	 * @return
	 */
	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends Variable> parameters, List<IntExpression> exprs) {
		DomainDimensions dims = createDomainDimensions(indices, parameters);
		return createFunction(dims, exprs);
	}

	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends Variable> parameters, List<IntExpression> exprs,
			DimensionsManager manager) {
		DomainDimensions dims = createDomainDimensions(indices, parameters);
		return createFunction(dims, exprs, manager);
	}

	public <F extends Function> F createFunction(List<? extends Variable> indices, List<IntExpression> exprs, DimensionsManager manager) {
		DomainDimensions dims = createDomainDimensions(indices, null);
		return createFunction(dims, exprs, manager);
	}

	/**
	 * Creates a function that associates to each OutputDimension in func
	 * mapping an expression of the indices and parameters. Make sure the Map is
	 * ordered.
	 * 
	 * @param indices
	 * @param parameters
	 * @param func
	 *            map the output dimensions to their definition
	 * @return
	 */
	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends Variable> parameters, Map<OutputDimension, IntExpression> func) {
		DomainDimensions dims = createDomainDimensions(indices, parameters);
		return createFunction(dims, func);
	}

	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends OutputDimension> outputs, List<? extends Variable> parameters, List<IntExpression> func) {
		return createFunction(indices, outputs, parameters, func,null,null);
	}

	public <F extends Function> F createFunction(List<? extends Variable> indices, List<? extends OutputDimension> outputs, List<? extends Variable> parameters, List<IntExpression> func, String in, String out) {
		int size = func.size();
		if (outputs.size() != size) 
			throw new IllegalArgumentException("");
		
		DomainDimensions dims = createDomainDimensions(indices, parameters);
		
		Map<OutputDimension,IntExpression> fMap = new LinkedHashMap<OutputDimension, IntExpression>(size);
		for (int i = 0; i < size; i++) {
			fMap.put(outputs.get(i), func.get(i));
		}
		
		return createFunction(dims, fMap, in,out);
	}

	public DimensionsManager createDimensionsManager() {
		return factory.createDimensionsManager();
	}

	public Label createLabel(String label) {
		Label createdLabel = factory.createLabel();
		createdLabel.setName(label);
		return createdLabel;
	}

	public Matrix createMatrix(int nbRows, int nbCols) {
		Matrix matrix = MatrixFactory.eINSTANCE.createMatrix();
		for (int i = 0; i < nbRows; ++i) {
			MatrixRow r = MatrixFactory.eINSTANCE.createMatrixRow();
			for (int j = 0; j < nbCols; ++j) {
				r.getValues().add(0L);
			}
			matrix.getRows().add(r);
		}
		return matrix;
	}
	
	public Matrix createMatrix(long[][] A) {
		if (A == null || A.length == 0) {
//			throw new RuntimeException("Empty matrix");
			return MatrixFactory.eINSTANCE.createMatrix();
		}
		
		int nRow = A.length;
		int nCol = A[0].length;
		
		Matrix mat = MatrixFactory.eINSTANCE.createMatrix();
		for (int i = 0; i < nRow; i++) {
			MatrixRow row = MatrixFactory.eINSTANCE.createMatrixRow();
			for (int j = 0; j < nCol; j++) {
				row.getValues().add(A[i][j]);
			}
			mat.getRows().add(row);
		}
		
		return mat;
	}
	
	public MatrixRow createMatrixRow(int nbCols) {
		MatrixRow r = MatrixFactory.eINSTANCE.createMatrixRow();
		for (int j = 0; j < nbCols; ++j) {
			r.getValues().add(0L);
		}
		return r;
	}

	public Matrix createMatrixWithoutEqualities(IntConstraintSystem system, List<? extends Variable> variables) {

		Matrix matrix = MatrixFactory.eINSTANCE.createMatrix();
		for (IntConstraint c : system.getConstraints()) {
			boolean isEquation = false;
			if (c.getComparisonOperator() == ComparisonOperator.EQ) {
				isEquation = true;
			} else if (c.getComparisonOperator() != ComparisonOperator.GE) {
				throw new RuntimeException("Unexpected operator " + c.getComparisonOperator());
			}
			MatrixRow row = MatrixFactory.eINSTANCE.createMatrixRow();
			matrix.getRows().add(row);
			for (int i = 0; i < variables.size() + 1; i++) {
				row.getValues().add(0L);
			}
			AffineExpression affine = c.getLhs().toAffine();
			for (int i = 0; i < variables.size(); i++) {
				Variable var = variables.get(i);
				AffineTerm term = affine.getTerm(var);
				if (term != null)
					row.getValues().set(i, term.getCoef());
			}
			// constant part
			if (affine.getTerm(null) != null) {
				row.getValues().set(variables.size(), affine.getTerm(null).getCoef());
			}
			// Add another row with negated values for equality
			if (isEquation) {
				MatrixRow negRow = MatrixFactory.eINSTANCE.createMatrixRow();
				matrix.getRows().add(negRow);
				for (int i = 0; i < row.getSize(); i++) {
					negRow.getValues().add(row.getValues().get(i) * -1);
				}
			}

		}
		return matrix;
	}
	
	/**
	 * Constructs a matrix representing the given constraint system using
	 * polylib format.
	 * 
	 * Each row represents a constraint of the system. First column is either
	 * 0/1 and the constraint is a equality when 0 and inequality (>) when 1.
	 * The last column is the constants. All other columns correspond to
	 * variables. The order of the variables reflects the list given at
	 * construction.
	 * 
	 * @param system
	 * @param variables
	 * @return
	 */
	public Matrix createMatrix(IntConstraintSystem system, List<? extends Variable> variables) {

		List<IntConstraint> constraints = new ArrayList<IntConstraint>();
		for (IntConstraint c : system.getConstraints()) {
			IntConstraint transformed = removeRightSide(c.copy()).simplify();		// simplify() takes lots of time
			//IntConstraint transformed = RemoveRightSideTransformation.transform(c).simplify();
			if (transformed.getComparisonOperator() == ComparisonOperator.NE) {
				throw new PolymodelException("Unable to create the matrix row for " + c);
			} else {
				constraints.add(transformed);
			}
		}
		return createMatrix(constraints, variables);
	}
	
	// Faster version of RemoveRightSideTransformation
	private static IntConstraint removeRightSide(IntConstraint c) {
		IntConstraint constr = c.copy();
		switch (constr.getComparisonOperator()) {
		case EQ:
			return IntExpressionBuilder.eqz(IntExpressionBuilder.sub(constr.getLhs(), constr.getRhs()));
		case NE:
			return IntExpressionBuilder.constraint(IntExpressionBuilder.sub(constr.getLhs(), constr.getRhs()),
					IntExpressionBuilder.affine(IntExpressionBuilder.constant(0)), ComparisonOperator.NE);
		case GE:
			return IntExpressionBuilder.gez(IntExpressionBuilder.sub(constr.getLhs(), constr.getRhs()));
		case GT:
			return IntExpressionBuilder.gez(IntExpressionBuilder.sub(constr.getLhs(),
					IntExpressionBuilder.add(constr.getRhs(),1)) );
		case LE:
			return IntExpressionBuilder.gez(IntExpressionBuilder.sub(constr.getRhs(), constr.getLhs()));
		case LT:
			return IntExpressionBuilder.gez(IntExpressionBuilder.sub(constr.getRhs(),
					IntExpressionBuilder.add(constr.getLhs(),1)) );
		default:
			throw new RuntimeException("removeRightSide : the operator of the constraint is unknown");
		}
	}
	

	/**
	 * Create a matrix assuming that there is no NE constraints and that the RHS
	 * has been removed.
	 * 
	 * @param constraints
	 * @param variables
	 * @return
	 */
	private static Matrix createMatrix(List<IntConstraint> constraints, List<? extends Variable> variables) {
		Matrix matrix = MatrixFactory.eINSTANCE.createMatrix();
		for (IntConstraint c : constraints) {
			boolean isEquation = false;
			if (c.getComparisonOperator() == ComparisonOperator.EQ) {
				isEquation = true;
			}
			MatrixRow row = MatrixFactory.eINSTANCE.createMatrixRow();
			matrix.getRows().add(row);
			for (int i = 0; i < variables.size() + 2; i++) {
				row.getValues().add(0L);
			}
			row.getValues().set(0, isEquation ? 0L : 1L);
			AffineExpression affine = c.getLhs().toAffine();
			for (int i = 0; i < variables.size(); i++) {
				Variable var = variables.get(i);
				AffineTerm term = affine.getTerm(var);
				if (term != null)
					row.getValues().set(i + 1, term.getCoef());
			}
			// constant part
			if (affine.getTerm(null) != null) {
				row.getValues().set(variables.size() + 1, affine.getTerm(null).getCoef());
			}

		}
		return matrix;
	}

	public Relation createIdentityRelationFromDomain(Domain set, DimensionsManager manager) {
		List<InputDimension> inputs = manager.getInputsDimensionsFor(set.getDimensions().getIndices());
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(set.getDimensions().getIndices());
		RelationDimensions rdim = createRelationDimensions(inputs, outputs, set.getDimensions().getParameters());

		IntConstraintSystem inputSystem = IntExpressionBuilder.constraintSystem();
		IntConstraintSystem outputSystem = IntExpressionBuilder.constraintSystem();
		IntConstraintSystem relationSystem = IntExpressionBuilder.constraintSystem();

		for (int d = 0; d < inputs.size(); d++) {
			relationSystem.getConstraints().add(
					IntExpressionBuilder.constraint(IntExpressionBuilder.affine(IntExpressionBuilder.term(inputs.get(d))),
							IntExpressionBuilder.affine(IntExpressionBuilder.term(outputs.get(d))), ComparisonOperator.EQ));
		}

		return createRelation(rdim, createBasicRelation(inputSystem, outputSystem, relationSystem));
	}

}
