package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.OutilMembreId;
import com.example.demo.entities.Outil_Membre;


@Repository
public interface Outil_MembreRepository extends JpaRepository<Outil_Membre, OutilMembreId>{
	
	@Query("select mo from Outil_Membre mo where membre_id = :x")
	List<Outil_Membre>findOutilId(@Param("x") Long membreid);
}
