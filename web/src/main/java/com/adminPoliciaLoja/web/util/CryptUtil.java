package com.adminPoliciaLoja.web.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import com.adminPoliciaLoja.app.common.VariablesStatic;

public class CryptUtil {
    
	public static String encriptar(String texto) {
        String base64EncryptedString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(VariablesStatic.LLAVE_MD5.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
            base64EncryptedString = URLEncoder.encode(base64EncryptedString, "UTF-8");
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    public static String desencriptar(String textoEncriptado) throws Exception {
        String base64EncryptedString = null;
        try {
//        	textoEncriptado = URLDecoder.decode(textoEncriptado, "UTF-8");
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(VariablesStatic.LLAVE_MD5.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            base64EncryptedString = new String(plainText, "UTF-8");
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
    
    public static void main(String[] args) {
		try {
			String text = "74&false";
			String textEnc=encriptar(text);
			String textDesenc=desencriptar(URLDecoder.decode(textEnc, "UTF-8"));
			System.out.println(textEnc);
			System.out.println(textDesenc);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
