package cn.felix.multipledatasources.annotation;

import cn.felix.multipledatasources.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
*
* @author felix-ma
* @create 2019/1/25 14:45
**/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.DB1;
}
