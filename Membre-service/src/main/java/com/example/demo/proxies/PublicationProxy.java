package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.PublicationBean;

@FeignClient(name="PUBLICATION-SERVICE")
public interface PublicationProxy {
	
	
	@GetMapping("/publications")
	CollectionModel<PublicationBean> listeDesPublications();
	
	@GetMapping("/publications/{id}")
	EntityModel<PublicationBean> recupererUnePub(@PathVariable("id") Long id);

}
