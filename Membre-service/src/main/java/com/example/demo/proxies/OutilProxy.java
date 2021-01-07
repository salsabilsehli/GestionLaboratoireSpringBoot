package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.OutilBean;

@FeignClient(name="OUTIL-SERVICE")
public interface OutilProxy {
	
	@GetMapping("/outils")
	CollectionModel<OutilBean> listeDesOutils();
	
	@GetMapping("/outils/{id}")
	EntityModel<OutilBean> recupererUnOutil(@PathVariable("id") Long id);

}
