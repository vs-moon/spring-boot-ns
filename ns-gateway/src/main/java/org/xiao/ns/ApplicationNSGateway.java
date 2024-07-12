package org.xiao.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationNSGateway {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationNSGateway.class, args);
    	System.out.println("===================== Starter Success ApplicationNSGateway =====================");
    	System.out.println("===================== Starter Success ApplicationNSGateway =====================");
    	System.out.println("===================== Starter Success ApplicationNSGateway =====================");
	}
}
