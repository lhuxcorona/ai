package com.maxcom.ai.log;

import org.apache.log4j.Logger;


/**
*AppLogger
*
*Bitácoras de la aplicación  
*
*Versión 1.0
*
*Septiembre 2012
*
*/
public class AppLogger{

  private static Logger app      = null;
  private static Logger errores   = null;
  
  private AppLogger(){}
  
  /**
	 *  Inicia bitácoras
	 *  
	 * @param loggerType tipo de log
	 * @param log settea a log
	 * 
	 * 
	*/
  public static void setLogger(String loggerType,Logger log){
    if(loggerType.equalsIgnoreCase("app")){
        if( app == null){
          app = log;
        }
    }else if(loggerType.equalsIgnoreCase("errores")){
        if( errores == null){
          errores = log;
        }
    }
  }
  
  /**
	 * Bitácora de tipo información
	 *  
	 * @param msg el mensaje de la bitácora 
	 * 
	*/
  public static void info(Object msg){
      info("app",msg);
  }
  
  /**
	 * Bitácora de tipo información
	 *  
	 * @param logger El tipo de log 
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void info(String logger,Object msg){
      Logger log = app;
      if(logger.equalsIgnoreCase("errores") ){
        log = errores;
      }
      if(log!=null){
        log.info(msg);
      }else{
        System.out.println("[INFO] - " + msg.toString());
      }
  }  
  
  /**
	 * Bitácora de tipo error
	 *  
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void error(Object msg){
    error("app",msg);
  }
  
  /**
	 * Bitácora de tipo error
	 *  
	 * @param logger El tipo de log 
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void error(String logger,Object msg){
      Logger log = app;
      if(logger.equalsIgnoreCase("errores")){
        log = errores;
      }
      if(log!=null){
        log.error(msg);
      }else{
        System.out.println("[ERROR] - " + msg.toString());
      }
  }

  /**
	 * Bitácora de tipo warn
	 *  
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void warn(Object msg){
      warn("app",msg);
  }
  
  /**
	 * Bitácora de tipo warn
	 *  
	 * @param logger El tipo de log 
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void warn(String logger,Object msg){
      Logger log = app;
      if(logger.equalsIgnoreCase("errores")){
        log = errores;
      }
      if(log!=null){
        log.warn(msg);
      }else{
        System.out.println("[WARN] - " + msg.toString());
      }
  }
  /**
	 * Bitácora de tipo debug
	 *  
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void debug(Object msg){
    debug("app",msg);
  }
  
  /**
	 * Bitácora de tipo debug
	 *  
	 * @param logger El tipo de log 
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void debug(String logger,Object msg){
      Logger log = app;
      if(logger.equalsIgnoreCase("errores")){
        log = errores;
      }
      if(log!=null){
        log.debug(msg);
      }else{
        System.out.println("[DEBUG] - " + msg.toString());
      }
  }
  /**
	 * Bitácora de tipo fatal
	 *   
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void fatal(Object msg){
      fatal("app",msg);
  }  
  
  /**
	 * Bitácora de tipo fatal
	 *  
	 * @param logger El tipo de log 
	 * @param msg El mensaje de la bitácora 
	 * 
	*/
  public static void fatal(String logger,Object msg){
      Logger log = app;
      if(logger.equalsIgnoreCase("errores") ){
        log = errores;
      }      if(log!=null){
        log.fatal(msg);
      }else{
        System.out.println("[FATAL] - " + msg.toString());
      }
  }
}