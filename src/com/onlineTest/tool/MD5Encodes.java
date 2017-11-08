package com.onlineTest.tool;

import java.security.MessageDigest;
/**
 * 用于做MD5加密
 * 创建日期 ：2017年9月21日
 * 项目名字：在线考试
 * 包名：com.onlineTest.tool
 * 类名：MD5Encodes.java
 */
public class MD5Encodes {
     public String EncodeByMD5(String password){
    	  char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; 
    	 try{
    		   byte[] strTemp=password.getBytes();
    		   MessageDigest mdTemp=MessageDigest.getInstance("MD5");
    		   mdTemp.update(strTemp);
    		   byte[] md=mdTemp.digest();
    		   int j=md.length;
    		   char str[]=new char[j*2];
    		   int k=0;
    		   for(int i=0;i<j;i++){
    			   byte b=md[i];
    			   str[k++]=hexDigits[b>>4&0xf];
    			   str[k++]=hexDigits[b&0xf];
    		   }
    		   return new String(str);
    	   }catch(Exception e){
    		   return null;
    	   }
     }
}
