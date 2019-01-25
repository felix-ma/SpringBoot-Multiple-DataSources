package cn.felix.multipledatsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.felix.multipledatsource.dao")
public class MultipleDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourcesApplication.class, args);
	}

}
