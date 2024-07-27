package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field macroBodyProvider is undefined for the type CustomProviderStatement"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\ngetBody cannot be resolved"
      + "\ntoExpr cannot be resolved");
  }

  private /* List<IntExpression> */Object toExpr(final /* List<Variable> */Object vars) {
    throw new Error("Unresolved compilation problems:"
      + "\nIntExpression cannot be resolved to a type."
      + "\nVariable cannot be resolved to a type."
      + "\nIntExpressionBuilder cannot be resolved to a type."
      + "\nIntExpressionBuilder cannot be resolved to a type."
      + "\naffine cannot be resolved"
      + "\nterm cannot be resolved");
  }

  public CharSequence writeAccess(final EquationAsStatement stmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field expressions is undefined for the type AffineFunction"
      + "\nType mismatch: cannot convert from Object to PolymodelVisitable"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
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
