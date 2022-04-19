package de.mwe.dev.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

class HashUtilsTest {

	@Test
	void testGenerateRandomSalt() {
		byte[] salt = HashUtils.generateRandomSalt();
		assertNotNull(salt);
		System.out.println("salt: " + DatatypeConverter.printHexBinary(salt));
	}
	
	@Test
	void testCreateSHA2Hash() throws Exception {
		byte[] salt = HashUtils.generateRandomSalt();
		String valueToHash = UUID.randomUUID().toString();
		byte[] hash = HashUtils.createSHA2Hash(valueToHash, salt);
		assertNotNull(hash);
		System.out.println("hash: " + DatatypeConverter.printHexBinary(hash));
		
		byte[] hash2 = HashUtils.createSHA2Hash(valueToHash, salt);
		assertEquals(DatatypeConverter.printHexBinary(hash), DatatypeConverter.printHexBinary(hash2));
	}
}