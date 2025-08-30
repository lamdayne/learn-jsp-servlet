package com.lamdayne.util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String hashPassword(String passWord) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passWord.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Error hashing password: " + e.getMessage());
        }
        return null;
    }
}
