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
public class AlphabetsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlphabetsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AAffineSystem_GivenKeyword_3_0_q;
	protected AbstractElementAlias match_AAffineSystem_ReturnsKeyword_4_0_q;
	protected AbstractElementAlias match_AAffineSystem_ThroughKeyword_6_0_q;
	protected AbstractElementAlias match_AAffineSystem_UsingKeyword_5_0_q;
	protected AbstractElementAlias match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlphabetsGrammarAccess) access;
		match_AAffineSystem_GivenKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAccess().getGivenKeyword_3_0());
		match_AAffineSystem_ReturnsKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAccess().getReturnsKeyword_4_0());
		match_AAffineSystem_ThroughKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAccess().getThroughKeyword_6_0());
		match_AAffineSystem_UsingKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getAAffineSystemAccess().getUsingKeyword_5_0());
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
			if(match_AAffineSystem_GivenKeyword_3_0_q.equals(syntax))
				emit_AAffineSystem_GivenKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystem_ReturnsKeyword_4_0_q.equals(syntax))
				emit_AAffineSystem_ReturnsKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystem_ThroughKeyword_6_0_q.equals(syntax))
				emit_AAffineSystem_ThroughKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AAffineSystem_UsingKeyword_5_0_q.equals(syntax))
				emit_AAffineSystem_UsingKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParanthesizedAlphabetsExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'given'?
	 */
	protected void emit_AAffineSystem_GivenKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'returns'?
	 */
	protected void emit_AAffineSystem_ReturnsKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'through'?
	 */
	protected void emit_AAffineSystem_ThroughKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'using'?
	 */
	protected void emit_AAffineSystem_UsingKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
