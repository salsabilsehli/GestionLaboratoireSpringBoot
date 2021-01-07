package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

@Service
public class OutilImpl implements IOutilService{

	@Autowired
	OutilRepository outilRepository; 
	
	public Outil addOutil(Outil o) {
		return outilRepository.save(o);
	}

	public void deleteOutil(Long id) {
		outilRepository.deleteById(id);
	}

	public Outil updateOutil(Outil o) {
		return outilRepository.saveAndFlush(o);
	}

	public Outil findOutil(Long id) {
		return outilRepository.findById(id).get();
	}

	public List<Outil> findAll() {
		return outilRepository.findAll();
	}

	public List<Outil> findBySource(String source) {
		return outilRepository.findBySource(source);
	}

}
