package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
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
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.CGeneratorForMPIC;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.cgenerator2.CGenerator;
import org.polymodel.scop.cgenerator2.FixedStringMacro;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;
import org.polymodel.scop.dtiler.DTilingOptions;

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
    StringConcatenation _builder = new StringConcatenation();
    final DTiledLoop tiled = l.generateDTiledLoop();
    _builder.newLineIfNotEmpty();
    {
      if ((l.isDeclareIterators() && (l.getIteratorNames().size() > 0))) {
        _builder.append("int ");
        final Function1<String, CharSequence> _function = (String n) -> {
          return n;
        };
        String _join = IterableExtensions.<String>join(l.getIteratorNames(), ",", _function);
        _builder.append(_join);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _generate = this.generate(tiled.getScop(), tiled);
    _builder.append(_generate);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generate(final DTiledLoop tiled) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generate = this.generate(tiled.getScop(), tiled);
    _builder.append(_generate);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  /**
   * Branch code generation to customized code gen once its in the tiled block.
   * ScopBlock and ScopGuard that separates tilable blocks are generated like the normal generation.
   * Although the rule is re-defined here.
   */
  public CharSequence branchGenerator(final AbstractScopNode node, final DTiledLoop tiled) {
    CharSequence _xblockexpression = null;
    {
      final Function1<DTiledBlock, Boolean> _function = (DTiledBlock e) -> {
        AbstractScopNode _blockStart = e.getBlockStart();
        return Boolean.valueOf(Objects.equal(_blockStart, node));
      };
      final Iterable<DTiledBlock> block = IterableExtensions.<DTiledBlock>filter(tiled.getTiledBlocks(), _function);
      CharSequence _xifexpression = null;
      int _size = IterableExtensions.size(block);
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _xifexpression = this.customGenerate(node, IterableExtensions.<DTiledBlock>head(block));
      } else {
        _xifexpression = this.generate(node, tiled);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public String generate(final AbstractScopNode node, final CharSequence recvStartBody, final CharSequence recvEndBody, final CharSequence sendBody) {
    String _xblockexpression = null;
    {
      CGeneratorForMPIC module = new CGeneratorForMPIC();
      HashMap<String, MacroBodyProvider> stmtBody = new HashMap<String, MacroBodyProvider>();
      String _string = recvStartBody.toString();
      FixedStringMacro _fixedStringMacro = new FixedStringMacro(_string);
      stmtBody.put(CodeGenConstantsForDistributed.recvStartFunctionName, _fixedStringMacro);
      String _string_1 = recvEndBody.toString();
      FixedStringMacro _fixedStringMacro_1 = new FixedStringMacro(_string_1);
      stmtBody.put(CodeGenConstantsForDistributed.recvEndFunctionName, _fixedStringMacro_1);
      String _string_2 = sendBody.toString();
      FixedStringMacro _fixedStringMacro_2 = new FixedStringMacro(_string_2);
      stmtBody.put(CodeGenConstantsForDistributed.sendFunctionName, _fixedStringMacro_2);
      _xblockexpression = CGenerator.generate(module, node, stmtBody);
    }
    return _xblockexpression;
  }

  public CharSequence generate(final ScopRoot sr, final DTiledLoop tiled) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractScopNode> _statements = sr.getStatements();
      for(final AbstractScopNode node : _statements) {
        CharSequence _branchGenerator = this.branchGenerator(node, tiled);
        _builder.append(_branchGenerator);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  protected CharSequence _generate(final ScopGuard s, final DTiledLoop tiled) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = s.getConstraintSystems().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("if (");
        final Function1<IntConstraintSystem, CharSequence> _function = (IntConstraintSystem cs) -> {
          return Utility.toCString(cs.simplify());
        };
        String _join = IterableExtensions.<IntConstraintSystem>join(s.getConstraintSystems(), " || ", _function);
        _builder.append(_join);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Object _branchGenerator = this.branchGenerator(s.getThenBody(), tiled);
        _builder.append(_branchGenerator, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        {
          AbstractScopNode _elseBody = s.getElseBody();
          boolean _notEquals = (!Objects.equal(_elseBody, null));
          if (_notEquals) {
            _builder.append(" else {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            Object _branchGenerator_1 = this.branchGenerator(s.getElseBody(), tiled);
            _builder.append(_branchGenerator_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
      } else {
        Object _branchGenerator_2 = this.branchGenerator(s.getThenBody(), tiled);
        _builder.append(_branchGenerator_2);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _generate(final ScopBlock sg, final DTiledLoop tiled) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      EList<AbstractScopNode> _statements = sg.getStatements();
      for(final AbstractScopNode node : _statements) {
        _builder.append("\t");
        Object _branchGenerator = this.branchGenerator(node, tiled);
        _builder.append(_branchGenerator, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence customGenerate(final AbstractScopNode n, final DTiledBlock tb) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    String _generate = this.generate(tb.getTileLoopStart(), this.receiveStart(tb), this.receiveEnd(tb), this.sendBody(tb));
    _builder.append(_generate, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence receiveStart(final DTiledBlock tb) {
    StringConcatenation _builder = new StringConcatenation();
    final DTilingOptions opts = tb.getContainerLoop().getDtilingOptions();
    _builder.newLineIfNotEmpty();
    TiledCLoop _generatorLoop = tb.getContainerLoop().getGeneratorLoop();
    final MPICLoop tcl = ((MPICLoop) _generatorLoop);
    _builder.newLineIfNotEmpty();
    _builder.append("//Initiate receive if the sender of the next tile is in the outset");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//receive happens in the first tile in the chunk only");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (");
    Variable _tileIndex = opts.getTileIndex(1);
    _builder.append(_tileIndex, "\t");
    _builder.append(" == ");
    _builder.append(CodeGenConstantsForDistributed.chunkOrigin, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//Receive Buffer");
    _builder.newLine();
    {
      EList<Buffer> _buffers = tcl.getBuffers();
      for(final Buffer b : _buffers) {
        _builder.append("\t\t");
        _builder.append("if (");
        CharSequence _printConstraints = this.domainExtensions.printConstraints(b.getReceiveDomain());
        _builder.append(_printConstraints, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("MPI_Irecv(&");
        String _name = b.getVariable().getName();
        _builder.append(_name, "\t\t\t");
        _builder.append("(");
        _builder.append(CodeGenConstantsForDistributed.recvBuffer, "\t\t\t");
        _builder.append(", 0), ");
        String _cString = Utility.toCString(b.computeBufferSize());
        _builder.append(_cString, "\t\t\t");
        _builder.append(", ");
        String _mPITypeString = b.getVariable().getMPITypeString();
        _builder.append(_mPITypeString, "\t\t\t");
        _builder.append(", _src_, 0, MPI_COMM_WORLD, &");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.recvBuffer, "\t\t\t");
        _builder.append("]);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence receiveEnd(final DTiledBlock tb) {
    StringConcatenation _builder = new StringConcatenation();
    final DTilingOptions opts = tb.getContainerLoop().getDtilingOptions();
    _builder.newLineIfNotEmpty();
    TiledCLoop _generatorLoop = tb.getContainerLoop().getGeneratorLoop();
    final MPICLoop tcl = ((MPICLoop) _generatorLoop);
    _builder.newLineIfNotEmpty();
    _builder.append("//Wait on the issued Irecv, and copy values to local memory");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//when in the first chunk");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (");
    Variable _tileIndex = opts.getTileIndex(1);
    _builder.append(_tileIndex, "\t");
    _builder.append(" == ");
    _builder.append(CodeGenConstantsForDistributed.chunkOrigin, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//Receive Buffer");
    _builder.newLine();
    {
      EList<Buffer> _buffers = tcl.getBuffers();
      for(final Buffer b : _buffers) {
        _builder.append("\t\t");
        _builder.append("if (");
        CharSequence _printConstraints = this.domainExtensions.printConstraints(b.getReceiveDomain());
        _builder.append(_printConstraints, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("MPI_Wait(&");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.recvBuffer, "\t\t\t");
        _builder.append("], NULL);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t");
        _builder.append("] = NULL;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("//Copy to Local Memory");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateLoopNest = this.generateLoopNest(tcl.getReceiveBufferCopyLoop());
    _builder.append(_generateLoopNest, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public CharSequence sendBody(final DTiledBlock tb) {
    StringConcatenation _builder = new StringConcatenation();
    final DTilingOptions opts = tb.getContainerLoop().getDtilingOptions();
    _builder.newLineIfNotEmpty();
    TiledCLoop _generatorLoop = tb.getContainerLoop().getGeneratorLoop();
    final MPICLoop tcl = ((MPICLoop) _generatorLoop);
    _builder.newLineIfNotEmpty();
    _builder.append("//Send code");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//send happens in the last tile of a chunk only");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if ((");
    Variable _tileIndex = opts.getTileIndex(1);
    _builder.append(_tileIndex, "\t");
    _builder.append(" == ");
    _builder.append(CodeGenConstantsForDistributed.chunkOrigin, "\t");
    _builder.append("+(");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk, "\t");
    _builder.append("-1)*");
    AffineTerm _tileSize = opts.getTileSize(1);
    _builder.append(_tileSize, "\t");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Buffer> _buffers = tcl.getBuffers();
      for(final Buffer b : _buffers) {
        _builder.append("\t\t");
        _builder.append("if (");
        CharSequence _printConstraints = this.domainExtensions.printConstraints(b.getSendDomain());
        _builder.append(_printConstraints, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("//wait for send buffer to be available before copying in ");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t");
        _builder.append("] != NULL) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("MPI_Wait(&");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t\t");
        _builder.append("], NULL);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t\t");
        _builder.append("] = NULL;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("//Copy from Local Memory");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateLoopNest = this.generateLoopNest(tcl.getSendBufferCopyLoop());
    _builder.append(_generateLoopNest, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//Send Buffer");
    _builder.newLine();
    {
      EList<Buffer> _buffers_1 = tcl.getBuffers();
      for(final Buffer b_1 : _buffers_1) {
        _builder.append("\t\t");
        _builder.append("if (");
        CharSequence _printConstraints_1 = this.domainExtensions.printConstraints(b_1.getSendDomain());
        _builder.append(_printConstraints_1, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("MPI_Isend(&");
        String _name = b_1.getVariable().getName();
        _builder.append(_name, "\t\t\t");
        _builder.append("(");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t");
        _builder.append(", 0), ");
        String _cString = Utility.toCString(b_1.computeBufferSize());
        _builder.append(_cString, "\t\t\t");
        _builder.append(", ");
        String _mPITypeString = b_1.getVariable().getMPITypeString();
        _builder.append(_mPITypeString, "\t\t\t");
        _builder.append(", _dst_, 0, MPI_COMM_WORLD, &");
        _builder.append(CodeGenConstantsForDistributed.requests, "\t\t\t");
        _builder.append("[");
        _builder.append(CodeGenConstantsForDistributed.sendBuffer, "\t\t\t");
        _builder.append("]);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
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

  public CharSequence generate(final AbstractScopNode sg, final DTiledLoop tiled) {
    if (sg instanceof ScopBlock) {
      return _generate((ScopBlock)sg, tiled);
    } else if (sg instanceof ScopGuard) {
      return _generate((ScopGuard)sg, tiled);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(sg, tiled).toString());
    }
  }
}
