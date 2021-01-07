package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class EvenementServiceApplication implements CommandLineRunner{

	@Autowired
	private EvenementRepository evenementRepository;

	@Autowired
	IEvenementService evenementService;
	
	@Autowired
	RepositoryRestConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}
	
	public void run(String... args) throws ParseException {
		configuration.exposeIdsFor(Evenement.class);
		SimpleDateFormat dateFormattor = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormattor.parse("1997-11-24");
		Date date2 = dateFormattor.parse("1986-07-03");
		Date date3 = dateFormattor.parse("2000-05-12");

		
		Evenement e1=new Evenement(date1,"titre1","lieu1");
		Evenement e2=new Evenement(date2,"titre2","lieu2");
		Evenement e3=new Evenement(date3,"titre3","lieu3");
		evenementService.addEvent(e1);
		evenementService.addEvent(e2); 
		evenementService.addEvent(e3); 

		
	}
	

}
