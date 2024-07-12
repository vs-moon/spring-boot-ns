package org.xiao.ns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ApplicationNSIM {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationNSIM.class, args);
    	System.out.println("===================== Starter Success ApplicationNSIM =====================");
    	System.out.println("===================== Starter Success ApplicationNSIM =====================");
    	System.out.println("===================== Starter Success ApplicationNSIM =====================");
	}
}
