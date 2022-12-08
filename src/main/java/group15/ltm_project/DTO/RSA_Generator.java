package group15.ltm_project.DTO;

//public static final String PUBLIC_KEY = "../LTM_Project/src/main/java/KeyStore/RSA/pulickey";
//    public static final String PRIVATE_KEY = "../LTM_Project/src/main/java/KeyStore/RSA/privatekey";
/**
 *
 * @author baoluan
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class RSA_Generator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        try {
            SecureRandom sr = new SecureRandom();
            // Thuật toán phát sinh khóa - RSA
            // Độ dài khóa 1024(bits), độ dài khóa này quyết định đến độ an toàn của khóa, càng lớn thì càng an toàn
        // Demo chỉ sử dụng 1024 bit. Nhưng theo khuyến cáo thì độ dài khóa nên tối thiểu là 2048
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024, sr);

            // Khởi tạo cặp khóa
            KeyPair kp = kpg.genKeyPair();
            // PublicKey
            PublicKey publicKey = kp.getPublic();
            // PrivateKey
            PrivateKey privateKey = kp.getPrivate();

            File publicKeyFile = createKeyFile(new File("../LTM_Project/src/main/java/KeyStore/RSA/pulickey"));
            File privateKeyFile = createKeyFile(new File("../LTM_Project/src/main/java/KeyStore/RSA/privatekey"));

            // Lưu Public Key
            FileOutputStream fos = new FileOutputStream(publicKeyFile);
            fos.write(publicKey.getEncoded());
            fos.close();

            // Lưu Private Key
            fos = new FileOutputStream(privateKeyFile);
            fos.write(privateKey.getEncoded());
            fos.close();

            System.out.println("Generate key successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static File createKeyFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        return file;
    }
}
