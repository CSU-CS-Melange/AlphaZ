package org.polymodel.polyhedralIR.recurrence.bis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;


/**
 * 
 * @author tyuki
 *
 */
public class StateVectorUpdateForm {
//	protected SortedMap<RecurrenceVariableIdentifier, RecurrenceVariable> recurrenceVariables;
	protected List<RecurrenceVariable> recurrenceVariables;
	protected Domain scanDomain;		//scan doman, init domain is included in the vector information
	protected Semiring semiring;
	protected List<Long> scanDirection;
	protected List<VectorElement> updateVector;
	protected List<List<Expression>> coefMatrix;
	
	public StateVectorUpdateForm(){
	}
	
	
	public void ScanInfoPrint(String prefix, PrintStream out){
		List<String> varList = new ArrayList<String>(recurrenceVariables.size());
		for (RecurrenceVariable var : recurrenceVariables) {
			varList.add(var.toString());
		}
		
		out.println(prefix + "Recurrence Vars: " + varList);
		out.println(prefix + "Scan Domain    : " + scanDomain);
		out.println(prefix + "Scan Direction : " + scanDirection);
	
//		out.println(prefix + "Init Expression: ");
//		for(int i = 0; i < init_exp.size(); i++){
//			out.println(prefix + "   " + PolyhedralIRToAlphabets.toSimplifiedString(init_exp.get(i)));
//		}

		out.println(prefix + "Update Vector  : ");
		out.print(prefix + "   ");
		for (VectorElement vec : updateVector) {
			out.print(vec.toUseString() + " ");
		}
		out.println("1");
		
		out.println(prefix + "Coefficient Matrix: ");
//		out.println(prefix + "   domain: " + coefMatrix.domain);
//			out.println(prefix + "   size  : " + coef_matrix.size());
		for (List<Expression> row : coefMatrix) {
			out.print(prefix + "   ");
			for (Expression expr : row) {
				out.print(PolyhedralIRToAlphabets.toSimplifiedString(expr) + "  ");
			}
			out.println();
		}
		
		
		
//		System.out.println();
//		System.out.println("The coefficient matrix list with size: " + matrix_list.size());
//		for(int i = 0; i < matrix_list.size(); i++){
//			MatrixInformation matrixInfo = matrix_list.get(i);
//			System.out.println("The matrix domain:" + matrixInfo.getMatrixDomain());
//			Expression[][] coef_matrix = matrixInfo.getCoefficientMatrix();
//			for(int j = 0; j < coef_matrix.length; j++){
//				for(int k = 0; k < coef_matrix[j].length; k++){
//					System.out.print(PolyhedralIRToAlphabets.toSimplifiedString(coef_matrix[j][k]) + "  ");
//				}
//				System.out.println();
//			}
//		}
	}
	
	public class VectorElement {
		public final RecurrenceVariable variable;
		public final long distance;
		public final AffineFunction defFunc;
		public final AffineFunction useFunc;
		
		protected VectorElement(RecurrenceVariable var, long dist) {
			this.variable = var;
			this.distance = dist;

			defFunc = ScanUtilities.retrieveDependence(scanDomain, scanDirection, -(dist - 1));
			useFunc = ScanUtilities.retrieveDependence(scanDomain, scanDirection, -dist);
		}
		
		public String toDefString() {
			return variable.getName()+defFunc.getExpressions();
		}
		public String toUseString() {
			return variable.getName()+useFunc.getExpressions();
		}
	}

	protected void constructUpdateVector() {
		updateVector = new ArrayList<VectorElement>(recurrenceVariables.size());
		
		for (RecurrenceVariable var : recurrenceVariables) {
			for (int dist = 1; dist <= var.getMaxGCD(); dist++) {
				updateVector.add(new VectorElement(var, dist));
			}
		}
		
	}
	
	
}
