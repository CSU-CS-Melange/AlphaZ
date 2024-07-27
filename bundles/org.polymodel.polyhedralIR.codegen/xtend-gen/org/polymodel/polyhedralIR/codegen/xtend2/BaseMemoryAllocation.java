package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

/**
 * Memory allocation and freeing are defined in this extension.
 */
@SuppressWarnings("all")
public class BaseMemoryAllocation {
  public CodeGenVariable variableWithMaxDim(final Iterable<AbstractVariable> vars) {
    final Function2<CodeGenVariable, CodeGenVariable, CodeGenVariable> _function = (CodeGenVariable a, CodeGenVariable b) -> {
      CodeGenVariable _xifexpression = null;
      int _nIndices = a.getDomain().getNIndices();
      int _nIndices_1 = b.getDomain().getNIndices();
      boolean _greaterThan = (_nIndices > _nIndices_1);
      if (_greaterThan) {
        _xifexpression = a;
      } else {
        _xifexpression = b;
      }
      return _xifexpression;
    };
    return IterableExtensions.<CodeGenVariable>reduce(Iterables.<CodeGenVariable>filter(vars, CodeGenVariable.class), _function);
  }

  public CharSequence reset(final FlagVariableReset b) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<CodeGenVariable, Boolean> _function = (CodeGenVariable e) -> {
      Type _type = e.getType();
      return Boolean.valueOf(Objects.equal(_type, DATATYPE.CHAR));
    };
    final Function1<CodeGenVariable, CharSequence> _function_1 = (CodeGenVariable e) -> {
      return this.reset(e, false);
    };
    String _join = IterableExtensions.<CodeGenVariable>join(IterableExtensions.<CodeGenVariable>filter(Iterables.<CodeGenVariable>filter(b.getLocals(), CodeGenVariable.class), _function), "\n", _function_1);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected Boolean _ofType(final AbstractVariable t, final DATATYPE dt) {
    return null;
  }

  protected Boolean _ofType(final CodeGenVariable v, final DATATYPE dt) {
    DATATYPE _typeID = v.getType().getTypeID();
    return Boolean.valueOf(Objects.equal(_typeID, dt));
  }

  protected Boolean _ofType(final BasicVariable v, final DATATYPE dt) {
    String _type = v.getType();
    String _name = dt.getName();
    return Boolean.valueOf(Objects.equal(_type, _name));
  }

