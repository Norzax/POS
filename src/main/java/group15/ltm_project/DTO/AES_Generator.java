/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group15.ltm_project.DTO;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author baoluan
 */
public class AES_Generator {
    
    public String encrypt(String strToEncrypt, PrivateKey myKey) {
        try {
                MessageDigest sha = MessageDigest.getInstance("SHA-1");
                byte[] key = myKey.getEncoded();
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16);
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                System.out.println(e.toString());
        }
        return null;
    }
    
    public String decrypt(String strToDecrypt, PublicKey myKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
        try {
                MessageDigest sha = MessageDigest.getInstance("SHA-1");
                byte[] key = myKey.getEncoded();
                key = sha.digest(key);
                key = Arrays.copyOf(key, 16);
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AES_Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args)  {
//        String secretKey = "TVD";
        String originalString = "teamvietdev.com";
//
//        AES_Generator test = new AES_Generator();
//        String encryptedString = test.encrypt(originalString, secretKey);
//        System.out.println("Encrypt: " + encryptedString);
//        String decryptedString = null;
//        try {
//            decryptedString = test.decrypt(encryptedString, secretKey);
//        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException ex) {
//            Logger.getLogger(AES_Generator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Decrypt: " + decryptedString);
    }
}
