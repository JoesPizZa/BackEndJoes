package com.joes.gestion.service;

import com.joes.gestion.dao.DossierRepository;
import com.joes.gestion.entity.Dossier;
import com.joes.gestion.entity.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class DossierService {
    private final DossierRepository dossierRepository;
    @Autowired
    private EmployeService employeService ;

    @Autowired
    public DossierService(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }


    public List<Dossier> getDossiers(){
        return dossierRepository.findAll();
    }

    public Dossier find(int d) {
        return dossierRepository.findById(d).isPresent()? dossierRepository.findById(d).get():null;
    }

    public Dossier findDossierByCin(int cin) {
    	return dossierRepository.findDossierByCin(cin);
    }

    


    public Dossier save(Dossier d) {


    	Employe e =  employeService.findEmployeById(d.getEmploye().cin);
    	
    	e.setDossier(d);
    	dossierRepository.save(d);
    	employeService.updateEmploye(e, e.cin);
    	
    	
        return d;
    }
    
    public Dossier update (int code ,  Dossier d) {
    	if(code==d.getCoded()){
            dossierRepository.deleteById(code);
        }
        return save(d);
    }

    public void delete (int d) {
        dossierRepository.deleteById(d);
    }
}

