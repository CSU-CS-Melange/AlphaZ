package org.polymodel.polyhedralIR.codegen.xtend2;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;

@SuppressWarnings("all")
public class BaseDomain {
  /**
   * Prints the constraints without the parameter context as a simplification.
   */
  public CharSequence printConstraints(final Domain dom, final ParameterDomain params) {
    CharSequence _xblockexpression = null;
    {
      Domain _copy = params.copy();
      final Domain context = ((Domain) _copy);
      EList<String> _indexNames = dom.getIndexNames();
      for (final String i : _indexNames) {
        context.addDimension(i);
      }
      _xblockexpression = this.printConstraints(dom, context);
    }
    return _xblockexpression;
  }

  /**
   * Prints the constraints after simplify in context with the given context.
   */
  public CharSequence printConstraints(final Domain dom, final Domain context) {
    CharSequence _xblockexpression = null;
    {
      final Domain simplified = dom.copy();
      simplified.simplifyInContext(context);
      _xblockexpression = this.printConstraints(simplified.getPMdomain());
    }
    return _xblockexpression;
  }

  public Object printConstraints(final Domain dom) {
    return this.printConstraints(dom.getPMdomain());
  }

  public CharSequence printConstraints(final org.polymodel.Domain dom) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field polyhedra is undefined for the type Domain"
      + "\nAmbiguous feature call.\nThe extension methods\n\tprintConstraints(Domain) in BaseDomain and\n\tprintConstraints(Domain) in BaseDomain\nboth match."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved");
  }

  public CharSequence printConstraints(final /* IntConstraintSystem */Object system) {
    throw new Error("Unresolved compilation problems:"
      + "\nOUTPUT_FORMAT cannot be resolved to a type."
      + "\nInvalid number of arguments. The method toString() is not applicable for the arguments (Object)"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nconstraints cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nconstraints cannot be resolved"
      + "\njoin cannot be resolved"
      + "\nC cannot be resolved");
  }
}
