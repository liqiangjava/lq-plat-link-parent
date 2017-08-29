package com.lq.plat.link.utils.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class Aes {
    private static String KEY_ALGORITHM = "AES";
    private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final byte[] SECURE_KEY = StringUtils.getBytesUtf8("Joehe@Lk&#08$Aes");
    public static final String PLUGIN_SECURE_KEY = "Joehe@Et&#08$Aes";
    public static final String CONNECT_SECURE_KEY = "Joehe@Ct&#91$Aes";

    public static String encrypt(String inputStr)
            throws Exception
    {
        return encryptToString(StringUtils.getBytesUtf8(inputStr), SECURE_KEY);
    }

    public static String decrypt(String inputStr)
            throws Exception
    {
        return decrypt(Base64.decodeBase64(inputStr), SECURE_KEY);
    }

    public static String encrypt(String inputStr, String secureKey)
            throws Exception
    {
        return encryptToString(StringUtils.getBytesUtf8(inputStr), StringUtils.getBytesUtf8(secureKey));
    }

    public static String decrypt(String inputStr, String secureKey)
            throws Exception
    {
        return decrypt(Base64.decodeBase64(inputStr), StringUtils.getBytesUtf8(secureKey));
    }

    private static String encryptToString(byte[] input, byte[] key)
            throws Exception
    {
        return Base64.encodeBase64URLSafeString(encrypt(input, key));
    }

    private static byte[] encrypt(byte[] input, byte[] key)
            throws Exception
    {
        return aes(input, key, 1);
    }

    private static String decrypt(byte[] input, byte[] key)
            throws Exception
    {
        byte[] decryptResult = aes(input, key, 2);
        return StringUtils.newStringUtf8(decryptResult);
    }

    private static byte[] aes(byte[] input, byte[] key, int mode)
            throws Exception
    {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(mode, secretKey);
        return cipher.doFinal(input);
    }

    public static void main(String[] args)
            throws Exception
    {}

}
