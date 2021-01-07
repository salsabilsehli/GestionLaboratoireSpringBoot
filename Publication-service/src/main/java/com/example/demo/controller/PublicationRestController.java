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

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@RestController
@CrossOrigin
public class PublicationRestController {
	
	@Autowired
	IPublicationService publicationService;
	
	
	
	// GET
		@RequestMapping(value = "/publications", method = RequestMethod.GET)
		public List<Publication> findPublications() {
			return publicationService.findAll();
		}

		
		@GetMapping(value = "/publications/{id}")
		public Publication findOnePublicationById(@PathVariable Long id) {
			return publicationService.findPublication(id);
		}
		

		@GetMapping(value = "/publication/search/type")
		public List<Publication> findByType(@RequestParam String type)

		{
			return publicationService.findByType(type);
		}

		@GetMapping(value = "/publications/search/lien")

		public Publication findByLien(@RequestParam String lien)

		{
			return publicationService.findByLien(lien);
		}

		@GetMapping(value = "/publications/search/sourcepdf")

		public Publication findBySourcepdf(@RequestParam String sourcepdf)

		{
			return publicationService.findBySourcepdf(sourcepdf);
		}
		
		@GetMapping(value = "/publications/search/titre")

		public Publication findByTitre(@RequestParam String titre)

		{
			return publicationService.findByTitre(titre);
		}

		// POST
		@CrossOrigin
		@PostMapping(value = "/publications")
		public Publication addPublication(@RequestBody Publication m)

		{
			return publicationService.addPublication(m);

		}

		// DELETE
		@DeleteMapping(value = "/publications/{id}")

		public void deletePublication(@PathVariable Long id)

		{

			publicationService.deletePublication(id);

		}

		// UPDATE
		@CrossOrigin
		@PutMapping(value = "/publications/{id}")
		public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p)

		{
			p.setId(id);
			return publicationService.updatePublication(p);

		}



}
