package testabc;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class Encrypt {

	public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		// Generate a secret key
		SecretKey secretKey;
		String encryptedBase64="";
		try {
			secretKey = KeyGenerator.getInstance("AES").generateKey();

			System.out.println("secretKey : "+secretKey);
			System.out.println("secretKey : "+Base64.getEncoder().encodeToString(secretKey.getEncoded()));
			// Create a Cipher object and initialize it for encryption
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);


			// Encrypt the data
			byte[] encryptedData = cipher.doFinal("guru123".getBytes(StandardCharsets.UTF_8));

			// Convert the encrypted data to Base64 for better handling
			encryptedBase64 = Base64.getEncoder().encodeToString(encryptedData);

			System.out.println("encryptedBase64 : "+encryptedBase64);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
