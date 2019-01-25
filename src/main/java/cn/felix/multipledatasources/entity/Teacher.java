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
@Api("老师实体对象")
@Data
@TableName("t_teacher")
public class Teacher {

    @ApiModelProperty("老师id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("老师姓名")
    private String name;

    @ApiModelProperty("老师年龄")
    private Integer age;

    @ApiModelProperty("老师所教学科")
    private String subject;
}
