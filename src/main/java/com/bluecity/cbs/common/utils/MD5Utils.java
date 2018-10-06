package com.bluecity.cbs.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
    private static final String SALT = "1qazxsw2";
    private static final String ALGORITHM_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String password) {
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
    }

    public static String encrypt(String userName, String password) {
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(userName + SALT), HASH_ITERATIONS).toHex();
    }
}
