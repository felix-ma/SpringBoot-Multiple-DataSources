package cn.felix.multipledatsource.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("table_a")
@Data
public class DataA {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name", strategy = FieldStrategy.NOT_NULL)
    private String name;
}