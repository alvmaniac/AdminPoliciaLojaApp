package com.adminPoliciaLoja.app.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Cripto {

	public static String encrypSHA256Code64(String originalString) {
		MessageDigest digest;
		byte[] encodedhash = null;
		String encodedString=null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			encodedString =Base64.getEncoder().encodeToString(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encodedString;
	}
	
	public static String bytesBase64(byte[] originalByte) {
		String encodedString =Base64.getEncoder().encodeToString(originalByte);
		return encodedString;
	}
	
	public static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	
	
	public static void main(String[] args) {
		String clave = "admin";
		System.out.println(encrypSHA256Code64(clave));
	}

}
