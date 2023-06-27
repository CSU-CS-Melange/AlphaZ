package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.StructManagement;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.cgenerator2.CGenerator;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

@SuppressWarnings("all")
public class BaseBody {
  @Inject
  @Extension
  private BaseStatement stmtExtensions;
  
  @Inject
  @Extension
  private BaseDomain domainExtensions;
  
  @Inject
  @Extension
  private BaseMemoryAllocation mallocs;
  
  protected CharSequence _code(final Body body) {
    return null;
  }
  
  protected CharSequence _code(final BasicBody body) {
    return body.getString();
  }
  
  protected CharSequence _code(final ParameterCheck body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("///Parameter checking");
    _builder.newLine();
    _builder.append("if (!(");
    CharSequence _printConstraints = this.domainExtensions.printConstraints(body.getParameterDomain());
    _builder.append(_printConstraints);
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("printf(\"The value of parameters are not valid.\\n\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("exit(-1);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _code(final VariableInitialization b) {
    CharSequence _xblockexpression = null;
    {
      EList<AbstractVariable> _inputs = b.getInputs();
      EList<AbstractVariable> _outputs = b.getOutputs();
      final Function1<AbstractVariable, Boolean> _function = (AbstractVariable v) -> {
        return Boolean.valueOf(v.isGlobal());
      };
      final Iterable<AbstractVariable> globals = IterableExtensions.<AbstractVariable>filter(Iterables.<AbstractVariable>concat(_inputs, _outputs), _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _length = ((Object[])Conversions.unwrapArray(globals, Object.class)).length;
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          _builder.append("//Copy to global");
          _builder.newLine();
          {
            for(final AbstractVariable v : globals) {
              {
                boolean _isScalar = Utility.isScalar(v);
                if (_isScalar) {
                  _builder.newLine();
                  {
                    boolean _contains = b.getInputs().contains(v);
                    if (_contains) {
                      String _name = v.getName();
                      _builder.append(_name);
                      _builder.append(" = *");
                      _builder.append(CodeGenConstantsForC.TEMP_LOCAL_PREFIX);
                      String _name_1 = v.getName();
                      _builder.append(_name_1);
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  String _name_2 = v.getName();
                  _builder.append(_name_2);
                  _builder.append(" = ");
                  _builder.append(CodeGenConstantsForC.TEMP_LOCAL_PREFIX);
                  String _name_3 = v.getName();
                  _builder.append(_name_3);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
        }
      }
      CharSequence _malloc = this.mallocs.malloc(b);
      _builder.append(_malloc);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _code(final FlagVariableReset b) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _reset = this.mallocs.reset(b);
    _builder.append(_reset);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final VariableFinalization b) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _mfree = this.mallocs.mfree(b);
    _builder.append(_mfree);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final Loop body) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<Statement, CharSequence> _function = (Statement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function);
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Domain");
    _builder.newLine();
    {
      EList<Statement> _statements = body.getStatements();
      for(final Statement stmt : _statements) {
        _builder.append("\t");
        _builder.append("//");
        Domain _domain = stmt.getDomain();
        _builder.append(_domain, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _generateLoopNest = this.generateLoopNest(body);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final Function1<Statement, CharSequence> _function_1 = (Statement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_1 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final TiledCLoop body) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((!Objects.equal(body.getOptimizedPointLoop(), null)) && (body.getOptimizedPointLoop().getStatements().size() > 0))) {
        final Function1<Statement, CharSequence> _function = (Statement s) -> {
          return this.stmtExtensions.statementDefine(s);
        };
        String _join = IterableExtensions.<Statement>join(body.getOptimizedPointLoop().getStatements(), "\n", _function);
        _builder.append(_join);
        _builder.newLineIfNotEmpty();
      }
    }
    final Function1<Statement, CharSequence> _function_1 = (Statement s) -> {
      return this.stmtExtensions.statementDefine(s);
    };
    String _join_1 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_1);
    _builder.append(_join_1);
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Domain");
    _builder.newLine();
    {
      EList<Statement> _statements = body.getStatements();
      for(final Statement stmt : _statements) {
        _builder.append("\t");
        _builder.append("//");
        Domain _domain = stmt.getDomain();
        _builder.append(_domain, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _generateLoopNest = this.generateLoopNest(body);
    _builder.append(_generateLoopNest, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final Function1<Statement, CharSequence> _function_2 = (Statement s) -> {
      return this.stmtExtensions.statementUndefine(s);
    };
    String _join_2 = IterableExtensions.<Statement>join(body.getStatements(), "\n", _function_2);
    _builder.append(_join_2);
    _builder.newLineIfNotEmpty();
    {
      if (((!Objects.equal(body.getOptimizedPointLoop(), null)) && (body.getOptimizedPointLoop().getStatements().size() > 0))) {
        final Function1<Statement, CharSequence> _function_3 = (Statement s) -> {
          return this.stmtExtensions.statementUndefine(s);
        };
        String _join_3 = IterableExtensions.<Statement>join(body.getOptimizedPointLoop().getStatements(), "\n", _function_3);
        _builder.append(_join_3);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateLoopNest(final Loop l) {
    StringConcatenation _builder = new StringConcatenation();
    final ScopRoot scop = l.generateScop();
    _builder.newLineIfNotEmpty();
    {
      if ((l.isDeclareIterators() && (l.getIteratorNames().size() > 0))) {
        _builder.append("int ");
        final Function1<String, CharSequence> _function = (String n) -> {
          return n;
        };
        String _join = IterableExtensions.<String>join(l.getIteratorNames(), ",", _function);
        _builder.append(_join);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    HashMap<String, MacroBodyProvider> stmtBody = new HashMap<String, MacroBodyProvider>();
    _builder.newLineIfNotEmpty();
    {
      final Function1<Statement, Boolean> _function_1 = (Statement s) -> {
        return Boolean.valueOf(s.isInlined());
      };
      Iterable<Statement> _filter = IterableExtensions.<Statement>filter(l.getStatements(), _function_1);
      for(final Statement s : _filter) {
        MacroBodyProvider _put = stmtBody.put(s.getName(), s.getMacroBodyProvider());
        _builder.append(_put);
        _builder.newLineIfNotEmpty();
      }
    }
    String _generate = CGenerator.generate(scop, stmtBody);
    _builder.append(_generate);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence name(final StructManagement psm) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = psm.getInstance().getName();
    _builder.append(_name);
    return _builder;
  }
  
  protected CharSequence _code(final PackStruct pps) {
    StringConcatenation _builder = new StringConcatenation();
    String _typeString = pps.getInstance().getTypeString();
    _builder.append(_typeString);
    _builder.append(" ");
    CharSequence _name = this.name(pps);
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _members = pps.getStruct().getMembers();
      for(final AbstractVariable p : _members) {
        CharSequence _name_1 = this.name(pps);
        _builder.append(_name_1);
        _builder.append(".");
        String _name_2 = p.getName();
        _builder.append(_name_2);
        _builder.append(" = ");
        String _name_3 = p.getName();
        _builder.append(_name_3);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _code(final CustomPackStruct cpps) {
    StringConcatenation _builder = new StringConcatenation();
    String _typeString = cpps.getInstance().getTypeString();
    _builder.append(_typeString);
    _builder.append(" ");
    CharSequence _name = this.name(cpps);
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      EList<AbstractVariable> _members = cpps.getStruct().getMembers();
      for(final AbstractVariable p : _members) {
        CharSequence _name_1 = this.name(cpps);
        _builder.append(_name_1);
        _builder.append(".");
        String _name_2 = p.getName();
        _builder.append(_name_2);
        _builder.append(" = ");
        String _get = cpps.getInitValues().get(p.getName());
        _builder.append(_get);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * If there are more than one array then icc cannot distinguish whether there are aliasing
   * In order to hint the compiler we use "restrict" keyword in the declaration
   */
  protected CharSequence _code(final UnpackStruct pps) {
    StringConcatenation _builder = new StringConcatenation();
    final Function1<AbstractVariable, Boolean> _function = (AbstractVariable m) -> {
      boolean _isScalar = Utility.isScalar(m);
      return Boolean.valueOf((!_isScalar));
    };
    int _size = IterableExtensions.size(IterableExtensions.<AbstractVariable>filter(pps.getStruct().getMembers(), _function));
    final boolean addRestrict = (_size > 1);
    _builder.newLineIfNotEmpty();
    {
      if (addRestrict) {
        {
          EList<AbstractVariable> _members = pps.getStruct().getMembers();
          for(final AbstractVariable p : _members) {
            String _asParameterType = p.asParameterType();
            _builder.append(_asParameterType);
            {
              boolean _isScalar = Utility.isScalar(p);
              boolean _not = (!_isScalar);
              if (_not) {
                _builder.append(" restrict");
              }
            }
            _builder.append(" ");
            String _name = p.getName();
            _builder.append(_name);
            _builder.append(" = ");
            CharSequence _name_1 = this.name(pps);
            _builder.append(_name_1);
            _builder.append(".");
            String _name_2 = p.getName();
            _builder.append(_name_2);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          EList<AbstractVariable> _members_1 = pps.getStruct().getMembers();
          for(final AbstractVariable p_1 : _members_1) {
            String _asParameterType_1 = p_1.asParameterType();
            _builder.append(_asParameterType_1);
            _builder.append(" ");
            String _name_3 = p_1.getName();
            _builder.append(_name_3);
            _builder.append(" = ");
            CharSequence _name_4 = this.name(pps);
            _builder.append(_name_4);
            _builder.append(".");
            String _name_5 = p_1.getName();
            _builder.append(_name_5);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence code(final Body body) {
    if (body instanceof TiledCLoop) {
      return _code((TiledCLoop)body);
    } else if (body instanceof CustomPackStruct) {
      return _code((CustomPackStruct)body);
    } else if (body instanceof PackStruct) {
      return _code((PackStruct)body);
    } else if (body instanceof UnpackStruct) {
      return _code((UnpackStruct)body);
    } else if (body instanceof BasicBody) {
      return _code((BasicBody)body);
    } else if (body instanceof ParameterCheck) {
      return _code((ParameterCheck)body);
    } else if (body instanceof FlagVariableReset) {
      return _code((FlagVariableReset)body);
    } else if (body instanceof Loop) {
      return _code((Loop)body);
    } else if (body instanceof VariableFinalization) {
      return _code((VariableFinalization)body);
    } else if (body instanceof VariableInitialization) {
      return _code((VariableInitialization)body);
    } else if (body != null) {
      return _code(body);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(body).toString());
    }
  }
}
