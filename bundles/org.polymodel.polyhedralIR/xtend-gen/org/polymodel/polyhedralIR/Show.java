package org.polymodel.polyhedralIR;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Show {
  public String toString(final PolyhedralIRVisitable o) {
    return this.print(o, false).toString();
  }

  public String toSimplifiedString(final PolyhedralIRVisitable o) {
    return this.print(o, true).toString();
  }

  protected CharSequence _print(final Program o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<ExternalFunctionDeclaration, CharSequence> _function = (ExternalFunctionDeclaration e) -> {
      return this.print(e, simplify);
    };
    String _join = IterableExtensions.<ExternalFunctionDeclaration>join(o.getExternalFunctionDeclarations(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final Function1<AffineSystem, CharSequence> _function_1 = (AffineSystem e) -> {
      return this.print(e, simplify);
    };
    String _join_1 = IterableExtensions.<AffineSystem>join(o.getSystems(), "\n\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _print(final ExternalFunctionDeclaration o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _print = this.print(o.getOutput(), simplify);
    _builder.append(_print);
    _builder.append(" ");
    String _name = o.getName();
    _builder.append(_name);
    _builder.append("(");
    final Function1<Type, CharSequence> _function = (Type i) -> {
      return this.print(i, simplify);
    };
    String _join = IterableExtensions.<Type>join(o.getInputs(), ",", _function);
    _builder.append(_join);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _print(final Type o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    String _cName = o.getCName();
    _builder.append(_cName);
    return _builder;
  }

  protected CharSequence _print(final AffineSystem o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("affine ");
    String _name = o.getName();
    _builder.append(_name);
    _builder.append(" ");
    ParameterDomain _parameters = o.getParameters();
    _builder.append(_parameters);
    _builder.newLineIfNotEmpty();
    {
      int _size = o.getInputs().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("input");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        final Function1<VariableDeclaration, CharSequence> _function = (VariableDeclaration i) -> {
          return this.print(i, simplify);
        };
        String _join = IterableExtensions.<VariableDeclaration>join(o.getInputs(), "\n", _function);
        _builder.append(_join, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      int _size_1 = o.getOutputs().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t");
        _builder.append("output");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        final Function1<VariableDeclaration, CharSequence> _function_1 = (VariableDeclaration i) -> {
          return this.print(i, simplify);
        };
        String _join_1 = IterableExtensions.<VariableDeclaration>join(o.getOutputs(), "\n", _function_1);
        _builder.append(_join_1, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      int _size_2 = o.getLocals().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        _builder.append("\t");
        _builder.append("local");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        final Function1<VariableDeclaration, CharSequence> _function_2 = (VariableDeclaration i) -> {
          return this.print(i, simplify);
        };
        String _join_2 = IterableExtensions.<VariableDeclaration>join(o.getLocals(), "\n", _function_2);
        _builder.append(_join_2, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("let");
    _builder.newLine();
    _builder.append("\t\t");
    final Function1<StandardEquation, CharSequence> _function_3 = (StandardEquation i) -> {
      return this.print(i, simplify);
    };
    String _join_3 = IterableExtensions.<StandardEquation>join(o.getEquations(), "\n", _function_3);
    _builder.append(_join_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    final Function1<UseEquation, CharSequence> _function_4 = (UseEquation i) -> {
      return this.print(i, simplify);
    };
    String _join_4 = IterableExtensions.<UseEquation>join(o.getUseEquations(), "\n", _function_4);
    _builder.append(_join_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append(".");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _print(final Domain o, final boolean simplify) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field indices is undefined for the type Domain"
      + "\nThe method or field name is undefined for the type Object"
      + "\nThe method simplifyDomain(Domain, boolean) is undefined"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\njoin cannot be resolved"
      + "\nprint cannot be resolved");
  }

  protected CharSequence _print(final ParameterDomain o, final boolean simplify) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field params is undefined for the type ParameterDomain"
      + "\nThe method or field indices is undefined for the type ParameterDomain"
      + "\nThe method or field name is undefined for the type Object"
      + "\nThe method or field polyhedra is undefined for the type Domain"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\n+ cannot be resolved"
      + "\njoin cannot be resolved"
      + "\nprint cannot be resolved");
  }

  protected CharSequence print(final /* List<IntConstraintSystem> */Object ics, final String indices) {
    throw new Error("Unresolved compilation problems:"
      + "\nOUTPUT_FORMAT cannot be resolved to a type."
      + "\ntoString cannot be resolved"
      + "\nALPHABETS cannot be resolved");
  }

  protected CharSequence _print(final VariableDeclaration o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _print = this.print(o.getType(), simplify);
    _builder.append(_print);
    _builder.append(" ");
    CharSequence _print_1 = this.print(o.getVarID(), simplify);
    _builder.append(_print_1);
    _builder.append(" ");
    CharSequence _print_2 = this.print(o.getDomain(), simplify);
    _builder.append(_print_2);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _print(final VariableIdentifier o, final boolean simplify) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = o.getName();
    _builder.append(_name);
    return _builder;
  }

  protected CharSequence print(final EObject o, final boolean simplify) {
    if (o instanceof ParameterDomain) {
      return _print((ParameterDomain)o, simplify);
    } else if (o instanceof AffineSystem) {
      return _print((AffineSystem)o, simplify);
    } else if (o instanceof Domain) {
      return _print((Domain)o, simplify);
    } else if (o instanceof ExternalFunctionDeclaration) {
      return _print((ExternalFunctionDeclaration)o, simplify);
    } else if (o instanceof Program) {
      return _print((Program)o, simplify);
    } else if (o instanceof VariableDeclaration) {
      return _print((VariableDeclaration)o, simplify);
    } else if (o instanceof VariableIdentifier) {
      return _print((VariableIdentifier)o, simplify);
    } else if (o instanceof Type) {
      return _print((Type)o, simplify);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o, simplify).toString());
    }
  }
}
