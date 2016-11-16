package com.springwalk.sample.crypto;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jgonzalezg on 11/11/2016.
 */
public class CryptoTools {

    public static String encryptWithAESKey(String data, String iv) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        SecretKey secKey = new SecretKeySpec("1234567890123456".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec paramSpec = new IvParameterSpec(getIvParameter(iv).getBytes());
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secKey,paramSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        byte[] newData = cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(newData);
    }

    public static String decryptWithAESKey(String inputData, String iv) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec paramSpec = new IvParameterSpec(getIvParameter(iv).getBytes());
        SecretKeySpec secKey = new SecretKeySpec("1234567890123456".getBytes(), "AES");
        try {
            cipher.init(Cipher.DECRYPT_MODE, secKey, paramSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        byte[] newData = cipher.doFinal(Base64.decodeBase64(inputData.getBytes()));
        return new String(newData);

    }

    public static String getIvParameter(String IvParam){
        String Iv = IvParam.replaceAll("-","").replaceAll(":","").replaceAll("\\.","").replaceAll(" ","");
        if (Iv.length() == 16) {
            return Iv;
        } else if (Iv.length() > 16) {
            return Iv.substring(Iv.length() - 16);
        }else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has less than 16 characters!");
        }
    }
}
