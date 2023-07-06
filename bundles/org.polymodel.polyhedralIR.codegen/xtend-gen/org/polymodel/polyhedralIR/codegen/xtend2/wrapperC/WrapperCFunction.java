package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.codegen.xtend2.Indexed;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants;

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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//function prototypes");
    _builder.newLine();
    CharSequence _mainFunctionPrototype = this.mainFunctionPrototype(func);
    _builder.append(_mainFunctionPrototype);
    _builder.newLineIfNotEmpty();
    CharSequence _verifyPrototype = this.verifyPrototype(func);
    _builder.append(_verifyPrototype);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("//main");
    _builder.newLine();
    _builder.append("int main(int argc, char** argv) {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _checkNumberOfArgs = this.checkNumberOfArgs(func);
    _builder.append(_checkNumberOfArgs, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _readParameters = this.readParameters(func);
    _builder.append(_readParameters, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _parameterCheck = this.parameterCheck(func);
    _builder.append(_parameterCheck, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    Object _tilingHandling = this.tilingHandling(func);
    _builder.append(_tilingHandling, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _malloc = this.malloc(func);
    _builder.append(_malloc, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Initialization of rand");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("srand((unsigned)time(NULL));");
    _builder.newLine();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Input Initialization");
    _builder.newLine();
    _builder.append("\t");
    final Function1<Body, Boolean> _function = (Body b) -> {
      return Boolean.valueOf((b instanceof InputInitialization));
    };
    final Function1<Body, CharSequence> _function_1 = (Body b) -> {
      return this.inputInitialization(((InputInitialization) b));
    };
    String _join = IterableExtensions.<Body>join(IterableExtensions.<Body>filter(func.getBodies(), _function), "", _function_1);
    _builder.append(_join, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Timing");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("struct timeval time;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double elapsed_time;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Call the main computation");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("gettimeofday(&time, NULL);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _mainFunctionCall = this.mainFunctionCall(func);
    _builder.append(_mainFunctionCall, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("gettimeofday(&time, NULL);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// timing information");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("printf(\"Execution time : %lf sec.\\n\", elapsed_time);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.TIMING_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("FILE * fp = fopen( \"trace.dat\",\"a+\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (fp == NULL) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("printf(\"I couldn\'t open trace.dat for writing.\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("exit(EXIT_FAILURE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fprintf(fp, \"");
    final Function1<Variable, CharSequence> _function_2 = (Variable p) -> {
      return "%ld";
    };
    String _join_1 = IterableExtensions.<Variable>join(this.getParamDomain(func).getParams(), "\\t", _function_2);
    _builder.append(_join_1, "\t\t");
    _builder.append("\\t%lf\\n\",");
    final Function1<Variable, CharSequence> _function_3 = (Variable p) -> {
      return p.getName();
    };
    String _join_2 = IterableExtensions.<Variable>join(this.getParamDomain(func).getParams(), ",", _function_3);
    _builder.append(_join_2, "\t\t");
    _builder.append(",elapsed_time);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("fclose(fp);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Verification Run");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.TIMING_FLAG, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("gettimeofday(&time, NULL);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("    \t");
    CharSequence _verifyFunctionCall = this.verifyFunctionCall(func);
    _builder.append(_verifyFunctionCall, "    \t");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.TIMING_FLAG, "    \t");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t\t");
    _builder.append("gettimeofday(&time, NULL);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("elapsed_time = (((double) time.tv_sec) + ((double) time.tv_usec)/1000000) - elapsed_time;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("FILE * fp");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t");
    _builder.append(" = fopen( \"trace");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t");
    _builder.append(".dat\",\"a+\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (fp");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t");
    _builder.append(" == NULL) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("printf(\"I couldn\'t open trace");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t\t\t");
    _builder.append(".dat for writing.\\n\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("exit(EXIT_FAILURE);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fprintf(fp");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t");
    _builder.append(", \"");
    final Function1<Variable, CharSequence> _function_4 = (Variable p) -> {
      return "%ld";
    };
    String _join_3 = IterableExtensions.<Variable>join(this.getParamDomain(func).getParams(), "\\t", _function_4);
    _builder.append(_join_3, "\t\t\t");
    _builder.append("\\t%lf\\n\",");
    final Function1<Variable, CharSequence> _function_5 = (Variable p) -> {
      return p.getName();
    };
    String _join_4 = IterableExtensions.<Variable>join(this.getParamDomain(func).getParams(), ",", _function_5);
    _builder.append(_join_4, "\t\t\t");
    _builder.append(",elapsed_time);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("fclose(fp");
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("//Print Outputs");
    _builder.newLine();
    _builder.append("\t\t");
    final Function1<Body, Boolean> _function_6 = (Body b) -> {
      return Boolean.valueOf((b instanceof OutputPrinting));
    };
    final Function1<Body, CharSequence> _function_7 = (Body b) -> {
      return this.printOutput(((OutputPrinting) b));
    };
    String _join_5 = IterableExtensions.<Body>join(IterableExtensions.<Body>filter(func.getBodies(), _function_6), "", _function_7);
    _builder.append(_join_5, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#elif ");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//Compare outputs for verification");
    _builder.newLine();
    _builder.append("\t\t");
    final Function1<Body, Boolean> _function_8 = (Body b) -> {
      return Boolean.valueOf((b instanceof OutputVerification));
    };
    final Function1<Body, CharSequence> _function_9 = (Body b) -> {
      return this.verifyOutput(((OutputVerification) b));
    };
    String _join_6 = IterableExtensions.<Body>join(IterableExtensions.<Body>filter(func.getBodies(), _function_8), "", _function_9);
    _builder.append(_join_6, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _mfree = this.mfree(func);
    _builder.append(_mfree, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return EXIT_SUCCESS;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected ParameterDomain getParamDomain(final Function func) {
    return func.getCodeunit().getSystem().getParameters();
  }
  
  protected CharSequence checkNumberOfArgs(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Check number of args");
    _builder.newLine();
    _builder.append("if (argc <= ");
    int _dim = this.getParamDomain(f).getDim();
    _builder.append(_dim);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("printf(\"Number of argument is smaller than expected.\\n\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("printf(\"Expecting ");
    final Function1<Variable, CharSequence> _function = (Variable p) -> {
      return p.getName();
    };
    String _join = IterableExtensions.<Variable>join(this.getParamDomain(f).getParams(), ",", _function);
    _builder.append(_join, "\t");
    _builder.append("\\n\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("exit(0);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence readParameters(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("char *end = 0;");
    _builder.newLine();
    _builder.append("char *val = 0;");
    _builder.newLine();
    _builder.append("//Read Parameters");
    _builder.newLine();
    {
      Iterable<Indexed<Variable>> _indexed = Indexed.<Variable>indexed(this.getParamDomain(f).getParams());
      for(final Indexed<Variable> p : _indexed) {
        _builder.append("//Initialisation of ");
        String _name = p.getValue().getName();
        _builder.append(_name);
        _builder.newLineIfNotEmpty();
        _builder.append("errno = 0;");
        _builder.newLine();
        _builder.append("end = 0;");
        _builder.newLine();
        _builder.append("val = argv[");
        int _index1 = p.getIndex1();
        _builder.append(_index1);
        _builder.append("];");
        _builder.newLineIfNotEmpty();
        _builder.append("long ");
        String _name_1 = p.getValue().getName();
        _builder.append(_name_1);
        _builder.append(" = strtol(val,&end,10);");
        _builder.newLineIfNotEmpty();
        _builder.append("if ((errno == ERANGE && (");
        String _name_2 = p.getValue().getName();
        _builder.append(_name_2);
        _builder.append(" == LONG_MAX || ");
        String _name_3 = p.getValue().getName();
        _builder.append(_name_3);
        _builder.append(" == LONG_MIN)) || (errno != 0 && ");
        String _name_4 = p.getValue().getName();
        _builder.append(_name_4);
        _builder.append(" == 0)) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("perror(\"strtol\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("exit(EXIT_FAILURE);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (end == val) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("fprintf(stderr, \"No digits were found for ");
        String _name_5 = p.getValue().getName();
        _builder.append(_name_5, "\t");
        _builder.append("\\n\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("exit(EXIT_FAILURE);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("if (*end != \'\\0\'){");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("printf(\"For parameter ");
        String _name_6 = p.getValue().getName();
        _builder.append(_name_6, "\t");
        _builder.append(": Converted part: %ld, non-convertible part: %s\\n\", ");
        String _name_7 = p.getValue().getName();
        _builder.append(_name_7, "\t");
        _builder.append(", end);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("exit(EXIT_FAILURE);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence parameterCheck(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("///Parameter checking");
    _builder.newLine();
    _builder.append("if (!(");
    CharSequence _printConstraints = this.domainExtensions.printConstraints(this.getParamDomain(f));
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
  
  protected Iterable<EObject> mainFunctionParameters(final Function f) {
    EList<Variable> _params = this.getParamDomain(f).getParams();
    final Function1<AbstractVariable, Boolean> _function = (AbstractVariable e) -> {
      return Boolean.valueOf((Utility.isInput(e, f) || Utility.isOutput(e, f)));
    };
    Iterable<AbstractVariable> _filter = IterableExtensions.<AbstractVariable>filter(f.getCodeunit().getVariables(), _function);
    return Iterables.<EObject>concat(_params, _filter);
  }
  
  protected CharSequence _asParameter(final Variable v) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = v.getName();
    _builder.append(_name);
    return _builder;
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
  
  protected CharSequence _asParameterType(final Variable v) {
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
  
  protected CharSequence _asVerifyParameter(final Variable v) {
    return this.asParameter(v);
  }
  
  protected CharSequence _asVerifyParameter(final CVariable v) {
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    String _mainFunctionName = this.mainFunctionName(f);
    _builder.append(_mainFunctionName);
    _builder.append("(");
    final Function1<EObject, CharSequence> _function = (EObject p) -> {
      return this.asParameterType(p);
    };
    String _join = IterableExtensions.<EObject>join(this.mainFunctionParameters(f), ", ", _function);
    _builder.append(_join);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence verifyPrototype(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    String _mainFunctionName = this.mainFunctionName(f);
    _builder.append(_mainFunctionName);
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX);
    _builder.append("(");
    final Function1<EObject, CharSequence> _function = (EObject p) -> {
      return this.asParameterType(p);
    };
    String _join = IterableExtensions.<EObject>join(this.mainFunctionParameters(f), ", ", _function);
    _builder.append(_join);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence mainFunctionCall(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    String _mainFunctionName = this.mainFunctionName(f);
    _builder.append(_mainFunctionName);
    _builder.append("(");
    final Function1<EObject, CharSequence> _function = (EObject p) -> {
      return this.asParameter(p);
    };
    String _join = IterableExtensions.<EObject>join(this.mainFunctionParameters(f), ", ", _function);
    _builder.append(_join);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence verifyFunctionCall(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    String _mainFunctionName = this.mainFunctionName(f);
    _builder.append(_mainFunctionName);
    _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX);
    _builder.append("(");
    final Function1<EObject, CharSequence> _function = (EObject p) -> {
      return this.asVerifyParameter(p);
    };
    String _join = IterableExtensions.<EObject>join(this.mainFunctionParameters(f), ", ", _function);
    _builder.append(_join);
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence inputInitialization(final InputInitialization b) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
      return e.toString();
    };
    String accessIndex = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), ",", _function);
    _builder.newLineIfNotEmpty();
    CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
    _builder.newLineIfNotEmpty();
    final Function1<Variable, CharSequence> _function_1 = (Variable e) -> {
      String _string = e.toString();
      return ("(long) " + _string);
    };
    String macroIndexB = IterableExtensions.<Variable>join(b.getSpecialVar().getVarDecl().getDomain().getIndices(), ",", _function_1);
    _builder.append("  ");
    _builder.newLineIfNotEmpty();
    String macroName = b.getStatements().get(0).getName();
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#if defined (");
    _builder.append(CodeGenConstantsForC.RANDOM_FLAG, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t\t");
    _builder.append(") (");
    CharSequence _varAccess = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, false);
    _builder.append(_varAccess, "\t\t");
    _builder.append(" = rand()) ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#elif defined (");
    _builder.append(CodeGenConstantsForC.CHECKING_FLAG, "\t");
    _builder.append(") || defined (");
    _builder.append(CodeGenConstantsForC.VERIFY_FLAG, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _userInput = this.userInput(b, macroName, macroIndexB, macroIndex, accessIndex);
    _builder.append(_userInput, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#else");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t\t");
    _builder.append(") (");
    CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), macroIndex, false);
    _builder.append(_varAccess_1, "\t\t");
    _builder.append(" = 1)   //Default value");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateLoopNest = this.body.generateLoopNest(b);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#undef ");
    _builder.append(macroName, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
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
  
  protected CharSequence printIndex(final VariableDeclaration v, final CharSequence macroIndex) {
    CharSequence _xifexpression = null;
    int _nIndices = v.getDomain().getNIndices();
    boolean _greaterThan = (_nIndices > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("printf(\"");
      String _name = v.getName();
      _builder.append(_name);
      _builder.append("(");
      final Function1<Variable, CharSequence> _function = (Variable e) -> {
        return "%ld";
      };
      String _join = IterableExtensions.<Variable>join(v.getDomain().getIndices(), ",", _function);
      _builder.append(_join);
      _builder.append(")=\",");
      _builder.append(macroIndex);
      _builder.append(");");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("printf(\"");
      String _name_1 = v.getName();
      _builder_1.append(_name_1);
      _builder_1.append("=\");");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  protected CharSequence varAccess(final VariableDeclaration v, final CharSequence macroIndex, final boolean isSpecial) {
    CharSequence _xifexpression = null;
    if ((v.isOutput() && Objects.equal(macroIndex, null))) {
      _xifexpression = this.varAccess(v.getName(), " ", isSpecial);
    } else {
      _xifexpression = this.varAccess(v.getName(), macroIndex, isSpecial);
    }
    return _xifexpression;
  }
  
  protected CharSequence varAccess(final CharSequence vName, final CharSequence macroIndex, final boolean isSpecial) {
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
    StringConcatenation _builder = new StringConcatenation();
    final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
      return e.toString();
    };
    String accessIndex = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), ",", _function);
    _builder.newLineIfNotEmpty();
    final Function1<AffineExpression, Boolean> _function_1 = (AffineExpression e) -> {
      boolean _equals = e.toString().equals("t");
      return Boolean.valueOf((!_equals));
    };
    final Function1<AffineExpression, CharSequence> _function_2 = (AffineExpression e) -> {
      return e.toString();
    };
    String _join = IterableExtensions.<AffineExpression>join(IterableExtensions.<AffineExpression>filter(b.getSpecialVar().getMemoryAccessExpressions(), _function_1), ",", _function_2);
    String accessIndexWithoutTime = ("0," + _join);
    _builder.newLineIfNotEmpty();
    CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
    _builder.newLineIfNotEmpty();
    CharSequence macroIndexWithoutTime = this.indices.getMacroIndicesExceptTime(b.getSpecialVar().getVarDecl().getDomain().getIndices());
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<Variable, CharSequence> _function_3 = (Variable e) -> {
      String _string = e.toString();
      return ("(long) " + _string);
    };
    String macroIndexB = IterableExtensions.<Variable>join(b.getSpecialVar().getVarDecl().getDomain().getIndices(), ",", _function_3);
    _builder.newLineIfNotEmpty();
    final Function1<Variable, Boolean> _function_4 = (Variable e) -> {
      boolean _equals = e.toString().equals("t");
      return Boolean.valueOf((!_equals));
    };
    final Function1<Variable, CharSequence> _function_5 = (Variable e) -> {
      String _string = e.toString();
      return ("(long) " + _string);
    };
    String _join_1 = IterableExtensions.<Variable>join(IterableExtensions.<Variable>filter(b.getSpecialVar().getVarDecl().getDomain().getIndices(), _function_4), ",", _function_5);
    String macroIndexBWithoutTime = ("(long) 0," + _join_1);
    _builder.newLineIfNotEmpty();
    String macroName = b.getStatements().get(0).getName();
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef ");
    _builder.append(CodeGenConstantsForC.NO_PROMT_FLAG, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t\t");
    _builder.append(") printf(\"");
    String _cPrintfSpecifier = b.getSpecialVar().getVarDecl().getType().getCPrintfSpecifier();
    _builder.append(_cPrintfSpecifier, "\t\t");
    _builder.append("\\n\",var_");
    CharSequence _varAccess = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
    _builder.append(_varAccess, "\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#else");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#define ");
    _builder.append(macroName, "\t\t");
    _builder.append("(");
    _builder.append(macroIndex, "\t\t");
    _builder.append(") ");
    CharSequence _printIndex = this.printIndex(b.getSpecialVar().getVarDecl(), macroIndexB);
    _builder.append(_printIndex, "\t\t");
    _builder.append("printf(\"");
    String _cPrintfSpecifier_1 = b.getSpecialVar().getVarDecl().getType().getCPrintfSpecifier();
    _builder.append(_cPrintfSpecifier_1, "\t\t");
    _builder.append("\\n\",var_");
    CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
    _builder.append(_varAccess_1, "\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateLoopNest = this.body.generateLoopNest(b);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#undef ");
    _builder.append(macroName, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence verifyOutput(final OutputVerification b) {
    CharSequence _xblockexpression = null;
    {
      final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
        return e.toString();
      };
      String accessIndex = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), ",", _function);
      CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
      if ((Objects.equal(macroIndex, null) && b.getSpecialVar().getVarDecl().isOutput())) {
        macroIndex = " ";
      }
      String macroName = b.getStatements().get(0).getName();
      boolean isRelative = false;
      String absf = "abs";
      String constPostFix = "";
      if ((Objects.equal(b.getSpecialVar().getVarDecl().getType().getTypeID(), DATATYPE.FLOATING_POINT) && (b.getSpecialVar().getVarDecl().getType().getWidth() == 32))) {
        isRelative = true;
        absf = "fabsf";
        constPostFix = ".0f";
      } else {
        if ((Objects.equal(b.getSpecialVar().getVarDecl().getType().getTypeID(), DATATYPE.FLOATING_POINT) && (b.getSpecialVar().getVarDecl().getType().getWidth() == 64))) {
          isRelative = true;
          absf = "fabs";
          constPostFix = ".0";
        }
      }
      CharSequence _xifexpression = null;
      int _nIndices = b.getSpecialVar().getVarDecl().getDomain().getNIndices();
      boolean _equals = (_nIndices == 0);
      if (_equals) {
        CharSequence _xifexpression_1 = null;
        if (isRelative) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("if (");
          _builder.append(absf);
          _builder.append("(1");
          _builder.append(constPostFix);
          _builder.append(" - var_");
          String _name = b.getSpecialVar().getVarDecl().getName();
          CharSequence _varAccess = this.varAccess((_name + CodeGenConstantsForC.VERIFY_POSTFIX), accessIndex, true);
          _builder.append(_varAccess);
          _builder.append("/var_");
          CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
          _builder.append(_varAccess_1);
          _builder.append(") > ");
          _builder.append(CodeGenConstants.EPSILON_NAME);
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("printf(\"TEST for ");
          String _name_1 = b.getSpecialVar().getVarDecl().getName();
          _builder.append(_name_1, "\t");
          _builder.append(" FAILED result: %f expected: %f\\n\",var_");
          CharSequence _varAccess_2 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
          _builder.append(_varAccess_2, "\t");
          _builder.append(", var_");
          String _name_2 = b.getSpecialVar().getVarDecl().getName();
          CharSequence _varAccess_3 = this.varAccess((_name_2 + CodeGenConstantsForC.VERIFY_POSTFIX), accessIndex, true);
          _builder.append(_varAccess_3, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("} else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("printf(\"TEST for ");
          String _name_3 = b.getSpecialVar().getVarDecl().getName();
          _builder.append(_name_3, "\t");
          _builder.append(" PASSED\\n\");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _xifexpression_1 = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("if (var_");
          String _name_4 = b.getSpecialVar().getVarDecl().getName();
          CharSequence _varAccess_4 = this.varAccess((_name_4 + CodeGenConstantsForC.VERIFY_POSTFIX), accessIndex, true);
          _builder_1.append(_varAccess_4);
          _builder_1.append("!=var_");
          CharSequence _varAccess_5 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
          _builder_1.append(_varAccess_5);
          _builder_1.append(") {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("printf(\"TEST for ");
          String _name_5 = b.getSpecialVar().getVarDecl().getName();
          _builder_1.append(_name_5, "\t");
          _builder_1.append(" FAILED\\n\");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("} else {");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("printf(\"TEST for ");
          String _name_6 = b.getSpecialVar().getVarDecl().getName();
          _builder_1.append(_name_6, "\t");
          _builder_1.append(" PASSED\\n\");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _xifexpression_1 = _builder_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        CharSequence _xifexpression_2 = null;
        if (isRelative) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("{");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("//Error Counter");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("int _errors_ = 0;");
          _builder_2.newLine();
          _builder_2.append("\t");
          _builder_2.append("#define ");
          _builder_2.append(macroName, "\t");
          _builder_2.append("(");
          _builder_2.append(macroIndex, "\t");
          _builder_2.append(") if (");
          _builder_2.append(absf, "\t");
          _builder_2.append("(1");
          _builder_2.append(constPostFix, "\t");
          _builder_2.append(" - var_");
          String _name_7 = b.getSpecialVar().getVarDecl().getName();
          CharSequence _varAccess_6 = this.varAccess((_name_7 + CodeGenConstantsForC.VERIFY_POSTFIX), accessIndex, true);
          _builder_2.append(_varAccess_6, "\t");
          _builder_2.append("/var_");
          CharSequence _varAccess_7 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
          _builder_2.append(_varAccess_7, "\t");
          _builder_2.append(") > ");
          _builder_2.append(CodeGenConstants.EPSILON_NAME, "\t");
          _builder_2.append(") _errors_++;");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          CharSequence _generateLoopNest = this.body.generateLoopNest(b);
          _builder_2.append(_generateLoopNest, "\t");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("#undef ");
          _builder_2.append(macroName, "\t");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("if(_errors_ == 0){");
          _builder_2.newLine();
          _builder_2.append("\t\t");
          _builder_2.append("printf(\"TEST for ");
          String _name_8 = b.getSpecialVar().getVarDecl().getName();
          _builder_2.append(_name_8, "\t\t");
          _builder_2.append(" PASSED\\n\");");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("}else{");
          _builder_2.newLine();
          _builder_2.append("\t\t");
          _builder_2.append("printf(\"TEST for ");
          String _name_9 = b.getSpecialVar().getVarDecl().getName();
          _builder_2.append(_name_9, "\t\t");
          _builder_2.append(" FAILED. #Errors: %d\\n\", _errors_);");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("}");
          _builder_2.newLine();
          _builder_2.append("}");
          _builder_2.newLine();
          _xifexpression_2 = _builder_2;
        } else {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("{");
          _builder_3.newLine();
          _builder_3.append("\t");
          _builder_3.append("//Error Counter");
          _builder_3.newLine();
          _builder_3.append("\t");
          _builder_3.append("int _errors_ = 0;");
          _builder_3.newLine();
          _builder_3.append("\t");
          _builder_3.append("#define ");
          _builder_3.append(macroName, "\t");
          _builder_3.append("(");
          _builder_3.append(macroIndex, "\t");
          _builder_3.append(") if (var_");
          String _name_10 = b.getSpecialVar().getVarDecl().getName();
          CharSequence _varAccess_8 = this.varAccess((_name_10 + CodeGenConstantsForC.VERIFY_POSTFIX), accessIndex, true);
          _builder_3.append(_varAccess_8, "\t");
          _builder_3.append("!=var_");
          CharSequence _varAccess_9 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
          _builder_3.append(_varAccess_9, "\t");
          _builder_3.append(") _errors_++;");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("\t");
          CharSequence _generateLoopNest_1 = this.body.generateLoopNest(b);
          _builder_3.append(_generateLoopNest_1, "\t");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("\t");
          _builder_3.append("#undef ");
          _builder_3.append(macroName, "\t");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("\t");
          _builder_3.append("if(_errors_ == 0){");
          _builder_3.newLine();
          _builder_3.append("\t\t");
          _builder_3.append("printf(\"TEST for ");
          String _name_11 = b.getSpecialVar().getVarDecl().getName();
          _builder_3.append(_name_11, "\t\t");
          _builder_3.append(" PASSED\\n\");");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("\t");
          _builder_3.append("}else{");
          _builder_3.newLine();
          _builder_3.append("\t\t");
          _builder_3.append("printf(\"TEST for ");
          String _name_12 = b.getSpecialVar().getVarDecl().getName();
          _builder_3.append(_name_12, "\t\t");
          _builder_3.append(" FAILED. #Errors: %d\\n\", _errors_);");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("\t");
          _builder_3.append("}");
          _builder_3.newLine();
          _builder_3.append("}");
          _builder_3.newLine();
          _xifexpression_2 = _builder_3;
        }
        _xifexpression = _xifexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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
  
  protected CharSequence asParameter(final EObject v) {
    if (v instanceof CVariable) {
      return _asParameter((CVariable)v);
    } else if (v instanceof Variable) {
      return _asParameter((Variable)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
  
  protected CharSequence asParameterType(final EObject v) {
    if (v instanceof CVariable) {
      return _asParameterType((CVariable)v);
    } else if (v instanceof Variable) {
      return _asParameterType((Variable)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
  
  protected CharSequence asVerifyParameter(final EObject v) {
    if (v instanceof CVariable) {
      return _asVerifyParameter((CVariable)v);
    } else if (v instanceof Variable) {
      return _asVerifyParameter((Variable)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
