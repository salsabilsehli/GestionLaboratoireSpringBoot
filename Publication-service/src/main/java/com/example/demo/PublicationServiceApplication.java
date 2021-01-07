package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicationServiceApplication implements CommandLineRunner{
	
	@Autowired
	IPublicationService publicationService;
	
	@Autowired
	RepositoryRestConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		config.exposeIdsFor(Publication.class);
		
		SimpleDateFormat dateFormattor = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormattor.parse("1997-11-26");
		Date date2 = dateFormattor.parse("2000-03-01");
		Date date3 = dateFormattor.parse("2011-08-15");

		Publication p1 = new Publication(date1, "an approach for testing soa systems", "article", "lien", "pdf");
		Publication p2 = new Publication(date2, "towards cloud computing: issues and challenges", "chapitre de livre", "lien", "pdf");
		Publication p3 = new Publication(date3, "introducing blockchain systems", "article", "lien", "pdf");

		publicationService.addPublication(p1);
		publicationService.addPublication(p2);
		publicationService.addPublication(p3);

		
	}

}
