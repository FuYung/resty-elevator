package cn.dreamfy.resource.elevator;

import cn.dreamfy.resource.ApiResource;
import cn.dreamfy.resource.elevator.model.ElevatorInfo;
import cn.dreampie.route.core.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ElevatorResource
 * Created by FuYung on 2015/8/28.
 */
@API("/elevators")
public class ElevatorResource extends ApiResource {

    @GET
    public List<ElevatorInfo> queryElevatorInfo() {
        return ElevatorInfo.dao.findBy("is_delete = 0");
    }

    @GET("/:id")
    public ElevatorInfo queryElevatorInfoById(int id) {
        return ElevatorInfo.dao.findFirstBy("is_delete = 0 and id = ?", id);
    }

    @PUT
    public boolean updateElevatorInfo(ElevatorInfo elevatorInfo) {
        if (elevatorInfo.findBy("is_delete = 0 and id = ?", elevatorInfo.get("id")) != null) {
            elevatorInfo.set("update_time", new Date());
            return elevatorInfo.update();
        }
        return false;
    }

    @POST
    public boolean saveElevatorInfo(ElevatorInfo elevatorInfo) {
        elevatorInfo.set("create_time", new Date());
        return elevatorInfo.save();
    }

    @DELETE("/:id")
    public boolean deleteElevatorInfo(int id) {
        return ElevatorInfo.dao.deleteBy("id = ?", id);
    }

}
