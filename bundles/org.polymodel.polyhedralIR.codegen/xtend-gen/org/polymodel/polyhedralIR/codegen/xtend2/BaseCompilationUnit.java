package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.inject.Inject;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class BaseCompilationUnit {
  @Inject
  @Extension
  private BaseCodeUnit extensions;

  public String externalFunctionHeader(final Program p) {
    String _xifexpression = null;
    int _size = p.getExternalFunctionDeclarations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      final Function1<ExternalFunctionDeclaration, CharSequence> _function = (ExternalFunctionDeclaration ex) -> {
        return this.externalFunctionDeclaration(ex);
      };
      String _join = IterableExtensions.<ExternalFunctionDeclaration>join(p.getExternalFunctionDeclarations(), "\n", _function);
      _xifexpression = ("//External Functions\n" + _join);
    }
    return _xifexpression;
  }

  public CharSequence externalFunctionDeclaration(final ExternalFunctionDeclaration exFunc) {
    StringConcatenation _builder = new StringConcatenation();
    Type _output = exFunc.getOutput();
    _builder.append(_output);
    _builder.append(" ");
    String _name = exFunc.getName();
    _builder.append(_name);
    _builder.append("(");
    final Function1<Type, CharSequence> _function = (Type t) -> {
      return this.name(t);
    };
    String _join = IterableExtensions.<Type>join(exFunc.getInputs(), ",", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }

  public String name(final Type type) {
    return type.toString();
  }

  public Map<String, String> generate(final CompilationUnit unit) {
    final TreeMap<String, String> files = new TreeMap<String, String>();
    files.put(CodeGenConstantsForC.EXTERNAL_FUNCTION_HEADER_NAME, this.externalFunctionHeader(unit.getProgram()));
    EList<CodeUnit> _units = unit.getUnits();
    for (final CodeUnit cu : _units) {
      files.put(this.extensions.filename(cu), this.extensions.generate(cu).toString());
    }
    return files;
  }
}
