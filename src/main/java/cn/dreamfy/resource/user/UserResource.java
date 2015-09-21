package cn.dreamfy.resource.user;

import cn.dreamfy.resource.ApiResource;
import cn.dreamfy.resource.user.model.User;
import cn.dreamfy.resource.user.util.PasswordTools;
import cn.dreampie.route.core.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * UserResource
 * Created by FuYung on 2015/8/28.
 */
@API("/users")
public class UserResource extends ApiResource {

    @GET
    public List<User> queryUsers() {
        return User.dao.findBy("is_delete = 0");
    }

    @GET("/:id")
    public User queryUserById(int id) {
        User user = User.dao.findFirstBy("id=?", id);
        if (user != null) {
            user.remove("password");
        }
        return user;
    }

    @POST
    public boolean saveUser(User user) {
        user.set("create_time", new Date());
        user.set("password", PasswordTools.createPwd(user.get("password").toString()));
        return user.save();
    }

    @PUT
    public boolean updateUser(User user) {
        boolean flag = false;
        if (User.dao.findById(user.get("id")) != null) {
            user.set("update_time", new Date());
            flag = user.update();
        }
        return flag;
    }

    @DELETE("/:id")
    public boolean deleteUser(int id) {
        return User.dao.deleteBy("id = ?", id);
    }

}
