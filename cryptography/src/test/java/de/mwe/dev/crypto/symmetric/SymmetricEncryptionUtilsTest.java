package de.mwe.dev.crypto.symmetric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

class SymmetricEncryptionUtilsTest {

	@Test
	void testCreateAESKey() throws Exception {
		SecretKey key = SymmetricEncryptionUtils.createAESKey();
		assertNotNull(key);
		System.out.println("symmetric Key:  " + DatatypeConverter.printHexBinary(key.getEncoded()));
	}
	
	@Test
	void testAESCryptoRoutine() throws Exception {
		SecretKey key = SymmetricEncryptionUtils.createAESKey();
		byte[] initVec = SymmetricEncryptionUtils.createInitVec();
		String plainText = "Text to hide!";
		
		byte[] cipherText = SymmetricEncryptionUtils.performAESEncryption(plainText, initVec, key);
		assertNotNull(cipherText);
		System.out.println("Encrypted Text: " + DatatypeConverter.printHexBinary(cipherText));
		
		String decryptedText = SymmetricEncryptionUtils.performAESDecryption(cipherText, initVec, key);
		assertEquals(plainText, decryptedText);
		
		
	}
	
	
	

}
