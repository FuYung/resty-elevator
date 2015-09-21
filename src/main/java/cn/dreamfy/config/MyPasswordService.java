package cn.dreamfy.config;

import cn.dreamfy.resource.user.util.PasswordTools;
import cn.dreampie.security.PasswordService;

/**
 * 密码service
 * Created by FuYung on 2015/8/30.
 */
public class MyPasswordService implements PasswordService {

    private static PasswordService passwordService = new MyPasswordService();

    public static PasswordService instance() {
        return passwordService;
    }

    public String hash(String password) {
        return PasswordTools.createPwd(password);
    }

    public boolean match(String password, String passwordHash) {
        String algorithm = "SHA1";
        return PasswordTools.checkPwd(password, passwordHash, algorithm);
    }
}
