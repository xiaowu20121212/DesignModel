package com.company.secret;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.*;
import java.util.Base64;

public class RSADemo {
    //指定的加密算法
    private static String ALGORIHM = "RSA";
    //指定的key大小
    private static int KEY_SIZE = 1024;
    private static String PUBLIC_KEY_FILE = "public.keystore";
    private static String PRIVATE_KE_FILE = "private_keystore";

    /**
     * 声明密钥对并写入文件中
     * @throws Exception
     */
    private static void generateKeyPair() throws Exception {
        //RSA算法妖气一个可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORIHM);
        //利用上面的随机数据源初始化这个KeyPairGenerator
        keyPairGenerator.initialize(KEY_SIZE, secureRandom);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //通过密钥对得到公钥
        Key publicKey = keyPair.getPublic();
        //通过密钥对得到私钥
        Key privateKey = keyPair.getPrivate();

        ObjectOutputStream objectOutputStream1 =  new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KE_FILE));
        objectOutputStream1.writeObject(publicKey);
        objectOutputStream2.writeObject(privateKey);
        objectOutputStream1.close();
        objectOutputStream2.close();
    }

    private static String encrypt(String data) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
        Key key = (Key) objectInputStream.readObject();
        objectInputStream.close();
        //得到Cipher对象来实现对数据源的RSA加密操作
        Cipher cipher = Cipher.getInstance(ALGORIHM);
        //利用key进行初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //对原数据进行加密操作并进行Base64编码
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));//Base64编码方法要求把每三个8Bit的字节转换为四个6Bit的字节
    }

    private static String decrypt(String data) throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KE_FILE));
        Key key = (Key) objectInputStream.readObject();
        //得到Cipher对象来实现对数据源的RSA加密操作
        Cipher cipher = Cipher.getInstance(ALGORIHM);
        //利用key进行初始化
        cipher.init(Cipher.DECRYPT_MODE, key);
        //先进行Base64解码再进行解密操作
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void main(String[] args) throws Exception{
        generateKeyPair();
        String source = "hello , i am 小武";
        System.out.println("source: " + source);
        String encryptSource = encrypt(source);
        System.out.println("encryptSource: " + encryptSource);
        String decryptSource = decrypt(encryptSource);
        System.out.println("decryptSource:" + decryptSource);





    }
}
