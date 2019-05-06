package org.polymodel.dataflow.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.WriteAccess;

public class ExportADAInputAsClass {

	private ADAInput input;
	private List<String> methods;
	private Map<Variable,Integer> vars;
	private String packageName;
	private DomainDimensions currentDims;
	public ExportADAInputAsClass(ADAInput input, String packageName) {
		this.input = input;
		this.methods = new ArrayList<String>();
		this.packageName = packageName;
	}
	
	
	public String print() {
		StringBuffer classString = new StringBuffer("");

		//package name
		classString.append("\npackage "+packageName+";\n");
		//imports
		classString.append(imports());
		
		//class prototype
		String name = "Build"+input.toString().replace("/", "_");
		classString.append("public class "+name+" {\n");
		
		//static shortcut
		classString.append("\n\tpublic static ADAInput staticBuild() {\n");
		classString.append("\t\treturn (new "+name+"()).build();\n\t}\n");

		//attributes
		classString.append("\n\tprivate DimensionsManager manager;\n");
		classString.append("\tprivate Variable[] variables;\n");
		classString.append("\tprivate Variable[] parameters;\n");
		classString.append("\tprivate PolymodelDefaultFactory polyFactory;\n");
		
		//constructor with argument
		classString.append("\n\tpublic "+name+"(PolymodelDefaultFactory f) {\n");
		classString.append("\t\tthis.polyFactory = f;\n");
		classString.append("\t}\n");
		
		//constructor without argument
		classString.append("\n\tpublic "+name+"() {\n");
		classString.append("\t\tthis(PolymodelComponent.INSTANCE.getFactory());\n");
		classString.append("\t}\n");
		
		//main build method
		methods.add(buildInput(input));
		
		//append methods
		for (String str : methods) {
			classString.append(str+"\n");
		}

		classString.append("\tpublic static void main(String[] argv) {\n");
		classString.append("\t\tADAInput i = "+name+".staticBuild();\n");
		classString.append("\t\tSystem.out.println(i);\n");
		classString.append("\t\tISLDataflowAnalysis.compute(i);\n");
		
		classString.append("\t}\n");
		
		//finish & return
		classString.append("}\n");
		
		return classString.toString();
//		return "plop";
	}

	private String buildInput(ADAInput input) {
		StringBuffer classString = new StringBuffer();
		classString.append("\tpublic ADAInput build() {\n");
		classString.append("\t\tmanager = buildDimManager();\n");
		methods.add(buildDimManager(input.getDimensionsManager()));
		classString.append("\t\tEList<ADAStatement> stmts = new BasicEList<ADAStatement>("+this.input.getAdaStatements().size()+");\n");
		
		//iterate over statements
		int stmti = 0;
		for (ADAStatement stmt : this.input.getAdaStatements()) {
			classString.append("\t\tstmts.add(buildStmt"+stmti+"());\n");
			methods.add(buildStmt(stmt,stmti));
			stmti++;
		}
		
		//build input & return
		classString.append("\t\tADAInput res = new ADAInputStub(manager,stmts);\n");
		
		classString.append("\t\tfor (ADAStatement s : stmts) {\n");
		classString.append("\t\t\ts.setParentADAInput(res);\n");
		classString.append("\t\t}\n");
		
		classString.append("\t\treturn res;\n");
		classString.append("\t}\n");
		return classString.toString();
	}
	
