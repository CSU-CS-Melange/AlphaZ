package org.polymodel.polyhedralIR.codegen.xtend2;

import com.google.inject.Inject;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Extension;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;

@SuppressWarnings("all")
public class Xtend2CodeGenTop {
  @Inject
  @Extension
  private BaseCompilationUnit extensions;

  public Map<String, String> generate(final CompilationUnit unit) {
    return this.extensions.generate(unit);
  }
}
