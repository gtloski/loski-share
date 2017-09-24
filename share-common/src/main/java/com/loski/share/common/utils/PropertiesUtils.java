package com.loski.share.common.utils;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtils {

   public static ResourceBundle getResourceBundle(String baseName, Locale locale) {
       ClassLoader loader = Thread.currentThread().getContextClassLoader();
       ResourceBundle rs = ResourceBundle.getBundle(baseName, locale, loader);
       return rs;
   }
   
  public static ResourceBundle getResourceBundle(String baseName) {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      Locale locale = Locale.getDefault();
      ResourceBundle rs = ResourceBundle.getBundle(baseName, locale, loader);
      return rs;
  }
  
  public static String getStringFromBundle(String key, String baseName) {
      ResourceBundle rs = getResourceBundle(baseName);
      String txt = null;
      if (rs != null) {
          txt = rs.getString(key);
      }
      return txt;
  }
  
  public static String getStringFromBundle(String key, String baseName, Locale locale) {
      ResourceBundle rs = getResourceBundle(baseName, locale);
      String txt = null;
      if (rs != null) {
          txt = rs.getString(key);
      }
      return txt;
  }
  
  public static Properties getProperties(String filePath){
	  
	  Properties properties = new Properties();
	  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	  InputStream is = classloader.getResourceAsStream(filePath);
	try {
		properties.load(is);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return properties;
  }
  
  public static String getStringProperties(String filePath, String propertiesName){
	  Properties properties = getProperties(filePath);
	  return properties.getProperty(propertiesName);
  }
}
