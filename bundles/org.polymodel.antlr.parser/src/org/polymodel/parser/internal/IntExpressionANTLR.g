grammar IntExpressionANTLR;

options {
	language=Java;
	output   = AST;
}

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

import org.polymodel.algebra.*;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineFactory;
import org.polymodel.algebra.affine.AffineTerm;

import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

}

@lexer::header {
package org.polymodel.parser;

import java.util.HashMap; 
}
 
@members {

      public static IntExpression parseIntExpression(String input, Variable... vars) throws RecognitionException {
        CharStream cs = new ANTLRStringStream(input);
        IntExpressionANTLRLexer lexer = new IntExpressionANTLRLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        IntExpressionANTLRParser parser = new IntExpressionANTLRParser(tokens);
        for(Variable v : vars) {
          parser.symTable.put(v.toString(),v);
        }    
        return (IntExpression) parser.intExpr().value;
      }

      public static IntConstraint parseIntConstraint(String input, Variable... vars) throws RecognitionException {
        CharStream cs = new ANTLRStringStream(input);
        IntExpressionANTLRLexer lexer = new IntExpressionANTLRLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        IntExpressionANTLRParser parser = new IntExpressionANTLRParser(tokens);
        for(Variable v : vars) {
          parser.symTable.put(v.toString(),v);
        }    
        return (IntConstraint) parser.intConstr().value;
      }

       public static IntConstraintSystem parseIntConstraintSystem(String input, Variable... vars) throws RecognitionException {
        CharStream cs = new ANTLRStringStream(input);
        IntExpressionANTLRLexer lexer = new IntExpressionANTLRLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        IntExpressionANTLRParser parser = new IntExpressionANTLRParser(tokens);
        for(Variable v : vars) {
          parser.symTable.put(v.toString(),v);
        }    
        return (IntConstraintSystem) parser.intConstrSystem().value;
      }

  /** Map variable name to Integer object holding value */
  HashMap<String,Variable> symTable = new HashMap<String,Variable>();

  public class NamedVariable extends VariableImpl {
    String id;
    
    public NamedVariable(String id) {
      this.id=id;
      this.name=id;
    }
    
    @Override
    public String toString() {
      return id ;
    }
  }

  private boolean createScope=true;

  private Variable getVariable(String txt) {
      if (symTable.get(txt)!=null) {
          return symTable.get(txt);       
      } else {
          if(createScope) {
	          NamedVariable v = new NamedVariable(txt);
	          symTable.put(txt,v);
	          return v;
          } else {
            throw new RuntimeException("Unknown symbol "+txt);
          }
      }
  }
}
   
                
intExpr returns [IntExpression value]:
  (e=quasiAffineExpr {$value=$e.value;}) ; 

intConstr returns [IntConstraint value]:
  lhs=intExpr {ComparisonOperator op;}
  ( 
    ('<=' {op=ComparisonOperator.LE;}) |
    ('<'  {op=ComparisonOperator.LT;}) |  
    ('='  {op=ComparisonOperator.EQ;}) |
    ('>=' {op=ComparisonOperator.GE;}) |
    ('>'  {op=ComparisonOperator.GT;})
    {$value=constraint($lhs.value,null,op);}
  )
  rhs=intExpr {$value.setRhs($rhs.value);} ; 

intConstrSystem returns [IntConstraintSystem value]:
  e=intConstr {$value =constraintSystem($e.value);} (('&'|'and') e=intConstr  { $value .getConstraints().add($e.value);})*; 

intConstrSystemUnion returns [List<IntConstraintSystem> value]:
  e=intConstrSystem {$value = new ArrayList<IntConstraintSystem>();$value.add($e.value);} 
  (('|'|'or') e=intConstrSystem  { $value.add($e.value);})*; 


  

quasiAffineExpr returns [QuasiAffineExpression value]:
  m= multiplicativeExp {
      QuasiAffineExpression qaffExpr = QuasiAffineFactory.eINSTANCE.createQuasiAffineExpression();
      qaffExpr.getTerms().add($m.value);
      $value = qaffExpr;
  } 
  (op=('+'|'-') m= multiplicativeExp {
      if(($op.getText()).equals("+")) {
        qaffExpr.getTerms().add($m.value);
        $value = qaffExpr;
      } else {
        qaffExpr.getTerms().add(mul(qaffine($m.value),-1));
      }
  })*;
  
//  {int neg=0} ('-' {neg=-1;})? base=unaryTerm {
//      AffineTerm affT= $e.value;
//      affT.setCoef(neg*affT.getCoef());  
//      $value = affT;
//  };

multiplicativeExp returns [QuasiAffineTerm value]:
  e=unaryTerm {
    $value = $e.value;
  }
  (op=('/'|'%') c=INT {
         
      if(($op.getText()).equals("/"))
        $value = floord(qaffine($e.value), Integer.parseInt($c.getText()));
      else 
        $value = mod(qaffine($e.value), Integer.parseInt($c.getText()));
  })?;
  

unaryTerm returns [QuasiAffineTerm value]:
  {int neg=0;} 
  ('-' {neg=-1;})? base=baseAffTerm {
    if(neg==-1) {
        $value = mul(qaffine($base.value), -1);
    } else {
        $value = $base.value;
    }
  };


baseAffTerm returns [QuasiAffineTerm value]:
    INT {
      $value = mul(affine(term(Integer.parseInt($INT.text))),1);
      }
    |   
    (INT ID)
        {  
        Variable v = getVariable($ID.text);
        Integer  l = Integer.parseInt($INT.text);
        $value = mul(affine(term((long)l,v)),1);
       
        }
    |   ID
        {
        Variable v = getVariable($ID.text);
        $value = mul(affine(term((long)1,v)),1);
        }
        
    | '(' e=quasiAffineExpr ')' {
        $value = mul($e.value,1);
    }
    | INT '(' e=quasiAffineExpr ')' {
        $value = mul($e.value,Integer.parseInt($INT.text));
    }
    
;

ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;	