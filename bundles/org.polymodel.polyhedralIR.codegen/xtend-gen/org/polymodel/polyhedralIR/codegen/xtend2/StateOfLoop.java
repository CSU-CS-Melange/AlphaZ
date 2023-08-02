package org.polymodel.polyhedralIR.codegen.xtend2;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Used to keep track of the start of loop generation and end of loop generation
 * so that for while systems we can generate a infinite loop containing all the
 * loops generated as the body of the infinite loop
 */
@SuppressWarnings("all")
public class StateOfLoop {
  @Accessors
  private boolean firstLoop;

  @Accessors
  private boolean lastLoop;

  public StateOfLoop(final boolean firstLoop, final boolean lastLoop) {
    this.firstLoop = firstLoop;
    this.lastLoop = lastLoop;
  }

  @Pure
  public boolean isFirstLoop() {
    return this.firstLoop;
  }

  public void setFirstLoop(final boolean firstLoop) {
    this.firstLoop = firstLoop;
  }

  @Pure
  public boolean isLastLoop() {
    return this.lastLoop;
  }

  public void setLastLoop(final boolean lastLoop) {
    this.lastLoop = lastLoop;
  }
}
