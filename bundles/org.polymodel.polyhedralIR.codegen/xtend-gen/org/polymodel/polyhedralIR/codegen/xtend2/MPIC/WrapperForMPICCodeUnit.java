package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.wrapperC.WrapperCCodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;

@SuppressWarnings("all")
public class WrapperForMPICCodeUnit extends WrapperCCodeUnit {
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
}
