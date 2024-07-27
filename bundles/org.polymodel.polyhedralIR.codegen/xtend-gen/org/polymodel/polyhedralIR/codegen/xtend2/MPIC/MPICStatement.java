package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;

@SuppressWarnings("all")
public class MPICStatement extends BaseStatement {
  /**
   * Write accesses also need to be translated by the chunkOrigin
   */
  @Override
  public CharSequence writeAccess(final EquationAsStatement stmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field expressions is undefined for the type AffineFunction"
      + "\nType mismatch: cannot convert from Object to PolymodelVisitable"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }
}
