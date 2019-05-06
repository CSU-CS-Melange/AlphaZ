package org.polymodel.prdg.scheduling;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.util.JNIUnionMapBuilderFromPRDG;
import org.polymodel.prdg.scheduling.util.JNIUnionMapBuilderFromPRDG.Pair;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSchedule;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSchedule.JNIISLSchedulingOptions;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

public class AdvancedISLScheduler implements IPRDGScheduler {

	protected JNIISLSchedulingOptions options;

	public AdvancedISLScheduler() {
		JNIISLSchedulingOptions options = new JNIISLSchedulingOptions();
		this.options = options;
	}
	
	public AdvancedISLScheduler(JNIISLSchedulingOptions options) {
		this.options = options;
	}
	
	@Override
	public EList<ScheduledStatement> schedule(PRDG prdg)
			throws SchedulingException {
		if (prdg.getNodes().size() < 1) {
			System.err.println("Warning : given PRDG has 0 node.");
			return new BasicEList<ScheduledStatement>(0);
		}
		
		// build isl PRDG and domains
		Pair isl = JNIUnionMapBuilderFromPRDG.build(prdg);
		JNIISLUnionMap islPRDG = isl.prdg;	//.reverse();
		JNIISLUnionSet islDomains = isl.domains;
		
		JNIISLSchedule sched = JNIISLSchedule.computeSchedule(islDomains, islPRDG, options);
		
		// call ISL built-in Pluto scheduler
		JNIISLUnionMap islSchedule = sched.getMap();
//				JNIISLSchedule.computePlutoSchedule(islDomains, islPRDG).getMap();
		if (!islSchedule.isSingleValued()){
			throw new RuntimeException("Schedule is not single valued.");
		}

		BasicEList<ScheduledStatement> res = new BasicEList<ScheduledStatement>(prdg.getNodes().size());
		SchedulingConcreteFactory schedulingConcreteFactory = new SchedulingConcreteFactory();
		// build list of schedule statement from isl union map
		List<JNIISLMap> maps = islSchedule.getMaps();
		for (JNIISLMap map : maps) {

			String stmtID = map.getTupleName(JNIISLDimType.isl_dim_in);
			PRDGNode node = prdg.getNode(stmtID);			

			if (map.getNbBasicMaps() != 1 || !map.isSingleValued()) {
				throw new RuntimeException();
			}
			JNIISLBasicMap bmap = map.getBasicMapAt(0);
			EList<Variable> indices = node.getDomain().getDimensions().getIndices();
			EList<Variable> params = node.getDomain().getDimensions().getParameters();
			Map<ISLSet, List<IntExpression>> mapping = ISLNativeBinder.mapping(bmap, indices, params);
			
			if (mapping.size() != 1)
				throw new RuntimeException();
			List<IntExpression> schedule = mapping.entrySet().iterator().next().getValue();
			
			ScheduledStatement s = schedulingConcreteFactory.createScheduledStatement(node, schedule);
			res.add(s);
		}
		return res;
	}
	
	// Special management of projection functions before sending it to pluto
	public JNIISLSchedule schedulePluto(PRDG prdg) throws SchedulingException {
		if (prdg.getNodes().size() < 1)
			throw new RuntimeException("Given PRDG has 0 node");
		
		// build isl PRDG and domains
		Pair isl = JNIUnionMapBuilderFromPRDG.buildPluto(prdg);						// <<<<======= MODIF HERE
		JNIISLUnionMap islPRDG = isl.prdg;
		JNIISLUnionSet islDomains = isl.domains;
		
		// DEBUG
		//System.out.println("[AdvancedISLScheduler] islConstraints = " + islPRDG.toString());
		//System.out.println("[AdvancedISLScheduler] islDomain = " + islDomains.toString());
		
		JNIISLSchedule sched = JNIISLSchedule.computeSchedule(islDomains, islPRDG, options);
		
		return sched;
	}
	
}
