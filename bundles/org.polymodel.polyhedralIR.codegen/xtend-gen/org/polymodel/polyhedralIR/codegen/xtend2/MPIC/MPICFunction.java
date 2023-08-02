package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.Indexed;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

@SuppressWarnings("all")
public class MPICFunction extends BaseFunction {
  @Override
  public CharSequence functionBody(final Function func) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int ");
    _builder.append(CodeGenConstantsForDistributed.numP);
    _builder.append(", ");
    _builder.append(CodeGenConstantsForDistributed.pid);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("MPI_Comm_size(MPI_COMM_WORLD,&");
    _builder.append(CodeGenConstantsForDistributed.numP);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("MPI_Comm_rank(MPI_COMM_WORLD,&");
    _builder.append(CodeGenConstantsForDistributed.pid);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("//Source and Destination should be the neighbor in our scheme");
    _builder.newLine();
    _builder.append("int _src_ = ");
    _builder.append(CodeGenConstantsForDistributed.pid);
    _builder.append("-1;");
    _builder.newLineIfNotEmpty();
    _builder.append("if (_src_ < 0) _src_ = ");
    _builder.append(CodeGenConstantsForDistributed.numP);
    _builder.append("-1;");
    _builder.newLineIfNotEmpty();
    _builder.append("int _dst_ = ");
    _builder.append(CodeGenConstantsForDistributed.pid);
    _builder.append("+1;");
    _builder.newLineIfNotEmpty();
    _builder.append("if (_dst_ >= ");
    _builder.append(CodeGenConstantsForDistributed.numP);
    _builder.append(") _dst_ = 0;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateNumberOfTilesComputation = this.generateNumberOfTilesComputation(func.getCodeunit().getSystem());
    _builder.append(_generateNumberOfTilesComputation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateChunkSizeComputation = this.generateChunkSizeComputation(func.getCodeunit().getSystem());
    _builder.append(_generateChunkSizeComputation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _functionBody = super.functionBody(func);
    _builder.append(_functionBody);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateChunkSizeComputation(final AffineSystem system) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//default chunk size is computed when given chunk size is invalid");
    _builder.newLine();
    _builder.append("if (");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk);
    _builder.append(" <= 0) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk, "\t");
    _builder.append(" = ceild(");
    _builder.append(CodeGenConstantsForDistributed.numTilesPrefix, "\t");
    _builder.append("1, ");
    _builder.append(CodeGenConstantsForDistributed.numP, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int ");
    _builder.append(CodeGenConstantsForDistributed.chunkSize);
    _builder.append(" = ");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk);
    _builder.append(" * ");
    _builder.append(CodeGenConstantsForTiling.tileSizePrefix);
    _builder.append("1;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("//number of chunks per processor");
    _builder.newLine();
    _builder.append("int ");
    _builder.append(CodeGenConstantsForDistributed.chunkPerP);
    _builder.append(" = ceild(");
    _builder.append(CodeGenConstantsForDistributed.numTilesPrefix);
    _builder.append("1, ");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifdef DEBUG");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("printf(\"");
    _builder.append(CodeGenConstantsForDistributed.pid, "\t");
    _builder.append(":%d ");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk, "\t");
    _builder.append(":%d ");
    _builder.append(CodeGenConstantsForDistributed.chunkPerP, "\t");
    _builder.append(":%d\\n\", ");
    _builder.append(CodeGenConstantsForDistributed.pid, "\t");
    _builder.append(", ");
    _builder.append(CodeGenConstantsForDistributed.numTilesPerChunk, "\t");
    _builder.append(", ");
    _builder.append(CodeGenConstantsForDistributed.chunkPerP, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("#endif");
    _builder.newLine();
    return _builder;
  }
  
  public String generateNumberOfTilesComputation(final AffineSystem system) {
    Domain udom = null;
    EList<VariableDeclaration> _locals = system.getLocals();
    EList<VariableDeclaration> _outputs = system.getOutputs();
    Iterable<VariableDeclaration> _plus = Iterables.<VariableDeclaration>concat(_locals, _outputs);
    for (final VariableDeclaration v : _plus) {
      boolean _equals = Objects.equal(udom, null);
      if (_equals) {
        udom = v.getDomain().copy();
      } else {
        udom = udom.union(v.getDomain());
      }
    }
    final EList<Integer> orderingDim = system.getTargetMapping().getSpaceTimeLevel(0).getOrderingDimensions();
    udom = DomainOperations.removeOrderingDimensions(udom, orderingDim);
    udom.simplify();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//number of tiles");
    String res = _builder.toString();
    Iterable<Indexed<Variable>> _indexed = Indexed.<Variable>indexed(udom.getIndices());
    for (final Indexed<Variable> i : _indexed) {
      {
        final EList<IntExpression> lbub = udom.getBounds(i.getIndex0());
        final ReductionExpression size = IntExpressionBuilder.sum(IntExpressionBuilder.sub(lbub.get(1), lbub.get(0)), IntExpressionBuilder.constant(1));
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(res);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("int ");
        _builder_1.append(CodeGenConstantsForDistributed.numTilesPrefix);
        int _index1 = i.getIndex1();
        _builder_1.append(_index1);
        _builder_1.append(" = ceild(");
        String _cString = Utility.toCString(size);
        _builder_1.append(_cString);
        _builder_1.append(", ");
        String _tileSizeName = CodeGenConstantsForTiling.getTileSizeName(i.getIndex1());
        _builder_1.append(_tileSizeName);
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        res = _builder_1.toString();
      }
    }
    return res;
  }
}
