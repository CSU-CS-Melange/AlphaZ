package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.codegen.xtend2.Utility;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPICUtility;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

@SuppressWarnings("all")
public class MPICStatement extends BaseStatement {
  /**
   * Write accesses also need to be translated by the chunkOrigin
   */
  @Override
  public CharSequence writeAccess(final EquationAsStatement stmt) {
    CharSequence _xifexpression = null;
    if ((stmt.getVarDecl().isLocal() && (!Utility.isScalar(stmt.getVariable())))) {
      CharSequence _xblockexpression = null;
      {
        final TargetMapping tm = stmt.getContainerLoop().getFunction().getCodeunit().getSystem().getTargetMapping();
        final AffineFunction F = MPICUtility.getAccessFunctionForDistributedVariable(tm, stmt.getVarDecl());
        StringConcatenation _builder = new StringConcatenation();
        String _name = stmt.getVariable().getName();
        _builder.append(_name);
        _builder.append("(");
        final Function1<AffineExpression, CharSequence> _function = (AffineExpression e) -> {
          return Utility.toCString(e);
        };
        String _join = IterableExtensions.<AffineExpression>join(F.getExpressions(), ",", _function);
        _builder.append(_join);
        _builder.append(")");
        _xblockexpression = _builder;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.writeAccess(stmt);
    }
    return _xifexpression;
  }
}
