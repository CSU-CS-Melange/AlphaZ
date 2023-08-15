package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;

@SuppressWarnings("all")
public class ABFTScheduledCFunction extends BaseFunction {
  public static ABFTCodeGenOptions options;
  
  public boolean isMainSystemFunction(final Function func) {
    String _name = func.getCodeunit().getSystem().getName();
    String _name_1 = func.getName();
    return Objects.equal(_name, _name_1);
  }
  
  @Override
  public CharSequence code(final Function func) {
    CharSequence _xblockexpression = null;
    {
      final int x = 123;
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _functionSignature = this.functionSignature(func);
      _builder.append(_functionSignature);
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      {
        boolean _isMainSystemFunction = this.isMainSystemFunction(func);
        if (_isMainSystemFunction) {
          _builder.append("\t");
          _builder.append("// Error injection configuration");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("const char* ti = getenv(\"T_INJ\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("const char* ii = getenv(\"I_INJ\");");
          _builder.newLine();
          {
            if ((ABFTScheduledCFunction.options.numDims == 2)) {
              _builder.append("\t");
              _builder.append("const char* ji = getenv(\"J_INJ\");");
              _builder.newLine();
            } else {
              if ((ABFTScheduledCFunction.options.numDims == 3)) {
                _builder.append("\t");
                _builder.append("const char* ki = getenv(\"K_INJ\");");
                _builder.newLine();
              }
            }
          }
          _builder.append("\t");
          _builder.append("const char* bit = getenv(\"BIT\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("const char* seed = getenv(\"SEED\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if (ti==NULL) printf(\"T_INJ is not set\\n\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if (ii==NULL) printf(\"I_INJ is not set\\n\");");
          _builder.newLine();
          {
            if ((ABFTScheduledCFunction.options.numDims == 2)) {
              _builder.append("\t");
              _builder.append("if (ji==NULL) printf(\"J_INJ is not set\\n\");");
              _builder.newLine();
            } else {
              if ((ABFTScheduledCFunction.options.numDims == 3)) {
                _builder.append("\t");
                _builder.append("if (ki==NULL) printf(\"K_INJ is not set\\n\");");
                _builder.newLine();
              }
            }
          }
          _builder.append("\t");
          _builder.append("if (bit==NULL) printf(\"bit is not set\\n\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("T_INJ = atoi(ti);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("I_INJ = atoi(ii);");
          _builder.newLine();
          {
            if ((ABFTScheduledCFunction.options.numDims == 2)) {
              _builder.append("\t");
              _builder.append("J_INJ = atoi(ji);");
              _builder.newLine();
            } else {
              if ((ABFTScheduledCFunction.options.numDims == 3)) {
                _builder.append("\t");
                _builder.append("K_INJ = atoi(ki);");
                _builder.newLine();
              }
            }
          }
          _builder.append("\t");
          _builder.append("BIT = atoi(bit);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if (seed==NULL) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("SEED = 0;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("} else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("SEED = atoi(seed);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _functionBody = this.functionBody(func);
      _builder.append(_functionBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
