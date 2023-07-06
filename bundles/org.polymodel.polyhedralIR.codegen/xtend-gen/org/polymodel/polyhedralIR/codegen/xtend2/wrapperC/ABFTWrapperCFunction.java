package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class ABFTWrapperCFunction extends WrapperCFunction {
  public static ABFTCodeGenOptions options;
  
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
  
  @Override
  public CharSequence inputInitialization(final InputInitialization b) {
    CharSequence _xblockexpression = null;
    {
      final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
        return e.toString();
      };
      String accessIndex = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), ",", _function);
      CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
      final Function1<Variable, CharSequence> _function_1 = (Variable e) -> {
        String _string = e.toString();
        return ("(long) " + _string);
      };
      String macroIndexB = IterableExtensions.<Variable>join(b.getSpecialVar().getVarDecl().getDomain().getIndices(), ",", _function_1);
      String macroName = b.getStatements().get(0).getName();
      final String varName = b.getSpecialVar().getVarDecl().getVarID().getName();
      final Function1<AffineExpression, CharSequence> _function_2 = (AffineExpression e) -> {
        return e.toString();
      };
      final String patchVarAccess = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), "][", _function_2);
      final Function1<String, Integer> _function_3 = (String it) -> {
        return Integer.valueOf(Integer.parseInt(it));
      };
      final List<Integer> patchSize = ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(ABFTWrapperCFunction.options.patchSize.split(","))), _function_3);
      final String[] kernel = ABFTWrapperCFunction.options.kernel.split(";");
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _equals = varName.equals(ABFTWrapperCFunction.options.weightsVar);
        if (_equals) {
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("#define ");
          _builder.append(macroName, "\t");
          _builder.append("(");
          _builder.append(macroIndex, "\t");
          _builder.append(") (");
          CharSequence _varAccess = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, false);
          _builder.append(_varAccess, "\t");
          _builder.append(" = ");
          _builder.append(ABFTWrapperCFunction.options.patchVar, "\t");
          _builder.append("[");
          _builder.append(patchVarAccess, "\t");
          _builder.append("])");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("FILE *kernel_file = fopen(\"kernel.in.txt\", \"w\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("fprintf(kernel_file, \"");
          _builder.append(ABFTWrapperCFunction.options.cT, "\t");
          _builder.append("\\n\");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("fprintf(kernel_file, \"");
          _builder.append(ABFTWrapperCFunction.options.cJx, "\t");
          _builder.append("\\n\");");
          _builder.newLineIfNotEmpty();
          {
            for(final String row : kernel) {
              _builder.append("\t");
              _builder.append("fprintf(kernel_file, \"");
              _builder.append(row, "\t");
              _builder.append("\\n\");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("fclose(kernel_file);");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(ABFTWrapperCFunction.options.dataType, "\t");
          _builder.append(" patch[");
          String _join = IterableExtensions.join(patchSize, "][");
          _builder.append(_join, "\t");
          _builder.append("];");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("int status = system(\"/Users/ln/git/virtual-islpy/bin/python /Users/ln/bin/patchlib.py\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("FILE *file = fopen(\"patch.block\", \"rb\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("fread(patch, sizeof(");
          _builder.append(ABFTWrapperCFunction.options.dataType, "\t");
          _builder.append("), ");
          final Function2<Integer, Integer, Integer> _function_4 = (Integer p0, Integer p1) -> {
            return Integer.valueOf(((p0).intValue() * (p1).intValue()));
          };
          Integer _reduce = IterableExtensions.<Integer>reduce(patchSize, _function_4);
          _builder.append(_reduce, "\t");
          _builder.append(", file);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("fclose(file);");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("remove(\"kernel.in.txt\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("remove(\"patch.block\");");
          _builder.newLine();
        } else {
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
          CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, false);
          _builder.append(_varAccess_1, "\t\t");
          _builder.append(" = rand()");
          {
            boolean _equals_1 = ABFTWrapperCFunction.options.dataType.equals("int");
            if (_equals_1) {
              _builder.append(" % 10");
            }
          }
          _builder.append(") ");
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
          CharSequence _varAccess_2 = this.varAccess(b.getSpecialVar().getVarDecl(), macroIndex, false);
          _builder.append(_varAccess_2, "\t\t");
          _builder.append(" = 1)   //Default value");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("#endif");
          _builder.newLine();
        }
      }
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
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence printOutput(final OutputPrinting b) {
    CharSequence _xblockexpression = null;
    {
      final Type varType = b.getSpecialVar().getVarDecl().getType();
      String _xifexpression = null;
      boolean _equals = varType.getTypeID().getName().equals("FLOATING_POINT");
      if (_equals) {
        _xifexpression = "%E";
      } else {
        _xifexpression = varType.getCPrintfSpecifier();
      }
      final String bCPrintfSpecifier = _xifexpression;
      final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
        return e.toString();
      };
      final String accessIndex = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), ",", _function);
      final Function1<AffineExpression, Boolean> _function_1 = (AffineExpression e) -> {
        boolean _equals_1 = e.toString().equals("t");
        return Boolean.valueOf((!_equals_1));
      };
      final Function1<AffineExpression, CharSequence> _function_2 = (AffineExpression e) -> {
        return e.toString();
      };
      String _join = IterableExtensions.<AffineExpression>join(IterableExtensions.<AffineExpression>filter(b.getSpecialVar().getMemoryAccessExpressions(), _function_1), ",", _function_2);
      final String accessIndexWithoutTime = ("0," + _join);
      final CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
      final CharSequence macroIndexWithoutTime = this.indices.getMacroIndicesExceptTime(b.getSpecialVar().getVarDecl().getDomain().getIndices());
      final Function1<Variable, CharSequence> _function_3 = (Variable e) -> {
        String _string = e.toString();
        return ("(long) " + _string);
      };
      final String macroIndexB = IterableExtensions.<Variable>join(b.getSpecialVar().getVarDecl().getDomain().getIndices(), ",", _function_3);
      final Function1<Variable, Boolean> _function_4 = (Variable e) -> {
        boolean _equals_1 = e.toString().equals("t");
        return Boolean.valueOf((!_equals_1));
      };
      final Function1<Variable, CharSequence> _function_5 = (Variable e) -> {
        String _string = e.toString();
        return ("(long) " + _string);
      };
      String _join_1 = IterableExtensions.<Variable>join(IterableExtensions.<Variable>filter(b.getSpecialVar().getVarDecl().getDomain().getIndices(), _function_4), ",", _function_5);
      final String macroIndexBWithoutTime = ("(long) 0," + _join_1);
      final String macroName = b.getStatements().get(0).getName();
      StringConcatenation _builder = new StringConcatenation();
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
      _builder.append(bCPrintfSpecifier, "\t\t");
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
      _builder.append(bCPrintfSpecifier, "\t\t");
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
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
