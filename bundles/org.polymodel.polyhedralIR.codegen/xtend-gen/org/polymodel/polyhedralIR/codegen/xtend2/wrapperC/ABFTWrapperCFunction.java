package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
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
import org.polymodel.polyhedralIR.polyIRCG.Function;
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
  public CharSequence code(final Function func) {
    final String dType = ABFTWrapperCFunction.options.dataType;
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((ABFTWrapperCFunction.options.numDims == 1)) {
        _builder.append("void init(long, long, long, long, ");
        _builder.append(dType);
        _builder.append("*, ");
        _builder.append(dType);
        _builder.append("*, ");
        _builder.append(dType);
        _builder.append("*);");
        _builder.newLineIfNotEmpty();
        _builder.append("void conv(long, long, ");
        _builder.append(dType);
        _builder.append("*, ");
        _builder.append(dType);
        _builder.append("*, ");
        _builder.append(dType);
        _builder.append("*);");
        _builder.newLineIfNotEmpty();
      } else {
        if ((ABFTWrapperCFunction.options.numDims == 2)) {
          _builder.append("void init(long, long, long, long, long, long, long, ");
          _builder.append(dType);
          _builder.append("**, ");
          _builder.append(dType);
          _builder.append("**, ");
          _builder.append(dType);
          _builder.append("**);");
          _builder.newLineIfNotEmpty();
          _builder.append("void conv(long, long, long, long, ");
          _builder.append(dType);
          _builder.append("**, ");
          _builder.append(dType);
          _builder.append("**, ");
          _builder.append(dType);
          _builder.append("**);");
          _builder.newLineIfNotEmpty();
        } else {
          if ((ABFTWrapperCFunction.options.numDims == 3)) {
            _builder.append("void init(long, long, long, long, long, long, long, long, long, long, ");
            _builder.append(dType);
            _builder.append("***, ");
            _builder.append(dType);
            _builder.append("***, ");
            _builder.append(dType);
            _builder.append("***);");
            _builder.newLineIfNotEmpty();
            _builder.append("void conv(long, long, long, long,  long, long, ");
            _builder.append(dType);
            _builder.append("***, ");
            _builder.append(dType);
            _builder.append("***, ");
            _builder.append(dType);
            _builder.append("***);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    CharSequence _code = super.code(func);
    _builder.append(_code);
    _builder.newLineIfNotEmpty();
    final String ret = _builder.toString();
    return ret;
  }
  
  public Map<String, Double> parseKernel(final String[] kernel) {
    HashMap<String, Double> _xblockexpression = null;
    {
      int _size = ((List<String>)Conversions.doWrapArray((kernel[0]).split(","))).size();
      final int numDims = (_size - 2);
      final HashMap<String, Double> ret = new HashMap<String, Double>();
      for (final String point : kernel) {
        {
          final Function1<Integer, String> _function = (Integer it) -> {
            return point.split(",")[(it).intValue()];
          };
          final String key = IterableExtensions.join(IterableExtensions.<Integer, String>map(new ExclusiveRange(1, (1 + numDims), true), _function), ",");
          final double value = Double.parseDouble(point.split(",")[(1 + numDims)]);
          ret.put(key, Double.valueOf(value));
        }
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public List<Long> computeRadius(final Map<String, Double> kernel) {
    List<Long> _xblockexpression = null;
    {
      final int numDims = ((List<String>)Conversions.doWrapArray((((String[])Conversions.unwrapArray(kernel.keySet(), String.class))[0]).split(","))).size();
      final Function1<Integer, ArrayList<Long>> _function = (Integer it) -> {
        return new ArrayList<Long>();
      };
      final List<ArrayList<Long>> radius = IterableExtensions.<ArrayList<Long>>toList(IterableExtensions.<Integer, ArrayList<Long>>map(new ExclusiveRange(0, numDims, true), _function));
      Set<String> _keySet = kernel.keySet();
      for (final String key : _keySet) {
        {
          final Function1<String, Long> _function_1 = (String it) -> {
            return Long.valueOf(Long.parseLong(it));
          };
          final List<Long> pieces = IterableExtensions.<Long>toList(ListExtensions.<String, Long>map(((List<String>)Conversions.doWrapArray(key.split(","))), _function_1));
          int _size = pieces.size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for (final Integer i : _doubleDotLessThan) {
            radius.get((i).intValue()).add(pieces.get((i).intValue()));
          }
        }
      }
      final Function1<ArrayList<Long>, Long> _function_1 = (ArrayList<Long> it) -> {
        final Function2<Long, Long, Long> _function_2 = (Long v0, Long v1) -> {
          return Long.valueOf(Math.max((v0).longValue(), (v1).longValue()));
        };
        return IterableExtensions.<Long>reduce(it, _function_2);
      };
      final List<Long> ret = IterableExtensions.<Long>toList(ListExtensions.<ArrayList<Long>, Long>map(radius, _function_1));
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public Map<String, Double> shiftKernel(final Map<String, Double> kernel, final List<Long> radius) {
    HashMap<String, Double> _xblockexpression = null;
    {
      final HashMap<String, Double> ret = new HashMap<String, Double>();
      final int numDims = ((List<String>)Conversions.doWrapArray((((String[])Conversions.unwrapArray(kernel.keySet(), String.class))[0]).split(","))).size();
      Set<String> _keySet = kernel.keySet();
      for (final String key : _keySet) {
        {
          final Function1<Integer, Long> _function = (Integer it) -> {
            long _parseLong = Long.parseLong(key.split(",")[(it).intValue()]);
            Long _get = radius.get((it).intValue());
            return Long.valueOf((_parseLong + (_get).longValue()));
          };
          final String shiftedKey = IterableExtensions.join(IterableExtensions.<Integer, Long>map(new ExclusiveRange(0, numDims, true), _function), ",");
          ret.put(shiftedKey, kernel.get(key));
        }
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public CharSequence inputInitialization_OLD(final InputInitialization b) {
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
      final String varAccess = IterableExtensions.<AffineExpression>join(b.getSpecialVar().getMemoryAccessExpressions(), "][", _function_2);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _equals = varName.equals(ABFTWrapperCFunction.options.weightsVar);
        if (_equals) {
          _builder.append("{");
          _builder.newLine();
          {
            if ((ABFTWrapperCFunction.options.numDims == 1)) {
              _builder.append("\t");
              String _weightVarComputation1d = this.weightVarComputation1d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess);
              _builder.append(_weightVarComputation1d, "\t");
              _builder.newLineIfNotEmpty();
            } else {
              if ((ABFTWrapperCFunction.options.numDims == 2)) {
                _builder.append("\t");
                String _weightVarComputation2d = this.weightVarComputation2d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess);
                _builder.append(_weightVarComputation2d, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                if ((ABFTWrapperCFunction.options.numDims == 3)) {
                  _builder.append("\t");
                  String _weightVarComputation3d = this.weightVarComputation3d(b, accessIndex, macroIndex, macroIndexB, macroName, varName, varAccess);
                  _builder.append(_weightVarComputation3d, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
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
          _builder.append(varAccess, "\t");
          _builder.append("])");
          _builder.newLineIfNotEmpty();
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
      {
        boolean _equals_2 = varName.equals(ABFTWrapperCFunction.options.weightsVar);
        if (_equals_2) {
          _builder.append("\t");
          _builder.append("#undef swap");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("#undef kernel");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          {
            if ((ABFTWrapperCFunction.options.numDims == 1)) {
              _builder.append("\t");
              CharSequence _free1d = this.free1d();
              _builder.append(_free1d, "\t");
              _builder.newLineIfNotEmpty();
            } else {
              if ((ABFTWrapperCFunction.options.numDims == 2)) {
                _builder.append("\t");
                CharSequence _free2d = this.free2d();
                _builder.append(_free2d, "\t");
                _builder.newLineIfNotEmpty();
              } else {
                if ((ABFTWrapperCFunction.options.numDims == 3)) {
                  _builder.append("\t");
                  CharSequence _free3d = this.free3d();
                  _builder.append(_free3d, "\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String weightVarComputation3d(final InputInitialization b, final String accessIndex, final CharSequence macroIndex, final String macroIndexB, final String macroName, final String varName, final String varAccess) {
    final String dType = ABFTWrapperCFunction.options.dataType;
    final String[] kernel = ABFTWrapperCFunction.options.kernel.split(";");
    final Map<String, Double> kernelMap = this.parseKernel(kernel);
    final List<Long> radius = this.computeRadius(kernelMap);
    final Map<String, Double> shiftedKernelMap = this.shiftKernel(kernelMap, radius);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("long _P0 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N0 = ");
    String _get = ABFTWrapperCFunction.options.cJx.split(",")[0];
    _builder.append(_get);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K0 = ");
    Long _get_1 = radius.get(0);
    _builder.append(_get_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK0 = _P0*_K0;");
    _builder.newLine();
    _builder.append("long _P1 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N1 = ");
    String _get_2 = ABFTWrapperCFunction.options.cJx.split(",")[1];
    _builder.append(_get_2);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K1 = ");
    Long _get_3 = radius.get(1);
    _builder.append(_get_3);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK1 = _P1*_K1;");
    _builder.newLine();
    _builder.append("long _P2 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N2 = ");
    String _get_4 = ABFTWrapperCFunction.options.cJx.split(",")[2];
    _builder.append(_get_4);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K2 = ");
    Long _get_5 = radius.get(2);
    _builder.append(_get_5);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK2 = _P2*_K2;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int padded_kernel_L0 = (2*(_PK0)+1);");
    _builder.newLine();
    _builder.append("int padded_kernel_L1 = (2*(_PK1)+1);");
    _builder.newLine();
    _builder.append("int padded_kernel_L2 = (2*(_PK2)+1);");
    _builder.newLine();
    _builder.append("int patch_L0 = _N0+2*_PK0;");
    _builder.newLine();
    _builder.append("int patch_L1 = _N1+2*_PK1;");
    _builder.newLine();
    _builder.append("int patch_L2 = _N2+2*_PK2;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_K0+1) * (2*_K1+1) * (2*_K2+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_kernel, ((2*_K0+1) * (2*_K1+1) * (2*_K2+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("*** kernel = (");
    _builder.append(dType);
    _builder.append("***)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("**)*(2*_K0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(kernel, (2*_K0+1), ");
    _builder.append(dType);
    _builder.append("**);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_K0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("kernel[mz1] = (");
    _builder.append(dType, "\t");
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType, "\t");
    _builder.append("*)*(2*_K1+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mallocCheck(kernel[mz1], (2*_K1+1), ");
    _builder.append(dType, "\t");
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (mz2=0;mz2 < 2*_K1+1; mz2++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("kernel[mz1][mz2] = &_lin_kernel[(mz1*((2*_K1+1) * (2*_K2+1))) + (mz2*(2*_K2+1))];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_padded_kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_padded_kernel, ((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("*** padded_kernel = (");
    _builder.append(dType);
    _builder.append("***)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("**)*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append("**);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("padded_kernel[mz1] = (");
    _builder.append(dType, "\t");
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType, "\t");
    _builder.append("*)*(2*_PK1+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mallocCheck(padded_kernel[mz1], (2*_PK1+1), ");
    _builder.append(dType, "\t");
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (mz2=0;mz2 < 2*_PK1+1; mz2++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("padded_kernel[mz1][mz2] = &_lin_padded_kernel[(mz1*((2*_PK1+1) * (2*_PK2+1))) + (mz2*(2*_PK2+1))];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_padded_kernel_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_padded_kernel_cp, ((2*_PK0+1) * (2*_PK1+1) * (2*_PK2+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("*** padded_kernel_cp = (");
    _builder.append(dType);
    _builder.append("***)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("**)*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel_cp, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append("**);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("padded_kernel_cp[mz1] = (");
    _builder.append(dType, "\t");
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType, "\t");
    _builder.append("*)*(2*_PK1+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mallocCheck(padded_kernel_cp[mz1], (2*_PK1+1), ");
    _builder.append(dType, "\t");
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (mz2=0;mz2 < 2*_PK1+1; mz2++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("padded_kernel_cp[mz1][mz2] = &_lin_padded_kernel_cp[(mz1*((2*_PK1+1) * (2*_PK2+1))) + (mz2*(2*_PK2+1))];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_patch = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_patch, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("*** patch = (");
    _builder.append(dType);
    _builder.append("***)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("**)*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append("**);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("patch[mz1] = (");
    _builder.append(dType, "\t");
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType, "\t");
    _builder.append("*)*(_N1+2*_PK1+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mallocCheck(patch[mz1], (_N1+2*_PK1+0), ");
    _builder.append(dType, "\t");
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (mz2=0;mz2 < _N1+2*_PK1+0; mz2++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("patch[mz1][mz2] = &_lin_patch[(mz1*((_N1+2*_PK1+0) * (_N2+2*_PK2+0))) + (mz2*(_N2+2*_PK2+0))];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_patch_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_patch_cp, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0) * (_N2+2*_PK2+0)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("*** patch_cp = (");
    _builder.append(dType);
    _builder.append("***)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("**)*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch_cp, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append("**);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("patch_cp[mz1] = (");
    _builder.append(dType, "\t");
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType, "\t");
    _builder.append("*)*(_N1+2*_PK1+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("mallocCheck(patch_cp[mz1], (_N1+2*_PK1+0), ");
    _builder.append(dType, "\t");
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (mz2=0;mz2 < _N1+2*_PK1+0; mz2++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("patch_cp[mz1][mz2] = &_lin_patch_cp[(mz1*((_N1+2*_PK1+0) * (_N2+2*_PK2+0))) + (mz2*(_N2+2*_PK2+0))];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("*** _tmp;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)");
    _builder.newLine();
    _builder.append("#define kernel(");
    _builder.append(accessIndex);
    _builder.append(") kernel[");
    _builder.append(varAccess);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Set<String> _keySet = shiftedKernelMap.keySet();
      for(final String key : _keySet) {
        _builder.append("kernel(");
        _builder.append(key);
        _builder.append(") = ");
        Double _get_6 = shiftedKernelMap.get(key);
        _builder.append(_get_6);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// initialize the buffers with appropriate padding");
    _builder.newLine();
    _builder.append("init(_P0, _N0, _N1, _N2, _K0, _K1, _K2, _PK0, _PK1, _PK2, kernel, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// precompute the self-convolution of the kernel _P0=");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(" times");
    _builder.newLineIfNotEmpty();
    _builder.append("for (int p=1; p<_P0; p++) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("conv(_K0, _K1, _K2, padded_kernel_L0, padded_kernel_L1, padded_kernel_L2, kernel, padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("swap(padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("conv(_PK0, _PK1, _PK2, patch_L0, patch_L1, patch_L2, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    _builder.append("swap(");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final String ret = _builder.toString();
    return ret;
  }
  
  public String weightVarComputation2d(final InputInitialization b, final String accessIndex, final CharSequence macroIndex, final String macroIndexB, final String macroName, final String varName, final String varAccess) {
    final String dType = ABFTWrapperCFunction.options.dataType;
    final String[] kernel = ABFTWrapperCFunction.options.kernel.split(";");
    final Map<String, Double> kernelMap = this.parseKernel(kernel);
    final List<Long> radius = this.computeRadius(kernelMap);
    final Map<String, Double> shiftedKernelMap = this.shiftKernel(kernelMap, radius);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("long _P0 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N0 = ");
    String _get = ABFTWrapperCFunction.options.cJx.split(",")[0];
    _builder.append(_get);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K0 = ");
    Long _get_1 = radius.get(0);
    _builder.append(_get_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK0 = _P0*_K0;");
    _builder.newLine();
    _builder.append("long _P1 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N1 = ");
    String _get_2 = ABFTWrapperCFunction.options.cJx.split(",")[1];
    _builder.append(_get_2);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K1 = ");
    Long _get_3 = radius.get(1);
    _builder.append(_get_3);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK1 = _P1*_K1;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int padded_kernel_L0 = (2*(_PK0)+1);");
    _builder.newLine();
    _builder.append("int padded_kernel_L1 = (2*(_PK1)+1);");
    _builder.newLine();
    _builder.append("int patch_L0 = _N0+2*_PK0;");
    _builder.newLine();
    _builder.append("int patch_L1 = _N1+2*_PK1;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_K0+1) * (2*_K1+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_kernel, ((2*_K0+1) * (2*_K1+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("** kernel = (");
    _builder.append(dType);
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("*)*(2*_K0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(kernel, (2*_K0+1), ");
    _builder.append(dType);
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_K0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("kernel[mz1] = &_lin_kernel[(mz1*(2*_K1+1))];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_padded_kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_PK0+1) * (2*_PK1+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_padded_kernel, ((2*_PK0+1) * (2*_PK1+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("** padded_kernel = (");
    _builder.append(dType);
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("*)*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("padded_kernel[mz1] = &_lin_padded_kernel[(mz1*(2*_PK1+1))];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_padded_kernel_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((2*_PK0+1) * (2*_PK1+1)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_padded_kernel_cp, ((2*_PK0+1) * (2*_PK1+1)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("** padded_kernel_cp = (");
    _builder.append(dType);
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("*)*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel_cp, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("padded_kernel_cp[mz1] = &_lin_padded_kernel_cp[(mz1*(2*_PK1+1))];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_patch = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((_N0+2*_PK0+0) * (_N1+2*_PK1+0)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_patch, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("** patch = (");
    _builder.append(dType);
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("*)*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("patch[mz1] = &_lin_patch[(mz1*(_N1+2*_PK1+0))];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* _lin_patch_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*((_N0+2*_PK0+0) * (_N1+2*_PK1+0)));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(_lin_patch_cp, ((_N0+2*_PK0+0) * (_N1+2*_PK1+0)), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("** patch_cp = (");
    _builder.append(dType);
    _builder.append("**)malloc(sizeof(");
    _builder.append(dType);
    _builder.append("*)*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch_cp, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append("*);");
    _builder.newLineIfNotEmpty();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("patch_cp[mz1] = &_lin_patch_cp[(mz1*(_N1+2*_PK1+0))];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(dType);
    _builder.append("** _tmp;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)");
    _builder.newLine();
    _builder.append("#define kernel(");
    _builder.append(accessIndex);
    _builder.append(") kernel[");
    _builder.append(varAccess);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Set<String> _keySet = shiftedKernelMap.keySet();
      for(final String key : _keySet) {
        _builder.append("kernel(");
        _builder.append(key);
        _builder.append(") = ");
        Double _get_4 = shiftedKernelMap.get(key);
        _builder.append(_get_4);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// initialize the buffers with appropriate padding");
    _builder.newLine();
    _builder.append("init(_P0, _N0, _N1, _K0, _K1, _PK0, _PK1, kernel, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// precompute the self-convolution of the kernel _P0=");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(" times");
    _builder.newLineIfNotEmpty();
    _builder.append("for (int p=1; p<_P0; p++) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("conv(_K0, _K1, padded_kernel_L0, padded_kernel_L1, kernel, padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("swap(padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("conv(_PK0, _PK1, patch_L0, patch_L1, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    _builder.append("swap(");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final String ret = _builder.toString();
    return ret;
  }
  
  public String weightVarComputation1d(final InputInitialization b, final String accessIndex, final CharSequence macroIndex, final String macroIndexB, final String macroName, final String varName, final String varAccess) {
    final String dType = ABFTWrapperCFunction.options.dataType;
    final String[] kernel = ABFTWrapperCFunction.options.kernel.split(";");
    final Map<String, Double> kernelMap = this.parseKernel(kernel);
    final List<Long> radius = this.computeRadius(kernelMap);
    final Map<String, Double> shiftedKernelMap = this.shiftKernel(kernelMap, radius);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("long _P0 = ");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _N0 = ");
    String _get = ABFTWrapperCFunction.options.cJx.split(",")[0];
    _builder.append(_get);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _K0 = ");
    Long _get_1 = radius.get(0);
    _builder.append(_get_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("long _PK0 = _P0*_K0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int padded_kernel_L0 = 2*(_PK0)+1;");
    _builder.newLine();
    _builder.append("int patch_L0 = _N0+2*_PK0;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(dType);
    _builder.append("* kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*(2*_K0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(kernel, (2*_K0+1), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("* padded_kernel = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("* padded_kernel_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*(2*_PK0+1));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(padded_kernel_cp, (2*_PK0+1), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("* patch = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("* patch_cp = (");
    _builder.append(dType);
    _builder.append("*)malloc(sizeof(");
    _builder.append(dType);
    _builder.append(")*(_N0+2*_PK0+0));");
    _builder.newLineIfNotEmpty();
    _builder.append("mallocCheck(patch_cp, (_N0+2*_PK0+0), ");
    _builder.append(dType);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append(dType);
    _builder.append("* _tmp;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#define swap(_A,_B) do {_tmp=_A; _A=_B; _B=_tmp;} while(0)");
    _builder.newLine();
    _builder.append("#define kernel(");
    _builder.append(accessIndex);
    _builder.append(") kernel[");
    _builder.append(varAccess);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Set<String> _keySet = shiftedKernelMap.keySet();
      for(final String key : _keySet) {
        _builder.append("kernel(");
        _builder.append(key);
        _builder.append(") = ");
        Double _get_2 = shiftedKernelMap.get(key);
        _builder.append(_get_2);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("// initialize the buffers with appropriate padding");
    _builder.newLine();
    _builder.append("init(_P0, _N0, _K0, _PK0, kernel, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// precompute the self-convolution of the kernel _P0=");
    _builder.append(ABFTWrapperCFunction.options.cT);
    _builder.append(" times");
    _builder.newLineIfNotEmpty();
    _builder.append("for (int p=1; p<_P0; p++) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("conv(_K0, padded_kernel_L0, kernel, padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("swap(padded_kernel, padded_kernel_cp);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("conv(_PK0, patch_L0, padded_kernel, ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    _builder.append("swap(");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append(", ");
    _builder.append(ABFTWrapperCFunction.options.patchVar);
    _builder.append("_cp);");
    _builder.newLineIfNotEmpty();
    final String ret = _builder.toString();
    return ret;
  }
  
  public CharSequence free1d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Free");
    _builder.newLine();
    _builder.append("free(kernel);");
    _builder.newLine();
    _builder.append("free(padded_kernel);");
    _builder.newLine();
    _builder.append("free(patch);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence free2d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Free");
    _builder.newLine();
    _builder.append("free(_lin_kernel);");
    _builder.newLine();
    _builder.append("free(kernel);");
    _builder.newLine();
    _builder.append("free(_lin_padded_kernel);");
    _builder.newLine();
    _builder.append("free(padded_kernel);");
    _builder.newLine();
    _builder.append("free(_lin_patch);");
    _builder.newLine();
    _builder.append("free(patch);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence free3d() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Free");
    _builder.newLine();
    _builder.append("free(_lin_kernel);");
    _builder.newLine();
    _builder.append("for (mz1=0;mz1 < 2*_K0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("free(kernel[mz1]);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("free(kernel);");
    _builder.newLine();
    _builder.append("free(_lin_padded_kernel);");
    _builder.newLine();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("free(padded_kernel[mz1]);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("free(padded_kernel);");
    _builder.newLine();
    _builder.append("free(_lin_padded_kernel_cp);");
    _builder.newLine();
    _builder.append("for (mz1=0;mz1 < 2*_PK0+1; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("free(padded_kernel_cp[mz1]);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("free(padded_kernel_cp);");
    _builder.newLine();
    _builder.append("free(_lin_patch);");
    _builder.newLine();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("free(patch[mz1]);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("free(patch);");
    _builder.newLine();
    _builder.append("free(_lin_patch_cp);");
    _builder.newLine();
    _builder.append("for (mz1=0;mz1 < _N0+2*_PK0+0; mz1++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("free(patch_cp[mz1]);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("free(patch_cp);");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence printOutput(final OutputPrinting b) {
    CharSequence _xblockexpression = null;
    {
      final String varName = b.getSpecialVar().getVarDecl().getVarID().getName();
      boolean _startsWith = varName.startsWith("Inv_");
      boolean _not = (!_startsWith);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      }
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
      final CharSequence macroIndex = this.indices.getMacroIndices(b.getSpecialVar().getVarDecl().getDomain());
      final Function1<Variable, CharSequence> _function_1 = (Variable e) -> {
        String _string = e.toString();
        return ("(long) " + _string);
      };
      final String macroIndexB = IterableExtensions.<Variable>join(b.getSpecialVar().getVarDecl().getDomain().getIndices(), ",", _function_1);
      final String macroName = b.getStatements().get(0).getName();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("#ifdef ");
      _builder_1.append(CodeGenConstantsForC.NO_PROMT_FLAG, "\t");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t\t");
      _builder_1.append("#define ");
      _builder_1.append(macroName, "\t\t");
      _builder_1.append("(");
      _builder_1.append(macroIndex, "\t\t");
      _builder_1.append(") printf(\"");
      _builder_1.append(bCPrintfSpecifier, "\t\t");
      _builder_1.append("\\n\",var_");
      CharSequence _varAccess = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
      _builder_1.append(_varAccess, "\t\t");
      _builder_1.append(")");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("#else");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("#define ");
      _builder_1.append(macroName, "\t\t");
      _builder_1.append("(");
      _builder_1.append(macroIndex, "\t\t");
      _builder_1.append(") ");
      CharSequence _printIndex = this.printIndex(b.getSpecialVar().getVarDecl(), macroIndexB);
      _builder_1.append(_printIndex, "\t\t");
      _builder_1.append("printf(\"");
      _builder_1.append(bCPrintfSpecifier, "\t\t");
      _builder_1.append("\\n\",var_");
      CharSequence _varAccess_1 = this.varAccess(b.getSpecialVar().getVarDecl(), accessIndex, true);
      _builder_1.append(_varAccess_1, "\t\t");
      _builder_1.append(")");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("#endif");
      _builder_1.newLine();
      _builder_1.append("\t");
      CharSequence _generateLoopNest = this.body.generateLoopNest(b);
      _builder_1.append(_generateLoopNest, "\t");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("#undef ");
      _builder_1.append(macroName, "\t");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("}");
      _builder_1.newLine();
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }
}
