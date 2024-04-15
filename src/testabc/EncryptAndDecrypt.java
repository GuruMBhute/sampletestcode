package testabc;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAndDecrypt {
	public static void main(String[] args) throws Exception {
		String originalText = "Hello, AES!";
		System.out.println("Original Text: " + originalText);

		SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();;
        System.out.println("secretKey : "+secretKey);
		System.out.println("secretKey : "+Base64.getEncoder().encodeToString(secretKey.getEncoded()));

		
		// Encrypt
		String encryptedText = encrypt(originalText, secretKey);
		System.out.println("Encrypted Text: " + encryptedText);

		// Decrypt
		String decryptedText = decrypt(encryptedText, secretKey);
		System.out.println("Decrypted Text: " + decryptedText);
	}

	public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
		return new String(decryptedBytes);
	}

	}
