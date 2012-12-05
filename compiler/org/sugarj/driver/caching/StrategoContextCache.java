package org.sugarj.driver.caching;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strategoxt.lang.Context;
import org.sugarj.util.Pair;

/**
 * Manages instances of org.strategoxt.lang.Context to enable
 *   reuse and exclusive access.
 * 
 * @author seba
 */
public class StrategoContextCache {

  /**
   * Class represents the actual type of the context,
   * first List denotes currently used contexts,
   * second List denotes currently unused contexts.
   */
  private final Map<Class<?>, Pair<? extends List<Context>, ? extends List<Context>>> cache
    = new HashMap<Class<?>, Pair<? extends List<Context>,? extends List<Context>>>();
  
  private final Map<Class<? extends Context>, Class<?>> ctxToInit = new HashMap<Class<? extends Context>, Class<?>>();
  
  /**
   * Retrieves a free context from the cache or generates a new one.
   * 
   * @param purpose
   * @return a context of the given actual type.
   */
  public synchronized Context acquireContext(Class<?> initType) {
    Pair<? extends List<Context>,? extends List<Context>> p = cache.get(initType);
    if (p == null)
      p = Pair.create(new ArrayList<Context>(), new ArrayList<Context>());
    
    Context fresh;
    if (p.b.isEmpty())
      try {
        fresh = (Context) initType.getMethod("init").invoke(initType);
      } catch (IllegalAccessException e) {
        throw new IllegalArgumentException("Illegal actual type " + initType, e);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Illegal actual type " + initType, e);
      } catch (InvocationTargetException e) {
        throw new IllegalArgumentException("Illegal actual type " + initType, e);
      } catch (NoSuchMethodException e) {
        throw new IllegalArgumentException("Illegal actual type " + initType, e);
      } catch (SecurityException e) {
        throw new IllegalArgumentException("Illegal actual type " + initType, e);
      }
    else
      fresh = p.b.remove(0);
    
    p.a.add(fresh);
    ctxToInit.put(fresh.getClass(), initType);
    
    return fresh;
  }
  
  /**
   * Releases a previously acquired context.
   */
  public synchronized void releaseContext(Context ctx) {
    Class<?> initType = ctxToInit.get(ctx.getClass());
    
    Pair<? extends List<Context>,? extends List<Context>> p = cache.get(initType);
    if (p == null || !p.a.contains(ctx))
      throw new IllegalArgumentException("unknown context from initializer " + initType);
    
    p.a.remove(ctx);
    p.b.add(ctx);
  }
}
