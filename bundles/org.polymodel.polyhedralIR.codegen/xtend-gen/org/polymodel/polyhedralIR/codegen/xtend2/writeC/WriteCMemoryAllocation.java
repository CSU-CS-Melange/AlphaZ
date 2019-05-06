package org.polymodel.polyhedralIR.codegen.xtend2.writeC;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

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
    CharSequence _xifexpression = null;
    Boolean _ofType = this.ofType(v, DATATYPE.CHAR);
    if ((_ofType).booleanValue()) {
      CharSequence _xblockexpression = null;
      {
        WhileInfo _whileInfo = v.getCodeunit().getSystem().getWhileInfo();
        boolean isWhile = (!Objects.equal(_whileInfo, null));
        String _xifexpression_1 = null;
        if (isWhile) {
          _xifexpression_1 = v.getCodeunit().getSystem().getWhileInfo().getTimeDomain().getIndexNames().get(0);
        } else {
          _xifexpression_1 = "";
        }
        String timeIndexName = _xifexpression_1;
        String _xifexpression_2 = null;
        if (isWhile) {
          _xifexpression_2 = Utility.toCString(v.getModFactor(0));
        } else {
          _xifexpression_2 = "";
        }
        String historyOfTime = _xifexpression_2;
        AffineSystem _system = v.getCodeunit().getSystem();
        String _xifexpression_3 = null;
        boolean _startsWith = v.getName().startsWith(CodeGenConstantsForC.FLAG_PREFIX);
        if (_startsWith) {
          _xifexpression_3 = v.getName().substring(CodeGenConstantsForC.FLAG_PREFIX.length());
        } else {
          _xifexpression_3 = v.getName();
        }
        boolean isOutputVar = v.getCodeunit().getSystem().isOutput(
          _system.getVariableDeclaration(_xifexpression_3));
        int _xifexpression_4 = (int) 0;
        if ((isWhile && (!isVariableInit))) {
          int _xifexpression_5 = (int) 0;
          if (isOutputVar) {
            _xifexpression_5 = 0;
          } else {
            _xifexpression_5 = 1;
          }
          _xifexpression_4 = _xifexpression_5;
        } else {
          _xifexpression_4 = 0;
        }
        int startingIndex = _xifexpression_4;
        if ((isWhile && (!isVariableInit))) {
          boolean _endsWith = v.getName().endsWith("__Wsplit");
          if (_endsWith) {
            StringConcatenation _builder = new StringConcatenation();
            return _builder.toString();
          }
        }
        String vol = Utility.toCString(v.getVolumeExpression(startingIndex, v.getDomain().getNIndices()));
        String _xifexpression_6 = null;
        boolean _isMDallocation = Utility.isMDallocation(v);
        if (_isMDallocation) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(CodeGenConstantsForC.LINEARIZED_ARRAY_PREFIX);
          String _name = v.getName();
          _builder_1.append(_name);
          _xifexpression_6 = _builder_1.toString();
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          String _name_1 = v.getName();
          _builder_2.append(_name_1);
          _xifexpression_6 = _builder_2.toString();
        }
        String varName = _xifexpression_6;
        String _xifexpression_7 = null;
        boolean _isScalar = Utility.isScalar(v);
        if (_isScalar) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(varName);
          _builder_3.append(" = \'N\';");
          _xifexpression_7 = _builder_3.toString();
        } else {
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("memset(");
          _builder_4.append(varName);
          CharSequence _xifexpression_8 = null;
          if (((!isVariableInit) && isWhile)) {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("+(((");
            _builder_5.append(timeIndexName);
            _builder_5.append(")%(");
            _builder_5.append(historyOfTime);
            _builder_5.append("))*(");
            _builder_5.append(vol);
            _builder_5.append("))");
            _xifexpression_8 = _builder_5;
          }
          _builder_4.append(_xifexpression_8);
          _builder_4.append(", \'N\', (");
          _builder_4.append(vol);
          _builder_4.append("));");
          _xifexpression_7 = _builder_4.toString();
        }
        String init = _xifexpression_7;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append(init);
        _xblockexpression = _builder_6;
      }
      _xifexpression = _xblockexpression;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _xifexpression = _builder;
    }
    return _xifexpression;
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
