package org.polymodel.polyhedralIR.codegen.xtend2;

import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;

@SuppressWarnings("all")
public class BaseIndices {
  protected CharSequence _getMacroIndices(final AbstractVariable v) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }

  protected CharSequence _getMacroIndices(final CodeGenVariable v) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type MemoryDomain"
      + "\ngetMacroIndicesL cannot be resolved");
  }

  public CharSequence getMacroIndices(final Domain dom) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\ngetMacroIndicesL cannot be resolved");
  }

  public CharSequence getMacroIndices(final AffineFunction func) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type AffineFunction"
      + "\ngetMacroIndicesL cannot be resolved");
  }

  public CharSequence getMacroIndices(final VariableDeclaration v) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\ngetMacroIndicesL cannot be resolved");
  }

  public CharSequence getMacroIndicesL(final /* List<Variable> */Object indices) {
    throw new Error("Unresolved compilation problems:"
      + "\ntoString cannot be resolved");
  }

  public CharSequence getMacroIndicesExceptTime(final /* List<Variable> */Object indices) {
    throw new Error("Unresolved compilation problems:"
      + "\ntoString cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n! cannot be resolved"
      + "\ntoString cannot be resolved");
  }

  public CharSequence getMacroIndices(final AbstractVariable v) {
    if (v instanceof CodeGenVariable) {
      return _getMacroIndices((CodeGenVariable)v);
    } else if (v != null) {
      return _getMacroIndices(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
