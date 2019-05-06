package org.polymodel.polyhedralIR.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.Function;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.util.TilableBand;

public class DetectTilableBands {
	
	public static List<TilableBand> detect(AffineSystem system) {
		DetectTilableBands dtb = new DetectTilableBands(system);
		return dtb.detect();
	}

	protected final AffineSystem system;
	protected PRDG prdg;
	
	protected DetectTilableBands(AffineSystem sytem) {
		this.system = sytem;
		this.prdg = PRDGBuilder.build(system, true);
	}
	
	private List<TilableBand> detect() {
		Map<PRDGNode, Function> schedules = new HashMap<PRDGNode, Function>();
		for (PRDGNode node : prdg.getNodes()) {
//			//TODO: Currently we are only using one level of the space time map, this has to be extended to hierarchy
			SpaceTimeMap map ;
			map = system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(node.getName());
//			if(system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(system.getVariableDeclaration(node.getName())) != null){
//				map = system.getTargetMapping().getSpaceTimeLevel(0).getStandardEquationSpaceTimeMaps().get(system.getVariableDeclaration(node.getName()));
//			}else{
//				map = system.getTargetMapping().getSpaceTimeLevel(0).getUseEquationSpaceTimeMaps().get(node.getName());
//			}
			schedules.put(node, map.getMapping().getPMmapping());
		}
		
		return org.polymodel.prdg.scheduling.util.DetectTilableBands.detect(prdg, schedules);
	}
	

	public static void printTilableBands(List<TilableBand> bands) {
		for (TilableBand band : bands) {
			System.out.println(band);
		}
	}
	
}
