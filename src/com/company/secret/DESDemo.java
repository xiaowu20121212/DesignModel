package com.company.secret;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 对称加密：加密（encryption）与解密（decryption）用的是同样的密钥（secret key
 */
public class DESDemo {
    //算法名称
    public static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式
    //des共有四种工作模式-》ECB:电子密码本模式  CBC:加密分组链接模式  CFB:加密反馈模式
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    private static SecretKey keyGenerator(String keyStr) throws Exception {
        byte input[] = HexString2Bytes(keyStr);
        DESKeySpec desKey = new DESKeySpec(input);
        //创建一个密匙工厂，然后用它吧DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(desKey);
        return secretKey;
    }

    private static int parse(char c) {
        if (c >= 'a') {
            return (c - 'a' + 10) & 0x0f;  //0x0f表示一个字节  对应二进制表示方式00001111
        }
        if (c >= 'A') {
            return (c - 'A' + 10) & 0x0f;
        }
        return (c - '0') & 0x0f;
    }


    //从十六进制字符串到字节数组转换
    private static byte[] HexString2Bytes(String hexStr) {
        byte[] b = new byte[hexStr.length() / 2];  //length表示字符数量
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexStr.charAt(j++);
            char c1 = hexStr.charAt(j++);
//            System.out.println("c0:" + c0 + " c1:" + c1);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }


    /**
     * 加密数据
     * @param data 待加密数据
     * @param key 密钥
     * @return 加密后的数据
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        Key desKey = keyGenerator(key);
        //实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();
        //初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, desKey, random);
        byte[] results  = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(results);//Base64编码方法要求把每三个8Bit的字节转换为四个6Bit的字节
    }


    public static String decrypt (String data, String key) throws Exception {
        Key desKey = keyGenerator(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void main(String[] args) throws Exception{
        String source = "hello , i am 小武a";
        System.out.println("source:" + source);
        String key = "A1B2C3D4E5F60708";
        String encryptData = encrypt(source, key);
        System.out.println("encryptData:" + encryptData);
        String decryptData = decrypt(encryptData, key);
        System.out.println("decryptData:" + decryptData);

        //对Base64测试
        System.out.println("decryptData.length():" + decryptData.length());
        System.out.println("decryptData.getBytes().length:" + decryptData.getBytes().length);
        System.out.println("decryptData.chat(14):" + decryptData.charAt(14));
        String encodeStr = Base64.getEncoder().encodeToString(decryptData.getBytes());//19个字节不够3整除，所以补上2字节变成21字节 encode后每3个字节增加一个字节，所以结果长度变成28
        System.out.println("encodeStr:" + encodeStr);
        int length = encodeStr.getBytes().length;
        System.out.println("Base64.encode length:" + length);
        String decodeStr = new String(Base64.getDecoder().decode(encodeStr));
        System.out.println("decodeStr:" + decodeStr);

    }
}
