package br.com.esndev.plants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "br.com.esndev.plants.configuration", "br.com.esndev.configuration.plants.pojo",
//		"br.com.esndev.plants.controller", "br.com.esndev.plants.service.impl.base" })
public class PlantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantsApplication.class, args);
	}

}
