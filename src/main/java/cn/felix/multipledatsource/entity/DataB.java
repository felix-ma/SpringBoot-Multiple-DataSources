package cn.felix.multipledatsource.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("table_b")
@Data
public class DataB {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("type")
    private String type;
}
