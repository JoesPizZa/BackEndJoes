package com.joes.gestion.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joes.gestion.dao.CandidatRepository;
import com.joes.gestion.entity.Candidat;
import com.joes.gestion.entity.Employe;
import com.joes.gestion.entity.TypePost;

@Service
@Transactional
public class CandidatService implements ICandidatService {
	
	@Autowired
	private CandidatRepository candidatRepository;
	@Autowired
	private EmployeService employeService;
	
	 @Autowired
	    private TypePostService typepostservice;

	    @Autowired
	    public CandidatService(CandidatRepository candidatRepository) {
	        this.candidatRepository = candidatRepository;}
	    
	

	@Override
	public Candidat ajouterCandidat(Candidat c) {
		TypePost p= typepostservice.find(c.getTypePost().getDescription());
    	p.addCandidat(c);
    	candidatRepository.save(c);
    	typepostservice.update(p.getId(),p);
    	return c;
	}

	@Override
	public List<Candidat> afficherCandidatRefuser(String etat) {
		// TODO Auto-generated method stub
		return candidatRepository.AfficherSelonEtat(etat);
	}

	@Override
	public void accepterCandidat(Employe e) {
		candidatRepository.deleteById(e.cin);
		
		employeService.addEmploye(e);
		
	}



	@Override
	public Candidat rechercheCandidatById(int id) {
		 return candidatRepository.findById(id).isPresent()? candidatRepository.findById(id).get():null;
	}

}
