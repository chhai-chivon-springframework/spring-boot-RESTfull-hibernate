package com.chhaichivon.springbootRESTfullhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/*@SpringBootApplication

@EnableAutoConfiguration*/


@Configuration
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.chhaichivon.springbootRESTfullhibernate")
@SpringBootConfiguration
public class SpringBootResTfullHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResTfullHibernateApplication.class, args);
	}
}
