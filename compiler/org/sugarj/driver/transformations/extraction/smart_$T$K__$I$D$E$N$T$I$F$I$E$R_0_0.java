package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class smart_$T$K__$I$D$E$N$T$I$F$I$E$R_0_0 extends Strategy 
{ 
  public static smart_$T$K__$I$D$E$N$T$I$F$I$E$R_0_0 instance = new smart_$T$K__$I$D$E$N$T$I$F$I$E$R_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("smart_TK__IDENTIFIER_0_0");
    Fail408:
    { 
      IStrategoTerm k_137 = null;
      IStrategoTerm o_137 = null;
      IStrategoTerm q_137 = null;
      term = try_1_0.instance.invoke(context, extraction.constNil0, lifted141.instance);
      if(term == null)
        break Fail408;
      k_137 = term;
      o_137 = extraction.constNil0;
      term = context.invokePrimitive("SUGARJ_unsafe_build", o_137, NO_STRATEGIES, new IStrategoTerm[]{extraction.const395});
      if(term == null)
        break Fail408;
      q_137 = term;
      term = build_alt_sort_or_fail_0_0.instance.invoke(context, k_137);
      if(term == null)
        break Fail408;
      term = put_syntax_sort_0_1.instance.invoke(context, q_137, term);
      if(term == null)
        break Fail408;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}