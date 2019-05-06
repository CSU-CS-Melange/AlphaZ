parser grammar IntAlgebra;
              
              
@parser::members {
  VariableScopeManager manager ;
}
                
intExpr returns [IntExpression value]:
  (e=quasiAffineExpr {$value=$e.value;}) ; 

intConstr returns [IntConstraint value]:
  lhs=intExpr {ComparisonOperator op = ComparisonOperator.LE;}
  ( 
    ('<=' {op=ComparisonOperator.LE;}) |
    ('<'  {op=ComparisonOperator.LT;}) |  
    ('='  {op=ComparisonOperator.EQ;}) |
    ('>=' {op=ComparisonOperator.GE;}) |
    ('>'  {op=ComparisonOperator.GT;})
    
    
  ) 
    
  rhs=intExpr {$value=constraint($lhs.value,$rhs.value,op);} ; 

intConstrSystem returns [IntConstraintSystem value]:
  e=intConstr {$value =constraintSystem($e.value);} (('&'|'and') e=intConstr  { $value .getConstraints().add($e.value);})*; 

intConstrSystemUnion returns [List<IntConstraintSystem> value]:
  e=intConstrSystem {$value = new ArrayList<IntConstraintSystem>();$value.add($e.value);} (('|'|'or') e=intConstrSystem  { $value.add($e.value);})*; 

  
  

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
        // helo
        Variable v = VariableScopeManager.getInstance().getVariable($ID.text); 
        Integer  l = Integer.parseInt($INT.text);
        $value = mul(affine(term((long)l,v)),1);  
       
        }
    |   ID
        {
        Variable v = VariableScopeManager.getInstance().getVariable($ID.text);
        $value = mul(affine(term((long)1,v)),1);
        }
        
    | '(' e=quasiAffineExpr ')' {  
        $value = mul($e.value,1);
    }
    | INT '(' e=quasiAffineExpr ')' {
        $value = mul($e.value,Integer.parseInt($INT.text));
    }
    
;


