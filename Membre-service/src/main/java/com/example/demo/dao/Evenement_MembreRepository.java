package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Evenement_Membre;
import com.example.demo.entities.EventMembreId;



public interface Evenement_MembreRepository extends JpaRepository<Evenement_Membre, EventMembreId>{

	@Query("select em from Evenement_Membre em where organisateur_id = :x")
	List<Evenement_Membre>findEventId(@Param("x") Long orgid);
}
