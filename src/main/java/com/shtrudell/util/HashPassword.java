package com.shtrudell.util;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class HashPassword {

    public static byte[] getHash(String password)
    {
        MessageDigest digest = null;

        if(password == null) return null;

        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();

            return digest.digest(password.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}