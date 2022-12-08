/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group15.ltm_project.DTO;

/**
 *
 * @author baoluan
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA_decript {

    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
            try {
                byte[] b;
                try ( 
                    // Đọc file chứa private key
                    FileInputStream fis = new FileInputStream("../LTM_Project/src/main/java/KeyStore/RSA/privatekey")) {
                    b = new byte[fis.available()];
                    fis.read(b);
                }

                    // Tạo private key
                    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
                    KeyFactory factory = KeyFactory.getInstance("RSA");
                    PrivateKey priKey = factory.generatePrivate(spec);

                    // Giải mã dữ liệu
                    Cipher c = Cipher.getInstance("RSA");
                    c.init(Cipher.DECRYPT_MODE, priKey);
                    byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                                    "WsPJqFcfB9kMOM7y3tJvRBcdy7iPVE6sCGF6D0aI4Gc909jW8TVlqTtghQe7hKA4taKuRtEfb8zYG63AD7pclQ4v8tI6mUxGPE46Cpmvf9/Q3ucfy789sTComBv5+KuS1o4mTHV8FP9wQ9KQxMs9zXSpKxUlTz6co3w0eN9l3hM="));
                    System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
            } catch (IOException e) {
                    System.out.println(e.getMessage());
            }
    }
}
