package de.mwe.dev.crypto.asymmetric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.KeyPair;

import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

class AsymmetricEncryptionUtilsTest {

	@Test
	void testRSAKeyGen() throws Exception {
		KeyPair key = AsymmetricEncryptionUtils.generateRSAKeyPair();
		assertNotNull(key);
		System.out.println("private Key: " + DatatypeConverter.printHexBinary(key.getPrivate().getEncoded()));
		System.out.println("public Key:  " + DatatypeConverter.printHexBinary(key.getPublic().getEncoded()));
	}

	@Test
	void testRSACryptoRoutine() throws Exception {
		KeyPair key = AsymmetricEncryptionUtils.generateRSAKeyPair();
		String plainText = "This is the test to hide!";
		
		byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(plainText, key.getPrivate());
		assertNotNull(cipherText);
		System.out.println("encrypted text: " + DatatypeConverter.printHexBinary(cipherText));
		
		String decryptedText = AsymmetricEncryptionUtils.performRSADecryption(cipherText, key.getPublic());
		assertEquals(plainText, decryptedText);		
	}	
}
