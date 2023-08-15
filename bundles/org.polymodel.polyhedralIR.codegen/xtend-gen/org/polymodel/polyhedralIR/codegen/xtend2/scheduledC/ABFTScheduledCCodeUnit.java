package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;

@SuppressWarnings("all")
public class ABFTScheduledCCodeUnit extends BaseCodeUnit {
  @Inject
  @Extension
  private ABFTScheduledCFunction function;
  
  public static ABFTCodeGenOptions options;
  
  @Override
  public String generate(final CodeUnit unit) {
    String _xblockexpression = null;
    {
      final int numSpatialDims = ABFTScheduledCCodeUnit.options.numDims;
      final String dataType = ABFTScheduledCCodeUnit.options.dataType;
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
      _builder.append("// Error injection configuration variables");
      _builder.newLine();
      CharSequence _injectionSiteVariableDeclarations = this.injectionSiteVariableDeclarations();
      _builder.append(_injectionSiteVariableDeclarations);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("// Error injection functions");
      _builder.newLine();
      _builder.append("void flip(");
      _builder.append(ABFTScheduledCCodeUnit.options.dataType);
      _builder.append(" *val) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int *bits;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("bits = (int*)val;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*bits ^= 1 << BIT;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void inject(");
      _builder.append(dataType);
      final Function1<Integer, String> _function = (Integer it) -> {
        return "*";
      };
      String _join = IterableExtensions.join(IterableExtensions.<Integer, String>map(new ExclusiveRange(0, (1 + numSpatialDims), true), _function), "");
      _builder.append(_join);
      _builder.append(" Y) {");
      _builder.newLineIfNotEmpty();
      {
        if ((ABFTScheduledCCodeUnit.options.numDims == 1)) {
          _builder.append("\t");
          _builder.append(dataType, "\t");
          _builder.append(" *val = &Y(T_INJ, I_INJ);");
          _builder.newLineIfNotEmpty();
        } else {
          if ((ABFTScheduledCCodeUnit.options.numDims == 2)) {
            _builder.append("\t");
            _builder.append(dataType, "\t");
            _builder.append(" *val = &Y(T_INJ, I_INJ, J_INJ);");
            _builder.newLineIfNotEmpty();
          } else {
            if ((ABFTScheduledCCodeUnit.options.numDims == 3)) {
              _builder.append("\t");
              _builder.append(dataType, "\t");
              _builder.append(" *val = &Y(T_INJ, I_INJ, J_INJ, K_INJ);");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("flip(val);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        final Function1<Function, Boolean> _function_1 = (Function f) -> {
          boolean _isInlined = f.isInlined();
          return Boolean.valueOf((!_isInlined));
        };
        Iterable<Function> _filter = IterableExtensions.<Function>filter(unit.getFunctions(), _function_1);
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
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public CharSequence injectionSiteVariableDeclarations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int T_INJ;");
    _builder.newLine();
    _builder.append("int I_INJ;");
    _builder.newLine();
    {
      if ((ABFTScheduledCCodeUnit.options.numDims == 2)) {
        _builder.append("int J_INJ;");
        _builder.newLine();
      } else {
        if ((ABFTScheduledCCodeUnit.options.numDims == 3)) {
          _builder.append("int K_INJ;");
          _builder.newLine();
        }
      }
    }
    _builder.append("int BIT;");
    _builder.newLine();
    _builder.append("int SEED;");
    _builder.newLine();
    return _builder;
  }
}
