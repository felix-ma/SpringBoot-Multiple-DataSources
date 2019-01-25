package cn.felix.multipledatasources.multiple;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
* 
* @author felix-ma
* @create 2019/1/25 14:47
**/
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
