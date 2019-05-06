package org.polymodel.polyhedralIR.codegen.xtend2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
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
  
  public CharSequence printConstraints(final Domain dom) {
    return this.printConstraints(dom.getPMdomain());
  }
  
  public CharSequence printConstraints(final org.polymodel.Domain dom) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<IntConstraintSystem, CharSequence> _function = (IntConstraintSystem poly) -> {
      return this.printConstraints(poly);
    };
    String _join = IterableExtensions.<IntConstraintSystem>join(dom.getPolyhedra(), " || ", _function);
    _builder.append(_join);
    return _builder;
  }
  
  public CharSequence printConstraints(final IntConstraintSystem system) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      int _size = system.getConstraints().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        final Function1<IntConstraint, CharSequence> _function = (IntConstraint c) -> {
          return c.toString(OUTPUT_FORMAT.C);
        };
        String _join = IterableExtensions.<IntConstraint>join(system.getConstraints(), " && ", _function);
        _builder.append(_join);
      } else {
        _builder.append("1");
      }
    }
    _builder.append(")");
    return _builder;
  }
}
