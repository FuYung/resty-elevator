package cn.dreamfy.resource.elevator.model;


import cn.dreampie.orm.Model;
import cn.dreampie.orm.annotation.Table;

/**
 * 电梯维修信息管理
 */
@Table(name = "elevator_info")
public class ElevatorInfo extends Model<ElevatorInfo> {

    public static final ElevatorInfo dao = new ElevatorInfo();


}
