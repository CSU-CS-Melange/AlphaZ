package org.polymodel.polyhedralIR.codegen.xtend2.make;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

/**
 * Makefile to allow compiling from other directories. Used for regression tests.
 */
@SuppressWarnings("all")
public class TestingMakefile extends BaseMakefile {
  @Override
  public CharSequence cflagsOthers() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _cflagsOthers = super.cflagsOthers();
    _builder.append(_cflagsOthers);
    _builder.append(" -W");
    return _builder;
  }

  @Override
  public CharSequence objects(final List<CharSequence> names) {
    StringConcatenation _builder = new StringConcatenation();
    String objs = _builder.toString();
    for (final CharSequence s : names) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(objs);
      _builder_1.append("$(ALPHAZ_MAKE_DIR)/");
      _builder_1.append(s);
      _builder_1.append(".o ");
      objs = _builder_1.toString();
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(objs);
    return _builder_2;
  }

  @Override
  public CharSequence makeObjs(final List<CharSequence> names) {
    StringConcatenation _builder = new StringConcatenation();
    String objs = _builder.toString();
    for (final CharSequence name : names) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(objs);
      _builder_1.append("$(ALPHAZ_MAKE_DIR)/");
      _builder_1.append(name);
      _builder_1.append(".o : $(ALPHAZ_MAKE_DIR)/");
      _builder_1.append(name);
      _builder_1.append(".c");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("$(CC) $(ALPHAZ_MAKE_DIR)/");
      _builder_1.append(name, "\t");
      _builder_1.append(".c -o $(ALPHAZ_MAKE_DIR)/");
      _builder_1.append(name, "\t");
      _builder_1.append(".o $(CFLAGS) -c");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      objs = _builder_1.toString();
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(objs);
    return _builder_2;
  }

  @Override
  public CharSequence makefile(final CharSequence name, final List<CharSequence> names, final CharSequence verifyName, final boolean omp) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("$(ALPHAZ_MAKE_DIR)/");
    _builder_1.append(name);
    final String path = _builder_1.toString();
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("$(ALPHAZ_MAKE_DIR)/");
    _builder_2.append(verifyName);
    final String verifyPath = _builder_2.toString();
    _builder.newLineIfNotEmpty();
    _builder.append("CFLAGS=");
    CharSequence _ompflag = this.ompflag();
    _builder.append(_ompflag);
    _builder.append(" ");
    CharSequence _cflagsOptimization = this.cflagsOptimization();
    _builder.append(_cflagsOptimization);
    _builder.append(" ");
    CharSequence _cflagsOthers = this.cflagsOthers();
    _builder.append(_cflagsOthers);
    _builder.append(" ");
    CharSequence _includes = this.includes();
    _builder.append(_includes);
    _builder.append(" ");
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
    _builder.newLineIfNotEmpty();
    _builder.append("all: plain check");
    _builder.newLine();
    _builder.newLine();
    _builder.append("debug: CFLAGS =-DDEBUG -g ");
    CharSequence _cflagsOthers_1 = this.cflagsOthers();
    _builder.append(_cflagsOthers_1);
    _builder.append(" ");
    CharSequence _libraries_1 = this.libraries();
    _builder.append(_libraries_1);
    _builder.append(" ");
    CharSequence _includes_1 = this.includes();
    _builder.append(_includes_1);
    _builder.newLineIfNotEmpty();
    _builder.append("debug: all");
    _builder.newLine();
    _builder.newLine();
    _builder.append("ifndef ALPHAZ_MAKE_DIR");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ALPHAZ_MAKE_DIR=.");
    _builder.newLine();
    _builder.append("endif");
    _builder.newLine();
    _builder.newLine();
    _builder.append("plain: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(" $(OBJS) $(CFLAGS) -lm");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("check: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(".check $(OBJS) $(CFLAGS) -lm -D");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("check-noprompt: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(".check $(OBJS) $(CFLAGS) -lm -D");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.append(" -D");
    _builder.append(CodeGenConstantsForC.NO_PROMT_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("verify: $(OBJS) ");
    _builder.append(verifyPath);
    _builder.append(".o");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(".verify $(OBJS) ");
    _builder.append(verifyPath, "\t");
    _builder.append(".o $(CFLAGS) -lm -D");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("verify-noprompt: $(OBJS) ");
    _builder.append(verifyPath);
    _builder.append(".o");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(".verify $(OBJS) ");
    _builder.append(verifyPath, "\t");
    _builder.append(".o $(CFLAGS) -lm -D");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.append(" -D");
    _builder.append(CodeGenConstantsForC.NO_PROMT_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("verify-rand: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(path, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(path, "\t");
    _builder.append(".verify-rand $(OBJS) ");
    _builder.append(verifyName, "\t");
    _builder.append(".o $(CFLAGS) -lm -D");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.append(" -D");
    _builder.append(CodeGenConstantsForC.RANDOM_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _makeObjs = this.makeObjs(names);
    _builder.append(_makeObjs);
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append(verifyPath);
    _builder.append(".o : ");
    _builder.append(verifyPath);
    _builder.append(".c");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(verifyPath, "\t");
    _builder.append(".c -o ");
    _builder.append(verifyPath, "\t");
    _builder.append(".o $(CFLAGS) -c");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("clean:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rm -f $(ALPHAZ_MAKE_DIR)/*.o ");
    _builder.append(path, "\t");
    _builder.append(" ");
    _builder.append(path, "\t");
    _builder.append(".check ");
    _builder.append(path, "\t");
    _builder.append(".verify ");
    _builder.append(path, "\t");
    _builder.append(".verify-rand\t\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
