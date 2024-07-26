package org.polymodel.polyhedralIR.codegen.xtend2.make;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class BaseMakefile {
  public Map<String, String> generate(final AffineSystem system, final List<AffineSystem> systems, final boolean omp) {
    return this.generate(system, systems, omp, false);
  }

  public Map<String, String> generate(final AffineSystem system, final List<AffineSystem> systems, final boolean omp, final boolean withVerification) {
    final TreeMap<String, String> files = new TreeMap<String, String>();
    final LinkedList<CharSequence> systemNames = new LinkedList<CharSequence>();
    for (final AffineSystem sys : systems) {
      systemNames.add(sys.getName());
    }
    String _name = system.getName();
    String _name_1 = system.getName();
    String _plus = (_name_1 + CodeGenConstantsForC.VERIFY_POSTFIX);
    files.put("Makefile", this.makefile(_name, systemNames, _plus, omp, withVerification).toString());
    return files;
  }

  public CharSequence cflagsOptimization() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-O3");
    return _builder;
  }

  public CharSequence cflagsOthers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("-std=c99");
    return _builder;
  }

  public CharSequence includes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("-I/usr/include/malloc/");
    return _builder;
  }

  public CharSequence libraries() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-lm");
    return _builder;
  }

  public CharSequence ompflag() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-fopenmp");
    return _builder;
  }

  public CharSequence cc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("gcc");
    return _builder;
  }

  public CharSequence objects(final List<CharSequence> names) {
    StringConcatenation _builder = new StringConcatenation();
    String objs = _builder.toString();
    for (final CharSequence s : names) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(objs);
      _builder_1.append(s);
      _builder_1.append(".o ");
      objs = _builder_1.toString();
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(objs);
    return _builder_2;
  }

  public CharSequence makeObjs(final List<CharSequence> names) {
    StringConcatenation _builder = new StringConcatenation();
    String objs = _builder.toString();
    for (final CharSequence name : names) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(objs);
      _builder_1.append(name);
      _builder_1.append(".o : ");
      _builder_1.append(name);
      _builder_1.append(".c");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("$(CC) ");
      _builder_1.append(name, "\t");
      _builder_1.append(".c -o ");
      _builder_1.append(name, "\t");
      _builder_1.append(".o $(CFLAGS) $(LIBRARIES) -c");
      _builder_1.newLineIfNotEmpty();
      _builder_1.newLine();
      objs = _builder_1.toString();
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(objs);
    return _builder_2;
  }

  public CharSequence makefile(final CharSequence name, final List<CharSequence> names, final CharSequence verifyName, final boolean omp) {
    return this.makefile(name, names, verifyName, omp, false);
  }

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
    _builder.append("check: $(OBJS)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(CC) ");
    _builder.append(name, "\t");
    _builder.append("-wrapper.c -o ");
    _builder.append(name, "\t");
    _builder.append(".check $(OBJS) $(CFLAGS) $(LIBRARIES) -D");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.append(" -DRANDOM");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      if (withVerification) {
        _builder.append("verify: $(OBJS) ");
        _builder.append(verifyName);
        _builder.append(".o");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("$(CC) ");
        _builder.append(name, "\t");
        _builder.append("-wrapper.c -o ");
        _builder.append(name, "\t");
        _builder.append(".verify $(OBJS) ");
        _builder.append(verifyName, "\t");
        _builder.append(".o $(CFLAGS) $(LIBRARIES) -D");
        _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("verify-rand: $(OBJS) ");
        _builder.append(verifyName);
        _builder.append(".o");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("$(CC) ");
        _builder.append(name, "\t");
        _builder.append("-wrapper.c -o ");
        _builder.append(name, "\t");
        _builder.append(".verify-rand $(OBJS) ");
        _builder.append(verifyName, "\t");
        _builder.append(".o $(CFLAGS) $(LIBRARIES) -D");
        _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
        _builder.append(" -D");
        _builder.append(CodeGenConstantsForC.RANDOM_FLAG, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    CharSequence _makeObjs = this.makeObjs(names);
    _builder.append(_makeObjs);
    _builder.newLineIfNotEmpty();
    {
      if (withVerification) {
        _builder.append(verifyName);
        _builder.append(".o : ");
        _builder.append(verifyName);
        _builder.append(".c");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("$(CC) ");
        _builder.append(verifyName, "\t");
        _builder.append(".c -o ");
        _builder.append(verifyName, "\t");
        _builder.append(".o $(CFLAGS) $(LIBRARIES) -c");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
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
