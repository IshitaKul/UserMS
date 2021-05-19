package com.infy.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class UserMSApplication {
	public static void main(String args[])
	{
		SpringApplication.run(UserMSApplication.class,args);
	}
}
