package com.onebookshop.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

   @Autowired
   private Environment env;

   private static Environment environment;

   @PostConstruct
   public void init(){
     environment = env;
   }

   public static String getPropertyValue(String property){
      return null != environment.getProperty(property) ? environment.getProperty(property) : "" ;
   }
}