package de.mwe.dev.crypto.symmetric;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class SymmetricEncryptionUtils {
	private static final String AES = "AES";
	
	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	
	public static SecretKey createAESKey() throws Exception{
		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		keyGenerator.init(256, secureRandom);
		return keyGenerator.generateKey();
	}
	
	public static byte[] createInitVec() {
		byte[] initVec = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(initVec);
		return initVec;
	}

	public static byte[] performAESEncryption(String plainText, byte[] initVec, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initVec);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		return cipher.doFinal(plainText.getBytes());		
	}
	
	public static String performAESDecryption(byte[] cipherText, byte[] initVec, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initVec);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		return new String(cipher.doFinal(cipherText));		
	}
	

}
