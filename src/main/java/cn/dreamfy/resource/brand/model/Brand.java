package cn.dreamfy.resource.brand.model;

import cn.dreampie.orm.Model;
import cn.dreampie.orm.annotation.Table;

/**
 * 品牌管理
 */
@Table(name = "brand", cached = true)
public class Brand extends Model<Brand> {

    public static final Brand dao = new Brand();
}
