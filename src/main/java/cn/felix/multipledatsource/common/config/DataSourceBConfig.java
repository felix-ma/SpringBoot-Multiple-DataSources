package cn.felix.multipledatsource.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSourceBConfig.PACKAGE, sqlSessionTemplateRef = "BSqlSessionTemplate")
public class DataSourceBConfig {
    static final String PACKAGE = "cn.felix.multipledatsource.dao.b";
    static final String MAPPER_LOCATION = "classpath:mapper/b/*.xml";

    @Value("${b.url}")
    private String url;

    @Value("${b.username}")
    private String username;

    @Value("${b.password}")
    private String password;

    @Value("${b.driver-class-name}")
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
    @ConfigurationProperties(prefix = "spring.datasource.b")
    public DataSource BDataSource() {
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

    @Bean(name = "BSqlSessionFactory")
    public SqlSessionFactory BSqlSessionFactory(@Qualifier("BDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceBConfig.MAPPER_LOCATION));
        return bean.getObject();
    }

    @Bean(name = "BTransactionManager")
    public DataSourceTransactionManager BTransactionManager(@Qualifier("BDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "BSqlSessionTemplate")
    public SqlSessionTemplate BSqlSessionTemplate(
            @Qualifier("BSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
