package com.vison.canteen.biz.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {

    private static final String algorithm = "MD5";

    private static final int hashIterations = 256;
    public static String encrypt(String username, String password) {
        //toString()和toHex()的结果一致
        String newPassword = new SimpleHash(algorithm, password, ByteSource.Util.bytes(username), hashIterations).toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.encrypt("tester", "123456"));
    }

}
