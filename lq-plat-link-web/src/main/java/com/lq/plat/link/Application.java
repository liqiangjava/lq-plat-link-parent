package com.lq.plat.link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

//@EnableJdbcHttpSession
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
public class Application {


	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
