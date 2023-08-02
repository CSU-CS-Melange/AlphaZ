package org.polymodel.polyhedralIR.codegen.xtend2.MPIC;

import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.SingleAnnotation;
import org.polymodel.scop.annotation.VectorizationAnnotation;
import org.polymodel.scop.cgenerator2.template.Xtend2_Annotation;

@SuppressWarnings("all")
public class CAnnotationForMPIC extends Xtend2_Annotation {
  @Override
  protected CharSequence _annotationBeforeStatement(final BarrierAnnotation ba) {
    CharSequence _xifexpression = null;
    boolean _isBefore = ba.isBefore();
    if (_isBefore) {
      CharSequence _xifexpression_1 = null;
      int _type = ba.getType();
      boolean _equals = (_type == 0);
      if (_equals) {
        _xifexpression_1 = super.annotationBeforeStatement(ba);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("MPI_Barrier(MPI_COMM_WORLD);");
        _xifexpression_1 = _builder;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  @Override
  protected CharSequence _annotationAfterStatement(final BarrierAnnotation ba) {
    CharSequence _xifexpression = null;
    boolean _isBefore = ba.isBefore();
    boolean _not = (!_isBefore);
    if (_not) {
      CharSequence _xifexpression_1 = null;
      int _type = ba.getType();
      boolean _equals = (_type == 0);
      if (_equals) {
        _xifexpression_1 = super.annotationBeforeStatement(ba);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("MPI_Barrier(MPI_COMM_WORLD);");
        _xifexpression_1 = _builder;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  @Override
  public CharSequence annotationBeforeStatement(final IScopAnnotation ba) {
    if (ba instanceof BarrierAnnotation) {
      return _annotationBeforeStatement((BarrierAnnotation)ba);
    } else if (ba instanceof DescriptionAnnotation) {
      return _annotationBeforeStatement((DescriptionAnnotation)ba);
    } else if (ba instanceof ParallelBlockAnnotation) {
      return _annotationBeforeStatement((ParallelBlockAnnotation)ba);
    } else if (ba instanceof ParallelLoopAnnotation) {
      return _annotationBeforeStatement((ParallelLoopAnnotation)ba);
    } else if (ba instanceof SingleAnnotation) {
      return _annotationBeforeStatement((SingleAnnotation)ba);
    } else if (ba instanceof VectorizationAnnotation) {
      return _annotationBeforeStatement((VectorizationAnnotation)ba);
    } else if (ba != null) {
      return _annotationBeforeStatement(ba);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ba).toString());
    }
  }

  @Override
  public CharSequence annotationAfterStatement(final IScopAnnotation ba) {
    if (ba instanceof BarrierAnnotation) {
      return _annotationAfterStatement((BarrierAnnotation)ba);
    } else if (ba != null) {
      return _annotationAfterStatement(ba);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ba).toString());
    }
  }
}
