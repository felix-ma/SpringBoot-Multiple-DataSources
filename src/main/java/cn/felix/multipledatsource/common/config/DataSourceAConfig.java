package cn.felix.multipledatsource.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSourceAConfig.PACKAGE, sqlSessionTemplateRef = "ASqlSessionTemplate")
public class DataSourceAConfig {

    static final String PACKAGE = "cn.felix.multipledatsource.dao.a";
    static final String MAPPER_LOCATION = "classpath:mapper/a/*.xml";

    @Value("${a.url}")
    private String url;

    @Value("${a.username}")
    private String username;

    @Value("${a.password}")
    private String password;

    @Value("${a.driver-class-name}")
    private String driver;

    @Value("${druid.initial-size}")
    private int initialSize;

    @Value("${druid.min-idle}")
    private int minIdle;

    @Value("${druid.max-active}")
    private int maxActive;

    @Value("${druid.max-wait}")
    private int maxWait;

    @Bean
    @Primary
    public DataSource ADataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(this.driver);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    @Bean(name = "ASqlSessionFactory")
    @Primary
    public SqlSessionFactory ASqlSessionFactory(@Qualifier("ADataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceAConfig.MAPPER_LOCATION));
        return bean.getObject();
    }

    @Bean(name = "ATransactionManager")
    @Primary
    public DataSourceTransactionManager ATransactionManager(@Qualifier("ADataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ASqlSessionTemplate")
    @Primary
    public SqlSessionTemplate ASqlSessionTemplate(
            @Qualifier("ASqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
