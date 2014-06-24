package uk.co.edgeorgedev.lumber;


/**
 * Root of Logging interface
 * @author edgeorge
 * @version 1.0
 * @since 2014-06-23
 */

public interface Stump {
  /** Log a verbose message */
  void v(Class<?> clazz, String message);
  
  void v(Class<?> clazz, Throwable th);
  
  //v,d,i,w,e,wtf
}