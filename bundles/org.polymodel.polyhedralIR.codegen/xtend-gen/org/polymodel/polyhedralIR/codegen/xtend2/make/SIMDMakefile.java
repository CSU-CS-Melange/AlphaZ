package org.polymodel.polyhedralIR.codegen.xtend2.make;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.make.BaseMakefile;

@SuppressWarnings("all")
public class SIMDMakefile extends BaseMakefile {
  @Override
  public CharSequence libraries() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _libraries = super.libraries();
    _builder.append(_libraries);
    _builder.append(" -mavx");
    return _builder;
  }
}
