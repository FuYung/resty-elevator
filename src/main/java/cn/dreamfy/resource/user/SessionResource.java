package cn.dreamfy.resource.user;

import cn.dreamfy.resource.ApiResource;
import cn.dreamfy.resource.user.model.User;
import cn.dreampie.route.core.annotation.API;
import cn.dreampie.route.core.annotation.POST;
import cn.dreampie.security.Subject;

/**
 * SessionResource
 * Created by FuYung on 2015/8/30.
 */
@API("/session")
public class SessionResource extends ApiResource {

    @POST
    public User login(String userName, String password, boolean rememberMe) {
        Subject.login(userName, password, rememberMe);
        return (User) Subject.getPrincipal().getModel();
    }
}
