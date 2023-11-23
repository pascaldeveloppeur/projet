package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entities.Customer;

import lombok.extern.slf4j.Slf4j;

@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
		log.info("Customer service started!");
		
		
	}

}
