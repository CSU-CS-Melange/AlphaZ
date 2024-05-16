package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class BaseCodeUnit {
  @Inject
  @Extension
  private BaseFunction function;

  @Inject
  @Extension
  private BaseMemoryAccess memory;

  public CharSequence generate(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonIncludes = this.commonIncludes(unit);
    _builder.append(_commonIncludes);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isVerification = this.isVerification(unit);
      if (_isVerification) {
        CharSequence _externalFunctionIncludeDeclarationsOnly = this.externalFunctionIncludeDeclarationsOnly(unit);
        _builder.append(_externalFunctionIncludeDeclarationsOnly);
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _externalFunctionInclude = this.externalFunctionInclude(unit);
        _builder.append(_externalFunctionInclude);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _commonMacroDefs = this.commonMacroDefs(unit);
    _builder.append(_commonMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _commonFuncDefs = this.commonFuncDefs(unit);
    _builder.append(_commonFuncDefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _headerDefs = this.headerDefs(unit);
    _builder.append(_headerDefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<CompileTimeParameter> _compileTimeParameters = unit.getCompileTimeParameters();
      for(final CompileTimeParameter param : _compileTimeParameters) {
        Object _compileTimeParameterDef = this.compileTimeParameterDef(param);
        _builder.append(_compileTimeParameterDef);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _globalVariablesDeclaration = this.globalVariablesDeclaration(unit);
    _builder.append(_globalVariablesDeclaration);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _subsystemFunctionDeclaration = this.subsystemFunctionDeclaration(unit);
    _builder.append(_subsystemFunctionDeclaration);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _localFunctionDeclaration = this.localFunctionDeclaration(unit);
    _builder.append(_localFunctionDeclaration);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _memoryMacroDefs = this.memoryMacroDefs(unit);
    _builder.append(_memoryMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      final Function1<Function, Boolean> _function = (Function f) -> {
        boolean _isInlined = f.isInlined();
        return Boolean.valueOf((!_isInlined));
      };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(unit.getFunctions(), _function);
      for(final Function func : _filter) {
        CharSequence _code = this.function.code(func);
        _builder.append(_code);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _memoryMacroUndefs = this.memoryMacroUndefs(unit);
    _builder.append(_memoryMacroUndefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<CompileTimeParameter> _compileTimeParameters_1 = unit.getCompileTimeParameters();
      for(final CompileTimeParameter param_1 : _compileTimeParameters_1) {
        Object _compileTimeParameterUndef = this.compileTimeParameterUndef(param_1);
        _builder.append(_compileTimeParameterUndef);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _commonMacroUndefs = this.commonMacroUndefs(unit);
    _builder.append(_commonMacroUndefs);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence commonIncludes(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// This file is generated from test alphabets program by code generator in alphaz");
    _builder.newLine();
    _builder.append("// To compile this code, use -lm option for math library.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// Includes");
    _builder.newLine();
    _builder.append("#include <stdio.h>");
    _builder.newLine();
    _builder.append("#include <stdlib.h>");
    _builder.newLine();
    _builder.append("#include <stdbool.h>");
    _builder.newLine();
    _builder.append("#include <math.h>");
    _builder.newLine();
    _builder.append("#include <string.h>");
    _builder.newLine();
    _builder.append("#include <limits.h>");
    _builder.newLine();
    _builder.append("#include <float.h>");
    _builder.newLine();
    return _builder;
  }

  public boolean isVerification(final CodeUnit unit) {
    return unit.getSystem().getName().endsWith("_verify");
  }

  public CharSequence externalFunctionIncludeDeclarationsOnly(final CodeUnit unit) {
    CharSequence _xblockexpression = null;
    {
      final BaseCompilationUnit baseUnit = new BaseCompilationUnit();
      CharSequence _xifexpression = null;
      int _size = unit.getCompilationUnit().getProgram().getExternalFunctionDeclarations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _xifexpression = baseUnit.externalFunctionHeader(unit.getCompilationUnit().getProgram());
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public CharSequence externalFunctionInclude(final CodeUnit unit) {
    CharSequence _xifexpression = null;
    int _size = unit.getCompilationUnit().getProgram().getExternalFunctionDeclarations().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include \"");
      _builder.append(CodeGenConstantsForC.EXTERNAL_FUNCTION_HEADER_NAME);
      _builder.append("\"");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }

  public CharSequence commonMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Common Macros");
    _builder.newLine();
    _builder.append("#define max(x, y)   ((x)>(y) ? (x) : (y))");
    _builder.newLine();
    _builder.append("#define MAX(x, y)\t((x)>(y) ? (x) : (y))");
    _builder.newLine();
    _builder.append("#define min(x, y)   ((x)>(y) ? (y) : (x))");
    _builder.newLine();
    _builder.append("#define MIN(x, y)\t((x)>(y) ? (y) : (x))");
    _builder.newLine();
    _builder.append("#define CEILD(n,d)  (int)ceil(((double)(n))/((double)(d)))");
    _builder.newLine();
    _builder.append("#define ceild(n,d)  (int)ceil(((double)(n))/((double)(d)))");
    _builder.newLine();
    _builder.append("#define FLOORD(n,d) (int)floor(((double)(n))/((double)(d)))");
    _builder.newLine();
    _builder.append("#define floord(n,d) (int)floor(((double)(n))/((double)(d)))");
    _builder.newLine();
    _builder.append("#define CDIV(x,y)    CEILD((x),(y))");
    _builder.newLine();
    _builder.append("#define div(x,y)    CDIV((x),(y))");
    _builder.newLine();
    _builder.append("#define FDIV(x,y)    FLOORD((x),(y))");
    _builder.newLine();
    _builder.append("#define LB_SHIFT(b,s)  ((int)ceild(b,s) * s)");
    _builder.newLine();
    _builder.append("#define MOD(i,j)   ((i)%(j))");
    _builder.newLine();
    _builder.append("#define mallocCheck(v,s,d) if ((v) == NULL) { printf(\"Failed to allocate memory for %s : size=%lu\\n\", \"sizeof(d)*(s)\", sizeof(d)*(s)); exit(-1); }");
    _builder.newLine();
    return _builder;
  }

  public CharSequence commonMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Common Macro undefs");
    _builder.newLine();
    _builder.append("#undef max");
    _builder.newLine();
    _builder.append("#undef MAX");
    _builder.newLine();
    _builder.append("#undef min");
    _builder.newLine();
    _builder.append("#undef MIN");
    _builder.newLine();
    _builder.append("#undef CEILD");
    _builder.newLine();
    _builder.append("#undef ceild");
    _builder.newLine();
    _builder.append("#undef FLOORD");
    _builder.newLine();
    _builder.append("#undef floord");
    _builder.newLine();
    _builder.append("#undef CDIV");
    _builder.newLine();
    _builder.append("#undef FDIV");
    _builder.newLine();
    _builder.append("#undef LB_SHIFT");
    _builder.newLine();
    _builder.append("#undef MOD");
    _builder.newLine();
    return _builder;
  }

  public CharSequence commonFuncDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Common functions for min and max");
    _builder.newLine();
    _builder.append("//functions for integer max");
    _builder.newLine();
    _builder.append("inline int __max_int(int x, int y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline short __max_short(short x, short y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline long __max_long(long x, long y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline unsigned int __max_unsigned_int(unsigned int x, unsigned int y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline unsigned short __max_unsigned_short(unsigned short x, unsigned short y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//function for float max");
    _builder.newLine();
    _builder.append("inline float __max_float(float x, float y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//function for double max");
    _builder.newLine();
    _builder.append("inline double __max_double(double x, double y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (x) : (y));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//function for integer min");
    _builder.newLine();
    _builder.append("inline int __min_int(int x, int y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline short __min_short(short x, short y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline long __min_long(long x, long y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline unsigned int __min_unsigned_int(unsigned int x, unsigned int y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline unsigned short __min_unsigned_short(unsigned short x, unsigned short y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline unsigned long __min_unsigned_long(unsigned long x, unsigned long y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline float __min_float(float x, float y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline double __min_double(double x, double y){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ((x)>(y) ? (y) : (x));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence globalVariablesDeclaration(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
        return Boolean.valueOf(v.isGlobal());
      };
      boolean _exists = IterableExtensions.<AbstractVariable>exists(unit.getVariables(), _function);
      if (_exists) {
        _builder.append("///Global Variables");
        _builder.newLine();
      }
    }
    {
      final Function1<AbstractVariable, Boolean> _function_1 = (AbstractVariable v) -> {
        return Boolean.valueOf(v.isGlobal());
      };
      Iterable<AbstractVariable> _filter = IterableExtensions.<AbstractVariable>filter(unit.getVariables(), _function_1);
      for(final AbstractVariable v : _filter) {
        {
          boolean _isScalar = Utility.isScalar(v);
          if (_isScalar) {
            _builder.append("static ");
            String _typeString = v.getTypeString();
            _builder.append(_typeString);
            _builder.append(" ");
            String _name = v.getName();
            _builder.append(_name);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("static ");
            String _pointerType = v.getPointerType();
            _builder.append(_pointerType);
            _builder.append(" ");
            String _name_1 = v.getName();
            _builder.append(_name_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }

  public CharSequence subsystemFunctionDeclaration(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = unit.getSubsystemFunctions().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("//SubSystem Function Declarations");
        _builder.newLine();
      }
    }
    {
      EList<FunctionSignature> _subsystemFunctions = unit.getSubsystemFunctions();
      for(final FunctionSignature f : _subsystemFunctions) {
        CharSequence _prototype = this.function.prototype(f);
        _builder.append(_prototype);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence localFunctionDeclaration(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<Function, Boolean> _function = (Function f) -> {
        boolean _isEntryPoint = f.isEntryPoint();
        return Boolean.valueOf((!_isEntryPoint));
      };
      boolean _exists = IterableExtensions.<Function>exists(unit.getFunctions(), _function);
      if (_exists) {
        _builder.append("//Local Function Declarations");
        _builder.newLine();
      }
    }
    {
      final Function1<Function, Boolean> _function_1 = (Function f) -> {
        return Boolean.valueOf(((!f.isEntryPoint()) && (!f.isInlined())));
      };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(unit.getFunctions(), _function_1);
      for(final Function f : _filter) {
        CharSequence _prototype = this.function.prototype(f.getSignature());
        _builder.append(_prototype);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence memoryMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Macros");
    _builder.newLine();
    {
      EList<AbstractVariable> _variables = unit.getVariables();
      for(final AbstractVariable v : _variables) {
        CharSequence _memoryMacroDef = this.memory.memoryMacroDef(v);
        _builder.append(_memoryMacroDef);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence memoryMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Macros");
    _builder.newLine();
    {
      EList<AbstractVariable> _variables = unit.getVariables();
      for(final AbstractVariable v : _variables) {
        CharSequence _memoryMacroUndef = this.memory.memoryMacroUndef(v);
        _builder.append(_memoryMacroUndef);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public Object compileTimeParameterDef(final CompileTimeParameter param) {
    return null;
  }

  public Object compileTimeParameterUndef(final CompileTimeParameter param) {
    return null;
  }

  public String filename(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = unit.getSystem().getName();
    _builder.append(_name);
    _builder.append(".c");
    return _builder.toString();
  }

  public CharSequence headerDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<CodeUnitHeader> _headers = unit.getHeaders();
      for(final CodeUnitHeader h : _headers) {
        CharSequence _header = this.header(h);
        _builder.append(_header);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  protected CharSequence _header(final CodeUnitHeader header) {
    return null;
  }

  protected CharSequence _header(final DeclareStructs header) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Struct> _structs = header.getStructs();
      for(final Struct ps : _structs) {
        CharSequence _structDef = this.structDef(ps);
        _builder.append(_structDef);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence structDef(final Struct s) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = s.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _members = s.getMembers();
      for(final AbstractVariable p : _members) {
        _builder.append("\t");
        String _asParameterType = p.asParameterType();
        _builder.append(_asParameterType, "\t");
        _builder.append(" ");
        String _name_1 = p.getName();
        _builder.append(_name_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }

  public CharSequence header(final CodeUnitHeader header) {
    if (header instanceof DeclareStructs) {
      return _header((DeclareStructs)header);
    } else if (header != null) {
      return _header(header);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(header).toString());
    }
  }
}
