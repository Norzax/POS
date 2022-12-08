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
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA_encript {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            byte[] b;
            try ( 
                // Đọc file chứa public key
                FileInputStream fis = new FileInputStream("../LTM_Project/src/main/java/KeyStore/RSA/pulickey")) {
                b = new byte[fis.available()];
                fis.read(b);
            }

            // Tạo public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);
            
            System.out.println(pubKey);
            
            // Mã hoá dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pubKey);
            String msg = "helloworld";
            byte encryptOut[] = c.doFinal(msg.getBytes());
            String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
            System.out.println("Chuỗi sau khi mã hoá: " + strEncrypt);
        } catch (IOException e) {
                System.out.println(e.getMessage());
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException ex) {
            Logger.getLogger(RSA_encript.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
