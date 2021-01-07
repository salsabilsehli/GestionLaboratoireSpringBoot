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

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;


@RestController
@CrossOrigin
public class OutilRestController {
	
	@Autowired
	IOutilService outilService;
	
	// GET
			@RequestMapping(value = "/outils", method = RequestMethod.GET)
			public List<Outil> findOutils() {
				return outilService.findAll();
			}

			
			@GetMapping(value = "/outils/{id}")
			public Outil findOneOutilById(@PathVariable Long id) {
				return outilService.findOutil(id);
			}

			
			@GetMapping(value = "/outils/search/source")
			public List<Outil> findBySource(@RequestParam String source)

			{
				return outilService.findBySource(source);
			}
			
			

			// POST
			
			@PostMapping(value = "/outils")
			@CrossOrigin
			public Outil addOutil(@RequestBody Outil o)

			{
				return outilService.addOutil(o);

			}


			// DELETE
			@DeleteMapping(value = "/outils/{id}")
			@CrossOrigin
			public void deleteOutil(@PathVariable Long id)

			{

				outilService.deleteOutil(id);

			}

			// UPDATE
			
			@PutMapping(value = "/outils/{id}")
			@CrossOrigin
			public Outil updateOutil(@PathVariable Long id, @RequestBody Outil e)

			{
				
				e.setId(id);
				return outilService.updateOutil(e);

			}

		


}
