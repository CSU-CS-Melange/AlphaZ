package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;

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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThe method getBounds(Object) is undefined for the type Domain"
      + "\nIntExpressionBuilder cannot be resolved to a type."
      + "\nIntExpressionBuilder cannot be resolved to a type."
      + "\nIntExpressionBuilder cannot be resolved to a type."
      + "\nindexed cannot be resolved"
      + "\nindex0 cannot be resolved"
      + "\nsum cannot be resolved"
      + "\nsub cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\nconstant cannot be resolved"
      + "\nindex1 cannot be resolved"
      + "\ntoCString cannot be resolved"
      + "\nindex1 cannot be resolved");
  }
}
