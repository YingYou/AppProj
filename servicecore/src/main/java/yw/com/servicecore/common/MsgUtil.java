package yw.com.servicecore.common;
 


import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
 
 public class MsgUtil
 {
	 private static Gson gson = new Gson();
	 static Logger log = Logger.getLogger("MsgUtil");
  
   public static <T> T str2Obj(String text,Class<T> c){
	   try{
		   return gson.fromJson(text, c);   
	   }catch(JsonSyntaxException e){
		   log.info("str2Obj error:"+e.getMessage());
	   }catch(JsonParseException e1){
		   log.info("obj2Str error e1:"+e1.getMessage());
	   }catch(Throwable e){
		   e.printStackTrace();
	   }
	   return null;
	   
//	   return str2Obj(text, c);
   }

   public static String obj2Str(Object o){
	   try{
		   return gson.toJson(o);
	   }catch(JsonSyntaxException e){
		   log.info("obj2Str error:"+e.getMessage());
	   }catch(JsonParseException e1){
		   log.info("obj2Str error:"+e1.getMessage());
	   }
	   return null;

   }


   
 }

