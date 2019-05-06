package org.polymodel.polyhedralIR.polyIRCG.generator.C.scan;

import java.util.List;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;

public class ScanCodeGenInfo {
	private AffineSystem scanBodySystem;	//transformed subsystem used for the final scan
	private AffineSystem reductionBodySystem;	//transformed subsystem used for the reduction phase
	private AffineSystem mainBodySystem;	//transformed subsystem used for the main scan 
	private List<VariableDeclaration> outputVector;	
	private List<VariableDeclaration> inputVector;
	private List<Expression> init_vector;
	private List<scanOutput> scanOutVec;
	private List<scanOutput> initScanOutVec;
	private Domain scan_domain;
	private OP oplus;
	private OP otimes;
	private int m_size;
	
	public ScanCodeGenInfo(){	
	}
	
	//set the properties
	public void setScanBodySystem(AffineSystem scan){
		scanBodySystem = scan;
	}
	
	public void setReductionBodySystem(AffineSystem reduction){
		reductionBodySystem = reduction;
	}
	
	public void setMainBodySystem(AffineSystem body){
		mainBodySystem = body;
	}
	
	public void setOutputVector(List<VariableDeclaration> vec){
		outputVector = vec;
	}
	
	public void setInputVector(List<VariableDeclaration> vec){
		inputVector = vec;
	}
	
	public void setInitVector(List<Expression> vec){
		init_vector = vec;
	}
	
	public void setInitScanOutVec(List<scanOutput> initOutVector){
		initScanOutVec = initOutVector;
	}
	
	public void setScanOutput(List<scanOutput> scanOutVector){
		scanOutVec = scanOutVector;
	}
	
	public void setDomain(Domain domain){
		scan_domain = domain;
	}
	
	public void setOPlus(OP plus){
		oplus = plus;
	}
	
	public void setOtimes(OP times){
		otimes = times;
	}
	
	public void setSize(int m){
		m_size = m;
	}
	
	//get the properties
	public AffineSystem getScanBodySystem (){
		return scanBodySystem;
	}
	
	public AffineSystem getReductionBodySystem(){
		return reductionBodySystem;
	}
	
	public AffineSystem getMainBodySystem(){
		return mainBodySystem;
	}
	
	public List<VariableDeclaration> getInputVector(){
		return inputVector;
	}
	
	public List<VariableDeclaration> getOutputVector(){
		return outputVector;
	}
	
	public List<Expression> getInitVector(){
		return init_vector;
	}
	
	public List<scanOutput> getScanOutVector(){
		return scanOutVec;
	}
	
	public List<scanOutput> getInitScanOutVector(){
		return initScanOutVec;
	}
	
	public OP getOPlus(){
		return oplus;
	}
	
	public OP getOTimes(){
		return otimes;
	}
	
	public Domain getDomain(){
		return scan_domain;
	}
	
	public int getSize(){
		return m_size;
	}
	
	//set some interface for scanOutput
	public scanOutput newScanOutput(VariableDeclaration _var, AffineFunction _func){
		scanOutput out = new scanOutput(_var, _func);
		return out;
	}
	
	public class scanOutput{
		private VariableDeclaration var;
		private AffineFunction func;
		
		public scanOutput(VariableDeclaration _var, AffineFunction _func){
			var = _var;
			func = _func;
		}
		
		public VariableDeclaration getVar(){
			return var;
		}
		
		public AffineFunction getFunc(){
			return func;
		}
	}
}
