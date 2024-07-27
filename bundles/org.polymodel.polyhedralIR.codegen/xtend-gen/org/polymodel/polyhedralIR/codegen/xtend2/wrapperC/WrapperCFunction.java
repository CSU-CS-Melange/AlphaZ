package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class WrapperCFunction extends BaseFunction {
  @Inject
  @Extension
  private BaseDomain domainExtensions;

  @Inject
  @Extension
  private BaseIndices indices;

  @Inject
  @Extension
  private BaseMemoryAllocation memory;

  @Inject
  @Extension
  private BaseBody body;

  /**
   * The main function is totally different from other code generators.
   * Assumes there is only one function for wrapper; the main
   * 
   * There are some special conventions:
   *  - Function with entryPoint = true actually contains information about the function the wrapper is going to call
   */
  @Override
  public CharSequence code(final Function func) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved"
      + "\njoin cannot be resolved"
      + "\njoin cannot be resolved"
      + "\njoin cannot be resolved");
  }

  protected ParameterDomain getParamDomain(final Function func) {
    return func.getCodeunit().getSystem().getParameters();
  }

  protected CharSequence checkNumberOfArgs(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected CharSequence readParameters(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nindexed cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nindex1 cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nname cannot be resolved");
  }

  protected CharSequence parameterCheck(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("///Parameter checking");
    _builder.newLine();
    _builder.append("if (!(");
    Object _printConstraints = this.domainExtensions.printConstraints(this.getParamDomain(f));
    _builder.append(_printConstraints);
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("printf(\"The value of parameters are not valid.\\n\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("exit(-1);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected String mainFunctionName(final Function f) {
    return this.nameEsc(f.getCodeunit().getSystem().getName());
  }

  protected Object mainFunctionParameters(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\n+ cannot be resolved");
  }

  protected CharSequence _asParameter(final /* Variable */Object v) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved");
  }

  protected CharSequence _asParameter(final CVariable v) {
    CharSequence _xifexpression = null;
    boolean _isScalar = Utility.isScalar(v);
    if (_isScalar) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("&");
      String _name = v.getName();
      _builder.append(_name);
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = v.getName();
      _builder_1.append(_name_1);
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }

  protected CharSequence _asParameterType(final /* Variable */Object v) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("long");
    return _builder;
  }

  protected CharSequence _asParameterType(final CVariable v) {
    StringConcatenation _builder = new StringConcatenation();
    String _pointerType = v.getPointerType();
    _builder.append(_pointerType);
    return _builder;
  }

  protected Object _asVerifyParameter(final /* Variable */Object v) {
    throw new Error("Unresolved compilation problems:"
      + "\nasParameter cannot be resolved");
  }

  protected Object _asVerifyParameter(final CVariable v) {
    CharSequence _xifexpression = null;
    final Function1<Function, Boolean> _function = (Function f) -> {
      return Boolean.valueOf(f.isEntryPoint());
    };
    boolean _isOutput = Utility.isOutput(v, IterableExtensions.<Function>findLast(v.getCodeunit().getFunctions(), _function));
    if (_isOutput) {
      CharSequence _xifexpression_1 = null;
      boolean _isScalar = Utility.isScalar(v);
      if (_isScalar) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("&");
        String _name = v.getName();
        _builder.append(_name);
        _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX);
        _xifexpression_1 = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = v.getName();
        _builder_1.append(_name_1);
        _builder_1.append(CodeGenConstantsForC.VERIFY_POSTFIX);
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = v.asParameter();
    }
    return _xifexpression;
  }

  protected CharSequence mainFunctionPrototype(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mainFunctionParameters(Function) from the type WrapperCFunction refers to the missing type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected CharSequence verifyPrototype(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mainFunctionParameters(Function) from the type WrapperCFunction refers to the missing type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected CharSequence mainFunctionCall(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mainFunctionParameters(Function) from the type WrapperCFunction refers to the missing type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected CharSequence verifyFunctionCall(final Function f) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method mainFunctionParameters(Function) from the type WrapperCFunction refers to the missing type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method asVerifyParameter(CVariable) from the type WrapperCFunction refers to the missing type Object"
      + "\njoin cannot be resolved");
  }

  protected CharSequence inputInitialization(final InputInitialization b) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field getMemoryAccessExpressions is undefined for the type SpecialVariable"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved"
      + "\njoin cannot be resolved");
  }

  public CharSequence userInput(final InputInitialization b, final CharSequence macroName, final CharSequence macroNameB, final CharSequence macroIndex, final CharSequence accessIndex) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.NO_PROMT_FLAG);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t");
    _builder.append(") scanf(\"");
    String _cScanfSpecifier = b.getSpecialVar().getVarDecl().getType().getCScanfSpecifier();
    _builder.append(_cScanfSpecifier, "\t");
    _builder.append("\", &");
    CharSequence _varAccess = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, false);
    _builder.append(_varAccess, "\t");
    _builder.append(")");
    String _cScanfPostProcess = b.getSpecialVar().getVarDecl().getType().getCScanfPostProcess();
    _builder.append(_cScanfPostProcess, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("#else");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t");
    _builder.append(") ");
    CharSequence _printIndex = this.printIndex(b.getSpecialVar().getVarDecl(), macroNameB);
    _builder.append(_printIndex, "\t");
    _builder.append(" scanf(\"");
    String _cScanfSpecifier_1 = b.getSpecialVar().getVarDecl().getType().getCScanfSpecifier();
    _builder.append(_cScanfSpecifier_1, "\t");
    _builder.append("\", &");
    CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, false);
    _builder.append(_varAccess_1, "\t");
    _builder.append(")");
    String _cScanfPostProcess_1 = b.getSpecialVar().getVarDecl().getType().getCScanfPostProcess();
    _builder.append(_cScanfPostProcess_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("#endif");
    _builder.newLine();
    return _builder;
  }

  private CharSequence printIndex(final VariableDeclaration v, final CharSequence macroIndex) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  private CharSequence varAccess(final VariableDeclaration v, final CharSequence macroIndex, final boolean isSpecial) {
    CharSequence _xifexpression = null;
    if ((v.isOutput() && Objects.equal(macroIndex, null))) {
      _xifexpression = this.varAccess(v.getName(), " ", isSpecial);
    } else {
      _xifexpression = this.varAccess(v.getName(), macroIndex, isSpecial);
    }
    return _xifexpression;
  }

  private CharSequence varAccess(final CharSequence vName, final CharSequence macroIndex, final boolean isSpecial) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(vName);
    {
      if (((!Objects.equal(macroIndex, null)) && (macroIndex.length() > 0))) {
        _builder.append("(");
        _builder.append(macroIndex);
        _builder.append(")");
      }
    }
    {
      if (((Objects.equal(macroIndex, null) || (macroIndex.length() == 0)) && isSpecial)) {
        _builder.append("()");
      }
    }
    return _builder;
  }

  protected CharSequence printOutput(final OutputPrinting b) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field getMemoryAccessExpressions is undefined for the type SpecialVariable"
      + "\nThe method or field getMemoryAccessExpressions is undefined for the type SpecialVariable"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\njoin cannot be resolved"
      + "\ngetMacroIndicesExceptTime cannot be resolved"
      + "\njoin cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\njoin cannot be resolved");
  }

  protected CharSequence verifyOutput(final OutputVerification b) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field getMemoryAccessExpressions is undefined for the type SpecialVariable"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  protected Object tilingHandling(final Function f) {
    return null;
  }

  protected CharSequence malloc(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Allocation");
    _builder.newLine();
    final CodeGenVariable maxDim = this.memory.variableWithMaxDim(f.getCodeunit().getVariables());
    _builder.newLineIfNotEmpty();
    String _declareMalloLoopIterators = this.memory.declareMalloLoopIterators(maxDim.getDomain().getNIndices());
    _builder.append(_declareMalloLoopIterators);
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _inputs = f.getInputs();
      EList<AbstractVariable> _outputs = f.getOutputs();
      Iterable<AbstractVariable> _plus = Iterables.<AbstractVariable>concat(_inputs, _outputs);
      for(final AbstractVariable v : _plus) {
        CharSequence _malloc = this.memory.malloc(v);
        _builder.append(_malloc);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG);
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _outputs_1 = f.getOutputs();
      for(final AbstractVariable v_1 : _outputs_1) {
        _builder.append("\t");
        CharSequence _malloc_1 = this.memory.malloc(v_1, CodeGenConstantsForC.VERIFY_POSTFIX);
        _builder.append(_malloc_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#endif");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence mfree(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Free");
    _builder.newLine();
    {
      EList<AbstractVariable> _inputs = f.getInputs();
      EList<AbstractVariable> _outputs = f.getOutputs();
      Iterable<AbstractVariable> _plus = Iterables.<AbstractVariable>concat(_inputs, _outputs);
      for(final AbstractVariable v : _plus) {
        CharSequence _mfree = this.memory.mfree(v);
        _builder.append(_mfree);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG);
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _outputs_1 = f.getOutputs();
      for(final AbstractVariable v_1 : _outputs_1) {
        _builder.append("\t");
        CharSequence _mfree_1 = this.memory.mfree(v_1, CodeGenConstantsForC.VERIFY_POSTFIX);
        _builder.append(_mfree_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#endif");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence asParameter(final CVariable v) {
    if (v != null) {
      return _asParameter(v);
    } else if (v != null) {
      return _asParameter(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }

  protected CharSequence asParameterType(final CVariable v) {
    if (v != null) {
      return _asParameterType(v);
    } else if (v != null) {
      return _asParameterType(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }

  protected Object asVerifyParameter(final CVariable v) {
    if (v != null) {
      return _asVerifyParameter(v);
    } else if (v != null) {
      return _asVerifyParameter(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
