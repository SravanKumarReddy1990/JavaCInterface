package net.isetjb.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class WordDocumentApp  {
	
	public static void main(String[] args) throws Exception {
	try 
        {
		String qrtext = "qrtext";

		//String text = "Hello World";
            String key = "Bir12345Bai12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(qrtext.getBytes());
            System.err.println(new String(encrypted));


		cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);


		ByteArrayOutputStream out = QRCode.from(new String(encrypted)).to(
				ImageType.PNG).stream();
		
		
	}
        catch(Exception e) 
        {
            e.printStackTrace();
        }
	}
}