	private String buildDimManager(DimensionsManager dims) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate DimensionsManager buildDimManager() {\n");
		method.append("\t\tDimensionsManager manager = polyFactory.createDimensionsManager();\n");
		
		vars = new HashMap<Variable, Integer>();
		
		method.append("\t\tvariables = new Variable["+dims.getDimensions().size()+"];\n");
		int i = 0;
		for (Variable v : dims.getDimensions()) {
			IndexDimension index = (IndexDimension) v;
			method.append("\t\tvariables["+i+"] = PolymodelFactory.eINSTANCE.createIndexDimension();\n");
			method.append("\t\tvariables["+i+"].setName(\""+v.getName()+"\");\n");
			method.append("\t\t((IndexDimension)variables["+i+"]).setDimension("+index.getDimension()+");\n");
			method.append("\t\tmanager.getDimensions().add(variables["+i+"]);\n");
			vars.put(v, i);
			i++;
		}
		
		method.append("\t\tparameters = new Variable["+dims.getParameters().size()+"];\n");
		i = 0;
		for (Variable v : dims.getParameters()) {
			method.append("\t\tparameters["+i+"] = IntExpressionBuilder.var(\""+v.getName()+"\");\n");
			method.append("\t\tmanager.getParameters().add(parameters["+i+"]);\n");
			vars.put(v, i);
			i++;
		}
		
		method.append("\t\treturn manager;\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildStmt(ADAStatement stmt, int stmti) {
		StringBuffer method = new StringBuffer("\tprivate ADAStatement buildStmt"+stmti+"() {\n");
		method.append("\t\tFunction f = buildFunctionStmt"+stmti+"();\n");
		methods.add(buildFunction(stmt.getIDSchedule(),"Stmt"+stmti));
		method.append("\t\tDomain d = buildDomainStmt"+stmti+"();\n");
		methods.add(buildDomain(stmt.getDomain(),"Stmt"+stmti));
		method.append("\t\tEList<ReadAccess> reads = new BasicEList<ReadAccess>("+stmt.getReads().size()+");\n");
		method.append("\t\tEList<WriteAccess> writes = new BasicEList<WriteAccess>("+stmt.getWrites().size()+");\n");
		int ri = 0,wi = 0;
		for (ReadAccess r : stmt.getReads()) {
			method.append("\t\treads.add(buildRead"+stmti+"_"+ri+"());\n");
			methods.add(buildRead(r,stmti,ri));
			ri++;
		}
		for (WriteAccess w : stmt.getWrites()) {
			method.append("\t\twrites.add(buildWrite"+stmti+"_"+wi+"());\n");
			methods.add(buildWrite(w,stmti,wi));
			wi++;
		}
		method.append("\t\tADAStatement stmt = new ADAStatementStub("+stmt.getId()+",writes,reads, d, f);\n");
		method.append("\t\tfor (WriteAccess a : writes) {\n");
		method.append("\t\t\ta.setParentADAStatement(stmt);\n");
		method.append("\t\t}\n");
		method.append("\t\tfor (ReadAccess a : reads) {\n");
		method.append("\t\t\ta.setParentADAStatement(stmt);\n");
		method.append("\t\t}\n");
		method.append("\t\treturn stmt;\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildFunction(Function idSchedule, String suffix) {
		currentDims = idSchedule.getDimensions();
		StringBuffer method = new StringBuffer();
		method.append("\tprivate Function buildFunction"+suffix+"() {\n");
		method.append("\t\tEList<IntExpression> index = new BasicEList<IntExpression>();\n");
		int cpt = 0;
		for (IntExpression e : idSchedule.getExpressions()) {
			method.append("\t\tindex.add(buildExpr"+"F"+suffix+"_"+cpt+"());\n");
			methods.add(buildExpr(e,"F"+suffix+"_"+cpt));
			cpt++;
		}
		method.append("\t\tDomainDimensions dims = buildDomainDimsF"+suffix+"();\n");
		methods.add(buildDomainDims(idSchedule.getDimensions(),"F"+suffix));
		method.append("\t\tFunction f = polyFactory.createFunction(dims, index, manager);\n");
		if (idSchedule.getIn() != null) method.append("\t\tf.setIn(polyFactory.createLabel(\""+idSchedule.getIn().getName()+"\"));\n");
		if (idSchedule.getOut() != null) method.append("\t\tf.setOut(polyFactory.createLabel(\""+idSchedule.getOut().getName()+"\"));\n");
		method.append("\t\treturn f;\n");
		
		

		method.append("\t}\n");
		return method.toString();
	}


	private String buildDomainDims(DomainDimensions dimensions, String suffix) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate DomainDimensions buildDomainDims"+suffix+"() {\n");
		method.append("\t\tEList<Variable> dimensions = new BasicEList<Variable>("+dimensions.getIndices().size()+");\n");
		for (Variable v : dimensions.getIndices()) {
			method.append("\t\tdimensions.add(variables["+vars.get(v)+"]);\n");
		}
		method.append("\t\tEList<Variable> params = new BasicEList<Variable>("+dimensions.getParameters().size()+");\n");
		for (Variable v : dimensions.getParameters()) {
			method.append("\t\tparams.add(parameters["+vars.get(v)+"]);\n");
		}
		method.append("\t\tDomainDimensions dims = polyFactory.createDomainDimensions(dimensions, params);\n");
		
		method.append("\t\treturn dims;\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildDomain(Domain domain, String suffix) {
		currentDims = domain.getDimensions();
		StringBuffer method = new StringBuffer();
		method.append("\tprivate Domain buildDomain"+suffix+"() {\n");
		method.append("\t\tEList<IntConstraintSystem> systems = new BasicEList<IntConstraintSystem>("+domain.getPolyhedra().size()+");\n");
		int i = 0;
		for (IntConstraintSystem sys : domain.getPolyhedra()) {
			method.append("\t\tsystems.add(buildSystem"+suffix+"_"+i+"());\n");
			methods.add(buildSystem(sys,suffix+"_"+i));
			i++;
		}
		method.append("\t\tDomainDimensions dims = buildDomainDimsD"+suffix+"();\n");
		methods.add(buildDomainDims(domain.getDimensions(),"D"+suffix));

		method.append("\t\tDomain d = polyFactory.createDomain(dims, systems);\n");
		if (domain.getLabel() != null) method.append("\t\td.setLabel(polyFactory.createLabel(\""+domain.getLabel().getName()+"\"));\n");
		method.append("\t\treturn d;\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildSystem(IntConstraintSystem sys, String string) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate IntConstraintSystem buildSystem"+string+"() {\n");
		method.append("\t\tEList<IntConstraint> constraints = new BasicEList<IntConstraint>("+sys.getConstraints().size()+");\n");
		int i = 0;
		for (IntConstraint c : sys.getConstraints()) {
			method.append("\t\tconstraints.add(buildConstraint"+string+"_"+i+"());\n");
			methods.add(buildConstraint(c,string+"_"+i));
			i++;
		}
		method.append("\t\treturn IntExpressionBuilder.constraintSystem(constraints);\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildConstraint(IntConstraint c, String string) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate IntConstraint buildConstraint"+string+"() {\n");
		method.append("\t\tIntExpression lhs = buildExpr"+string+"lhs();\n");
		methods.add(buildExpr(c.getLhs(), string+"lhs"));
		method.append("\t\tIntExpression rhs = buildExpr"+string+"rhs();\n");
		methods.add(buildExpr(c.getRhs(), string+"rhs"));
		method.append("\t\tComparisonOperator op = ComparisonOperator."+c.getComparisonOperator().getLiteral()+";\n");
		method.append("\t\treturn IntExpressionBuilder.constraint(lhs, rhs, op);\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildWrite(WriteAccess w, int stmt, int i) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate WriteAccess buildWrite"+stmt+"_"+i+"() {\n");
		method.append("\t\tEList<IntExpression> index = new BasicEList<IntExpression>();\n");
		int cpt = 0;
		for (IntExpression e : w.getIndex()) {
			method.append("\t\tindex.add(buildExpr"+"W"+stmt+"_"+i+"_"+cpt+"());\n");
			methods.add(buildExpr(e,"W"+stmt+"_"+i+"_"+cpt));
			cpt++;
		}
		method.append("\t\treturn new WriteAccessStub(index, \""+w.getAccessId()+"\");\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildRead(ReadAccess r, int stmt, int i) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate ReadAccess buildRead"+stmt+"_"+i+"() {\n");
		method.append("\t\tEList<IntExpression> index = new BasicEList<IntExpression>();\n");
		int cpt = 0;
		for (IntExpression e : r.getIndex()) {
			method.append("\t\tindex.add(buildExpr"+"R"+stmt+"_"+i+"_"+cpt+"());\n");
			methods.add(buildExpr(e,"R"+stmt+"_"+i+"_"+cpt));
			cpt++;
		}
		method.append("\t\treturn new ReadAccessStub(index, \""+r.getAccessId()+"\");\n");
		method.append("\t}\n");
		return method.toString();
	}


	private String buildExpr(IntExpression e, String string) {
		StringBuffer method = new StringBuffer();
		method.append("\tprivate IntExpression buildExpr"+string+"() {\n");
		method.append("\t\tIntExpression expr;\n");
		if (e instanceof AffineExpression) {
			method.append(generate((AffineExpression)e));
		} else if (e instanceof QuasiAffineExpression) {
			method.append(generate((QuasiAffineExpression)e));
		} else {
			throw new RuntimeException("Unsupported generation for "+e.getClass().getSimpleName());
		}
		
		method.append("\t\treturn expr;\n");
		method.append("\t}\n");
		return method.toString();
	}

	private String generate(AffineExpression e) {
		StringBuffer sb = new StringBuffer("\t\tList<AffineTerm> terms = new ArrayList<AffineTerm>("+e.getTerms().size()+");\n");
		for (AffineTerm t : e.getTerms()) {
			Variable v = t.getVariable();
			long coef = t.getCoef();
			if (coef != 0) {
				if (v != null) {
					if (currentDims.getIndices().contains(v)) {
						sb.append("\t\tterms.add(IntExpressionBuilder.term("+t.getCoef()+", variables["+vars.get(t.getVariable())+"]));\n");
					} else if (currentDims.getParameters().contains(v)) {
						sb.append("\t\tterms.add(IntExpressionBuilder.term("+t.getCoef()+", parameters["+vars.get(t.getVariable())+"]));\n");
					} else {
						throw new RuntimeException("Unknown variable : "+v);
					}
				} else {
					sb.append("\t\tterms.add(IntExpressionBuilder.term("+t.getCoef()+"));\n");
				}
			}
		}
		sb.append("\t\texpr = IntExpressionBuilder.affine(terms);\n");
		return sb.toString();
	}

	private String generate(QuasiAffineExpression e) {
		// TODO Auto-generated method stub
		throw new RuntimeException("TODO");
	}

	private String imports() {
		String res = "\n";
		res += "import java.util.ArrayList;\n";
		res += "import java.util.List;\n";
		res += "\n";
		res += "import org.eclipse.emf.common.util.BasicEList;\n";
		res += "import org.eclipse.emf.common.util.EList;\n";
		res += "import org.polymodel.DimensionsManager;\n";
		res += "import org.polymodel.Domain;\n";
		res += "import org.polymodel.DomainDimensions;\n";
		res += "import org.polymodel.Function;\n";
		res += "import org.polymodel.IndexDimension;\n";
		res += "import org.polymodel.PolymodelFactory;\n";
		res += "import org.polymodel.algebra.ComparisonOperator;\n";
		res += "import org.polymodel.algebra.IntConstraint;\n";
		res += "import org.polymodel.algebra.IntConstraintSystem;\n";
		res += "import org.polymodel.algebra.IntExpression;\n";
		res += "import org.polymodel.algebra.Variable;\n";
		res += "import org.polymodel.algebra.affine.AffineTerm;\n";
		res += "import org.polymodel.algebra.factory.IntExpressionBuilder;\n";
		res += "import org.polymodel.dataflow.ADAInput;\n";
		res += "import org.polymodel.dataflow.ADAStatement;\n";
		res += "import org.polymodel.dataflow.ReadAccess;\n";
		res += "import org.polymodel.dataflow.WriteAccess;\n";
		res += "import org.polymodel.dataflow.stubs.ADAInputStub;\n";
		res += "import org.polymodel.dataflow.stubs.ADAStatementStub;\n";
		res += "import org.polymodel.dataflow.stubs.ReadAccessStub;\n";
		res += "import org.polymodel.dataflow.stubs.WriteAccessStub;\n";
		res += "import org.polymodel.factory.PolymodelDefaultFactory;\n";
		res += "import org.polymodel.factory.PolymodelComponent;\n";
		res += "import org.polymodel.isl.dataflowanalysis.ISLDataflowAnalysis;\n";
		res += "\n";
		return res;
	}
	
	
}
