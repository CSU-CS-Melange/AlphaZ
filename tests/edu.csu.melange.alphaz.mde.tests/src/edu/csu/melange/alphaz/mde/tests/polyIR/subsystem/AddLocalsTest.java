package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Test;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.helper.AddLocal;
import org.polymodel.polyhedralIR.util.PolyhedralIRDimensionManager;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;

public class AddLocalsTest {
	
	
	@Test
	public void testEquivalence() {
		PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
		
		List<Variable> params1 = new BasicEList<Variable>();
		List<Variable> inds1 = new BasicEList<Variable>();
		Type typeA = _polyIRFact.createType(DATATYPE.INTEGER);
		Domain domA = PolyhedralIRUtility.createEmptyDomain(params1, inds1);
		VariableDeclaration varDeclA = _polyIRFact.createVariableDeclaration("A", typeA, domA);
		Type typeB = _polyIRFact.createType(DATATYPE.INTEGER);
		Domain domB = PolyhedralIRUtility.createEmptyDomain(params1, inds1);
		VariableDeclaration varDeclB = _polyIRFact.createVariableDeclaration("B", typeB, domB);
		
		// Context = 8*(A+4)
		VariableExpression exprVarA = _polyIRFact.createVariableExpression(varDeclA);
		IntegerExpression expr4 = _polyIRFact.createIntegerExpression(4);
		BinaryExpression exprAp4 = _polyIRFact.createBinaryExpression(OP.ADD, exprVarA, expr4);
		IntegerExpression expr8 = _polyIRFact.createIntegerExpression(8);
		BinaryExpression context = _polyIRFact.createBinaryExpression(OP.MUL, expr8, exprAp4);
		
		// Target = A+4
		VariableExpression exprVarAt = _polyIRFact.createVariableExpression(varDeclA);
		IntegerExpression expr4t = _polyIRFact.createIntegerExpression(4);
		BinaryExpression target = _polyIRFact.createBinaryExpression(OP.ADD, exprVarAt, expr4t);
		
		// Test of equivalence
		boolean equivTestPos = exprAp4.equivalence(target);
		System.out.println("EquivTestPos = " + equivTestPos);
	}
	
	// Test equivalence for expressions: "(i -> i)@A" and "A".
	@Test
	public void testEquivalence2() {
		PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
		PolyhedralIRDimensionManager polyManag = new PolyhedralIRDimensionManager();
		
		List<Variable> params1 = new BasicEList<Variable>();
		List<Variable> inds1 = new BasicEList<Variable>();
		Variable vari = polyManag.getDimension(0, "i");
		inds1.add(vari);
		Type typeA = _polyIRFact.createType(DATATYPE.INTEGER);
		Domain domA = PolyhedralIRUtility.createEmptyDomain(params1, inds1);
		VariableDeclaration varDeclA = _polyIRFact.createVariableDeclaration("A", typeA, domA);
		
		// First expression
		VariableExpression varExpr1 = _polyIRFact.createVariableExpression(varDeclA);
		AffineFunction affFunc1 = PolyhedralIRUtility.createIdentityFunction(domA);
		DependenceExpression expr1 = _polyIRFact.createDependenceExpression(affFunc1, varExpr1);
		
		// Second expression
		VariableExpression expr2 = _polyIRFact.createVariableExpression(varDeclA);
		
		// Equivalence test
		boolean equivTestPos = expr1.equivalence(expr2);
		boolean equivTestBis = expr2.equivalence(expr1);
		System.out.println("EquivtestPos = " + equivTestPos);
		System.out.println("EquivtestBis = " + equivTestBis);
	}
	
	@Test
	public void testParseExpr() throws IOException {
		// Getting the system
			Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/others/TestAddLocal.ab");
			AffineSystem syst = program.getSystem("syst1");
			
			List<String> freeInds = new BasicEList<String>();
			freeInds.add("i");
			Expression expr = AlphabetsToPolyhedralIR.readExpression("4*A[i] + B[i,N-i]", syst, freeInds);
			
			System.out.println(PolyhedralIRToAlphabets.toString(expr));
			
	}
	
	@Test
	public void testAddLocal() throws IOException {
		//PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
		
		// *** Test of TOM's AddLocal
			Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/others/TestAddLocal.ab");
			AffineSystem syst = program.getSystem("syst1");
			
			System.out.println("*** System before AddLocal =\n" + syst.toString());
			System.out.println();
			
			// Local_added = ({i|i<N-1}: B[i,i])
			List<String> freeInds = new BasicEList<String>();
			freeInds.add("i");
			Expression exprLoc = AlphabetsToPolyhedralIR.readExpression("({i|i<N-1}: B[i,i])", syst, freeInds);
			//System.out.println(PolyhedralIRToAlphabets.toString(exprLoc));
			
			Domain defDomLocal = PolyhedralIRUtility.parseDomain(syst.getParameters(), "{i|i<N-1}");;
			AddLocal.addLocal(syst, exprLoc, "Local_added", defDomLocal);
			
			System.out.println("*** System after AddLocal =\n" + syst.toString());
			System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		// *** Test of AddLocal with nodeID
			Program programD = alphaz.mde.Basic.ReadAlphabets("alphabets/others/TestAddLocal.ab");
			AffineSystem systD = programD.getSystem("syst1");
			
			System.out.println("*** System before AddLocal =\n" + systD.toString());
			System.out.println();
			
			int[] nodeIdD = {0,0,1,1};
			AddLocal.addLocal(systD, nodeIdD, "Local_added");
			
			System.out.println("*** System after AddLocal =\n" + systD.toString());
			System.out.println();
	}
	
	@Test
	public void testAddLocalUnique() throws IOException {
		// *** Test of AddLocalUnique
			Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/others/TestAddLocal.ab");
			AffineSystem syst = program.getSystem("syst1");
			
			System.out.println("*** System before AddLocalUnique =\n" + syst.toString());
			System.out.println();
			
			int[] nodeId = {0,0,1,1,1};
			AddLocal.addLocalUnique(syst, nodeId, "Local_added");
			
			System.out.println("*** System after AddLocalUnique =\n" + syst.toString());
			System.out.println();
	}
	
	@Test
	public void testAddLocals() throws IOException {
		
		// *** Test of AddLocals (with potential expression inclusion)
			Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/others/TestAddLocal.ab");
			AffineSystem syst = program.getSystem("syst1");
			
			System.out.println("*** System before AddLocals =\n" + syst.toString());
			System.out.println();
			
			// -- Locals_added
			List<Expression> lexpr = new BasicEList<Expression>();
			List<String> freeInds = new BasicEList<String>();
			freeInds.add("i");
			Expression exprLoc1 = AlphabetsToPolyhedralIR.readExpression("({i|i<N-1}: B[i,i])", syst, freeInds);
			lexpr.add(exprLoc1);
			Expression exprLoc2 = AlphabetsToPolyhedralIR.readExpression("8*({i|i<N-1}: B[i,i])", syst, freeInds);
			lexpr.add(exprLoc2);
			
			AddLocal.addLocals(syst, lexpr);
			
			System.out.println("*** System after AddLocals =\n" + syst.toString());
			System.out.println();
	}
	
	
} // AddLocalsTest