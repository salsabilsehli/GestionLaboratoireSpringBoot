package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Membre_Publication;
import com.example.demo.entities.PublicationMembreId;



@Repository
public interface Membre_PublicationRepository extends JpaRepository<Membre_Publication, PublicationMembreId>{

	@Query("select mp from Membre_Publication mp where auteur_id = :x")
	List<Membre_Publication>findpubId(@Param("x") Long autid);
	
}
