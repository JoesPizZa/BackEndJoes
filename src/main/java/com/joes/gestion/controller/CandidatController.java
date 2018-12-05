package com.joes.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joes.gestion.entity.Candidat;
import com.joes.gestion.entity.Employe;
import com.joes.gestion.service.CandidatService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CandidatController {

	 
	private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
    
    @RequestMapping(value="/AfficherCandidat/{etat}",method = RequestMethod.GET)

    public List<Candidat> afficherCandidatRefuser(@PathVariable String etat){
    	return candidatService.afficherCandidatRefuser(etat);
    	
    }
    
    @RequestMapping(value="/AjouterCandidat",method = RequestMethod.POST)
    public Candidat ajouterCandidat (@RequestBody Candidat c) {
    	return candidatService.ajouterCandidat(c);
    }

    @RequestMapping(value="/AccepterCandidat",method = RequestMethod.POST)
    public void ajouterCandidat (@RequestBody Employe e) {
    	candidatService.accepterCandidat(e);
    }
    
}
