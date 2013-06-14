package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class constraint_error_0_0 extends Strategy 
{ 
  public static constraint_error_0_0 instance = new constraint_error_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail30:
    { 
      if(true)
        break Fail30;
      if(true)
        return term;
    }
    context.push("constraint_error_0_0");
    context.popOnFailure();
    return null;
  }
}