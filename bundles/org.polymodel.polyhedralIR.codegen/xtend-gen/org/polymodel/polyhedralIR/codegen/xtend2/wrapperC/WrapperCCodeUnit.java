package org.polymodel.polyhedralIR.codegen.xtend2.wrapperC;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseCodeUnit;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseIndices;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAccess;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenConstants;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;

@SuppressWarnings("all")
public class WrapperCCodeUnit extends BaseCodeUnit {
  @Inject
  @Extension
  private BaseIndices indices;
  
  @Inject
  @Extension
  private BaseMemoryAccess access;
  
  @Override
  public CharSequence commonIncludes(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonIncludes = super.commonIncludes(unit);
    _builder.append(_commonIncludes);
    _builder.newLineIfNotEmpty();
    _builder.append("#include <time.h>");
    _builder.newLine();
    _builder.append("#include <sys/time.h>");
    _builder.newLine();
    _builder.append("#include <sys/errno.h>");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroDefs = super.commonMacroDefs(unit);
    _builder.append(_commonMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    _builder.append(CodeGenConstants.EPSILON_NAME);
    _builder.append(" ");
    _builder.append(CodeGenConstants.EPSILON_DEFAULT);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public CharSequence commonMacroUndefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _commonMacroUndefs = super.commonMacroUndefs(unit);
    _builder.append(_commonMacroUndefs);
    _builder.newLineIfNotEmpty();
    _builder.append("#undef ");
    _builder.append(CodeGenConstants.EPSILON_NAME);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public CharSequence commonFuncDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  @Override
  public CharSequence memoryMacroDefs(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _memoryMacroDefs = super.memoryMacroDefs(unit);
    _builder.append(_memoryMacroDefs);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Function> _functions = unit.getFunctions();
      for(final Function f : _functions) {
        {
          EList<AbstractVariable> _outputs = f.getOutputs();
          for(final AbstractVariable v : _outputs) {
            String _name = v.getName();
            final String verifyName = (_name + CodeGenConstantsForC.VERIFY_POSTFIX);
            _builder.newLineIfNotEmpty();
            _builder.append("#define ");
            _builder.append(verifyName);
            _builder.append("(");
            CharSequence _macroIndices = this.indices.getMacroIndices(v);
            _builder.append(_macroIndices);
            _builder.append(") ");
            _builder.append(verifyName);
            CharSequence _arrayIndexing = this.access.arrayIndexing(v);
            _builder.append(_arrayIndexing);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<VariableDeclaration> _outputs_1 = unit.getSystem().getOutputs();
      for(final VariableDeclaration varDecl : _outputs_1) {
        final MemorySpace memSpace = unit.getSystem().getTargetMapping().getMemoryMaps().get(varDecl).getSpace();
        _builder.newLineIfNotEmpty();
        final CodeGenVariable codeGenVar = unit.findCGVariable(memSpace.getName());
        _builder.newLineIfNotEmpty();
        final CharSequence microIndices = this.indices.getMacroIndices(codeGenVar);
        _builder.newLineIfNotEmpty();
        final CharSequence access = this.getMemSpaceAccess(codeGenVar);
        _builder.newLineIfNotEmpty();
        _builder.append("#define var_");
        String _name_1 = varDecl.getName();
        _builder.append(_name_1);
        _builder.append("(");
        _builder.append(microIndices);
        _builder.append(") ");
        String _name_2 = memSpace.getName();
        _builder.append(_name_2);
        _builder.append(access);
        _builder.newLineIfNotEmpty();
        _builder.append("#define var_");
        String _name_3 = varDecl.getName();
        _builder.append(_name_3);
        _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX);
        _builder.append("(");
        _builder.append(microIndices);
        _builder.append(") ");
        String _name_4 = memSpace.getName();
        _builder.append(_name_4);
        _builder.append(CodeGenConstantsForC.VERIFY_POSTFIX);
        _builder.append(access);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence getMemSpaceAccess(final CodeGenVariable v) {
    CharSequence _xifexpression = null;
    int _nIndices = v.getDomain().getNIndices();
    boolean _equals = (_nIndices == 0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      CharSequence _macroIndices = this.indices.getMacroIndices(v);
      _builder_1.append(_macroIndices);
      _builder_1.append(")");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  protected CharSequence iterToMemSpace(final AffineFunction f) {
    CharSequence _xifexpression = null;
    int _dimRHS = f.getDimRHS();
    boolean _equals = (_dimRHS == 0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
        return Utility.toCString(e);
      };
      String _join = IterableExtensions.<AffineExpression>join(f.getExpressions(), ",", _function);
      _builder_1.append(_join);
      _builder_1.append(")");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  @Override
  public CharSequence memoryMacroUndefs(final CodeUnit unit) {
    return super.memoryMacroUndefs(unit);
  }
  
  @Override
  public CharSequence externalFunctionInclude(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  @Override
  public String filename(final CodeUnit unit) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = unit.getSystem().getName();
    _builder.append(_name);
    _builder.append("-wrapper.c");
    return _builder.toString();
  }
}
