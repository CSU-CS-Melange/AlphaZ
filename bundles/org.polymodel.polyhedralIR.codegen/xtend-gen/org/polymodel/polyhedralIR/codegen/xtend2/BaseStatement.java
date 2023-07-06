package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.Statement;

@SuppressWarnings("all")
public class BaseStatement {
  @Inject
  @Extension
  private BaseExpression expression;
  
  @Inject
  @Extension
  private BaseIndices indices;
  
  protected CharSequence _statementDefine(final BasicStatement stmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    String _name = stmt.getName();
    _builder.append(_name);
    _builder.append("(");
    CharSequence _macroIndices = this.indices.getMacroIndices(stmt.getDomain());
    _builder.append(_macroIndices);
    _builder.append(") ");
    String _statement = stmt.getStatement();
    _builder.append(_statement);
    return _builder;
  }
  
  protected CharSequence _statementDefine(final EquationAsStatement stmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    String _name = stmt.getName();
    _builder.append(_name);
    _builder.append("(");
    CharSequence _macroIndices = this.indices.getMacroIndices(stmt.getAccessFunction());
    _builder.append(_macroIndices);
    _builder.append(") ");
    CharSequence _writeAccess = this.writeAccess(stmt);
    _builder.append(_writeAccess);
    _builder.append(" = ");
    CharSequence _print = this.expression.print(stmt.getRhs(), stmt.getVariable().getCodeunit(), stmt.getContainerLoop().getFunction());
    _builder.append(_print);
    return _builder;
  }
  
  protected CharSequence _statementDefine(final CustomProviderStatement stmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    String _name = stmt.getName();
    _builder.append(_name);
    _builder.append("(");
    CharSequence _macroIndices = this.indices.getMacroIndices(stmt.getDomain());
    _builder.append(_macroIndices);
    _builder.append(") ");
    String _body = stmt.getMacroBodyProvider().getBody(this.toExpr(stmt.getDomain().getIndices()));
    _builder.append(_body);
    return _builder;
  }
  
  private List<IntExpression> toExpr(final List<Variable> vars) {
    ArrayList<IntExpression> exprs = new ArrayList<IntExpression>();
    for (final Variable v : vars) {
      exprs.add(IntExpressionBuilder.affine(IntExpressionBuilder.term(v)));
    }
    return exprs;
  }
  
  public CharSequence writeAccess(final EquationAsStatement stmt) {
    CharSequence _xifexpression = null;
    boolean _isScalar = Utility.isScalar(stmt.getVariable());
    boolean _not = (!_isScalar);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = stmt.getVariable().getName();
      _builder.append(_name);
      _builder.append("(");
      final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
        return Utility.toCString(e);
      };
      String _join = IterableExtensions.<AffineExpression>join(stmt.getAccessFunction().getExpressions(), ",", _function);
      _builder.append(_join);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _contains = stmt.getContainerLoop().getFunction().getLocals().contains(stmt.getVariable());
      if (_contains) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = stmt.getVariable().getName();
        _builder_1.append(_name_1);
        _xifexpression_1 = _builder_1;
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("*");
        String _name_2 = stmt.getVariable().getName();
        _builder_2.append(_name_2);
        _xifexpression_1 = _builder_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence statementUndefine(final Statement stmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#undef ");
    String _name = stmt.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence statementDefine(final Statement stmt) {
    if (stmt instanceof BasicStatement) {
      return _statementDefine((BasicStatement)stmt);
    } else if (stmt instanceof EquationAsStatement) {
      return _statementDefine((EquationAsStatement)stmt);
    } else if (stmt instanceof CustomProviderStatement) {
      return _statementDefine((CustomProviderStatement)stmt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stmt).toString());
    }
  }
}
