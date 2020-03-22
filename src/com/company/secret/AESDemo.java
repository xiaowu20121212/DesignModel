package com.company.secret;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESDemo {
    //算法名称
    public static final String KEY_ALGORITHM = "AES";

    private static int KEY_SIZE = 128;

    /**
     * 生成AES密钥
     * @param key
     * @return
     * @throws Exception
     */
    private static SecretKeySpec keyGenerator(String key) throws Exception{
        //获取密钥生成器对象
        KeyGenerator instance = KeyGenerator.getInstance(KEY_ALGORITHM);
        /**
         * SecureRandom不能new对象 实现完全随操作系统本身的內部状态，除非调用方在调用 getInstance 方法，然后调用 setSeed 方法；该实现在 windows 上每次生成的 key 都相同，但是在 solaris 或部分 linux 系统上则不同。关于SecureRandom类的详细介绍，见 http://yangzb.iteye.com/blog/325264
         */
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");//修改后
        //设置密钥随机数源的密钥key
        random.setSeed(key.getBytes());
        //初始化密钥生成器
        instance.init(KEY_SIZE,random);
        //获取原始对称密钥
        SecretKey secretKey = instance.generateKey();
        //根据字节数据生成AES密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }

    private static String encrypt(String data, String key) throws Exception{
        //根据密钥数据，得到密钥
        SecretKeySpec secretKeySpec = keyGenerator(key);
        //数据加密操作对象
        Cipher instance = Cipher.getInstance(KEY_ALGORITHM);
        //初始化密钥操作对象，并设置指定的加密操作
        instance.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return Base64.getEncoder().encodeToString(instance.doFinal(data.getBytes()));
    }

    private static String decrypt(String data, String key) throws Exception{
        //根据密钥数据，得到密钥
        SecretKeySpec secretKeySpec = keyGenerator(key);
        //数据加密操作对象
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        //初始化密钥操作对象，并设置指定的解密操作
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }


    public static void main(String[] args) throws Exception{
        String source = "hello , i am 小武";
        String key = "A1B2C3D4E5F60708";
        System.out.println("source:" + source);
        String encryptStr = encrypt(source, key);
        System.out.println("encryptStr: " + encryptStr);
        String decryptStr = decrypt(encryptStr, key);
        System.out.println("decryptStr:" + decryptStr);

    }
}
