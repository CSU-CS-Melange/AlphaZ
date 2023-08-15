package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;

@SuppressWarnings("all")
public class ABFTScheduledCStatement extends BaseStatement {
  public static ABFTCodeGenOptions options;
  
  @Inject
  @Extension
  private BaseExpression expression;
  
  @Inject
  @Extension
  private BaseIndices indices;
  
  @Override
  protected CharSequence _statementDefine(final EquationAsStatement stmt) {
    CharSequence _xblockexpression = null;
    {
      final String abftProtectedVar = ABFTScheduledCStatement.options.weightsVar.split("_")[1];
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _writeAccess = this.writeAccess(stmt);
      _builder.append(_writeAccess);
      _builder.append(" = ");
      CharSequence _print = this.expression.print(stmt.getRhs(), stmt.getVariable().getCodeunit(), stmt.getContainerLoop().getFunction());
      _builder.append(_print);
      final String stmtCode = _builder.toString();
      boolean _equals = stmt.getVarDecl().getVarID().getName().equals(abftProtectedVar);
      boolean _not = (!_equals);
      if (_not) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("#define ");
        String _name = stmt.getName();
        _builder_1.append(_name);
        _builder_1.append("(");
        CharSequence _macroIndices = this.indices.getMacroIndices(stmt.getAccessFunction());
        _builder_1.append(_macroIndices);
        _builder_1.append(") ");
        _builder_1.append(stmtCode);
        return _builder_1;
      }
      final Function1<AffineExpression, String> _function = (AffineExpression it) -> {
        return it.toString();
      };
      final List<String> indices = IterableExtensions.<String>toList(ListExtensions.<AffineExpression, String>map(stmt.getAccessFunction().getExpressions(), _function));
      String _xifexpression = null;
      if ((ABFTScheduledCStatement.options.numDims == 1)) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("(");
        String _get = indices.get(0);
        _builder_2.append(_get);
        _builder_2.append("==T_INJ && ");
        String _get_1 = indices.get(1);
        _builder_2.append(_get_1);
        _builder_2.append("==I_INJ)");
        _xifexpression = _builder_2.toString();
      } else {
        String _xifexpression_1 = null;
        if ((ABFTScheduledCStatement.options.numDims == 2)) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("(");
          String _get_2 = indices.get(0);
          _builder_3.append(_get_2);
          _builder_3.append("==T_INJ && ");
          String _get_3 = indices.get(1);
          _builder_3.append(_get_3);
          _builder_3.append("==I_INJ && ");
          String _get_4 = indices.get(2);
          _builder_3.append(_get_4);
          _builder_3.append("==J_INJ)");
          _xifexpression_1 = _builder_3.toString();
        } else {
          String _xifexpression_2 = null;
          if ((ABFTScheduledCStatement.options.numDims == 3)) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("(");
            String _get_5 = indices.get(0);
            _builder_4.append(_get_5);
            _builder_4.append("==T_INJ && ");
            String _get_6 = indices.get(1);
            _builder_4.append(_get_6);
            _builder_4.append("==I_INJ && ");
            String _get_7 = indices.get(2);
            _builder_4.append(_get_7);
            _builder_4.append("==J_INJ && ");
            String _get_8 = indices.get(3);
            _builder_4.append(_get_8);
            _builder_4.append("==K_INJ)");
            _xifexpression_2 = _builder_4.toString();
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      final String injectionCondition = _xifexpression;
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("#define ");
      String _name_1 = stmt.getName();
      _builder_5.append(_name_1);
      _builder_5.append("(");
      CharSequence _macroIndices_1 = this.indices.getMacroIndices(stmt.getAccessFunction());
      _builder_5.append(_macroIndices_1);
      _builder_5.append(") do { ");
      _builder_5.append(stmtCode);
      _builder_5.append("; if ");
      _builder_5.append(injectionCondition);
      _builder_5.append(" {inject(Y);}; } while (0)");
      _xblockexpression = _builder_5;
    }
    return _xblockexpression;
  }
  
  @Override
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
