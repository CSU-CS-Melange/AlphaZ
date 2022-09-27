package org.polymodel.polyhedralIR.codegen.xtend2.make;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MPICMakefile extends BaseMakefile {
  @Override
  public CharSequence cc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mpicc");
    return _builder;
  }
}
