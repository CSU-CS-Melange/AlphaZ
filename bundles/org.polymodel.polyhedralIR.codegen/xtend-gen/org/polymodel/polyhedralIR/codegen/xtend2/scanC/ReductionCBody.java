package org.polymodel.polyhedralIR.codegen.xtend2.scanC;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;

@SuppressWarnings("all")
public class ReductionCBody extends ScanCBody {
  @Inject
  @Extension
  private BaseMemoryAllocation malloc;

  @Override
  protected CharSequence _code(final ScanBody b) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBounds(int) is undefined for the type Domain"
      + "\nThe method getBounds(int) is undefined for the type Domain"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved");
  }

  @Override
  public CharSequence code(final Body b) {
    if (b instanceof TiledCLoop) {
      return _code((TiledCLoop)b);
    } else if (b instanceof CustomPackStruct) {
      return _code((CustomPackStruct)b);
    } else if (b instanceof PackStruct) {
      return _code((PackStruct)b);
    } else if (b instanceof UnpackStruct) {
      return _code((UnpackStruct)b);
    } else if (b instanceof BasicBody) {
      return _code((BasicBody)b);
    } else if (b instanceof ParameterCheck) {
      return _code((ParameterCheck)b);
    } else if (b instanceof BoundComputation) {
      return _code((BoundComputation)b);
    } else if (b instanceof OriginDomainVolume) {
      return _code((OriginDomainVolume)b);
    } else if (b instanceof ScanBody) {
      return _code((ScanBody)b);
    } else if (b instanceof VolumeFunction) {
      return _code((VolumeFunction)b);
    } else if (b instanceof VolumeFunctionDerivative) {
      return _code((VolumeFunctionDerivative)b);
    } else if (b instanceof FlagVariableReset) {
      return _code((FlagVariableReset)b);
    } else if (b instanceof Loop) {
      return _code((Loop)b);
    } else if (b instanceof VariableFinalization) {
      return _code((VariableFinalization)b);
    } else if (b instanceof VariableInitialization) {
      return _code((VariableInitialization)b);
    } else if (b != null) {
      return _code(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
