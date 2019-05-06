package edu.csu.melange.alphabets.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem;
import edu.csu.melange.alphabets.xtext.alphabets.AAndExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionIdentifier;
import edu.csu.melange.alphabets.xtext.alphabets.AFunction;
import edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.AIdentifierList;
import edu.csu.melange.alphabets.xtext.alphabets.AIfExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexAffineExpressionList;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexList;
import edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AModuloExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANotExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOrExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.APolyhedron;
import edu.csu.melange.alphabets.xtext.alphabets.AProgram;
import edu.csu.melange.alphabets.xtext.alphabets.ARealExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AType;
import edu.csu.melange.alphabets.xtext.alphabets.AUseEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;
import edu.csu.melange.alphabets.xtext.services.AlphabetsGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractAlphabetsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AlphabetsGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AlphabetsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AlphabetsPackage.AADDITIVE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AAdditiveExpression(context, (AAdditiveExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AAFFINE_SYSTEM:
				if(context == grammarAccess.getAAffineSystemARule()) {
					sequence_AAffineSystemA(context, (AAffineSystem) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAAffineSystemBRule()) {
					sequence_AAffineSystemB(context, (AAffineSystem) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAAffineSystemRule()) {
					sequence_AAffineSystem_AAffineSystemA_AAffineSystemB(context, (AAffineSystem) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AAND_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AAndExpression(context, (AAndExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ABOOLEAN_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getABooleanExpressionRule() ||
				   context == grammarAccess.getAConstantExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ABooleanExpression(context, (ABooleanExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ACASE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getACaseExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ACaseExpression(context, (ACaseExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ADEPENDENCE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getADependenceExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ADependenceExpression(context, (ADependenceExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ADEPENDENCE_IN_ARRAY_NOTATION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getADependenceInArrayNotationRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ADependenceInArrayNotation(context, (ADependenceInArrayNotation) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ADOMAIN:
				if(context == grammarAccess.getADomainRule()) {
					sequence_ADomain(context, (ADomain) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AEXTERNAL_FUNCTION_CALL:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAExternalFunctionCallRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiArgExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AExternalFunctionCall(context, (AExternalFunctionCall) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AEXTERNAL_FUNCTION_DECLARATION:
				if(context == grammarAccess.getAExternalFunctionDeclarationRule()) {
					sequence_AExternalFunctionDeclaration(context, (AExternalFunctionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AEXTERNAL_FUNCTION_IDENTIFIER:
				if(context == grammarAccess.getAExternalFunctionIdentifierRule()) {
					sequence_AExternalFunctionIdentifier(context, (AExternalFunctionIdentifier) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AFUNCTION:
				if(context == grammarAccess.getAFunctionRule()) {
					sequence_AFunction(context, (AFunction) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AFUNCTION_IN_ARRAY_NOTATION:
				if(context == grammarAccess.getAFunctionInArrayNotationRule()) {
					sequence_AFunctionInArrayNotation(context, (AFunctionInArrayNotation) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AIDENTIFIER_LIST:
				if(context == grammarAccess.getAIdentifierListRule()) {
					sequence_AIdentifierList(context, (AIdentifierList) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AIF_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAIfExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AIfExpression(context, (AIfExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AINDEX_AFFINE_EXPRESSION_LIST:
				if(context == grammarAccess.getAIndexAffineExpressionListRule()) {
					sequence_AIndexAffineExpressionList(context, (AIndexAffineExpressionList) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AINDEX_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAIndexExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AIndexExpression(context, (AIndexExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AINDEX_LIST:
				if(context == grammarAccess.getAIndexListRule()) {
					sequence_AIndexList(context, (AIndexList) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AINPUT_DECLARATION:
				if(context == grammarAccess.getAInputDeclarationRule() ||
				   context == grammarAccess.getAVariableDeclarationRule()) {
					sequence_AInputDeclaration(context, (AInputDeclaration) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AINTEGER_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAConstantExpressionRule() ||
				   context == grammarAccess.getAIntegerExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AIntegerExpression(context, (AIntegerExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ALOCAL_DECLARATION:
				if(context == grammarAccess.getALocalDeclarationRule() ||
				   context == grammarAccess.getAVariableDeclarationRule()) {
					sequence_ALocalDeclaration(context, (ALocalDeclaration) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AMIN_MAX_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AMinMaxExpression(context, (AMinMaxExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AMODULO_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AModuloExpression(context, (AModuloExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AMULTI_ARG_ARITHMETIC_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiArgArithmeticExpressionRule() ||
				   context == grammarAccess.getAMultiArgExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AMultiArgArithmeticExpression(context, (AMultiArgArithmeticExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AMULTI_ARG_LOGICAL_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiArgExpressionRule() ||
				   context == grammarAccess.getAMultiArgLogicalExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AMultiArgLogicalExpression(context, (AMultiArgLogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AMULTIPLICATIVE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AMultiplicativeExpression(context, (AMultiplicativeExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ANEGATE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getANegateExpressionRule() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryExpressionRule() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ANegateExpression(context, (ANegateExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ANOT_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getANotExpressionRule() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryExpressionRule() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ANotExpression(context, (ANotExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AOR_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AOrExpression(context, (AOrExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AOUTPUT_DECLARATION:
				if(context == grammarAccess.getAOutputDeclarationRule() ||
				   context == grammarAccess.getAVariableDeclarationRule()) {
					sequence_AOutputDeclaration(context, (AOutputDeclaration) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.APOLYHEDRON:
				if(context == grammarAccess.getAPolyhedronRule()) {
					sequence_APolyhedron(context, (APolyhedron) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.APROGRAM:
				if(context == grammarAccess.getAProgramRule()) {
					sequence_AProgram(context, (AProgram) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AREAL_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAConstantExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARealExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ARealExpression(context, (ARealExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AREDUCE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getAReduceExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_AReduceExpression(context, (AReduceExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ARELATIONAL_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ARelationalExpression(context, (ARelationalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ARESTRICT_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getARestrictExpressionRule() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule()) {
					sequence_ARestrictExpression(context, (ARestrictExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ASTANDARD_EQUATION:
				if(context == grammarAccess.getAEquationRule() ||
				   context == grammarAccess.getAStandardEquationRule()) {
					sequence_AStandardEquation(context, (AStandardEquation) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.ATYPE:
				if(context == grammarAccess.getATypeRule()) {
					sequence_AType(context, (AType) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AUSE_EQUATION:
				if(context == grammarAccess.getAEquationRule() ||
				   context == grammarAccess.getAUseEquationRule()) {
					sequence_AUseEquation(context, (AUseEquation) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AVARIABLE_EXPRESSION:
				if(context == grammarAccess.getAAdditiveExpressionRule() ||
				   context == grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAAlphabetsExpressionRule() ||
				   context == grammarAccess.getAAlphabetsTerminalExpressionRule() ||
				   context == grammarAccess.getAAndExpressionRule() ||
				   context == grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMinMaxExpressionRule() ||
				   context == grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAModuloExpressionRule() ||
				   context == grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAMultiplicativeExpressionRule() ||
				   context == grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAOrExpressionRule() ||
				   context == grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAParanthesizedAlphabetsExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionRule() ||
				   context == grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAUnaryOrTerminalExpressionRule() ||
				   context == grammarAccess.getAVariableExpressionRule()) {
					sequence_AVariableExpression(context, (AVariableExpression) semanticObject); 
					return; 
				}
				else break;
			case AlphabetsPackage.AWHILE_DECLARATION:
				if(context == grammarAccess.getAWhileDeclarationRule()) {
					sequence_AWhileDeclaration(context, (AWhileDeclaration) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=AAdditiveExpression_AAdditiveExpression_1_0 (op=PlusOp | op=MinusOp) right=AModuloExpression)
	 */
	protected void sequence_AAdditiveExpression(EObject context, AAdditiveExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=SystemID 
	 *         parameters=ADomain 
	 *         inputDeclarations+=AInputDeclaration* 
	 *         outputDeclarations+=AOutputDeclaration* 
	 *         localvarDeclarations+=ALocalDeclaration* 
	 *         whileDeclaration=AWhileDeclaration? 
	 *         equations+=AEquation*
	 *     )
	 */
	protected void sequence_AAffineSystemA(EObject context, AAffineSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=SystemID 
	 *         parameters=ADomain 
	 *         inputDeclarations+=AInputDeclaration* 
	 *         outputDeclarations+=AOutputDeclaration* 
	 *         localvarDeclarations+=ALocalDeclaration* 
	 *         equations+=AEquation*
	 *     )
	 */
	protected void sequence_AAffineSystemB(EObject context, AAffineSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             name=SystemID 
	 *             parameters=ADomain 
	 *             inputDeclarations+=AInputDeclaration* 
	 *             outputDeclarations+=AOutputDeclaration* 
	 *             localvarDeclarations+=ALocalDeclaration* 
	 *             whileDeclaration=AWhileDeclaration? 
	 *             equations+=AEquation*
	 *         ) | 
	 *         (
	 *             name=SystemID 
	 *             parameters=ADomain 
	 *             inputDeclarations+=AInputDeclaration* 
	 *             outputDeclarations+=AOutputDeclaration* 
	 *             localvarDeclarations+=ALocalDeclaration* 
	 *             equations+=AEquation*
	 *         )
	 *     )
	 */
	protected void sequence_AAffineSystem_AAffineSystemA_AAffineSystemB(EObject context, AAffineSystem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AAndExpression_AAndExpression_1_0 (operator=AndOp | operator=NandOp) right=ARelationalExpression)
	 */
	protected void sequence_AAndExpression(EObject context, AAndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=BOOLEAN
	 */
	protected void sequence_ABooleanExpression(EObject context, ABooleanExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ABOOLEAN_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ABOOLEAN_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getABooleanExpressionAccess().getValueBOOLEANTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     exprs+=AAlphabetsExpression+
	 */
	protected void sequence_ACaseExpression(EObject context, ACaseExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (func=AFunction expr=AAlphabetsTerminalExpression)
	 */
	protected void sequence_ADependenceExpression(EObject context, ADependenceExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_EXPRESSION__FUNC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_EXPRESSION__FUNC));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_EXPRESSION__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getADependenceExpressionAccess().getFuncAFunctionParserRuleCall_0_0(), semanticObject.getFunc());
		feeder.accept(grammarAccess.getADependenceExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=VariableIdentifier dep=AIndexAffineExpressionList)
	 */
	protected void sequence_ADependenceInArrayNotation(EObject context, ADependenceInArrayNotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_IN_ARRAY_NOTATION__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_IN_ARRAY_NOTATION__VAR));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_IN_ARRAY_NOTATION__DEP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ADEPENDENCE_IN_ARRAY_NOTATION__DEP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getADependenceInArrayNotationAccess().getVarVariableIdentifierParserRuleCall_0_0(), semanticObject.getVar());
		feeder.accept(grammarAccess.getADependenceInArrayNotationAccess().getDepAIndexAffineExpressionListParserRuleCall_2_0(), semanticObject.getDep());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (polyhedra+=APolyhedron polyhedra+=APolyhedron*)
	 */
	protected void sequence_ADomain(EObject context, ADomain semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (func=ID (exprs+=AAlphabetsExpression exprs+=AAlphabetsExpression*)?)
	 */
	protected void sequence_AExternalFunctionCall(EObject context, AExternalFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (output=AType name=AExternalFunctionIdentifier inputs+=AType? inputs+=AType*)
	 */
	protected void sequence_AExternalFunctionDeclaration(EObject context, AExternalFunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_AExternalFunctionIdentifier(EObject context, AExternalFunctionIdentifier semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AEXTERNAL_FUNCTION_IDENTIFIER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AEXTERNAL_FUNCTION_IDENTIFIER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAExternalFunctionIdentifierAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     newIds=AIndexAffineExpressionList
	 */
	protected void sequence_AFunctionInArrayNotation(EObject context, AFunctionInArrayNotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AFUNCTION_IN_ARRAY_NOTATION__NEW_IDS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAFunctionInArrayNotationAccess().getNewIdsAIndexAffineExpressionListParserRuleCall_1_0(), semanticObject.getNewIds());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (indexes=AIndexList func=AIndexAffineExpressionList)
	 */
	protected void sequence_AFunction(EObject context, AFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AFUNCTION__INDEXES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AFUNCTION__INDEXES));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AFUNCTION__FUNC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AFUNCTION__FUNC));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAFunctionAccess().getIndexesAIndexListParserRuleCall_1_0(), semanticObject.getIndexes());
		feeder.accept(grammarAccess.getAFunctionAccess().getFuncAIndexAffineExpressionListParserRuleCall_3_0(), semanticObject.getFunc());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (identifiers+=VariableIdentifier identifiers+=VariableIdentifier*)
	 */
	protected void sequence_AIdentifierList(EObject context, AIdentifierList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (cond=AAlphabetsExpression then=AAlphabetsExpression else=AAlphabetsExpression)
	 */
	protected void sequence_AIfExpression(EObject context, AIfExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__COND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__COND));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__THEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__THEN));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__ELSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AIF_EXPRESSION__ELSE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAIfExpressionAccess().getCondAAlphabetsExpressionParserRuleCall_1_0(), semanticObject.getCond());
		feeder.accept(grammarAccess.getAIfExpressionAccess().getThenAAlphabetsExpressionParserRuleCall_3_0(), semanticObject.getThen());
		feeder.accept(grammarAccess.getAIfExpressionAccess().getElseAAlphabetsExpressionParserRuleCall_5_0(), semanticObject.getElse());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((exprs+=IndexAffineExpression exprs+=IndexAffineExpression*)?)
	 */
	protected void sequence_AIndexAffineExpressionList(EObject context, AIndexAffineExpressionList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (func=IndexAffineExpression | (indexes=AIndexList func=IndexAffineExpression))
	 */
	protected void sequence_AIndexExpression(EObject context, AIndexExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ids+=IndexIdentifier ids+=IndexIdentifier*)?)
	 */
	protected void sequence_AIndexList(EObject context, AIndexList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=AType identifierList=AIdentifierList domain=ADomain?)
	 */
	protected void sequence_AInputDeclaration(EObject context, AInputDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_AIntegerExpression(EObject context, AIntegerExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AINTEGER_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AINTEGER_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAIntegerExpressionAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=AType identifierList=AIdentifierList domain=ADomain?)
	 */
	protected void sequence_ALocalDeclaration(EObject context, ALocalDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AMinMaxExpression_AMinMaxExpression_1_0 (op=MinOp | op=MaxOp) right=AUnaryOrTerminalExpression)
	 */
	protected void sequence_AMinMaxExpression(EObject context, AMinMaxExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AModuloExpression_AModuloExpression_1_0 op=ModOp right=AMultiplicativeExpression)
	 */
	protected void sequence_AModuloExpression(EObject context, AModuloExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__LEFT));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__OP));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AMODULO_EXPRESSION__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAModuloExpressionAccess().getOpModOpTerminalRuleCall_1_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getAModuloExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=ArithmeticOp exprs+=AAlphabetsExpression exprs+=AAlphabetsExpression+)
	 */
	protected void sequence_AMultiArgArithmeticExpression(EObject context, AMultiArgArithmeticExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=LogicalOp exprs+=AAlphabetsExpression exprs+=AAlphabetsExpression+)
	 */
	protected void sequence_AMultiArgLogicalExpression(EObject context, AMultiArgLogicalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=AMultiplicativeExpression_AMultiplicativeExpression_1_0 (op=MulOp | op=DivOp) right=AMinMaxExpression)
	 */
	protected void sequence_AMultiplicativeExpression(EObject context, AMultiplicativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=MinusOp expr=AAlphabetsTerminalExpression)
	 */
	protected void sequence_ANegateExpression(EObject context, ANegateExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ANEGATE_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ANEGATE_EXPRESSION__OP));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ANEGATE_EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ANEGATE_EXPRESSION__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getANegateExpressionAccess().getOpMinusOpTerminalRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getANegateExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op='not' expr=AAlphabetsTerminalExpression)
	 */
	protected void sequence_ANotExpression(EObject context, ANotExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ANOT_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ANOT_EXPRESSION__OP));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ANOT_EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ANOT_EXPRESSION__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getANotExpressionAccess().getOpNotKeyword_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getANotExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=AOrExpression_AOrExpression_1_0 (operator=OrOp | operator=XorOp) right=AAndExpression)
	 */
	protected void sequence_AOrExpression(EObject context, AOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=AType identifierList=AIdentifierList domain=ADomain?)
	 */
	protected void sequence_AOutputDeclaration(EObject context, AOutputDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (indexes=AIndexList (constraints+=InEquality constraints+=InEquality*)?)
	 */
	protected void sequence_APolyhedron(EObject context, APolyhedron semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (externalFunctions+=AExternalFunctionDeclaration* systems+=AAffineSystem+)
	 */
	protected void sequence_AProgram(EObject context, AProgram semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=REAL
	 */
	protected void sequence_ARealExpression(EObject context, ARealExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AREAL_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AREAL_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getARealExpressionAccess().getValueREALTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=ReductionOp (projection=AFunction | projection=AFunctionInArrayNotation) expr=AAlphabetsExpression)
	 */
	protected void sequence_AReduceExpression(EObject context, AReduceExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=ARelationalExpression_ARelationalExpression_1_0 operator=RelationalOp right=AAdditiveExpression)
	 */
	protected void sequence_ARelationalExpression(EObject context, ARelationalExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__LEFT));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ARELATIONAL_EXPRESSION__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getARelationalExpressionAccess().getOperatorRelationalOpParserRuleCall_1_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (domain=ADomain expr=AAlphabetsExpression)
	 */
	protected void sequence_ARestrictExpression(EObject context, ARestrictExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ARESTRICT_EXPRESSION__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ARESTRICT_EXPRESSION__DOMAIN));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.ARESTRICT_EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.ARESTRICT_EXPRESSION__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getARestrictExpressionAccess().getDomainADomainParserRuleCall_0_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getARestrictExpressionAccess().getExprAAlphabetsExpressionParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=ID indexes=AIndexList? expr=AAlphabetsExpression)
	 */
	protected void sequence_AStandardEquation(EObject context, AStandardEquation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (unsigned='unsigned'? (type=ATypeInteger | type=ATypeFloat | type=ATypeBoolean | type=ATypeChar))
	 */
	protected void sequence_AType(EObject context, AType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         extDom=ADomain? 
	 *         nameSubSys=ID 
	 *         param=AIndexAffineExpressionList 
	 *         inputs+=AAlphabetsExpression? 
	 *         inputs+=AAlphabetsExpression* 
	 *         outputs=AIdentifierList
	 *     )
	 */
	protected void sequence_AUseEquation(EObject context, AUseEquation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     var=VariableIdentifier
	 */
	protected void sequence_AVariableExpression(EObject context, AVariableExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AVARIABLE_EXPRESSION__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AVARIABLE_EXPRESSION__VAR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAVariableExpressionAccess().getVarVariableIdentifierParserRuleCall_0(), semanticObject.getVar());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (timeDomain=ADomain cond=AAlphabetsExpression)
	 */
	protected void sequence_AWhileDeclaration(EObject context, AWhileDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AWHILE_DECLARATION__TIME_DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AWHILE_DECLARATION__TIME_DOMAIN));
			if(transientValues.isValueTransient(semanticObject, AlphabetsPackage.Literals.AWHILE_DECLARATION__COND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AlphabetsPackage.Literals.AWHILE_DECLARATION__COND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAWhileDeclarationAccess().getTimeDomainADomainParserRuleCall_0_0(), semanticObject.getTimeDomain());
		feeder.accept(grammarAccess.getAWhileDeclarationAccess().getCondAAlphabetsExpressionParserRuleCall_2_0(), semanticObject.getCond());
		feeder.finish();
	}
}
