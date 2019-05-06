package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;

@SuppressWarnings("all")
public class MPICCodeUnit extends BaseCodeUnit {
  @Override
  public CharSequence commonIncludes(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonIncludes = super.commonIncludes(unit);
    _builder.append(_commonIncludes);
    _builder.newLineIfNotEmpty();
    _builder.append("#include <mpi.h>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroDefs = super.commonMacroDefs(unit);
    _builder.append(_commonMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    _builder.append(CodeGenConstantsForDistributed.BUFFERING_FACTOR);
    _builder.append(" 2");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroUndefs = super.commonMacroUndefs(unit);
    _builder.append(_commonMacroUndefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#undef ");
    _builder.append(CodeGenConstantsForDistributed.BUFFERING_FACTOR);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
