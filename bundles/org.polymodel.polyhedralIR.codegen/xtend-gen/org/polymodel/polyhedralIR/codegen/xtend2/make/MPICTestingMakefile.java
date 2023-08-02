package org.polymodel.polyhedralIR.codegen.xtend2.make;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MPICTestingMakefile extends TestingMakefile {
  @Override
  public CharSequence cc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mpicc");
    return _builder;
  }

  @Override
  public CharSequence includes() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _includes = super.includes();
    _builder.append(_includes);
    _builder.append(" -I$(MPI_INCLUDE_DIR)");
    return _builder;
  }

  @Override
  public CharSequence makefile(final CharSequence name, final List<CharSequence> names, final CharSequence verifyName, final boolean omp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ifndef MPI_INCLUDE_DIR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MPI_INCLUDE_DIR=/usr/include/openmpi-x86_64/");
    _builder.newLine();
    _builder.append("endif");
    _builder.newLine();
    CharSequence _makefile = super.makefile(name, names, verifyName, omp);
    _builder.append(_makefile);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
