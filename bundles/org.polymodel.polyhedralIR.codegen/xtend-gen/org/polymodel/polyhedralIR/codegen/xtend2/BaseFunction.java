package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class BaseFunction {
  @Inject
  @Extension
  private BaseBody extensions;

  public String nameEsc(final FunctionSignature fs) {
    return this.nameEsc(fs.getName());
  }

  public String nameEsc(final String fname) {
    String name = fname.replaceAll("\\-", "_");
    boolean _matches = name.matches("\\d.+");
    if (_matches) {
      return ("_" + name);
    } else {
      return name;
    }
  }

  public CharSequence prototype(final FunctionSignature fs) {
    StringConcatenation _builder = new StringConcatenation();
    String _returnType = fs.getReturnType();
    _builder.append(_returnType);
    _builder.append(" ");
    String _nameEsc = this.nameEsc(fs);
    _builder.append(_nameEsc);
    _builder.append("(");
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable p) -> {
      return p.asParameterType();
    };
    String _join = IterableExtensions.<AbstractVariable>join(fs.getParameters(), ", ", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }

  public CharSequence functionSignature(final Function f) {
    EList<AbstractVariable> _inputs = f.getInputs();
    EList<AbstractVariable> _outputs = f.getOutputs();
    final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
      return Boolean.valueOf(v.isGlobal());
    };
    return this.fullSignature(f.getSignature(), IterableExtensions.<AbstractVariable>filter(Iterables.<AbstractVariable>concat(_inputs, _outputs), _function));
  }

  public CharSequence fullSignature(final FunctionSignature fs, final Iterable<AbstractVariable> globals) {
    StringConcatenation _builder = new StringConcatenation();
    String _returnType = fs.getReturnType();
    _builder.append(_returnType);
    _builder.append(" ");
    String _nameEsc = this.nameEsc(fs);
    _builder.append(_nameEsc);
    _builder.append("(");
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable v) -> {
      return this.functionParam(v, globals);
    };
    String _join = IterableExtensions.<AbstractVariable>join(fs.getParameters(), ", ", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }

  private CharSequence functionParam(final AbstractVariable p, final Iterable<AbstractVariable> globals) {
    StringConcatenation _builder = new StringConcatenation();
    String _asParameterType = p.asParameterType();
    _builder.append(_asParameterType);
    _builder.append(" ");
    {
      final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
        return Boolean.valueOf(v.getName().matches(p.getName()));
      };
      boolean _exists = IterableExtensions.<AbstractVariable>exists(globals, _function);
      if (_exists) {
        _builder.append(CodeGenConstantsForC.TEMP_LOCAL_PREFIX);
      }
    }
    String _name = p.getName();
    _builder.append(_name);
    return _builder;
  }

  public CharSequence code(final Function func) {
    CharSequence _xifexpression = null;
    boolean _isInlined = func.isInlined();
    boolean _not = (!_isInlined);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _functionSignature = this.functionSignature(func);
      _builder.append(_functionSignature);
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _functionBody = this.functionBody(func);
      _builder.append(_functionBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      _xifexpression = this.functionBody(func);
    }
    return _xifexpression;
  }

  public CharSequence functionBody(final Function func) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getLowerBound(int) is undefined for the type Domain"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\ntoString cannot be resolved"
      + "\njoin cannot be resolved");
  }
}
