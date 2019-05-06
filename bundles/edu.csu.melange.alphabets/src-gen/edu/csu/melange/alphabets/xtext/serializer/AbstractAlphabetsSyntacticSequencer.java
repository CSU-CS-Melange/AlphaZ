package edu.csu.melange.alphabets.xtext.serializer;

import com.google.inject.Inject;
import edu.csu.melange.alphabets.xtext.services.AlphabetsGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractAlphabetsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlphabetsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AAffineSystemA_InputKeyword_3_0_0_q;
	protected AbstractElementAlias match_AAffineSystemA_LetKeyword_3_4_0_q;
	protected AbstractElementAlias match_AAffineSystemA_LocalKeyword_3_2_0_q;
	protected AbstractElementAlias match_AAffineSystemA_OutputKeyword_3_1_0_q;
	protected AbstractElementAlias match_AAffineSystemB_GivenKeyword_3_0_0_q;
	protected AbstractElementAlias match_AAffineSystemB_ReturnsKeyword_3_1_0_q;
	protected AbstractElementAlias match_AAffineSystemB_ThroughKeyword_3_3_0_q;
	protected AbstractElementAlias match_AAffineSystemB_UsingKeyword_3_2_0_q;
	protected AbstractElementAlias match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlphabetsGrammarAccess) access;
		match_AAffineSystemA_InputKeyword_3_0_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAAccess().getInputKeyword_3_0_0());
		match_AAffineSystemA_LetKeyword_3_4_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAAccess().getLetKeyword_3_4_0());
		match_AAffineSystemA_LocalKeyword_3_2_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAAccess().getLocalKeyword_3_2_0());
		match_AAffineSystemA_OutputKeyword_3_1_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAAccess().getOutputKeyword_3_1_0());
		match_AAffineSystemB_GivenKeyword_3_0_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemBAccess().getGivenKeyword_3_0_0());
		match_AAffineSystemB_ReturnsKeyword_3_1_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemBAccess().getReturnsKeyword_3_1_0());
		match_AAffineSystemB_ThroughKeyword_3_3_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemBAccess().getThroughKeyword_3_3_0());
		match_AAffineSystemB_UsingKeyword_3_2_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemBAccess().getUsingKeyword_3_2_0());
		match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getINTERSECTIONRule())
			return getINTERSECTIONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getUNIONRule())
			return getUNIONToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal INTERSECTION : '&&' ;
	 */
	protected String getINTERSECTIONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "&&";
	}
	
	/**
	 * terminal UNION : '||' ;
	 */
	protected String getUNIONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "||";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AAffineSystemA_InputKeyword_3_0_0_q.equals(syntax))
				emit_AAffineSystemA_InputKeyword_3_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemA_LetKeyword_3_4_0_q.equals(syntax))
				emit_AAffineSystemA_LetKeyword_3_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemA_LocalKeyword_3_2_0_q.equals(syntax))
				emit_AAffineSystemA_LocalKeyword_3_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemA_OutputKeyword_3_1_0_q.equals(syntax))
				emit_AAffineSystemA_OutputKeyword_3_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemB_GivenKeyword_3_0_0_q.equals(syntax))
				emit_AAffineSystemB_GivenKeyword_3_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemB_ReturnsKeyword_3_1_0_q.equals(syntax))
				emit_AAffineSystemB_ReturnsKeyword_3_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemB_ThroughKeyword_3_3_0_q.equals(syntax))
				emit_AAffineSystemB_ThroughKeyword_3_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystemB_UsingKeyword_3_2_0_q.equals(syntax))
				emit_AAffineSystemB_UsingKeyword_3_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'input'?
	 */
	protected void emit_AAffineSystemA_InputKeyword_3_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'let'?
	 */
	protected void emit_AAffineSystemA_LetKeyword_3_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'local'?
	 */
	protected void emit_AAffineSystemA_LocalKeyword_3_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'output'?
	 */
	protected void emit_AAffineSystemA_OutputKeyword_3_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'given'?
	 */
	protected void emit_AAffineSystemB_GivenKeyword_3_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'returns'?
	 */
	protected void emit_AAffineSystemB_ReturnsKeyword_3_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'through'?
	 */
	protected void emit_AAffineSystemB_ThroughKeyword_3_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'using'?
	 */
	protected void emit_AAffineSystemB_UsingKeyword_3_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
