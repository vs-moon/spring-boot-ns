package org.xiao.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ApplicationNSSSO {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationNSSSO.class, args);
    	System.out.println("===================== Starter Success " + ApplicationNSSSO.class.getSimpleName() + " =====================");
    	System.out.println("===================== Starter Success " + ApplicationNSSSO.class.getSimpleName() + " =====================");
    	System.out.println("===================== Starter Success " + ApplicationNSSSO.class.getSimpleName() + " =====================");
	}
}
