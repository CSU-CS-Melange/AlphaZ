package org.polymodel.polyhedralIR.codegen.xtend2;

import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

@SuppressWarnings("all")
public class BaseIndices {
  protected CharSequence _getMacroIndices(final AbstractVariable v) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  protected CharSequence _getMacroIndices(final CodeGenVariable v) {
    return this.getMacroIndicesL(v.getDomain().getIndices());
  }

  public CharSequence getMacroIndices(final Domain dom) {
    return this.getMacroIndicesL(dom.getIndices());
  }

  public CharSequence getMacroIndices(final AffineFunction func) {
    return this.getMacroIndicesL(func.getIndices());
  }

  public CharSequence getMacroIndices(final VariableDeclaration v) {
    return this.getMacroIndicesL(v.getDomain().getIndices());
  }

  public CharSequence getMacroIndicesL(final List<Variable> indices) {
    CharSequence _xifexpression = null;
    int _size = indices.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      final Function1<Variable, CharSequence> _function = (Variable i) -> {
        return i.toString();
      };
      String _join = IterableExtensions.<Variable>join(indices, ",", _function);
      _builder.append(_join);
      _xifexpression = _builder;
    }
    return _xifexpression;
  }

  public CharSequence getMacroIndicesExceptTime(final List<Variable> indices) {
    CharSequence _xifexpression = null;
    int _size = indices.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      final Function1<Variable, Boolean> _function = (Variable i) -> {
        boolean _equals = i.toString().equals("t");
        return Boolean.valueOf((!_equals));
      };
      final Function1<Variable, CharSequence> _function_1 = (Variable i) -> {
        return i.toString();
      };
      String _join = IterableExtensions.<Variable>join(IterableExtensions.<Variable>filter(indices, _function), ",", _function_1);
      _builder.append(_join);
      _xifexpression = _builder;
    }
    return _xifexpression;
  }

  public CharSequence getMacroIndices(final AbstractVariable v) {
    if (v instanceof CodeGenVariable) {
      return _getMacroIndices((CodeGenVariable)v);
    } else if (v != null) {
      return _getMacroIndices(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
