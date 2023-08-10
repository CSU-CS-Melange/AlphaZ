package org.polymodel.polyhedralIR.codegen.xtend2.make;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.AffineSystem;

@SuppressWarnings("all")
public class Xtend2ABFTMakefileTop {
  @Inject
  @Extension
  private ABFTMakefile extensions;
  
  public Map<String, String> generate(final AffineSystem system, final List<AffineSystem> systems) {
    return this.extensions.generate(system, systems, false, false);
  }
}
