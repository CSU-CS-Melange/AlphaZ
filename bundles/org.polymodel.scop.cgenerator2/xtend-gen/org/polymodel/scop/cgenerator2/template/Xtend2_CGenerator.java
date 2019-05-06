package org.polymodel.scop.cgenerator2.template;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.cgenerator2.CGenerator;
import org.polymodel.scop.cgenerator2.template.Xtend2_Annotation;

@SuppressWarnings("all")
public class Xtend2_CGenerator {
  @Inject
  @Extension
  private Xtend2_Annotation annotation;
  
  public CharSequence generate(final ScopRoot root) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<AbstractScopNode> _statements = root.getStatements();
      for(final AbstractScopNode statement : _statements) {
        CharSequence _generate = this.generate(statement);
        _builder.append(_generate);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generate(final AbstractScopNode node) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<IScopAnnotation> _scopAnnotations = node.getScopAnnotations();
      for(final IScopAnnotation ann : _scopAnnotations) {
        CharSequence _annotationBeforeStatement = this.annotation.annotationBeforeStatement(ann);
        _builder.append(_annotationBeforeStatement);
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _statementBody = this.statementBody(node);
    _builder.append(_statementBody);
    _builder.newLineIfNotEmpty();
    {
      EList<IScopAnnotation> _scopAnnotations_1 = node.getScopAnnotations();
      for(final IScopAnnotation ann_1 : _scopAnnotations_1) {
        CharSequence _annotationAfterStatement = this.annotation.annotationAfterStatement(ann_1);
        _builder.append(_annotationAfterStatement);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _statementBody(final ScopBlock s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<AbstractScopNode> _statements = s.getStatements();
      for(final AbstractScopNode sbs : _statements) {
        CharSequence _generate = this.generate(sbs);
        _builder.append(_generate, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _statementBody(final ScopFor s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(");
    Variable _iterator = s.getIterator();
    _builder.append(_iterator);
    _builder.append("=");
    CharSequence _cString = this.toCString(s.getLB());
    _builder.append(_cString);
    _builder.append(";");
    CharSequence _cString_1 = this.toCString(s.getIterator());
    _builder.append(_cString_1);
    _builder.append(" <= ");
    CharSequence _cString_2 = this.toCString(s.getUB());
    _builder.append(_cString_2);
    _builder.append(";");
    CharSequence _cString_3 = this.toCString(s.getIterator());
    _builder.append(_cString_3);
    _builder.append("+=");
    CharSequence _cString_4 = this.toCString(s.getStride());
    _builder.append(_cString_4);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    {
      AbstractScopNode _body = s.getBody();
      boolean _notEquals = (!Objects.equal(_body, null));
      if (_notEquals) {
        CharSequence _generate = this.generate(s.getBody());
        _builder.append(_generate, " ");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toCString(final Variable v) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = v.getName();
    _builder.append(_name);
    return _builder;
  }
  
  protected CharSequence _toCString(final IntExpression ie) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = ie.simplify().toString(OUTPUT_FORMAT.C);
    _builder.append(_string);
    return _builder;
  }
  
  protected CharSequence _toCString(final IntConstraint ic) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = ic.simplify().toString(OUTPUT_FORMAT.C);
    _builder.append(_string);
    return _builder;
  }
  
  protected CharSequence _statementBody(final ScopGuard s) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = s.getConstraintSystems().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("if (");
        final Function1<IntConstraintSystem, CharSequence> _function = (IntConstraintSystem cs) -> {
          return this.printConstraintSystem(cs.simplify());
        };
        String _join = IterableExtensions.<IntConstraintSystem>join(s.getConstraintSystems(), " || ", _function);
        _builder.append(_join);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generate = this.generate(s.getThenBody());
        _builder.append(_generate, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        {
          AbstractScopNode _elseBody = s.getElseBody();
          boolean _notEquals = (!Objects.equal(_elseBody, null));
          if (_notEquals) {
            _builder.append(" else {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _generate_1 = this.generate(s.getElseBody());
            _builder.append(_generate_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _generate_2 = this.generate(s.getThenBody());
        _builder.append(_generate_2);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence printConstraintSystem(final IntConstraintSystem ics) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    final Function1<IntConstraint, CharSequence> _function = (IntConstraint c) -> {
      return this.toCString(c);
    };
    String _join = IterableExtensions.<IntConstraint>join(ics.getConstraints(), " && ", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _statementBody(final ScopAssignment s) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _cString = this.toCString(s.getLHS());
    _builder.append(_cString);
    _builder.append(" = ");
    CharSequence _cString_1 = this.toCString(s.getRHS());
    _builder.append(_cString_1);
    _builder.append(";");
    return _builder;
  }
  
  protected CharSequence _statementBody(final ScopStatementMacro s) {
    CharSequence _xifexpression = null;
    boolean _isInlined = CGenerator.isInlined(s.getName());
    if (_isInlined) {
      StringConcatenation _builder = new StringConcatenation();
      String _macroBody = CGenerator.getMacroBody(s.getName(), s.getMacroParams());
      _builder.append(_macroBody);
      _builder.append(";");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name = s.getName();
      _builder_1.append(_name);
      _builder_1.append("(");
      final Function1<IntExpression, CharSequence> _function = (IntExpression mp) -> {
        CharSequence _cString = this.toCString(mp);
        String _plus = ("(" + _cString);
        return (_plus + ")");
      };
      String _join = IterableExtensions.<IntExpression>join(s.getMacroParams(), ",", _function);
      _builder_1.append(_join);
      _builder_1.append(");");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public CharSequence statementBody(final AbstractScopNode s) {
    if (s instanceof ScopAssignment) {
      return _statementBody((ScopAssignment)s);
    } else if (s instanceof ScopStatementMacro) {
      return _statementBody((ScopStatementMacro)s);
    } else if (s instanceof ScopBlock) {
      return _statementBody((ScopBlock)s);
    } else if (s instanceof ScopFor) {
      return _statementBody((ScopFor)s);
    } else if (s instanceof ScopGuard) {
      return _statementBody((ScopGuard)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public CharSequence toCString(final AlgebraVisitable ic) {
    if (ic instanceof IntConstraint) {
      return _toCString((IntConstraint)ic);
    } else if (ic instanceof IntExpression) {
      return _toCString((IntExpression)ic);
    } else if (ic instanceof Variable) {
      return _toCString((Variable)ic);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ic).toString());
    }
  }
}
