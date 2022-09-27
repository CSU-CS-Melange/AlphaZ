package org.polymodel.polyhedralIR.codegen.xtend2.PCOT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;

/**
 * Note: some +1 to the band index is because tile bands are indexed from 0,
 *       but tile parameters starts from 1.
 */
@SuppressWarnings("all")
public class PCOTBody extends BaseBody {
  protected CharSequence _code(final RecursionBody body) {
    CharSequence _xblockexpression = null;
    {
      final Struct recurS = body.getRecurStructs().get(0);
      final List<AbstractVariable> tileWidth = this.tileWidth(body, recurS);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//Return if width of the orthant is 0");
      _builder.newLine();
      _builder.append("if (");
      final Function1<Integer, CharSequence> _function = (Integer i) -> {
        return this.eq0(tileWidth.get((i).intValue()));
      };
      String _join = IterableExtensions.<Integer>join(this.bandRange(body), " || ", _function);
      _builder.append(_join);
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//Call the base function");
      _builder.newLine();
      _builder.append("if (");
      final Function1<Integer, CharSequence> _function_1 = (Integer i) -> {
        return this.TwLETs(body, tileWidth, (i).intValue());
      };
      String _join_1 = IterableExtensions.<Integer>join(this.bandRange(body), " && ", _function_1);
      _builder.append(_join_1);
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _fcall = this.fcall(body.getBaseFunction());
      _builder.append(_fcall, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//Recursion");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//Half Tile Width");
      _builder.newLine();
      {
        IntegerRange _bandRange = this.bandRange(body);
        for(final Integer i : _bandRange) {
          CharSequence _htw = this.htw(body, tileWidth, (i).intValue());
          _builder.append(_htw);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("//Recurse");
      _builder.newLine();
      CharSequence _recursionCalls = this.recursionCalls(body, recurS);
      _builder.append(_recursionCalls);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public CharSequence eq0(final AbstractVariable p) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = p.getName();
    _builder.append(_name);
    _builder.append(" == 0");
    return _builder;
  }

  public CharSequence TwLETs(final RecursionBody rb, final List<AbstractVariable> tileWidth, final int i) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = tileWidth.get(i).getName();
    _builder.append(_name);
    _builder.append(" <= ");
    String _get = rb.getTileSizes().get(i);
    _builder.append(_get);
    return _builder;
  }

  public CharSequence fcall(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = f.getName();
    _builder.append(_name);
    _builder.append("(");
    final Function1<AbstractVariable, CharSequence> _function = (AbstractVariable p) -> {
      return p.getName();
    };
    String _join = IterableExtensions.<AbstractVariable>join(f.getParameters(), ", ", _function);
    _builder.append(_join);
    _builder.append(");");
    return _builder;
  }

  public CharSequence htw(final RecursionBody rb, final List<AbstractVariable> tileWidth, final int dim) {
    CharSequence _xblockexpression = null;
    {
      final String ts = rb.getTileSizes().get(dim);
      final String tw = tileWidth.get(dim).getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int ");
      CharSequence _halfTW = this.halfTW(dim);
      _builder.append(_halfTW);
      _builder.append(" = (");
      _builder.append(tw);
      _builder.append(" > ");
      _builder.append(ts);
      _builder.append(") ? ");
      _builder.append(tw);
      _builder.append("/2 : ");
      _builder.append(tw);
      _builder.append(";");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public CharSequence recursionCalls(final RecursionBody rb, final Struct recurS) {
    CharSequence _xblockexpression = null;
    {
      final IntegerRange range = this.bandRange(rb);
      final int maxDim = this.maxBandWidth(recurS);
      final TreeSet<List<Boolean>> product = new TreeSet<List<Boolean>>(
        new Comparator<List<Boolean>>() {
          @Override
          public int compare(final List<Boolean> o1, final List<Boolean> o2) {
            final Function1<Boolean, Boolean> _function = (Boolean x) -> {
              return x;
            };
            final int o1count = IterableExtensions.size(IterableExtensions.<Boolean>filter(o1, _function));
            final Function1<Boolean, Boolean> _function_1 = (Boolean x) -> {
              return x;
            };
            final int o2count = IterableExtensions.size(IterableExtensions.<Boolean>filter(o2, _function_1));
            String _string = o1.toString();
            final String o1str = (Integer.valueOf(o1count) + _string);
            String _string_1 = o2.toString();
            final String o2str = (Integer.valueOf(o2count) + _string_1);
            return o1str.compareTo(o2str);
          }
        });
      ArrayList<Boolean> _arrayList = new ArrayList<Boolean>();
      this.productRecur(product, maxDim, range, _arrayList);
      StringConcatenation _builder = new StringConcatenation();
      {
        IntegerRange _upTo = new IntegerRange(0, maxDim);
        for(final Integer wf : _upTo) {
          {
            final Function1<List<Boolean>, Boolean> _function = (List<Boolean> p) -> {
              final Function1<Boolean, Boolean> _function_1 = (Boolean x) -> {
                return x;
              };
              int _size = IterableExtensions.size(IterableExtensions.<Boolean>filter(p, _function_1));
              return Boolean.valueOf((_size == (wf).intValue()));
            };
            Iterable<List<Boolean>> _filter = IterableExtensions.<List<Boolean>>filter(product, _function);
            for(final List<Boolean> c : _filter) {
              CharSequence _recursionCall = this.recursionCall(rb, recurS, c);
              _builder.append(_recursionCall);
              _builder.append(" ");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            boolean _isParallel = rb.isParallel();
            if (_isParallel) {
              _builder.append("#pragma omp taskwait");
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public CharSequence recursionCall(final RecursionBody rb, final Struct recurS, final List<Boolean> side) {
    CharSequence _xblockexpression = null;
    {
      final List<AbstractVariable> tileWidth = this.tileWidth(rb, recurS);
      final List<AbstractVariable> tileIndex = this.tileIndex(rb, recurS);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isParallel = rb.isParallel();
        if (_isParallel) {
          _builder.append("#pragma omp task");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      String _name = recurS.getName();
      _builder.append(_name, "\t");
      _builder.append(" ");
      CharSequence _newRecur = this.newRecur();
      _builder.append(_newRecur, "\t");
      _builder.append(" = ");
      CharSequence _curRecur = this.curRecur();
      _builder.append(_curRecur, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        final Function1<Pair<Integer, Boolean>, Boolean> _function = (Pair<Integer, Boolean> x) -> {
          Boolean _value = x.getValue();
          return Boolean.valueOf(((_value).booleanValue() == true));
        };
        Iterable<Pair<Integer, Boolean>> _filter = IterableExtensions.<Pair<Integer, Boolean>>filter(IterableExtensions.<Boolean>indexed(side), _function);
        for(final Pair<Integer, Boolean> s : _filter) {
          _builder.append(" ");
          final String ti = tileIndex.get((s.getKey()).intValue()).getName();
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _newRecur_1 = this.newRecur();
          _builder.append(_newRecur_1, "\t");
          _builder.append(".");
          _builder.append(ti, "\t");
          _builder.append(" = ");
          CharSequence _curRecur_1 = this.curRecur();
          _builder.append(_curRecur_1, "\t");
          _builder.append(".");
          _builder.append(ti, "\t");
          _builder.append(" + ");
          CharSequence _halfTW = this.halfTW((s.getKey()).intValue());
          _builder.append(_halfTW, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        Iterable<Pair<Integer, Boolean>> _indexed = IterableExtensions.<Boolean>indexed(side);
        for(final Pair<Integer, Boolean> s_1 : _indexed) {
          _builder.append(" ");
          final String tw = tileWidth.get((s_1.getKey()).intValue()).getName();
          _builder.newLineIfNotEmpty();
          {
            Boolean _value = s_1.getValue();
            if ((_value).booleanValue()) {
              _builder.append("\t");
              CharSequence _newRecur_2 = this.newRecur();
              _builder.append(_newRecur_2, "\t");
              _builder.append(".");
              _builder.append(tw, "\t");
              _builder.append(" = ");
              CharSequence _curRecur_2 = this.curRecur();
              _builder.append(_curRecur_2, "\t");
              _builder.append(".");
              _builder.append(tw, "\t");
              _builder.append(" - ");
              CharSequence _halfTW_1 = this.halfTW((s_1.getKey()).intValue());
              _builder.append(_halfTW_1, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              CharSequence _newRecur_3 = this.newRecur();
              _builder.append(_newRecur_3, "\t");
              _builder.append(".");
              _builder.append(tw, "\t");
              _builder.append(" = ");
              CharSequence _halfTW_2 = this.halfTW((s_1.getKey()).intValue());
              _builder.append(_halfTW_2, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      String _name_1 = rb.getFunction().getName();
      _builder.append(_name_1, "\t");
      _builder.append("(");
      final Function1<AbstractVariable, CharSequence> _function_1 = (AbstractVariable p) -> {
        CharSequence _xifexpression = null;
        boolean _contentEquals = p.getName().contentEquals(this.curRecur());
        if (_contentEquals) {
          _xifexpression = this.newRecur();
        } else {
          _xifexpression = p.getName();
        }
        return _xifexpression;
      };
      String _join = IterableExtensions.<AbstractVariable>join(rb.getFunction().getParameters(), ", ", _function_1);
      _builder.append(_join, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  private CharSequence curRecur() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("recurStruct");
    return _builder;
  }

  private CharSequence newRecur() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newRecur");
    return _builder;
  }

  private CharSequence halfTW(final int dim) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("htw");
    _builder.append((dim + 1));
    return _builder;
  }

  private IntegerRange bandRange(final RecursionBody rb) {
    int _bandStart = rb.getBandStart();
    int _bandEnd = rb.getBandEnd();
    return new IntegerRange(_bandStart, _bandEnd);
  }

  private int maxBandWidth(final Struct recurS) {
    int _length = ((Object[])Conversions.unwrapArray(recurS.getMembers(), Object.class)).length;
    return (_length / 2);
  }

  private List<AbstractVariable> tileWidth(final RecursionBody rb, final Struct recurS) {
    final int bandWidth = this.maxBandWidth(recurS);
    EList<AbstractVariable> _members = recurS.getMembers();
    int _bandStart = rb.getBandStart();
    int _plus = (_bandStart + bandWidth);
    int _bandEnd = rb.getBandEnd();
    int _plus_1 = (_bandEnd + bandWidth);
    int _plus_2 = (_plus_1 + 1);
    final List<AbstractVariable> tileWidth = _members.subList(_plus, _plus_2);
    return tileWidth;
  }

  private List<AbstractVariable> tileIndex(final RecursionBody rb, final Struct recurS) {
    EList<AbstractVariable> _members = recurS.getMembers();
    int _bandStart = rb.getBandStart();
    int _bandEnd = rb.getBandEnd();
    int _plus = (_bandEnd + 1);
    final List<AbstractVariable> tileIndex = _members.subList(_bandStart, _plus);
    return tileIndex;
  }

  private void productRecur(final Set<List<Boolean>> result, final int maxDim, final IntegerRange range, final List<Boolean> current) {
    int _size = current.size();
    boolean _equals = (maxDim == _size);
    if (_equals) {
      result.add(current);
      return;
    }
    boolean _contains = range.contains(current.size());
    if (_contains) {
      final ArrayList<Boolean> next = new ArrayList<Boolean>();
      next.addAll(current);
      next.add(Boolean.valueOf(true));
      this.productRecur(result, maxDim, range, next);
    }
    {
      final ArrayList<Boolean> next_1 = new ArrayList<Boolean>();
      next_1.addAll(current);
      next_1.add(Boolean.valueOf(false));
      this.productRecur(result, maxDim, range, next_1);
    }
    return;
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
    } else if (body instanceof RecursionBody) {
      return _code((RecursionBody)body);
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
