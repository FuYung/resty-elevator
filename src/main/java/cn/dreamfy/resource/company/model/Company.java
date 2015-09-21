package cn.dreamfy.resource.company.model;


import cn.dreampie.orm.Model;
import cn.dreampie.orm.annotation.Table;

/**
 * 单位管理
 */
@Table(name = "company")
public class Company extends Model<Company> {

    public static final Company dao = new Company();

}
