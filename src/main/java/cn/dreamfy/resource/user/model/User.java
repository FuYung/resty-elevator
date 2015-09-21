package cn.dreamfy.resource.user.model;

import cn.dreampie.orm.Model;
import cn.dreampie.orm.annotation.Table;

import java.util.Map;

/**
 * 用户管理
 */
@Table(name = "user", cached = true)
public class User extends Model<User> {

    public final static User dao = new User();

    public Map<String, Object> getAttrs() {
        return super.getAttrs();
    }
}
