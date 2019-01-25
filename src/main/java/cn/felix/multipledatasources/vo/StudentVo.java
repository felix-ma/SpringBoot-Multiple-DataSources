package cn.felix.multipledatasources.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:53
**/
@Data
@ApiModel("学生vo")
public class StudentVo {

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("学生年龄")
    private Integer age;

    @ApiModelProperty("学生班级")
    private String classname;
}
