package com.jarvis.weixin.tool;

import java.security.MessageDigest;

/**
 * Created by zbs on 2017/11/2.
 */
public class EncrAndDecr {

    public static String getSha1(String str) throws Exception {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
        mdTemp.update(str.getBytes("UTF-8"));

        byte[] md = mdTemp.digest();
        int j = md.length;
        char[] buf = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
            buf[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(buf);
    }
}
