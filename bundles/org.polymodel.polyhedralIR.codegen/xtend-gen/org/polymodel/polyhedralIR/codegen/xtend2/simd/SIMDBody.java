package org.polymodel.polyhedralIR.codegen.xtend2.simd;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;

@SuppressWarnings("all")
public class SIMDBody extends BaseBody {
  @Inject
  @Extension
  private BaseStatement stmtExtensions;

  @Inject
  @Extension
  private BaseMemoryAllocation mallocs;

  protected CharSequence _code(final VRegisterInitialization body) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _malloc = this.malloc(body);
    _builder.append(_malloc);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence malloc(final VRegisterInitialization b) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Memory Declaration for SIMD registers");
    _builder.newLine();
    final Function1<VRegister, CharSequence> _function = (VRegister e) -> {
      return this.mallocs.malloc(e);
    };
    String _join = IterableExtensions.<VRegister>join(b.getLocals(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _code(final SIMDLoop body) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<Statement, CharSequence> _function = (Statement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    final Function1<SIMDStatement, CharSequence> _function_1 = (SIMDStatement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join_1 = IterableExtensions.<SIMDStatement>join(body.getSimdStatements(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Domain");
    _builder.newLine();
    {
      EList<Statement> _statements = body.getStatements();
      for(final Statement stmt : _statements) {
        _builder.append("\t");
        _builder.append("//");
        Domain _domain = stmt.getDomain();
        _builder.append(_domain, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _generateLoopNest = this.generateLoopNest(body);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final Function1<Statement, CharSequence> _function_2 = (Statement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_2 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_2);
    _builder.append(_join_2);
    _builder.newLineIfNotEmpty();
    final Function1<SIMDStatement, CharSequence> _function_3 = (SIMDStatement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_3 = IterableExtensions.<SIMDStatement>join(body.getSimdStatements(), "\n", _function_3);
    _builder.append(_join_3);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _code(final TiledSIMDCLoop body) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((!Objects.equal(body.getOptimizedPointLoop(), null)) && (body.getOptimizedPointLoop().getStatements().size() > 0))) {
        final Function1<Statement, CharSequence> _function = (Statement s) -> {
          return this.stmtExtensions.statementDefine(s);
        };
        String _join = IterableExtensions.<Statement>join(body.getOptimizedPointLoop().getStatements(), "\n", _function);
        _builder.append(_join);
        _builder.newLineIfNotEmpty();
      }
    }
    final Function1<Statement, CharSequence> _function_1 = (Statement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join_1 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    final Function1<SIMDStatement, CharSequence> _function_2 = (SIMDStatement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join_2 = IterableExtensions.<SIMDStatement>join(body.getSimdStatements(), "\n", _function_2);
    _builder.append(_join_2);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Domain");
    _builder.newLine();
    {
      EList<Statement> _statements = body.getStatements();
      for(final Statement stmt : _statements) {
        _builder.append("\t");
        _builder.append("//");
        Domain _domain = stmt.getDomain();
        _builder.append(_domain, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _generateLoopNest = this.generateLoopNest(body);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final Function1<Statement, CharSequence> _function_3 = (Statement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_3 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_3);
    _builder.append(_join_3);
    _builder.newLineIfNotEmpty();
    final Function1<SIMDStatement, CharSequence> _function_4 = (SIMDStatement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_4 = IterableExtensions.<SIMDStatement>join(body.getSimdStatements(), "\n", _function_4);
    _builder.append(_join_4);
    _builder.newLineIfNotEmpty();
    {
      if (((!Objects.equal(body.getOptimizedPointLoop(), null)) && (body.getOptimizedPointLoop().getStatements().size() > 0))) {
        final Function1<Statement, CharSequence> _function_5 = (Statement s) -> {
          return this.stmtExtensions.statementUndefine(s);
        };
        String _join_5 = IterableExtensions.<Statement>join(body.getOptimizedPointLoop().getStatements(), "\n", _function_5);
        _builder.append(_join_5);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence code(final Body body) {
    if (body instanceof TiledSIMDCLoop) {
      return _code((TiledSIMDCLoop)body);
    } else if (body instanceof TiledCLoop) {
      return _code((TiledCLoop)body);
    } else if (body instanceof CustomPackStruct) {
      return _code((CustomPackStruct)body);
    } else if (body instanceof PackStruct) {
      return _code((PackStruct)body);
    } else if (body instanceof SIMDLoop) {
      return _code((SIMDLoop)body);
    } else if (body instanceof UnpackStruct) {
      return _code((UnpackStruct)body);
    } else if (body instanceof BasicBody) {
      return _code((BasicBody)body);
    } else if (body instanceof ParameterCheck) {
      return _code((ParameterCheck)body);
    } else if (body instanceof FlagVariableReset) {
      return _code((FlagVariableReset)body);
    } else if (body instanceof Loop) {
      return _code((Loop)body);
    } else if (body instanceof VRegisterInitialization) {
      return _code((VRegisterInitialization)body);
    } else if (body instanceof VariableFinalization) {
      return _code((VariableFinalization)body);
    } else if (body instanceof VariableInitialization) {
      return _code((VariableInitialization)body);
    } else if (body != null) {
      return _code(body);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(body).toString());
    }
  }
}
