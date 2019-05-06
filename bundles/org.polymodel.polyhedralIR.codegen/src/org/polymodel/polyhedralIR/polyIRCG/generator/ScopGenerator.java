package org.polymodel.polyhedralIR.polyIRCG.generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolymodelCodeGenFacility.CodeGenStatement;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.transformations.ScopRemoveOTL;
import org.polymodel.scop.util.ScopLoopIteratorUtil;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;

public class ScopGenerator {


	/**
	 * Generates Scop from statements and surrounding domains
	 * 
	 * @param params
	 * @param indexNames
	 * @param statements
	 * @param options
	 * @return
	 */
	public static ScopRoot generateScop(ParameterDomain params, List<String> indexNames, List<Statement> statements, CloogOptionSpecifier options) {

		try {
			DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
			
			List<PolymodelCodeGenFacility.CodeGenStatement> clgStmts = new ArrayList<PolymodelCodeGenFacility.CodeGenStatement>(statements.size());

			for (Statement statement : statements) {
				statement.getDomain().getPMdomain().simplify();
				AbstractRelation scattering;
				//when not specified, use identity
				if (statement.getScattering() == null) {
					scattering = PolyhedralIRUtility.createIdentityFunction(statement.getDomain()).getPMmapping().buildRelation(manager);
				} else {
					scattering = statement.getScattering().getPMmapping().buildRelation(manager);
				}
				clgStmts.add(new CodeGenStatement(statement.getName(), statement.getDomain().getPMdomain(), scattering));
			}
			
			/*PrintWriter writer = new PrintWriter("/s/chopin/l/grad/zou/the-file-name.txt", "UTF-8");
			writer.println(clgStmts.size());
			for (int i = 0; i < clgStmts.size(); i++){
				writer.println(clgStmts.get(i).domain);
				//System.out.println(clgStmts.get(i).domain);
			}
			writer.println(clgStmts.size());
			for (int i = 0; i < clgStmts.size(); i++){
				writer.println(clgStmts.get(i).getScattering());
				//System.out.println(clgStmts.get(i).getScattering());
			}
			writer.close();*/
			
//			String context = PolyModelToISLString.toString(params.getPMdomain(), NAMING_SCHEME.GIVEN_NAME);
//			
//			List<CloogInputDomain> cids = new LinkedList<CloogInputDomain>();
//			int num = 0;
//			for (Statement statement : statements) {
//				statement.getDomain().getPMdomain().simplify();
//				cids.add(new CloogInputDomain(statement.getDomain().getPMdomain(), statement.getName(), num));
//				num++;
//			}
						
//			String union_domain = PolyModelToISLString.toCloogInputString(cids, NAMING_SCHEME.GIVEN_NAME);

//			System.out.println(context);
//			System.out.println(union_domain);
//			JNIISLContext isl_ctx = new JNIISLContext();
//			JNICloogInput input = new JNICloogInput(isl_ctx, state, context, union_domain.toString());
//			isl_ctx.islCtxFree();
			
//			JNIClastStmt root = JNIClastRoot.fromUnionMap(state, opt, context, union_domain);
			
//			root.pprint(opt);
//			System.out.println(ClastPrettyPrinter.pp(root));
			
//			ScopRoot sroot = JNIClastToScopModel.adapt((JNIClastRoot) root);
			ScopRoot sroot = PolymodelCodeGenFacility.generate(manager, params.getPMdomain(), clgStmts, options);
			
			sroot = sroot.simplify();
			
			if (options.otlClast != 0) {
				sroot = ScopRemoveOTL.removeOTL(sroot, options.otlClast);
			}
			
			//rename loop iterators
			if (indexNames != null && indexNames.size() > 0) {
				ScopLoopIteratorUtil.renameIterators(sroot, indexNames);
			}
			
			return sroot;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Failed to generate Clast.");
		}
	}
	
	/**
	 * Generates ClooG Loop with default Options
	 * 
	 * @param params
	 * @param indexNames
	 * @param statements
	 * @return
	 */
	public static ScopRoot generateScop(ParameterDomain params, List<String> indexNames, List<Statement> statements) {
		try {
			return generateScop(params, indexNames, statements, CloogOptionSpecifier.getDefault());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Failed to create JNICloogOptions.");
		}
	}
	
	/**
	 * Return a scanning loops as CLooG AST (Clast)
	 */
	public static ScopRoot generateScop(CLoop poly) {
		return generateScop(poly.getParameterDomain(), poly.getIteratorNames(), poly.getStatements());
	}
	public static ScopRoot generateScop(CLoop poly, CloogOptionSpecifier options) {
		return generateScop(poly.getParameterDomain(), poly.getIteratorNames(), poly.getStatements(), options);
	}
	
	/**
	 * Split a scop root that is a sequence of loop nests to separate scops.
	 * 
	 * @param root
	 * @return
	 */
	public static List<ScopRoot> splitScop(ScopRoot root) {
		List<ScopRoot> scops = new LinkedList<>();
		
		if (root.getStatements().size() > 1) {
			for (AbstractScopNode node : root.getStatements()) {
				ScopRoot newRoot = ScopUserFactory.scopRoot(EcoreUtil.copy(node));
				scops.add(newRoot);
			}
		} else {
			scops.add(root);
		}
		
		return scops;
	}
}