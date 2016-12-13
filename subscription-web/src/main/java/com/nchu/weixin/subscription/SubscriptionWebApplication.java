package com.nchu.weixin.subscription;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@Configurable
@EnableAutoConfiguration
@SpringBootApplication
@ImportResource(value = {"classpath:static/application-security.xml"})
public class SubscriptionWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionWebApplication.class, args);
	}
}
