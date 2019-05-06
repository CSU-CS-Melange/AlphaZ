package org.polymodel.polyhedralIR.codegen.xtend2.scheduledC;

import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseExpression;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ExpressionPrinterForScheduledC;

@SuppressWarnings("all")
public class ScheduledCExpression extends BaseExpression {
  @Override
  public CharSequence print(final Expression expr, final CodeUnit cu, final Function func) {
    return ExpressionPrinterForScheduledC.print(expr, Boolean.valueOf(func.isEntryPoint()));
  }
}
