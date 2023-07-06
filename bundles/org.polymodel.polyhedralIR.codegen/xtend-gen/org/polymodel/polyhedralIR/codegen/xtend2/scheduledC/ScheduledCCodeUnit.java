package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;

@SuppressWarnings("all")
public class ScheduledCCodeUnit extends BaseCodeUnit {
  @Override
  public CharSequence commonMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroDefs = super.commonMacroDefs(unit);
    _builder.append(_commonMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.append("// Reduction Operators");
    _builder.newLine();
    _builder.append("#define RADD(x,y)    ((x)+=(y))");
    _builder.newLine();
    _builder.append("#define RMUL(x,y)    ((x)*=(y))");
    _builder.newLine();
    _builder.append("#define RMAX(x,y)    ((x)=MAX((x),(y)))");
    _builder.newLine();
    _builder.append("#define RMIN(x,y)    ((x)=MIN((x),(y)))");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroUndefs = super.commonMacroUndefs(unit);
    _builder.append(_commonMacroUndefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#undef RADD");
    _builder.newLine();
    _builder.append("#undef RMUL");
    _builder.newLine();
    _builder.append("#undef RMAX");
    _builder.newLine();
    _builder.append("#undef RMIN");
    _builder.newLine();
    return _builder;
  }
}
