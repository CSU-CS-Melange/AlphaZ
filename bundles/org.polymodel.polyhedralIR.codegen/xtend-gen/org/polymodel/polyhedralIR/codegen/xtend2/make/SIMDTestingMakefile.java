package org.polymodel.polyhedralIR.codegen.xtend2.make;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.make.TestingMakefile;

@SuppressWarnings("all")
public class SIMDTestingMakefile extends TestingMakefile {
  @Override
  public CharSequence cflagsOthers() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _cflagsOthers = super.cflagsOthers();
    _builder.append(_cflagsOthers);
    _builder.append(" -mavx");
    return _builder;
  }
}
