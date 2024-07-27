package org.polymodel.polyhedralIR.codegen.xtend2.scanC;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBounds(int) is undefined for the type Domain"
      + "\nThe method getBounds(int) is undefined for the type Domain"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved");
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
