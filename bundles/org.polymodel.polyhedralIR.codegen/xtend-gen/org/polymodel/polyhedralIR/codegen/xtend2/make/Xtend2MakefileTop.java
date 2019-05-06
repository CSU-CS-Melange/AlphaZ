package org.polymodel.polyhedralIR.codegen.xtend2.make;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.codegen.xtend2.make.BaseMakefile;

@SuppressWarnings("all")
public class Xtend2MakefileTop {
  @Inject
  @Extension
  private BaseMakefile extensions;
  
  public Map<String, String> generate(final AffineSystem system, final List<AffineSystem> systems, final boolean omp) {
    return this.extensions.generate(system, systems, omp);
  }
}
