package org.polymodel.scop.cgenerator2.template;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.SingleAnnotation;
import org.polymodel.scop.annotation.VectorizationAnnotation;

@SuppressWarnings("all")
public class Xtend2_Annotation {
  protected CharSequence _annotationBeforeStatement(final IScopAnnotation ann) {
    return null;
  }
  
  protected CharSequence _annotationAfterStatement(final IScopAnnotation ann) {
    return null;
  }
  
  protected CharSequence _annotationBeforeStatement(final ParallelLoopAnnotation p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#pragma omp parallel for ");
    {
      int _size = p.getPrivates().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("private(");
        final Function1<String, CharSequence> _function = (String pp) -> {
          return pp.toString();
        };
        String _join = IterableExtensions.<String>join(p.getPrivates(), ",", _function);
        _builder.append(_join);
        _builder.append(")");
      }
    }
    {
      String _schedule = p.getSchedule();
      boolean _notEquals = (!Objects.equal(_schedule, null));
      if (_notEquals) {
        _builder.append(" schedule(");
        String _schedule_1 = p.getSchedule();
        _builder.append(_schedule_1);
        _builder.append(" ");
        {
          int _chunksize = p.getChunksize();
          boolean _greaterThan_1 = (_chunksize > 0);
          if (_greaterThan_1) {
            _builder.append(",");
            int _chunksize_1 = p.getChunksize();
            _builder.append(_chunksize_1);
          }
        }
        _builder.append(")");
      }
    }
    return _builder;
  }
  
  protected CharSequence _annotationBeforeStatement(final ParallelBlockAnnotation p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#pragma omp parallel ");
    {
      int _size = p.getPrivates().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("private(");
        final Function1<String, CharSequence> _function = (String pp) -> {
          return pp.toString();
        };
        String _join = IterableExtensions.<String>join(p.getPrivates(), ",", _function);
        _builder.append(_join);
        _builder.append(")");
      }
    }
    return _builder;
  }
  
  protected CharSequence _annotationBeforeStatement(final BarrierAnnotation b) {
    CharSequence _xifexpression = null;
    boolean _isBefore = b.isBefore();
    if (_isBefore) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#pragma omp barrier");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  protected CharSequence _annotationAfterStatement(final BarrierAnnotation b) {
    CharSequence _xifexpression = null;
    boolean _isBefore = b.isBefore();
    boolean _not = (!_isBefore);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#pragma omp barrier");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  protected CharSequence _annotationBeforeStatement(final VectorizationAnnotation v) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isIvdep = v.isIvdep();
      if (_isIvdep) {
        _builder.append("#pragma ivdep");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("#pragma vector always ");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _annotationBeforeStatement(final SingleAnnotation s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#pragma omp single");
    return _builder;
  }
  
  protected CharSequence _annotationBeforeStatement(final DescriptionAnnotation d) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//");
    String _description = d.getDescription();
    _builder.append(_description);
    return _builder;
  }
  
  public CharSequence annotationBeforeStatement(final IScopAnnotation b) {
    if (b instanceof BarrierAnnotation) {
      return _annotationBeforeStatement((BarrierAnnotation)b);
    } else if (b instanceof DescriptionAnnotation) {
      return _annotationBeforeStatement((DescriptionAnnotation)b);
    } else if (b instanceof ParallelBlockAnnotation) {
      return _annotationBeforeStatement((ParallelBlockAnnotation)b);
    } else if (b instanceof ParallelLoopAnnotation) {
      return _annotationBeforeStatement((ParallelLoopAnnotation)b);
    } else if (b instanceof SingleAnnotation) {
      return _annotationBeforeStatement((SingleAnnotation)b);
    } else if (b instanceof VectorizationAnnotation) {
      return _annotationBeforeStatement((VectorizationAnnotation)b);
    } else if (b != null) {
      return _annotationBeforeStatement(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
  
  public CharSequence annotationAfterStatement(final IScopAnnotation b) {
    if (b instanceof BarrierAnnotation) {
      return _annotationAfterStatement((BarrierAnnotation)b);
    } else if (b != null) {
      return _annotationAfterStatement(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
