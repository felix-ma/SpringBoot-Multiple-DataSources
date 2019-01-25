# MultipleDataSource
使用ssm框架，配置多数据源自动切换
## 说明
SpringBoot 版本 2.0.3 
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.3.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
已经引入了 `postgreSQL` 和 `mysql` 的链接库
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
使用 `druid` 连接池和 `mybatis plus` 插件

## 切换数据源说明
1. 在配置文件中配置了多个数据源
    ```yml
    spring:
      datasource:
        multiple:
          db1:
            username: postgres
            password: postgres
            driverClassName: org.postgresql.Driver
            url: jdbc:postgresql://localhost:5432/data_a
            initialSize: 5
            minIdle: 5
            maxActive: 20
          db2:
            username: root
            password: root
            driver-class-name: com.mysql.jdbc.Driver
            url: jdbc:mysql:///data_b
            initialSize: 5
            minIdle: 5
            maxActive: 20
    ```
2. 然后在 `MyBatiesPlusConfiguration` 中注入
    ```java
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.multiple.db1" )
    public DataSource db1() {
        return DruidDataSourceBuilder.create().build();
    }
    
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.multiple.db2" )
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }
    ```
3. 添加到`multipleDataSource`中
    ```java
    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.DB1.getValue(), db1);
        targetDataSources.put(DataSourceEnum.DB2.getValue(), db2);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(db1);
        return multipleDataSource;
    }
    ```
4. 如果需要切换数据源，则在指定的方法上加上`@DataSource`注解即可
```java
@Override
@DataSource(DataSourceEnum.DB2)
public List<Student> selectList(Wrapper<Student> wrapper) {
    return super.selectList(wrapper);
}
```