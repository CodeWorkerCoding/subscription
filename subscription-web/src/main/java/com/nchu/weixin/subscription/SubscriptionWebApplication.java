package com.nchu.weixin.subscription;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@EnableAutoConfiguration
@SpringBootApplication
public class SubscriptionWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionWebApplication.class, args);
	}
}
