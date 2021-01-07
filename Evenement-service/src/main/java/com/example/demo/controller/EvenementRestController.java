package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@RestController
@CrossOrigin
public class EvenementRestController {
	
	@Autowired
	IEvenementService evenementService;
	
	// GET
		@RequestMapping(value = "/evenements", method = RequestMethod.GET)
		public List<Evenement> findEvenements() {
			return evenementService.findAll();
		}

		
		@GetMapping(value = "/evenements/{id}")
		public Evenement findOneEventById(@PathVariable Long id) {
			return evenementService.findEvent(id);
		}

		
		@GetMapping(value = "/evenements/search/lieu")
		public List<Evenement> findByLieu(@RequestParam String lieu)

		{
			return evenementService.findByLieu(lieu);
		}
		
		@GetMapping(value = "/evenements/search/titre")
		public Evenement findByTitre(@RequestParam String titre)

		{
			return evenementService.findByTitre(titre);
		}
		

		// POST
		@CrossOrigin
		@PostMapping(value = "/evenements")
		public Evenement addEvenement(@RequestBody Evenement e)

		{
			return evenementService.addEvent(e);

		}


		// DELETE
		@DeleteMapping(value = "/evenements/{id}")

		public void deleteEvenement(@PathVariable Long id)

		{

			evenementService.deleteEvent(id);

		}

		// UPDATE
		@CrossOrigin
		@PutMapping(value = "/evenements/{id}")
		public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement e)

		{
			
			e.setId(id);
			return evenementService.updateEvent(e);

		}

	


}
