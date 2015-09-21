package cn.dreamfy.resource.brand;

import cn.dreamfy.resource.ApiResource;
import cn.dreamfy.resource.brand.model.Brand;
import cn.dreampie.route.core.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * BrandResource
 * Created by FuYung on 2015/8/28.
 */
@API("/brands")
public class BrandResource extends ApiResource {

    @GET
    public List<Brand> queryBrands() {
        return Brand.dao.findBy("is_delete = 0");
    }

    @GET("/:id")
    public Brand queryBrandById(int id) {
        return Brand.dao.findFirstBy("is_delete = ? and id = ?", 0, id);
    }

    @POST
    public boolean saveBrand(Brand brand) {
        brand.set("create_time", new Date());
        return brand.save();
    }

    @PUT
    public boolean updateBrand(Brand brand) {
        boolean flag = false;
        if (Brand.dao.findById(brand.get("id")) != null) {
            brand.set("update_time", new Date());
            flag = brand.update();
        }
        return flag;
    }

    @DELETE("/:id")
    public boolean deleteBrand(int id) {
        return Brand.dao.deleteBy("id = ?", id);
    }

}
