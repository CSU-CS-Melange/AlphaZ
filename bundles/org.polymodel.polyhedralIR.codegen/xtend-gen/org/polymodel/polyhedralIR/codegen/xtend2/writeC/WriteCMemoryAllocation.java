package org.polymodel.polyhedralIR.codegen.xtend2.writeC;

import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

@SuppressWarnings("all")
public class WriteCMemoryAllocation extends BaseMemoryAllocation {
  @Override
  public CharSequence malloc(final AbstractVariable v) {
    CharSequence _xblockexpression = null;
    {
      Boolean _ofType = this.ofType(v, DATATYPE.CHAR);
      boolean _not = (!(_ofType).booleanValue());
      if (_not) {
        return super.malloc(v);
      }
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _malloc = super.malloc(v);
      _builder.append(_malloc);
      _builder.newLineIfNotEmpty();
      CharSequence _reset = this.reset(v, true);
      _builder.append(_reset);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  @Override
  public CharSequence reset(final AbstractVariable v, final boolean isVariableInit) {
    return this.resestDispatch(v, isVariableInit);
  }

  protected CharSequence _resestDispatch(final AbstractVariable v, final boolean isVariableInit) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  protected CharSequence _resestDispatch(final CodeGenVariable v, final boolean isVariableInit) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getModFactor(int) is undefined for the type CodeGenVariable"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved"
      + "\ntoCString cannot be resolved");
  }

  public CharSequence resestDispatch(final AbstractVariable v, final boolean isVariableInit) {
    if (v instanceof CodeGenVariable) {
      return _resestDispatch((CodeGenVariable)v, isVariableInit);
    } else if (v != null) {
      return _resestDispatch(v, isVariableInit);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, isVariableInit).toString());
    }
  }
}
