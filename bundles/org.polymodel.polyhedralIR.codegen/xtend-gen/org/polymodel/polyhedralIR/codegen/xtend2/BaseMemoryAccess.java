package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

@SuppressWarnings("all")
public class BaseMemoryAccess {
  @Inject
  @Extension
  private BaseIndices indices;

  protected CharSequence _memoryMacroDef(final BasicVariable v) {
    return null;
  }

  protected CharSequence _memoryMacroDef(final CodeGenVariable v) {
    CharSequence _xifexpression = null;
    WhileInfo _whileInfo = v.getCodeunit().getSystem().getWhileInfo();
    boolean _equals = Objects.equal(_whileInfo, null);
    if (_equals) {
      CharSequence _xifexpression_1 = null;
      boolean _isScalar = Utility.isScalar(v);
      boolean _not = (!_isScalar);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("#define ");
        String _name = v.getName();
        _builder.append(_name);
        _builder.append("(");
        CharSequence _macroIndices = this.indices.getMacroIndices(v);
        _builder.append(_macroIndices);
        _builder.append(") ");
        String _name_1 = v.getName();
        _builder.append(_name_1);
        CharSequence _arrayIndexing = this.arrayIndexing(v);
        _builder.append(_arrayIndexing);
        _xifexpression_1 = _builder;
      }
      _xifexpression = _xifexpression_1;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("#define ");
      String _name_2 = v.getName();
      _builder_1.append(_name_2);
      _builder_1.append("(");
      CharSequence _macroIndices_1 = this.indices.getMacroIndices(v);
      _builder_1.append(_macroIndices_1);
      _builder_1.append(") ");
      String _name_3 = v.getName();
      _builder_1.append(_name_3);
      CharSequence _arrayIndexing_1 = this.arrayIndexing(v);
      _builder_1.append(_arrayIndexing_1);
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }

  protected CharSequence _arrayIndexing(final AbstractVariable v) {
    return null;
  }

  protected CharSequence _arrayIndexing(final CodeGenVariable v) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field accessExpressions is undefined for the type MemoryAccessExpression"
      + "\nType mismatch: cannot convert from Object to PolymodelVisitable"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected CharSequence _memoryMacroUndef(final BasicVariable v) {
    return null;
  }

  protected CharSequence _memoryMacroUndef(final CodeGenVariable v) {
    CharSequence _xifexpression = null;
    boolean _isScalar = Utility.isScalar(v);
    boolean _not = (!_isScalar);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#undef ");
      String _name = v.getName();
      _builder.append(_name);
      _xifexpression = _builder;
    }
    return _xifexpression;
  }

  public CharSequence memoryMacroDef(final AbstractVariable v) {
    if (v instanceof BasicVariable) {
      return _memoryMacroDef((BasicVariable)v);
    } else if (v instanceof CodeGenVariable) {
      return _memoryMacroDef((CodeGenVariable)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }

  public CharSequence arrayIndexing(final AbstractVariable v) {
    if (v instanceof CodeGenVariable) {
      return _arrayIndexing((CodeGenVariable)v);
    } else if (v != null) {
      return _arrayIndexing(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }

  public CharSequence memoryMacroUndef(final AbstractVariable v) {
    if (v instanceof BasicVariable) {
      return _memoryMacroUndef((BasicVariable)v);
    } else if (v instanceof CodeGenVariable) {
      return _memoryMacroUndef((CodeGenVariable)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
