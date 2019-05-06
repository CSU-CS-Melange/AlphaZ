package org.polymodel.polyhedralIR.recurrence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class ScanInformations {
	private List<VariableDeclaration> target_list;
	private List<VectorInformation> updating_vector;
	private List<MatrixInformation> matrix_list;
	private List<Expression> init_exp;
	private Domain scan_domain;
	private Map<String, List<VectorInformation>> init_domain_map;
	private OP oplus;
	private OP otimes;
	private int size;	//the size of the matrix
	private List<Vector<Long>> directions;
	private int[][] optimization_matrix;
	
	public ScanInformations(){
			target_list = new LinkedList<VariableDeclaration>();
			updating_vector = new LinkedList<VectorInformation>();
			init_exp = new LinkedList<Expression>();
			init_domain_map = new HashMap<String, List<VectorInformation>>();
			matrix_list = new LinkedList<MatrixInformation>();
			optimization_matrix = null;
	}
	
	public VectorInformation createVector(VariableDeclaration var, AffineFunction dependence, int gcd, Domain domain){
		VectorInformation vec = new VectorInformation(var, dependence, gcd, domain);
		
		return vec;
	}

	//add the setting function
	
	
	//set the optimization matrix
	public void addOptimizationMatrix(int[][] matrix){
		optimization_matrix = matrix;
	}
	
	//set the scan target
	public void addTarget(VariableDeclaration target){
		target_list.add(target);
	}
	
	public void addTarget(List<VariableDeclaration> list){
		for(VariableDeclaration var: list){
			target_list.add(var);
		}
	}
	
	//add updating vector information
	public void addUpdatingVector(VariableDeclaration var, AffineFunction dependence, int gcd, Domain domain){
		VectorInformation vec = new VectorInformation(var, dependence, gcd, domain);
		updating_vector.add(vec);
	}
	
	public void addUpdatingVector(List<VectorInformation> _vectors){
		updating_vector.addAll(_vectors);
	}
	
	//add the coefficient matrix information
	public void addCoefficientMatrix(Domain matrix_domain, Expression[][] coef_matrix){
		MatrixInformation matrixInfo = new MatrixInformation(matrix_domain, coef_matrix);
		matrix_list.add(matrixInfo);
	}
	
	
	//set the initial value expression
	public void addInitialExpression(List<Expression> init){
		for(Expression exp : init){
			init_exp.add(exp);
		}
	}
	
	//set the scan domain
	public void addScanDomain(Domain scan){
		scan_domain = scan;
	}
	
	//set the initial value domain
	public void addInitialDoamin(Map<String, List<VectorInformation>> domainMap){
		init_domain_map = domainMap;
	}
	
	public void addOPlus(OP plus){
		oplus = plus;
	}
	
	public void addOTimes(OP times){
		otimes = times;
	}
	
	public void addSize(int m){
		size = m;
	}
	
	public void addDirections(List<Vector<Long>> dir){
		directions = dir;
	}
	
	//get information
	//get the optimization matrix
	public int[][] getOptimizationMatrix(){
		return optimization_matrix;
	}
	
	public List<VariableDeclaration> getTargetList(){
		return target_list;
	}
	
	//get updating vector information
	public List<VectorInformation> getUpdatingVector(){
		return updating_vector;
	}
	
	//get coefficient matrix list
	public List<MatrixInformation> getCoefficientMatrixList(){
		return matrix_list;
	}
	
	//get initial expression
	public List<Expression> getInitialExpression(){
		return init_exp;
	}
	
	//get scan domain
	public Domain getScanDomain(){
		return scan_domain;
	}
	
	//get initial domain
	public Map<String, List<VectorInformation>> getInitialDomain(){
		return init_domain_map;
	}
	
	//get the oplus operator
	public OP getOPlus(){
		return oplus;
	}
	
	//get the otimes operator
	public OP getOTimes(){
		return otimes;
	}
	
	//get the matrix size
	public int getMatrixSize(){
		return size;
	}
	
	//get the direction list
	public List<Vector<Long>> getDirections(){
		return directions;
	}
	
	public MatrixInformation createMatrixInformation(Domain matrix_dom, Expression[][] matrix){
		MatrixInformation matrixInfo = new MatrixInformation(matrix_dom, matrix);
		return matrixInfo;
	}
	
	public void ScanInfoPrint(){
		System.out.println("The Scan Variables: ");
		for(int i = 0; i < target_list.size(); i++){
			System.out.print(target_list.get(i).getName() + "  ");
		}
		System.out.println();
		System.out.println("Semiring: " + oplus + ", " + otimes);
		System.out.println("The coefficient matrix list with size: " + matrix_list.size());
		for(int i = 0; i < matrix_list.size(); i++){
			MatrixInformation matrixInfo = matrix_list.get(i);
			System.out.println("The matrix domain:" + matrixInfo.getMatrixDomain());
			Expression[][] coef_matrix = matrixInfo.getCoefficientMatrix();
			System.out.println("the coefficient matrix size: " + coef_matrix.length);
			for(int j = 0; j < coef_matrix.length; j++){
				for(int k = 0; k < coef_matrix[j].length; k++){
					System.out.print(PolyhedralIRToAlphabets.toSimplifiedString(coef_matrix[j][k]) + "  ");
				}
				System.out.println();
			}
		}
		
		
		System.out.println();
		System.out.println("initial expression");
		
		for(int i = 0; i < init_exp.size(); i++){
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(init_exp.get(i)));
		}
		
		System.out.println();
		System.out.println("current updating vector");
		
		for(int i = 0; i < updating_vector.size(); i++){
			VectorInformation vec = updating_vector.get(i);
			System.out.println("Variable :" + vec.getVar().getName() + " Dependence : " + vec.getDependence() + " GCD: " + vec.getGCD() + " Domain: "+ vec.getDomian());
		}
		
		System.out.println();
		System.out.println("Scan Domain: " + scan_domain);
		
		System.out.println("The initial Domain Map");
		for (Map.Entry<String, List<VectorInformation>> v : init_domain_map.entrySet()) {
		    System.out.println(v.getKey());
		    for (VectorInformation vi : v.getValue()) {
		    	System.out.println("   " + vi.getVar() + " " +  vi.getDomian() + " " + vi.getDependence());
		    }
		}
	}
	
	public class VectorInformation{
		private VariableDeclaration var;
		private AffineFunction dependence;
		private int gcd;
		private Domain domain;
		
		public VectorInformation(VariableDeclaration var, AffineFunction dependence, int gcd, Domain domain){
			this.var = var;
			this.dependence = dependence;
			this.gcd = gcd;
			this.domain = domain;
		}
		
		public VariableDeclaration getVar(){
			return var;
		}
		
		public AffineFunction getDependence(){
			return dependence;
		}
		
		public int getGCD(){
			return gcd;
		}
		
		public Domain getDomian(){
			return domain;
		}
	}
	
	public class MatrixInformation{
		private Domain domain;
		private Expression[][] coef_matrix;
		
		public MatrixInformation(Domain domain, Expression[][] coef_matrix){
			this.domain = domain;
			this.coef_matrix = coef_matrix;
		}
		
		public Domain getMatrixDomain(){
			return domain;
		}
		
		public Expression[][] getCoefficientMatrix(){
			return  coef_matrix;
		}
	}
	
}