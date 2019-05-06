package org.polymodel.polyhedralIR.codegen.xtend2.scanC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;

@SuppressWarnings("all")
public class ScanCCodeUnit extends BaseCodeUnit {
  @Override
  public CharSequence commonIncludes(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonIncludes = super.commonIncludes(unit);
    _builder.append(_commonIncludes);
    _builder.newLineIfNotEmpty();
    _builder.append("#include <omp.h>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroDefs = super.commonMacroDefs(unit);
    _builder.append(_commonMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.append("//Newton Raphson Macros");
    _builder.newLine();
    _builder.append("#define MAX_ITER 100");
    _builder.newLine();
    _builder.append("#define eps 1e-10");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroUndefs = super.commonMacroUndefs(unit);
    _builder.append(_commonMacroUndefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#undef MAX_ITER");
    _builder.newLine();
    _builder.append("#undef eps");
    _builder.newLine();
    return _builder;
  }
}
