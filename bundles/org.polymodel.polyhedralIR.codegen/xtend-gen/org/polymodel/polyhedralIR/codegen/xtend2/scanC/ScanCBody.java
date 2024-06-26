package org.polymodel.polyhedralIR.codegen.xtend2.scanC;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;

@SuppressWarnings("all")
public class ScanCBody extends BaseBody {
  @Inject
  @Extension
  private BaseMemoryAllocation malloc;

  protected String functionParameters(final Function f) {
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable p) -> {
      return p.asParameter();
    };
    return IterableExtensions.<AbstractVariable>join(f.getSignature().getParameters(), ", ", _function);
  }

  protected String functionParameters(final OriginDomainVolume b) {
    return this.functionParameters(b.getFunction());
  }

  protected String functionParameters(final VolumeFunction b) {
    return this.functionParameters(b.getFunction());
  }

  protected String functionParameters(final VolumeFunctionDerivative b) {
    return this.functionParameters(b.getFunction());
  }

  protected String functionParameters(final BoundComputation b) {
    return this.functionParameters(b.getFunction());
  }

  protected CharSequence _code(final OriginDomainVolume b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int volume = 0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//volume function(Modify by hand)");
    _builder.newLine();
    _builder.append("volume =  100;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("return volume;");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _code(final VolumeFunction b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int volume = 0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//volume function(Modify by hand)");
    _builder.newLine();
    _builder.append("volume = ");
    String _name = b.getUnknown().getName();
    _builder.append(_name);
    _builder.append("*");
    String _name_1 = b.getUnknown().getName();
    _builder.append(_name_1);
    _builder.append(" + 10;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("return volume;");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _code(final VolumeFunctionDerivative b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int volume = 0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//derivative of the volume function(Modify by hand)");
    _builder.newLine();
    _builder.append("volume = 2*");
    String _name = b.getUnknown().getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("return volume;");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _code(final BoundComputation b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("double fx, df, dx;");
    _builder.newLine();
    _builder.append("double xn = 0.0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//find the init value");
    _builder.newLine();
    _builder.append("double ");
    String _name = b.getVolumeFunction().getUnknown().getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("x = ");
    String _name_1 = b.getInitialValue().getName();
    _builder.append(_name_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("double val = ");
    String _name_2 = b.getVolumeFunction().getFunction().getName();
    _builder.append(_name_2);
    _builder.append("(");
    String _functionParameters = this.functionParameters(b.getVolumeFunction());
    _builder.append(_functionParameters);
    _builder.append(") - ");
    String _name_3 = b.getConstantTerm().getName();
    _builder.append(_name_3);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("if(val == 0.0) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return x;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//compute the root");
    _builder.newLine();
    _builder.append("int iter;");
    _builder.newLine();
    _builder.append("for (iter = 0; iter < MAX_ITER; iter++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fx = ");
    String _name_4 = b.getVolumeFunction().getFunction().getName();
    _builder.append(_name_4, "\t");
    _builder.append("(");
    String _functionParameters_1 = this.functionParameters(b.getVolumeFunction());
    _builder.append(_functionParameters_1, "\t");
    _builder.append(") -  ");
    String _name_5 = b.getConstantTerm().getName();
    _builder.append(_name_5, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("df = ");
    String _name_6 = b.getVolumeFunctionDerivative().getFunction().getName();
    _builder.append(_name_6, "\t");
    _builder.append("(");
    String _functionParameters_2 = this.functionParameters(b.getVolumeFunctionDerivative());
    _builder.append(_functionParameters_2, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("dx = -fx/df;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("x += dx;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef DEBUG");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("printf(\"root at iter %d: %.5f\\n\", iter, x);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(fabs(dx)<eps){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#ifdef DEBUG");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("printf(\"found root %.5f after %d attempts\\n\", x, iter);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("return (int)(x + 0.5);");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _code(final ScanBody b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Get the number of threads");
    _builder.newLine();
    _builder.append("int ");
    String _nthreadVariableName = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("#pragma omp parallel");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#pragma omp single");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    String _nthreadVariableName_1 = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName_1, "\t\t");
    _builder.append(" = omp_get_num_threads();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//declare memory for global variables used in the middle phrase");
    _builder.newLine();
    {
      EList<CodeGenVariable> _localScanReductionVariables = b.getLocalScanReductionVariables();
      for(final CodeGenVariable v : _localScanReductionVariables) {
        CharSequence _malloc = this.malloc.malloc(v);
        _builder.append(_malloc);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("//index array to save the results");
    _builder.newLine();
    _builder.append("int *index = (int *)malloc((");
    String _nthreadVariableName_2 = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName_2);
    _builder.append(")*sizeof(int));");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("//PUT THE INITIAL VALUE BACK");
    _builder.newLine();
    Object _code = this.code(b.getScanReductionBody().getInitValueCopy());
    _builder.append(_code);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#pragma omp parallel");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//GET THE THREAD NUMBER");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int ");
    String _threadNumVariableName = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName, "\t");
    _builder.append(" = omp_get_thread_num();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//COMPUTE THE INDEX VALUE OF EACH THREAD");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double blocksize;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double ");
    String _name = b.getBoundComputationFunction().getConstantTerm().getName();
    _builder.append(_name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int ");
    String _name_1 = b.getVolumeFunction().getUnknown().getName();
    _builder.append(_name_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//compute the blocksize");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("blocksize = (double)");
    String _name_2 = b.getOriginDomainVolume().getFunction().getName();
    _builder.append(_name_2, "\t");
    _builder.append("(");
    String _functionParameters = this.functionParameters(b.getOriginDomainVolume());
    _builder.append(_functionParameters, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("blocksize = blocksize/(double)(");
    String _nthreadVariableName_3 = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName_3, "\t");
    _builder.append("+1);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int ");
    String _name_3 = b.getBoundComputationFunction().getLb().getName();
    _builder.append(_name_3, "\t");
    _builder.append(" = ");
    IntExpression _get = b.getDomain().getBounds(0).get(0);
    _builder.append(_get, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int ");
    String _name_4 = b.getBoundComputationFunction().getUb().getName();
    _builder.append(_name_4, "\t");
    _builder.append(" = ");
    IntExpression _get_1 = b.getDomain().getBounds(0).get(1);
    _builder.append(_get_1, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int ");
    String _name_5 = b.getBoundComputationFunction().getInitialValue().getName();
    _builder.append(_name_5, "\t");
    _builder.append(" = (");
    String _name_6 = b.getBoundComputationFunction().getUb().getName();
    _builder.append(_name_6, "\t");
    _builder.append(" - ");
    String _name_7 = b.getBoundComputationFunction().getLb().getName();
    _builder.append(_name_7, "\t");
    _builder.append(")/(");
    String _nthreadVariableName_4 = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName_4, "\t");
    _builder.append("+1)*(");
    String _threadNumVariableName_1 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_1, "\t");
    _builder.append("+1);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("constantTerm = blocksize*(");
    String _threadNumVariableName_2 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_2, "\t");
    _builder.append("+1);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("index[");
    String _threadNumVariableName_3 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_3, "\t");
    _builder.append("] = ");
    String _name_8 = b.getBoundComputationFunction().getFunction().getName();
    _builder.append(_name_8, "\t");
    _builder.append("(");
    String _functionParameters_1 = this.functionParameters(b.getBoundComputationFunction());
    _builder.append(_functionParameters_1, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("#pragma omp barrier");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int ");
    String _beginVariableName = b.getBeginVariableName();
    _builder.append(_beginVariableName, "\t");
    _builder.append(", ");
    String _endVariableName = b.getEndVariableName();
    _builder.append(_endVariableName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Compute the initialization vector");
    _builder.newLine();
    {
      EList<CodeGenVariable> _initTempVariables = b.getScanReductionBody().getInitTempVariables();
      for(final CodeGenVariable v_1 : _initTempVariables) {
        _builder.append("\t");
        CharSequence _malloc_1 = this.malloc.malloc(v_1);
        _builder.append(_malloc_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//initialize the inidices\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (");
    String _threadNumVariableName_4 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_4, "\t");
    _builder.append(" == 0) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _beginVariableName_1 = b.getBeginVariableName();
    _builder.append(_beginVariableName_1, "\t\t");
    _builder.append(" = ");
    String _name_9 = b.getBoundComputationFunction().getLb().getName();
    _builder.append(_name_9, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    String _beginVariableName_2 = b.getBeginVariableName();
    _builder.append(_beginVariableName_2, "\t\t");
    _builder.append(" = index[");
    String _threadNumVariableName_5 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_5, "\t\t");
    _builder.append(" - 1];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _endVariableName_1 = b.getEndVariableName();
    _builder.append(_endVariableName_1, "\t");
    _builder.append(" = index[");
    String _threadNumVariableName_6 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_6, "\t");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (");
    String _threadNumVariableName_7 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_7, "\t");
    _builder.append("==0) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//INITIALIZE THE INITIALIZATION VALUE");
    _builder.newLine();
    _builder.append("\t\t");
    Object _code_1 = this.code(b.getScanReductionBody().getAssignmentLoop());
    _builder.append(_code_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//CALL THE SCAN FUNCTION");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_10 = b.getLocalScanFunction().getName();
    _builder.append(_name_10, "\t\t");
    _builder.append("(");
    String _functionParameters_2 = this.functionParameters(b.getLocalScanFunction());
    _builder.append(_functionParameters_2, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//GET THE NEW INITIALIZATION VALUE");
    _builder.newLine();
    _builder.append("\t\t");
    Object _code_2 = this.code(b.getScanReductionBody().getInitValueUpdate());
    _builder.append(_code_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    {
      EList<CodeGenVariable> _localReductionVariables = b.getLocalReductionVariables();
      for(final CodeGenVariable v_2 : _localReductionVariables) {
        _builder.append("\t\t");
        CharSequence _malloc_2 = this.malloc.malloc(v_2);
        _builder.append(_malloc_2, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//CALL THE REDUCTION FUNCTION");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_11 = b.getLocalReductionFunction().getName();
    _builder.append(_name_11, "\t\t");
    _builder.append("(");
    String _functionParameters_3 = this.functionParameters(b.getLocalReductionFunction());
    _builder.append(_functionParameters_3, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//THE REDUCTION SCAN PHASE");
    _builder.newLine();
    _builder.append("\t\t");
    Object _code_3 = this.code(b.getScanReductionBody().getPreProcessLoop());
    _builder.append(_code_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#pragma omp barrier");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#pragma omp single");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    {
      EList<CodeGenVariable> _matrixTempVariables = b.getScanReductionBody().getMatrixTempVariables();
      for(final CodeGenVariable v_3 : _matrixTempVariables) {
        _builder.append("\t\t");
        CharSequence _malloc_3 = this.malloc.malloc(v_3);
        _builder.append(_malloc_3, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    Object _code_4 = this.code(b.getScanReductionBody().getScanLoop());
    _builder.append(_code_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<CodeGenVariable> _matrixTempVariables_1 = b.getScanReductionBody().getMatrixTempVariables();
      for(final CodeGenVariable v_4 : _matrixTempVariables_1) {
        _builder.append("\t\t");
        CharSequence _mfree = this.malloc.mfree(v_4);
        _builder.append(_mfree, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#pragma omp barrier");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//get the new index value");
    _builder.newLine();
    _builder.append("\t");
    String _beginVariableName_3 = b.getBeginVariableName();
    _builder.append(_beginVariableName_3, "\t");
    _builder.append(" = index[");
    String _threadNumVariableName_8 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_8, "\t");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _endVariableName_2 = b.getEndVariableName();
    _builder.append(_endVariableName_2, "\t");
    _builder.append(" = index[");
    String _threadNumVariableName_9 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_9, "\t");
    _builder.append("+1];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (");
    String _threadNumVariableName_10 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_10, "\t");
    _builder.append("== ");
    String _nthreadVariableName_5 = b.getNthreadVariableName();
    _builder.append(_nthreadVariableName_5, "\t");
    _builder.append(" - 1) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _endVariableName_3 = b.getEndVariableName();
    _builder.append(_endVariableName_3, "\t\t");
    _builder.append(" = ");
    String _name_12 = b.getBoundComputationFunction().getUb().getName();
    _builder.append(_name_12, "\t\t");
    _builder.append(" + 1;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (");
    String _threadNumVariableName_11 = b.getThreadNumVariableName();
    _builder.append(_threadNumVariableName_11, "\t");
    _builder.append("==0) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    Object _code_5 = this.code(b.getScanReductionBody().getAssignmentLoop());
    _builder.append(_code_5, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    Object _code_6 = this.code(b.getScanReductionBody().getPostProcessLoop());
    _builder.append(_code_6, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//CALL THE SCAN FUNCTION");
    _builder.newLine();
    _builder.append("\t");
    String _name_13 = b.getLocalScanFunction().getName();
    _builder.append(_name_13, "\t");
    _builder.append("(");
    String _functionParameters_4 = this.functionParameters(b.getLocalScanFunction());
    _builder.append(_functionParameters_4, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<CodeGenVariable> _localReductionVariables_1 = b.getLocalReductionVariables();
      for(final CodeGenVariable v_5 : _localReductionVariables_1) {
        _builder.append("\t");
        CharSequence _mfree_1 = this.malloc.mfree(v_5);
        _builder.append(_mfree_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//free the variables");
    _builder.newLine();
    {
      EList<CodeGenVariable> _localScanReductionVariables_1 = b.getLocalScanReductionVariables();
      for(final CodeGenVariable v_6 : _localScanReductionVariables_1) {
        CharSequence _mfree_2 = this.malloc.mfree(v_6);
        _builder.append(_mfree_2);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence code(final Body b) {
    if (b instanceof TiledCLoop) {
      return _code((TiledCLoop)b);
    } else if (b instanceof CustomPackStruct) {
      return _code((CustomPackStruct)b);
    } else if (b instanceof PackStruct) {
      return _code((PackStruct)b);
    } else if (b instanceof UnpackStruct) {
      return _code((UnpackStruct)b);
    } else if (b instanceof BasicBody) {
      return _code((BasicBody)b);
    } else if (b instanceof ParameterCheck) {
      return _code((ParameterCheck)b);
    } else if (b instanceof BoundComputation) {
      return _code((BoundComputation)b);
    } else if (b instanceof OriginDomainVolume) {
      return _code((OriginDomainVolume)b);
    } else if (b instanceof ScanBody) {
      return _code((ScanBody)b);
    } else if (b instanceof VolumeFunction) {
      return _code((VolumeFunction)b);
    } else if (b instanceof VolumeFunctionDerivative) {
      return _code((VolumeFunctionDerivative)b);
    } else if (b instanceof FlagVariableReset) {
      return _code((FlagVariableReset)b);
    } else if (b instanceof Loop) {
      return _code((Loop)b);
    } else if (b instanceof VariableFinalization) {
      return _code((VariableFinalization)b);
    } else if (b instanceof VariableInitialization) {
      return _code((VariableInitialization)b);
    } else if (b != null) {
      return _code(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
