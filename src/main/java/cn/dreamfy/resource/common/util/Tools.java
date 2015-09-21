package cn.dreamfy.resource.common.util;

import java.util.Random;


public class Tools {

    public static String getRandom(int digit) {
        if (digit > 0) {
            StringBuffer sb = new StringBuffer();
            String str = "0123456789";
            Random r = new Random();
            for (int i = 0; i < digit; i++) {
                int num = r.nextInt(str.length());
                sb.append(str.charAt(num));
                str = str.replace((str.charAt(num) + ""), "");
            }
            return sb.toString();
        } else {
            return "";
        }
    }

}
