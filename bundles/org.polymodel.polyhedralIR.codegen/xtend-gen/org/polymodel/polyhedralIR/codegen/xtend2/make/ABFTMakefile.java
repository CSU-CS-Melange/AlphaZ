package org.polymodel.polyhedralIR.codegen.xtend2.make;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class ABFTMakefile extends BaseMakefile {
  @Override
  public CharSequence makefile(final CharSequence name, final List<CharSequence> names, final CharSequence verifyName, final boolean omp, final boolean withVerification) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CFLAGS=");
    {
      if (omp) {
        CharSequence _ompflag = this.ompflag();
        _builder.append(_ompflag);
        _builder.append(" ");
      }
    }
    _builder.append(" ");
    CharSequence _cflagsOptimization = this.cflagsOptimization();
    _builder.append(_cflagsOptimization);
    _builder.append(" ");
    CharSequence _cflagsOthers = this.cflagsOthers();
    _builder.append(_cflagsOthers);
    _builder.append(" ");
    CharSequence _includes = this.includes();
    _builder.append(_includes);
    _builder.newLineIfNotEmpty();
    _builder.append("LIBRARIES=");
    CharSequence _libraries = this.libraries();
    _builder.append(_libraries);
    _builder.newLineIfNotEmpty();
    _builder.append("CC?=");
    CharSequence _cc = this.cc();
    _builder.append(_cc);
    _builder.newLineIfNotEmpty();
    _builder.append("OBJS = ");
    CharSequence _objects = this.objects(names);
    _builder.append(_objects);
    _builder.append("init.o conv.o");
    _builder.newLineIfNotEmpty();
    _builder.append("all: plain check");
    {
      if (withVerification) {
        _builder.append(" verify verify-rand");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("debug: CFLAGS =-DDEBUG -g -Wall -Wextra");
    CharSequence _cflagsOthers_1 = this.cflagsOthers();
    _builder.append(_cflagsOthers_1);
    CharSequence _includes_1 = this.includes();
    _builder.append(_includes_1);
    _builder.newLineIfNotEmpty();
    _builder.append("debug: all");
    _builder.newLine();
    _builder.newLine();
    _builder.append("plain: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(name, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(name, "\t");
    _builder.append(" $(OBJS) $(CFLAGS) $(LIBRARIES)");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("check: ");
    _builder.append(name);
    _builder.append("-err.o init.o conv.o");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(name, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(name, "\t");
    _builder.append(".check ");
    _builder.append(name, "\t");
    _builder.append("-err.o init.o conv.o $(CFLAGS) $(LIBRARIES) -D");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.append(" -D");
    _builder.append(CodeGenConstantsForC.RANDOM_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("init.o : init.c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) init.c -o init.o $(CFLAGS) $(LIBRARIES) -c");
    _builder.newLine();
    _builder.newLine();
    _builder.append("conv.o : conv.c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) conv.c -o conv.o $(CFLAGS) $(LIBRARIES) -c");
    _builder.newLine();
    _builder.newLine();
    CharSequence _makeObjs = this.makeObjs(names);
    _builder.append(_makeObjs);
    _builder.newLineIfNotEmpty();
    _builder.append(name);
    _builder.append("-err.o: ");
    _builder.append(name);
    _builder.append("-err.c");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(name, "\t");
    _builder.append("-err.c -o ");
    _builder.append(name, "\t");
    _builder.append("-err.o $(CFLAGS) $(LIBRARIES) -c");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("clean:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm -f *.o ");
    _builder.append(name, "\t");
    _builder.append(" ");
    _builder.append(name, "\t");
    _builder.append(".check");
    {
      if (withVerification) {
        _builder.append(" ");
        _builder.append(name, "\t");
        _builder.append(".verify ");
        _builder.append(name, "\t");
        _builder.append(".verify-rand");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
