package cn.felix.multipledatsource.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("table_c")
@Data
public class DataC {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("number")
    private Integer number;
}
