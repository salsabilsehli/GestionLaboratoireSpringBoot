package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@SpringBootApplication
@EnableDiscoveryClient
public class OutilServiceApplication implements CommandLineRunner{
	
	@Autowired
	IOutilService outilService;
	@Autowired
	RepositoryRestConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Outil.class);

		SimpleDateFormat dateFormattor = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormattor.parse("1997-11-24");
		Outil o1=new Outil(date1,"source1");
		
		outilService.addOutil(o1);
		
	}

}
