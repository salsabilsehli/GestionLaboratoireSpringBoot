package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EvenementBean;
import com.example.demo.OutilBean;
import com.example.demo.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.Evenement_MembreRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.Membre_PublicationRepository;
import com.example.demo.dao.Outil_MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Evenement_Membre;
import com.example.demo.entities.EventMembreId;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.entities.OutilMembreId;
import com.example.demo.entities.Outil_Membre;
import com.example.demo.entities.PublicationMembreId;
import com.example.demo.proxies.EvenementProxy;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;

@Service
public class MemberImpl implements IMemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;

	@Autowired
	Membre_PublicationRepository mempubRepository;
	
	@Autowired
	Evenement_MembreRepository eventmemberRepository;
	
	@Autowired
	Outil_MembreRepository outilmembreRepo;

	@Autowired
	PublicationProxy publicationproxy;
	
	@Autowired
	EvenementProxy eventproxy;
	
	@Autowired
	OutilProxy outilproxy;

	public Membre addMember(Membre m) {

		memberRepository.save(m);

		return m;

	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);

	}

	public Membre findMember(Long id) {
		return memberRepository.findById(id).get();

	}

	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	public Membre affecterenseignantToetudiant(Long idetd, Long idens) {

		Etudiant etd = (Etudiant) memberRepository.findById(idetd).get();
		EnseignantChercheur ens = (EnseignantChercheur) memberRepository.findById(idens).get();

		etd.setEncadrant(ens);
		return memberRepository.save(etd);

	}

	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre m = memberRepository.findById(idauteur).get();
		Membre_Publication mp = new Membre_Publication();
		mp.setAuteur(m); // je donne l'objet
		mp.setId(new PublicationMembreId(idauteur, idpub));
		mempubRepository.save(mp);

	}

	public List<PublicationBean> findPublicationsParAuteur(Long idauteur) {
		final List<PublicationBean> pubs

				= new ArrayList<PublicationBean>();
		//get mp de la bd ayant idauteur

		List<Membre_Publication> idpubs

				= mempubRepository.findpubId(idauteur);
		//pour chaque ligne de idpubs je vais recuperer ttes les infos des publications(proxy) ayant idPub dans idpubs

		idpubs.forEach(s-> {
			pubs.add(publicationproxy.recupererUnePub(
					s.getId().getPublicationId()).getContent());
		});
		return pubs;

	}

	//en utilisant la tabe d'association
	public void affecterorganisateurToEvenement(Long idorg, Long idevent) {
		Membre m=memberRepository.findById(idorg).get();
		Evenement_Membre em= new Evenement_Membre();
		em.setOrganisateur(m);
		em.setId(new EventMembreId(idevent,idorg));
		eventmemberRepository.save(em);
		
	}

	//en utilisant query & proxy
	public List<EvenementBean> findEventsParOrganisateur(Long idorg) {
		
		List<Evenement_Membre> ems=eventmemberRepository.findEventId(idorg);
		List<EvenementBean> events = new ArrayList<EvenementBean>();
		
		ems.forEach(l->{
			events.add(eventproxy.recupererUnEvenement(l.getId().getEvent_id()).getContent());
		});
		
		return events;
	}

	@Override
	public void affecterOutilToMembre(Long idmembre, Long idoutil) {
		Membre m=memberRepository.findById(idmembre).get();
		Outil_Membre mo= new Outil_Membre();
		mo.setMembre(m);
		mo.setId(new OutilMembreId(idoutil,idmembre));
		outilmembreRepo.save(mo);
		
	}

	@Override
	public List<OutilBean> findOutilParMembre(Long idmembre) {
		
		List<Outil_Membre> outilsmembres=outilmembreRepo.findOutilId(idmembre);
		List<OutilBean> outils = new ArrayList<OutilBean>();
		
		outilsmembres.forEach(l->{
			outils.add(outilproxy.recupererUnOutil(l.getId().getOutil_id()).getContent());
		});
		
		return outils;
	}
}
