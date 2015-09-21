package cn.dreamfy.resource.company;

import cn.dreamfy.resource.ApiResource;
import cn.dreamfy.resource.company.model.Company;
import cn.dreampie.route.core.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * CompanyResource
 * Created by FuYung on 2015/8/28.
 */
@API("/companys")
public class CompanyResource extends ApiResource {

    @GET
    public List<Company> queryCompanys() {
        return Company.dao.findBy("is_delete = 0");
    }

    @GET("/:id")
    public Company queryCompanyById(int id) {
        return Company.dao.findFirstBy("is_delete = 0 and id = ?", id);
    }

    @PUT
    public boolean updateCompany(Company company) {
        if (Company.dao.findBy("is_delete = 0 and id = ?", company.get("id")) != null) {
            company.set("update_time", new Date());
            return company.update();
        }
        return false;
    }

    @POST
    public boolean saveCompany(Company company) {
        company.set("create_time", new Date());
        return company.save();
    }

    @DELETE("/:id")
    public boolean deleteCompany(int id) {
        return Company.dao.deleteBy("id = ?", id);
    }

}
