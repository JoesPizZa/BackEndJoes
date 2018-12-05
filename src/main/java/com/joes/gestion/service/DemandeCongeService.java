package com.joes.gestion.service;
/*
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.joes.gestion.dao.DemandeCongeRepository;
import com.joes.gestion.entity.Conge;
import com.joes.gestion.entity.DemandeConge;
//import com.joes.gestion.entity.Employe;
//import com.joes.gestion.entity.TypeContrat;

@Service
@Transactional
public class DemandeCongeService {
	
	
	 private final TypeCongeService typeCongeService;
	 
	private final DemandeCongeRepository demandecongeRepository;
	@Autowired
  	CongeService congeService;

	@Autowired
	public DemandeCongeService(DemandeCongeRepository demandecongeRepository,TypeCongeService typeCongeService) {
		this.demandecongeRepository=demandecongeRepository;
		this.typeCongeService=typeCongeService;
	}
	
	public List<DemandeConge> getDemandeConges(){
		return demandecongeRepository.findAll();
	}
	
	public DemandeConge find(int c) {
        return demandecongeRepository.findById(c).isPresent() ? demandecongeRepository.findById(c).get(): null;
    }


    


    public DemandeConge save( DemandeConge c) {
    	
    	Date aujourdhui = new Date();
    	c.setDateD(aujourdhui);
    	c.setEtatD(false);
    	
    	Conge conge = new Conge();
    	conge.setDateDeb(c.getDateDebut());
    	conge.setDateFin(c.getDatefin());
    	conge.setSolde(30);
    	
    	conge.setDemandeConges(c);
    	congeService.save(conge);
    	
    	c.setConge(conge);
        return demandecongeRepository.save(c);
    }
    
    public DemandeConge update ( int code , DemandeConge c) {
    	if(code!=c.getNumeroD()){
            demandecongeRepository.deleteById(code);
        }
        return save(c);
    }

    public void delete (int c) {
    	//if (emp.getIsAdmin())
        demandecongeRepository.deleteById(c);
    }
	
}
*/
