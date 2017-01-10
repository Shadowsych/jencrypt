package com.pravat.jencrypt;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class JEncrypt {
	/*
	 * @author Pravat Bhusal
	 * The hashes are UTF_8 encoding
	 */
	
	//working directory of the java file
	public static String workingDir = System.getProperty("user.dir");
	
	public static void main(String[] args)
	{
	}
	
	public String encryptMD5(String passwordText) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(StandardCharsets.UTF_8.encode(passwordText));
		return String.format("%032x", new BigInteger(1, md5.digest()));
	}
	public String encryptBase64(String passwordText)
	{
		byte[] bytesEncoded = Base64.encodeBase64(passwordText.getBytes());
		return new String(bytesEncoded);
	}
	public String decryptBase64(String passwordText)
	{
		byte[] valueDecoded= Base64.decodeBase64(passwordText);
		return new String(valueDecoded);
	}
	public String encryptSHA1(String passwordText) throws NoSuchAlgorithmException
	{
		return org.apache.commons.codec.digest.DigestUtils.sha1Hex(passwordText);
	}
	public String encryptSHA256 (String passwordText) throws NoSuchAlgorithmException
	{
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(passwordText);   
	}
	public String encryptSHA384 (String passwordText) throws NoSuchAlgorithmException
	{
		return org.apache.commons.codec.digest.DigestUtils.sha384Hex(passwordText);
	}
	public String encryptSHA512(String passwordText, String salt) throws UnsupportedEncodingException{
		String generatedPassword = null;
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         md.update(salt.getBytes("UTF-8"));
		         byte[] bytes = md.digest(passwordText.getBytes("UTF-8"));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		        } 
		       catch (NoSuchAlgorithmException e){
		        e.printStackTrace();
		       }
		    return generatedPassword;
		}

}
