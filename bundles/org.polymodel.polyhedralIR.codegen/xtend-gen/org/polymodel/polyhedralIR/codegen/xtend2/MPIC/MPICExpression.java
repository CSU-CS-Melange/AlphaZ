package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.ExpressionPrinterForMPIC;

@SuppressWarnings("all")
public class MPICExpression extends BaseExpression {
  @Override
  public CharSequence print(final Expression expr, final CodeUnit cu, final Function func) {
    return ExpressionPrinterForMPIC.print(expr, Boolean.valueOf(func.isEntryPoint()));
  }
}
