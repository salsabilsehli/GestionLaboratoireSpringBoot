package com.example.demo.service;

import java.util.List;

import com.example.demo.EvenementBean;
import com.example.demo.OutilBean;
import com.example.demo.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

//eli fl dao n3awed n7ot'hom lehna 
public interface IMemberService {

	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public List<Membre> findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);

	public Membre affecterenseignantToetudiant(Long idetd, Long idens);
	
	public void affecterauteurTopublication(Long idauteur,Long idpub);
	
	public List<PublicationBean> findPublicationsParAuteur(Long idauteur);
	
	public void affecterorganisateurToEvenement(Long idorg,Long idevent);
	
	public List<EvenementBean> findEventsParOrganisateur(Long idorg);
	
	public void affecterOutilToMembre(Long idmembre,Long idoutil);
	
	public List<OutilBean> findOutilParMembre(Long idmembre);
}
