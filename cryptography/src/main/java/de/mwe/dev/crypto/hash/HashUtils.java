package de.mwe.dev.crypto.hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashUtils {

	private static final String SHA2_ALGORITHM = "SHA-256";
	
	public static byte[] generateRandomSalt() {
		byte[] salt = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		return salt;
	}
	
	public static byte[] createSHA2Hash(String input, byte[] salt) throws Exception{		
		// concat salt + input (salt is used for additional randomnes, need to be stored!)
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byteStream.write(salt);
		byteStream.write(input.getBytes());
		byte[] valueToHash = byteStream.toByteArray();
		
		MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALGORITHM);
		return messageDigest.digest(valueToHash);
	}
}
