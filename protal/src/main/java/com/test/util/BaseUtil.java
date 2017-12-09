package com.test.util;

import java.util.Base64;

public class BaseUtil {
    //统一编码
    public static String encode(String src) {
        return Base64.getEncoder().encodeToString(src.getBytes());
    }

    public static String decode(String src) {
        byte[] bytes = Base64.getDecoder().decode(src);
        return new String(src);
    }

    public static void main(String[] args) {
        String s = decode("4546454fsdfasfsfasd=");

        System.out.println(s);
    }

}
