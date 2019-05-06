package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.IntExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;

public class PCOTFunctionInfo {
	private Map<Integer, List<IntExpression>> boundingBox;
	private Map<Integer, List<IntExpression>> convexHull;
	ScopRoot sroot;
	private PCOTBand currentBand;
	private PCOTBand previousBand;
	private String sysName;
	private int blockId;
	private ScopFor outer;
	private List<ScopFor> inner;
	private List<AbstractScopNode> body;
	
	private Map<String, Integer> loopVars;
	
	
//	public PCOTFunctionInfo(Map<Integer, List<IntExpression>> boundingBox,
//			ScopRoot sroot, PCOTBand currentBand, PCOTBand previousBand,
//			String sysName, int blockId) {
//		super();
//		this.boundingBox = boundingBox;
//		this.sroot = sroot;
//		this.currentBand = currentBand;
//		this.previousBand = previousBand;
//		this.sysName = sysName;
//		this.blockId = blockId;
//	}
//	
//	public PCOTFunctionInfo(Map<Integer, List<IntExpression>> boundingBox,
//			AbstractScopNode scopNode, PCOTBand currentBand, PCOTBand previousBand,
//			String sysName, int blockId) {
//		super();
//		this.boundingBox = boundingBox;
//		ScopRoot sroot = ScopUserFactory.scopFactory.createScopRoot();
//		sroot.getStatements().add(scopNode);
//		this.sroot = sroot;
//		this.currentBand = currentBand;
//		this.previousBand = previousBand;
//		this.sysName = sysName;
//		this.blockId = blockId;
//	}
	
	public PCOTFunctionInfo(PCOTBand currentBand, PCOTBand previousBand, 
			String sysName, int blockId) {
		super();
		this.currentBand = currentBand;
		this.previousBand = previousBand;
		this.sysName = sysName;
		this.blockId = blockId;
		this.inner = new ArrayList<ScopFor>();
		this.body = new ArrayList<AbstractScopNode>();
//		this.convexHull = new HashMap<Integer, List<IntExpression>>();
	}
	
	public PCOTFunctionInfo(Map<Integer, List<IntExpression>> boundingBox, 
			PCOTBand currentBand, PCOTBand previousBand, String sysName, int blockId) {
		super();
		this.boundingBox = boundingBox;
		this.currentBand = currentBand;
		this.previousBand = previousBand;
		this.sysName = sysName;
		this.blockId = blockId;
		this.inner = new ArrayList<ScopFor>();
		this.body = new ArrayList<AbstractScopNode>();
//		this.convexHull = new HashMap<Integer, List<IntExpression>>();
	}

	public Map<Integer, List<IntExpression>> getConvexHull() {
		return convexHull;
	}

	public void setConvexHull(Map<Integer, List<IntExpression>> convexHull) {
		this.convexHull = convexHull;
	}

	public Map<Integer, List<IntExpression>> getBoundingBox() {
		return boundingBox;
	}

	public void setScopRoot(AbstractScopNode scopNode) {
		ScopRoot sroot = ScopUserFactory.scopFactory.createScopRoot();
		sroot.getStatements().add(scopNode);
		this.sroot = sroot;
	}
	
	public void setScopRoot(ScopRoot scopRoot) {
		this.sroot = scopRoot;
	}
	
	public ScopRoot getScopRoot() {
		return sroot;
	}

	public PCOTBand getCurrentBand() {
		return currentBand;
	}
	
	public void setCurrentBand(PCOTBand b) {
		currentBand = b;
	}

	public void setBoundingBox(Map<Integer, List<IntExpression>> boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getSystemName() {
		return sysName;
	}

	public void setSystemName(String name) {
		this.sysName = name;
	}
	
	public PCOTBand getPreviousBand() {
		return previousBand;
	}

	public ScopFor getOuter() {
		return outer;
	}

	public void setOuter(ScopFor outer) {
		this.outer = outer;
	}

	public List<ScopFor> getInner() {
		return inner;
	}

	public void setInner(List<ScopFor> inner) {
		this.inner = inner;
	}
	
	public void addInner(ScopFor inner) {
		this.inner.add(inner);
	}

	public List<AbstractScopNode> getBody() {
		return body;
	}

	public void setBody(List<AbstractScopNode> body) {
		this.body = body;
	}
	
	public void addBody(AbstractScopNode body) {
		this.body.add(body);
	}

	public void setPreviousBand(PCOTBand previousBand) {
		this.previousBand = previousBand;
	}
	
	

	public Map<String, Integer> getLoopVars() {
		return loopVars;
	}

	public void setLoopVars(Map<String, Integer> loopVars) {
		this.loopVars = loopVars;
	}

	public String getRecursiveFunctionName() {
		StringBuilder sb = new StringBuilder();
		sb.append("recursive_").append(sysName).append("_")
		  .append(currentBand.getBandStart()).append("_").append(currentBand.getBandEnd())
		  .append("_").append(blockId);
		
		return sb.toString();
	}
	
	public String getBaseFunctionName() {
		StringBuilder sb = new StringBuilder();
		sb.append("base_").append(sysName).append("_")
		  .append(previousBand.getBandStart()).append("_").append(previousBand.getBandEnd())
		  .append("_").append(blockId);
		
		return sb.toString();
	}
	
	public String getBaseFunctionNameForFunctionCall() {
		StringBuilder sb = new StringBuilder();
		sb.append("base_").append(sysName).append("_")
		  .append(currentBand.getBandStart()).append("_").append(currentBand.getBandEnd())
		  .append("_").append(blockId);
		
		return sb.toString();
	}
}