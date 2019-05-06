package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.prdg.PRDG;

public class ExportPRDG  {
	
    
	/**
	Exports the given PRDG as a dot file.
	**/
	public ExportPRDG(@IModuleArgumentName(name="prdg") PRDG prdg,
@IModuleArgumentName(name="filename") String filename) {
	    try {
		    alphaz.mde.Analysis.ExportPRDG(prdg,filename);
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
