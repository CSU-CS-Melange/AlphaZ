package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetMinParamValues  {
	
    
	/**
	Set the minimum blocked parameter values, before the tiling transformation.
The default value is "0" for every parameters.
	**/
	public SetMinParamValues(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="paramName") String paramName,
@IModuleArgumentName(name="minValue") int minValue) {
	    try {
		    alphaz.mde.transformation.MonoparametricTiling.setMinParamValues(prog,syst,paramName,minValue);
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
