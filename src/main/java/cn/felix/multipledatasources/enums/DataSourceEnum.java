package cn.felix.multipledatasources.enums;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:46
**/
public enum DataSourceEnum {

    DB1("db1"),DB2("db2");

    private String value;

    DataSourceEnum(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}
