package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Outil;

@RepositoryRestResource
public interface OutilRepository extends JpaRepository<Outil, Long>{
	
	List<Outil> findBySource(String source); 

}
