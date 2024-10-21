package top.guke.springboot.redis.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_user")
public class User {
    @TableId(value = "pk_id" , type = IdType.AUTO)
    private Long pkId;
    private String phone;
    private String avater;
    private String nickname;
    private Integer gender;
    private Integer bonus;
    private String remark;
    private Integer enable;

    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value = "update_time" , fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value =  "create_time" , fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
