package cn.felix.multipledatasources.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
*
* @author felix-ma
* @create 2019/1/25 14:46
**/
@Api("学生实体对象")
@Data
@TableName("t_student")
public class Student {

    @ApiModelProperty("学生id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("学生年龄")
    private Integer age;

    @ApiModelProperty("学生班级")
    private String classname;

}