  public CharSequence reset(final AbstractVariable v, final boolean isVariableInit) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  public CharSequence malloc(final VariableInitialization b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Allocation");
    _builder.newLine();
    final CodeGenVariable maxDim = this.variableWithMaxDim(b.getLocals());
    _builder.newLineIfNotEmpty();
    {
      boolean _notEquals = (!Objects.equal(maxDim, null));
      if (_notEquals) {
        String _declareMalloLoopIterators = this.declareMalloLoopIterators(maxDim.getDomain().getNIndices());
        _builder.append(_declareMalloLoopIterators);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable e) -> {
      CharSequence _malloc = this.malloc(e);
      return (_malloc + "");
    };
    String _join = IterableExtensions.<AbstractVariable>join(b.getLocals(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    final Function1<CodeGenVariable, CharSequence> _function_1 = (CodeGenVariable e) -> {
      return this.malloc(e, false);
    };
    String _join_1 = IterableExtensions.<CodeGenVariable>join(b.getSpecialLocals(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public String declareMalloLoopIterators(final int dim) {
    if ((dim <= 0)) {
      StringConcatenation _builder = new StringConcatenation();
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int ");
    String decl = _builder_1.toString();
    int i = 0;
    while ((i < dim)) {
      {
        if ((i > 0)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(decl);
          _builder_2.append(", ");
          decl = _builder_2.toString();
        }
        i = (i + 1);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(decl);
        _builder_3.append(CodeGenConstantsForC.MALLOC_LOOP_INDEX);
        _builder_3.append(i);
        decl = _builder_3.toString();
      }
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(decl);
    _builder_2.append(";");
    return _builder_2.toString();
  }

  public CharSequence mfree(final VariableFinalization b) {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<AbstractVariable, Boolean> _function = (AbstractVariable e) -> {
        return Boolean.valueOf((e.isGlobal() && Utility.isScalar(e)));
      };
      boolean _exists = IterableExtensions.<AbstractVariable>exists(b.getOutputs(), _function);
      if (_exists) {
        _builder.append("//Copy scalars to output");
        _builder.newLine();
        {
          final Function1<AbstractVariable, Boolean> _function_1 = (AbstractVariable e) -> {
            return Boolean.valueOf((e.isGlobal() && Utility.isScalar(e)));
          };
          Iterable<AbstractVariable> _filter = IterableExtensions.<AbstractVariable>filter(b.getOutputs(), _function_1);
          for(final AbstractVariable s : _filter) {
            _builder.append("*");
            _builder.append(CodeGenConstantsForC.TEMP_LOCAL_PREFIX);
            String _name = s.getName();
            _builder.append(_name);
            _builder.append(" = ");
            String _name_1 = s.getName();
            _builder.append(_name_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("//Memory Free");
    _builder.newLine();
    final Function1<AbstractVariable, CharSequence> _function_2 = (AbstractVariable e) -> {
      CharSequence _mfree = this.mfree(e);
      return (_mfree + "");
    };
    String _join = IterableExtensions.<AbstractVariable>join(b.getLocals(), "\n", _function_2);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    final Function1<CodeGenVariable, CharSequence> _function_3 = (CodeGenVariable e) -> {
      return this.mfree(e, true);
    };
    String _join_1 = IterableExtensions.<CodeGenVariable>join(b.getSpecialLocals(), "\n", _function_3);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _malloc(final VRegister reg) {
    StringConcatenation _builder = new StringConcatenation();
    String _regTypeString = reg.getRegTypeString();
    _builder.append(_regTypeString);
    _builder.append(" ");
    String _name = reg.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence scalarAllocation(final CodeGenVariable v, final String varNamePostfix) {
    CharSequence _xifexpression = null;
    boolean _isGlobal = v.isGlobal();
    if (_isGlobal) {
      StringConcatenation _builder = new StringConcatenation();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _typeString = v.getTypeString();
      _builder_1.append(_typeString);
      _builder_1.append(" ");
      String _name = v.getName();
      _builder_1.append(_name);
      _builder_1.append(varNamePostfix);
      _builder_1.append(";");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }

  public CharSequence scalarAllocation(final CodeGenVariable v) {
    return this.scalarAllocation(v, "");
  }

  public CharSequence malloc(final AbstractVariable v) {
    return this.malloc(v, "", true);
  }

  public CharSequence malloc(final AbstractVariable v, final boolean allocate) {
    return this.malloc(v, "", allocate);
  }

  /**
   * verNamePostfix is used to add verify postfix
   */
  public CharSequence malloc(final AbstractVariable v, final String varNamePostfix) {
    return this.malloc(v, varNamePostfix, true);
  }

  protected CharSequence _malloc(final AbstractVariable v, final String varNamePostfix, final boolean allocate) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/** malloc not imlemented for the given type **/");
    return _builder;
  }

  protected CharSequence _malloc(final CodeGenVariable v, final String varNamePostfix, final boolean allocate) {
    CharSequence _xblockexpression = null;
    {
      int _nIndices = v.getDomain().getNIndices();
      boolean _equals = (_nIndices == 0);
      if (_equals) {
        return this.scalarAllocation(v, varNamePostfix);
      }
      CharSequence _xifexpression = null;
      if ((!allocate)) {
        CharSequence _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          String _name = v.getName();
          _builder.append(_name);
          _builder.append(varNamePostfix);
          String varName = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          String _pointerType = v.getPointerType();
          _builder_1.append(_pointerType);
          _builder_1.append(" ");
          String typeDecl = _builder_1.toString();
          StringConcatenation _builder_2 = new StringConcatenation();
          CharSequence _variableDeclaration = this.variableDeclaration(typeDecl, varName);
          _builder_2.append(_variableDeclaration);
          _builder_2.newLineIfNotEmpty();
          _xblockexpression_1 = _builder_2;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isMDallocation = Utility.isMDallocation(v);
        if (_isMDallocation) {
          StringConcatenation _builder = new StringConcatenation();
          CharSequence _mallocLinearlized = this.mallocLinearlized(v, varNamePostfix);
          _builder.append(_mallocLinearlized);
          _builder.newLineIfNotEmpty();
          _xifexpression_1 = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _malloc1D = this.malloc1D(v, varNamePostfix);
          _builder_1.append(_malloc1D);
          _builder_1.newLineIfNotEmpty();
          _xifexpression_1 = _builder_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public CharSequence mallocLinearlized(final CodeGenVariable v, final String varNamePostfix) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved");
  }

  public CharSequence malloc1D(final CodeGenVariable v, final String varNamePostfix) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved");
  }

  protected CharSequence variableDeclaration(final CharSequence varDecl, final CharSequence varName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(varDecl);
    _builder.append(varName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Helper to do all malloc and mallocCheck in a consistent manner
   */
  protected CharSequence malloc(final CharSequence varDecl, final CharSequence varName, final CharSequence type, final CharSequence vol, final boolean aligned) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (aligned) {
        _builder.append(varDecl);
        _builder.append(varName);
        _builder.append(" = (");
        _builder.append(type);
        _builder.append("*)_mm_malloc(sizeof(");
        _builder.append(type);
        _builder.append(")*(");
        _builder.append(vol);
        _builder.append("), 64);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append(varDecl);
        _builder.append(varName);
        _builder.append(" = (");
        _builder.append(type);
        _builder.append("*)malloc(sizeof(");
        _builder.append(type);
        _builder.append(")*(");
        _builder.append(vol);
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("mallocCheck(");
    _builder.append(varName);
    _builder.append(", (");
    _builder.append(vol);
    _builder.append("), ");
    _builder.append(type);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private CharSequence malloc(final CharSequence varName, final CharSequence type, final CharSequence vol) {
    return this.malloc("", varName, type, vol, false);
  }

  private CharSequence mallocMD(final CodeGenVariable v, final String varNamePostfix) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved");
  }

  private CharSequence mallocMDrecurse(final CodeGenVariable v, final String varNamePostfix, final int dim) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved"
      + "\ntoCString cannot be resolved");
  }

  private String getMDmallocAccess(final int dim) {
    StringConcatenation _builder = new StringConcatenation();
    String access = _builder.toString();
    int i = 1;
    while ((i <= dim)) {
      {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(access);
        _builder_1.append("[");
        _builder_1.append(CodeGenConstantsForC.MALLOC_LOOP_INDEX);
        _builder_1.append(i);
        _builder_1.append("]");
        access = _builder_1.toString();
        i = (i + 1);
      }
    }
    return access;
  }

  private CharSequence getMallocAccessToLinearized(final CodeGenVariable v, final String varNamePostfix) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type MemoryDomain"
      + "\nThe method or field index1 is undefined for the type Object"
      + "\nThe method getVolumeExpression(Object, int) is undefined for the type CodeGenVariable"
      + "\nThe method or field index1 is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nsubList cannot be resolved"
      + "\nindexed cannot be resolved"
      + "\njoin cannot be resolved"
      + "\ntoCString cannot be resolved");
  }

  private CharSequence getMDPointer(final CodeGenVariable v, final int dim) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      String pointers = _builder.toString();
      int i = 1;
      while ((i <= dim)) {
        {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(pointers);
          _builder_1.append("*");
          pointers = _builder_1.toString();
          i = (i + 1);
        }
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      String _cName = v.getType().getCName();
      _builder_1.append(_cName);
      _builder_1.append(pointers);
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }

  private String getFirstMDmallocAccess(final int dim) {
    StringConcatenation _builder = new StringConcatenation();
    String access = _builder.toString();
    int i = 1;
    while ((i <= dim)) {
      {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(access);
        _builder_1.append("[0]");
        access = _builder_1.toString();
        i = (i + 1);
      }
    }
    return access;
  }

  public CharSequence mfree(final AbstractVariable v) {
    return this.mfree(v, "", false);
  }

  public CharSequence mfree(final AbstractVariable v, final String varNamePostfix) {
    return this.mfree(v, varNamePostfix, false);
  }

  public CharSequence mfree(final AbstractVariable v, final boolean isSpecial) {
    return this.mfree(v, "", isSpecial);
  }

  protected CharSequence _mfree(final AbstractVariable v, final String varNamePostfix, final boolean isSpecial) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/** mfree not implemented for AbstractVariable **/");
    return _builder;
  }

  protected CharSequence _mfree(final CodeGenVariable v, final String varNamePostfix, final boolean isSpecial) {
    CharSequence _xblockexpression = null;
    {
      int _nIndices = v.getDomain().getNIndices();
      boolean _equals = (_nIndices == 0);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder.toString();
      }
      CharSequence _xifexpression = null;
      if ((isSpecial && Utility.isMDallocation(v))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("free(");
        String _name = v.getName();
        _builder_1.append(_name);
        _builder_1.append(varNamePostfix);
        int _nIndices_1 = v.getDomain().getNIndices();
        int _minus = (_nIndices_1 - 1);
        String _firstMDmallocAccess = this.getFirstMDmallocAccess(_minus);
        _builder_1.append(_firstMDmallocAccess);
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        CharSequence _mfreeMD = this.mfreeMD(v, varNamePostfix);
        _builder_1.append(_mfreeMD);
        _builder_1.newLineIfNotEmpty();
        _xifexpression = _builder_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isMDallocation = Utility.isMDallocation(v);
        if (_isMDallocation) {
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            boolean _isAligned = v.isAligned();
            if (_isAligned) {
              _builder_2.append("_mm_free");
            } else {
              _builder_2.append("free");
            }
          }
          _builder_2.append("(");
          _builder_2.append(CodeGenConstantsForC.LINEARIZED_ARRAY_PREFIX);
          String _name_1 = v.getName();
          _builder_2.append(_name_1);
          _builder_2.append(varNamePostfix);
          _builder_2.append(");");
          _builder_2.newLineIfNotEmpty();
          CharSequence _mfreeMD_1 = this.mfreeMD(v, varNamePostfix);
          _builder_2.append(_mfreeMD_1);
          _builder_2.newLineIfNotEmpty();
          _xifexpression_1 = _builder_2;
        } else {
          CharSequence _xifexpression_2 = null;
          boolean _isAligned_1 = v.isAligned();
          if (_isAligned_1) {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("_mm_free(");
            String _name_2 = v.getName();
            _builder_3.append(_name_2);
            _builder_3.append(varNamePostfix);
            _builder_3.append(");");
            _xifexpression_2 = _builder_3;
          } else {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("free(");
            String _name_3 = v.getName();
            _builder_4.append(_name_3);
            _builder_4.append(varNamePostfix);
            _builder_4.append(");");
            _xifexpression_2 = _builder_4;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private CharSequence mfreeMD(final CodeGenVariable v, final String varNamePostfix) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _nIndices = v.getDomain().getNIndices();
      boolean _lessThan = (2 < _nIndices);
      if (_lessThan) {
        CharSequence _mfreeMDrecurse = this.mfreeMDrecurse(v, varNamePostfix, 1);
        _builder.append(_mfreeMDrecurse);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("free(");
    String _name = v.getName();
    _builder.append(_name);
    _builder.append(varNamePostfix);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  private CharSequence mfreeMDrecurse(final CodeGenVariable v, final String varNamePostfix, final int dim) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getVolumeExpression(int, int) is undefined for the type CodeGenVariable"
      + "\ntoCString cannot be resolved");
  }

  public Boolean ofType(final AbstractVariable v, final DATATYPE dt) {
    if (v instanceof BasicVariable) {
      return _ofType((BasicVariable)v, dt);
    } else if (v instanceof CodeGenVariable) {
      return _ofType((CodeGenVariable)v, dt);
    } else if (v != null) {
      return _ofType(v, dt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, dt).toString());
    }
  }

  public CharSequence malloc(final VRegister reg) {
    return _malloc(reg);
  }

  public CharSequence malloc(final AbstractVariable v, final String varNamePostfix, final boolean allocate) {
    if (v instanceof CodeGenVariable) {
      return _malloc((CodeGenVariable)v, varNamePostfix, allocate);
    } else if (v != null) {
      return _malloc(v, varNamePostfix, allocate);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, varNamePostfix, allocate).toString());
    }
  }

  public CharSequence mfree(final AbstractVariable v, final String varNamePostfix, final boolean isSpecial) {
    if (v instanceof CodeGenVariable) {
      return _mfree((CodeGenVariable)v, varNamePostfix, isSpecial);
    } else if (v != null) {
      return _mfree(v, varNamePostfix, isSpecial);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, varNamePostfix, isSpecial).toString());
    }
  }
}
