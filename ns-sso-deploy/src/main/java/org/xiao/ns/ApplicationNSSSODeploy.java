package org.xiao.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ApplicationNSSSODeploy {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationNSSSODeploy.class, args);
    	System.out.println("===================== Starter Success " + ApplicationNSSSODeploy.class.getSimpleName() + " =====================");
    	System.out.println("===================== Starter Success " + ApplicationNSSSODeploy.class.getSimpleName() + " =====================");
    	System.out.println("===================== Starter Success " + ApplicationNSSSODeploy.class.getSimpleName() + " =====================");
	}
}
