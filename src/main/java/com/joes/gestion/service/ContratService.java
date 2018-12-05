package com.joes.gestion.service;

import com.joes.gestion.dao.ContratRepository;
import com.joes.gestion.entity.Contrat;
import com.joes.gestion.entity.Employe;
import com.joes.gestion.entity.TypeContrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;



@Service
@Transactional
public class ContratService {

    private final ContratRepository contratRepository;
    @Autowired
  	EmployeService employeService;
  	  @Autowired
  	  TypeContratService typecontratService;
    @Autowired
    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }


    public List<Contrat> getContrats(){

        return contratRepository.findAll();
    }


    public Contrat find(int c) {
        return contratRepository.findById(c).isPresent() ? contratRepository.findById(c).get(): null;
    }

    public List<Contrat> findContratByCin(int cin) {
    	return contratRepository.findContratByCin(cin);
    }

   


    public Contrat save( Contrat c) {

    	TypeContrat tc=typecontratService.find(c.getTypeContrat().getDescriptionC());
    	tc.addContrat(c);
  
    	contratRepository.save(c);
    	typecontratService.update(tc.getIdC(), tc);
    	Employe e= employeService.findEmployeById(c.getEmploye().cin);
    	e.addContrat(c);
    	employeService.updateEmploye(e, e.cin) ; 
    	return c;
    }
    public Contrat update ( int code , Contrat c) {
    	if(code==c.getCodec()){
            contratRepository.deleteById(code);
          
        }
        return save(c);
    }

    public void delete (int c) {
        contratRepository.deleteById(c);
    }

}

