package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetSpaceTimeMapForUseEquationOptimization  {
	
    
	/**
	set the space time map for the memory allocation, value copy, memory allocation statement for the input/output of the useEuqation.
isInput -- 0: for the input of the useEquation
isInput -- 1: for the output of the useEquation
	**/
	public SetSpaceTimeMapForUseEquationOptimization(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num,
@IModuleArgumentName(name="stMapForMemoryAllocation") AffineFunction stMapForMemoryAllocation,
@IModuleArgumentName(name="stMapForValueCopy") AffineFunction stMapForValueCopy,
@IModuleArgumentName(name="stMapForMemoryFree") AffineFunction stMapForMemoryFree) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForUseEquationOptimization(program,system,label,isInput,num,stMapForMemoryAllocation,stMapForValueCopy,stMapForMemoryFree);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	TODO : add description (to the model)
	**/
	public SetSpaceTimeMapForUseEquationOptimization(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num, @IModuleArgumentName(name="stMapForMemoryAllocation") String stMapForMemoryAllocation,
@IModuleArgumentName(name="stMapForValueCopy") String stMapForValueCopy,
@IModuleArgumentName(name="stMapForMemoryFree") String stMapForMemoryFree) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForUseEquationOptimization( program, system, label, isInput, num,  stMapForMemoryAllocation, stMapForValueCopy, stMapForMemoryFree);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public void compute(){
		
	}
}//endclass
