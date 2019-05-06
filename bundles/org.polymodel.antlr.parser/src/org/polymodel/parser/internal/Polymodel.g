grammar Polymodel;
options {
  language=Java;
  output   = AST;
}
import Lexer,IntAlgebra; 

@header {
package org.polymodel.parser;

import java.util.HashMap;
import static org.polymodel.algebra.factory.IntExpressionBuilder.*;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.impl.VariableImpl;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.polymodel.Domain;
import org.polymodel.Relation;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.impl.VariableImpl;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.floord;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mod;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mul;
import static org.polymodel.algebra.factory.IntExpressionBuilder.qaffine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

}

@lexer::header {
package org.polymodel.parser;
}

@parser::members {

      public static Domain parseDomain(String input) throws RecognitionException {
        CharStream cs = new ANTLRStringStream(input);
        PolymodelLexer lexer = new PolymodelLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        PolymodelParser parser = new PolymodelParser(tokens);
        return (Domain) parser.domain().dom;
      }

      public static Relation parseRelation(String input) throws RecognitionException {
        CharStream cs = new ANTLRStringStream(input);
        PolymodelLexer lexer = new PolymodelLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        PolymodelParser parser = new PolymodelParser(tokens);
        return (Relation) parser.relation().rel;
      }
      
      
      
}

domain returns [Domain dom]:
   paramIds=paramIdList '{' '[' setIds=idList ']'  ':' systemUnion=intConstrSystemUnion '}' {
        $dom  = PolymodelParserHelper.domain($paramIds.vars,$setIds.vars,$systemUnion.value);
  };   

exist returns [IntConstraintSystem system] : 'exists' s=ID {  
    Variable v = VariableScopeManager.getInstance().addVariable($s.text);   
  } '(' ssystem=intConstrSystem')'  {
    
  }
  ;  
 
idList returns [List<Variable> vars]:
  { List<Variable> l = new ArrayList<Variable>();} 
  s=ID {  
    Variable v = VariableScopeManager.getInstance().addVariable($s.text);
      l.add(v);
    }   
   (',' s=ID { 
      v = VariableScopeManager.getInstance().addVariable($s.text);
      l.add(v);
      $vars=l;
  })*;      
    
paramIdList returns [List<Variable> vars]:
  '[' { List<Variable> l = new ArrayList<Variable>();} 
  (s=ID {  
    Variable v = VariableScopeManager.getInstance().addVariable($s.text);   
    l.add(v); 
  }  
  (',' s=ID { 
      v = VariableScopeManager.getInstance().addVariable($s.text);
      l.add(v);
      ;
  })*)? ']' '->' {$vars=l;};      
      
relation returns [Relation rel]:
  params=paramIdList '{' '[' in=idList ']' '->' '[' out=idList ']' ':' systemUnion=intConstrSystemUnion '}' {
        $rel  = PolymodelParserHelper.relation(params.vars,in.vars,out.vars,systemUnion.value);
  };

  