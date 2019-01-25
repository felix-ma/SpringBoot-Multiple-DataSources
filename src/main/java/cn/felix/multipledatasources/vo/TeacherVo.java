package cn.felix.multipledatasources.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:56
**/
@Data
@ApiModel("老师vo")
public class TeacherVo {

    @ApiModelProperty("老师姓名")
    private String name;

    @ApiModelProperty("老师年龄")
    private Integer age;

    @ApiModelProperty("老师教的学科")
    private String subject;
}
