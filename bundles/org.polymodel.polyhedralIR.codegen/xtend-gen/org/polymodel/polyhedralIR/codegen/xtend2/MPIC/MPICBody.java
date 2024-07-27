package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;

@SuppressWarnings("all")
public class MPICBody extends BaseBody {
  @Inject
  @Extension
  private BaseStatement stmtExtensions;

  @Inject
  @Extension
  private BaseDomain domainExtensions;

  protected CharSequence _code(final MPICLoop body) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<Statement, CharSequence> _function = (Statement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int ");
    _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t");
    _builder.append(", ");
    _builder.append(CodeGenConstantsForDistributed.recvBuffer, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("MPI_Request ");
    _builder.append(CodeGenConstantsForDistributed.requests, "\t");
    _builder.append("[2];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(CodeGenConstantsForDistributed.requests, "\t");
    _builder.append("[0] = NULL;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(CodeGenConstantsForDistributed.requests, "\t");
    _builder.append("[1] = NULL;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t");
    _builder.append(" = 0;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(CodeGenConstantsForDistributed.recvBuffer, "\t");
    _builder.append(" = 1;");
    _builder.newLineIfNotEmpty();
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
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateLoopNest = this.generateLoopNest(body);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final Function1<Statement, CharSequence> _function_1 = (Statement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_1 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateLoopNest(final MPICLoop l) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field scop is undefined for the type DTiledLoop"
      + "\ngenerate cannot be resolved");
  }

  public CharSequence generate(final DTiledLoop tiled) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field scop is undefined for the type DTiledLoop"
      + "\ngenerate cannot be resolved");
  }

  /**
   * Branch code generation to customized code gen once its in the tiled block.
   * ScopBlock and ScopGuard that separates tilable blocks are generated like the normal generation.
   * Although the rule is re-defined here.
   */
  public Object branchGenerator(final /* AbstractScopNode */Object node, final DTiledLoop tiled) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field blockStart is undefined for the type DTiledBlock"
      + "\n== cannot be resolved"
      + "\ncustomGenerate cannot be resolved"
      + "\ngenerate cannot be resolved");
  }

  public Object generate(final /* AbstractScopNode */Object node, final CharSequence recvStartBody, final CharSequence recvEndBody, final CharSequence sendBody) {
    throw new Error("Unresolved compilation problems:"
      + "\nMacroBodyProvider cannot be resolved to a type."
      + "\nFixedStringMacro cannot be resolved."
      + "\nFixedStringMacro cannot be resolved."
      + "\nFixedStringMacro cannot be resolved."
      + "\nCGenerator cannot be resolved to a type."
      + "\ngenerate cannot be resolved");
  }

  public CharSequence generate(final /* ScopRoot */Object sr, final DTiledLoop tiled) {
    throw new Error("Unresolved compilation problems:"
      + "\nstatements cannot be resolved"
      + "\nbranchGenerator cannot be resolved");
  }

  protected CharSequence _generate(final /* ScopGuard */Object s, final DTiledLoop tiled) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field simplify is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nconstraintSystems cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nconstraintSystems cannot be resolved"
      + "\njoin cannot be resolved"
      + "\ntoCString cannot be resolved"
      + "\nthenBody cannot be resolved"
      + "\nbranchGenerator cannot be resolved"
      + "\nelseBody cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nelseBody cannot be resolved"
      + "\nbranchGenerator cannot be resolved"
      + "\nthenBody cannot be resolved"
      + "\nbranchGenerator cannot be resolved");
  }

  protected CharSequence _generate(final /* ScopBlock */Object sg, final DTiledLoop tiled) {
    throw new Error("Unresolved compilation problems:"
      + "\nstatements cannot be resolved"
      + "\nbranchGenerator cannot be resolved");
  }

  public CharSequence customGenerate(final /* AbstractScopNode */Object n, final DTiledBlock tb) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field tileLoopStart is undefined for the type DTiledBlock"
      + "\ngenerate cannot be resolved");
  }

  public CharSequence receiveStart(final DTiledBlock tb) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field dtilingOptions is undefined for the type DTiledLoop"
      + "\nThe method or field computeBufferSize is undefined for the type Buffer"
      + "\ngetTileIndex cannot be resolved"
      + "\ntoCString cannot be resolved");
  }

  public CharSequence receiveEnd(final DTiledBlock tb) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field dtilingOptions is undefined for the type DTiledLoop"
      + "\ngetTileIndex cannot be resolved");
  }

  public CharSequence sendBody(final DTiledBlock tb) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field dtilingOptions is undefined for the type DTiledLoop"
      + "\nThe method or field computeBufferSize is undefined for the type Buffer"
      + "\ngetTileIndex cannot be resolved"
      + "\ngetTileSize cannot be resolved"
      + "\ntoCString cannot be resolved");
  }

  public CharSequence code(final Body body) {
    if (body instanceof MPICLoop) {
      return _code((MPICLoop)body);
    } else if (body instanceof TiledCLoop) {
      return _code((TiledCLoop)body);
    } else if (body instanceof CustomPackStruct) {
      return _code((CustomPackStruct)body);
    } else if (body instanceof PackStruct) {
      return _code((PackStruct)body);
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

  public CharSequence generate(final ScopGuard s, final DTiledLoop tiled) {
    return _generate(s, tiled);
  }
}
