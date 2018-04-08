package com.textile083.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptUtil {

	public static String md5(String inputStr){
		BigInteger bigInteger=null;
		try{
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] inputData=inputStr.getBytes();
			md.update(inputData);
			bigInteger=new BigInteger(md.digest());
			bigInteger=bigInteger.abs();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bigInteger.toString(16);
	}
	public static void main(String[] args) {
		System.out.println(md5("0810110306"));
	}
}
