package cn.dreamfy.config;

import cn.dreamfy.resource.user.model.User;
import cn.dreampie.security.AuthenticateService;
import cn.dreampie.security.PasswordService;
import cn.dreampie.security.Principal;
import cn.dreampie.security.credential.Credential;

import java.util.HashSet;
import java.util.Set;

/**
 * MyAuthenticateService
 * Created by FuYung on 2015/8/30.
 */
public class MyAuthenticateService extends AuthenticateService {

    @Override
    public Principal getPrincipal(String username) {
        User user = User.dao.findFirstBy("mobile = ? and is_delete != 1", username);
        if (user != null) {
            Set<String> permissionValues = new HashSet<String>();
            permissionValues.add("admin");// 假定所有人都拥有admin权限

            // 参数列表：1、登录名 2、登录密码 3、该用户拥有的权限列表（权限名称） 4、登录之后返回的对象
            return new Principal<User>(username, (String) user.get("password"), permissionValues, user);
        }
        return null;
    }

    @Override
    public Set<Credential> getAllCredentials() {
        Set<Credential> credentials = new HashSet<Credential>();
        // 参数列表：1、需要拦截的path 2、拦截的antPath 3、antPath需要的权限名称
        credentials.add(new Credential("*", "/api/users/**", "admin"));
        return credentials;
    }

    @Override
    public PasswordService getPasswordService() {
        return MyPasswordService.instance();
    }
}
