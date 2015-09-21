package cn.dreamfy.resource.user.util;

import cn.dreamfy.resource.common.util.Tools;

public class PasswordTools {

    /**
     * 判断密码是否一致的方法
     *
     * @param password    未加密的密码
     * @param etcPassword 加密后的密码
     * @param algorithm   加密算法，目前只支持SHA1
     * @return 密码一致返回true
     */
    public static boolean checkPwd(String password, String etcPassword,
                                   String algorithm) {
        if (algorithm.toUpperCase().equals("SHA1")) {
            //先将加密后的密码按$符号进行分割
            String[] str = etcPassword.split("\\$");
            //判断str的length
            if (3 == str.length) {
                //取出随机生成的加密密钥，str的第二段字符串
                String salt = str[1];
                //调用工具方法，根据加密密钥得到加密后的密码
                String rawPassword = SHA1Util.hex_sha1(salt + password);
                //判断rawPassword是否等于str的第三段字符串，不区分大小写
                //密码一致，返回true 不一致，返回false
                return rawPassword.equalsIgnoreCase(str[2]);
            } else {
                //长度错误，返回false
                return false;
            }
        } else {
            //暂不支持非SHA1之外的算法
            return false;
        }
    }

    public static String createPwd(String password) {
        String algorithm = "sha1";//  加密算法名称
        String salt = Tools.getRandom(6);// 密钥
        if ("".equals(password)) { // 如果注册时密码为空则根据随机数生成密码
            password = salt;
        }
        String rawPassword = SHA1Util.hex_sha1(salt + password);
        return rawPassword != null && !"".equals(rawPassword) ? (algorithm + "$"
                + salt + "$" + rawPassword) : "";
    }

}
