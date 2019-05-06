package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.codegen.xtend2.StateOfLoop;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;

@SuppressWarnings("all")
public class BaseFunction {
  @Inject
  @Extension
  private BaseBody extensions;
  
  public String nameEsc(final FunctionSignature fs) {
    return this.nameEsc(fs.getName());
  }
  
  public String nameEsc(final String fname) {
    String name = fname.replaceAll("\\-", "_");
    boolean _matches = name.matches("\\d.+");
    if (_matches) {
      return ("_" + name);
    } else {
      return name;
    }
  }
  
  public CharSequence prototype(final FunctionSignature fs) {
    StringConcatenation _builder = new StringConcatenation();
    String _returnType = fs.getReturnType();
    _builder.append(_returnType);
    _builder.append(" ");
    String _nameEsc = this.nameEsc(fs);
    _builder.append(_nameEsc);
    _builder.append("(");
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable p) -> {
      return p.asParameterType();
    };
    String _join = IterableExtensions.<AbstractVariable>join(fs.getParameters(), ", ", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence functionSignature(final Function f) {
    EList<AbstractVariable> _inputs = f.getInputs();
    EList<AbstractVariable> _outputs = f.getOutputs();
    final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
      return Boolean.valueOf(v.isGlobal());
    };
    return this.fullSignature(f.getSignature(), IterableExtensions.<AbstractVariable>filter(Iterables.<AbstractVariable>concat(_inputs, _outputs), _function));
  }
  
  public CharSequence fullSignature(final FunctionSignature fs, final Iterable<AbstractVariable> globals) {
    StringConcatenation _builder = new StringConcatenation();
    String _returnType = fs.getReturnType();
    _builder.append(_returnType);
    _builder.append(" ");
    String _nameEsc = this.nameEsc(fs);
    _builder.append(_nameEsc);
    _builder.append("(");
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable v) -> {
      return this.functionParam(v, globals);
    };
    String _join = IterableExtensions.<AbstractVariable>join(fs.getParameters(), ", ", _function);
    _builder.append(_join);
    _builder.append(")");
    return _builder;
  }
  
  private CharSequence functionParam(final AbstractVariable p, final Iterable<AbstractVariable> globals) {
    StringConcatenation _builder = new StringConcatenation();
    String _asParameterType = p.asParameterType();
    _builder.append(_asParameterType);
    _builder.append(" ");
    {
      final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
        return Boolean.valueOf(v.getName().matches(p.getName()));
      };
      boolean _exists = IterableExtensions.<AbstractVariable>exists(globals, _function);
      if (_exists) {
        _builder.append(CodeGenConstantsForC.TEMP_LOCAL_PREFIX);
      }
    }
    String _name = p.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence code(final Function func) {
    CharSequence _xifexpression = null;
    boolean _isInlined = func.isInlined();
    boolean _not = (!_isInlined);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _functionSignature = this.functionSignature(func);
      _builder.append(_functionSignature);
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _functionBody = this.functionBody(func);
      _builder.append(_functionBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      _xifexpression = this.functionBody(func);
    }
    return _xifexpression;
  }
  
  public CharSequence functionBody(final Function func) {
    CharSequence _xblockexpression = null;
    {
      StateOfLoop state = new StateOfLoop(true, false);
      WhileInfo _whileInfo = func.getCodeunit().getSystem().getWhileInfo();
      boolean isWhile = (!Objects.equal(_whileInfo, null));
      String timeIndexName = "";
      if (isWhile) {
        timeIndexName = func.getCodeunit().getSystem().getWhileInfo().getTimeDomain().getIndexNames().get(0);
      }
      Domain _xifexpression = null;
      if (isWhile) {
        _xifexpression = func.getCodeunit().getSystem().getWhileInfo().getTimeDomain().getPMdomain().<Domain>lexMin();
      }
      Domain lexMinD = _xifexpression;
      org.polymodel.polyhedralIR.Domain _xifexpression_1 = null;
      if (isWhile) {
        _xifexpression_1 = PolyhedralIRUserFactory.eINSTANCE.createDomain(lexMinD);
      }
      org.polymodel.polyhedralIR.Domain lexMinPolyIRD = _xifexpression_1;
      String _xifexpression_2 = null;
      if (isWhile) {
        _xifexpression_2 = lexMinPolyIRD.getLowerBound(0).toString();
      }
      String lexminOfTime = _xifexpression_2;
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<Body> _bodies = func.getBodies();
        for(final Body body : _bodies) {
          {
            if ((((isWhile && func.isEntryPoint()) && ((body instanceof Loop) || (body instanceof FlagVariableReset))) && (state.isFirstLoop() == true))) {
              _builder.append("// infinite time loop with index ");
              _builder.append(timeIndexName);
              _builder.newLineIfNotEmpty();
              _builder.append("int ");
              _builder.append(timeIndexName);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("for (");
              _builder.append(timeIndexName);
              _builder.append("=");
              _builder.append(lexminOfTime);
              _builder.append("; ; ");
              _builder.append(timeIndexName);
              _builder.append("++) {\t");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if (((((isWhile && func.isEntryPoint()) && (!((body instanceof Loop) || (body instanceof FlagVariableReset)))) && (state.isFirstLoop() == false)) && (state.isLastLoop() == false))) {
              _builder.append("// Evaluate condition ");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("if (");
              _builder.append(timeIndexName, "\t");
              _builder.append(">=(");
              _builder.append(lexminOfTime, "\t");
              _builder.append(")+(");
              String _numberOfTimeIterationsForFirstConditionCheck = func.getNumberOfTimeIterationsForFirstConditionCheck();
              _builder.append(_numberOfTimeIterationsForFirstConditionCheck, "\t");
              _builder.append(")-1) { ");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("eval_isCond(");
              final Function1<Variable, CharSequence> _function = (Variable v) -> {
                return v.getName();
              };
              String _join = IterableExtensions.<Variable>join(func.getCodeunit().getSystem().getParameters().getParams(), ", ", _function);
              _builder.append(_join, "\t\t");
              _builder.append(", ");
              _builder.append(timeIndexName, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("if (isCond(");
              _builder.append(timeIndexName, "\t\t");
              _builder.append(") == false) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("printf(\"Breaking time: %d\\n\", ");
              _builder.append(timeIndexName, "\t\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("break;");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t\t\t");
              state.setLastLoop(true);
              _builder.newLineIfNotEmpty();
            }
          }
          CharSequence _code = this.extensions.code(body);
          _builder.append(_code);
          _builder.newLineIfNotEmpty();
          {
            if ((((isWhile && func.isEntryPoint()) && ((body instanceof Loop) || (body instanceof FlagVariableReset))) && (state.isFirstLoop() == true))) {
              state.setFirstLoop(false);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
