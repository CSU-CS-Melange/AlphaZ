package org.polymodel.polyhedralIR.codegen.xtend2.simd;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.codegen.xtend2.simd.SIMDCExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;

/**
 * SIMDStatement is conflicting with the type, so this class is named SIMDStatementGen
 */
@SuppressWarnings("all")
public class SIMDStatementGen extends BaseStatement {
  @Inject
  @Extension
  private SIMDCExpression expression;
  
  @Inject
  @Extension
  private BaseIndices indices;
  
  public CharSequence statementDefine(final SIMDStatement stmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    String _name = stmt.getName();
    _builder.append(_name);
    _builder.append("(");
    CharSequence _macroIndices = this.indices.getMacroIndices(stmt.getDomain());
    _builder.append(_macroIndices);
    _builder.append(") ");
    CharSequence _printSIMD = this.expression.printSIMD(stmt.getSimdExp());
    _builder.append(_printSIMD);
    return _builder;
  }
}
