package com.joes.gestion.service;


import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

//import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.joes.gestion.dao.CongeRepository;
import com.joes.gestion.entity.Conge;
import com.joes.gestion.entity.Employe;
import com.joes.gestion.entity.TypeConge;



@Service
@Transactional


public class CongeService implements ICongeService {
	
	String ch="";
	@Autowired
	private  TypeCongeService typeCongeService;
	
	@Autowired
  	EmployeService employeService;
	private final CongeRepository congeRepository;
	@Autowired
	public CongeService(CongeRepository congeRepository) {
		this.congeRepository=congeRepository;
		
	}
	
	public List<Conge> getConges(){
		return congeRepository.findAll();
	}
	
	public Conge find(int c) {
        return congeRepository.findById(c).isPresent() ? congeRepository.findById(c).get(): null;
    }
	
    public Conge update ( int code , Conge c) {
    	congeRepository.deleteById(c.getCodeconges());
        return congeRepository.save(c);
    }


    public Conge save( Conge c) {
    	Date aujourdhui = new Date();
    	c.setDateD(aujourdhui);
    	c.setEtat("En attente");
    	//c.setSolde(18);
    	TypeConge tc = typeCongeService.find(c.getTypeConge().getDescriptionCN());
    	tc.addConge(c);
    	congeRepository.save(c);
    	typeCongeService.update(tc.getId(), tc);
    	
    	Employe e= employeService.findEmployeById(c.getEmployee().cin);
    	e.addConge(c);
    	//e.setSolde(18);
    	employeService.updateEmploye(e, e.cin) ; 
    	
        return c; 
    }

    public void delete (int c) {
    	  congeRepository.deleteById(c);
    	
    }

	@Override
	public Conge AccepterConge(Conge c) {
		// TODO Auto-generated method stub
		
		if( c.getEmployee().getSolde()>0 && c.getEmployee().getSolde()-this.soldeRestant(c.getCodeconges())>0) {
		congeRepository.deleteById(c.getCodeconges());
		c.setEtat("Accepter");
		c.getEmployee().setSolde(c.getEmployee().getSolde()-this.soldeRestant(c.getCodeconges()));
		
        return congeRepository.save(c);}
		else
			return RefuserConge(c);
	}

	@Override
	public Conge RefuserConge(Conge c) {
		// TODO Auto-generated method stub
		congeRepository.deleteById(c.getCodeconges());
		c.setEtat("Refuser");
		
		
        return congeRepository.save(c);
	}

	@Override
	public List<Conge> AfficherCongeEnAttente(String ch) {
		// TODO Auto-generated method stub
		ch="En attente";
		return congeRepository.AfficherSelonEtat(ch);
	}

	@Override
	public List<Conge> AfficheCongeEnAttenteParEmploye(int cin, String ch) {
		// TODO Auto-generated method stub
		ch="En attente";
		return congeRepository.AfficheSelonEtatAndEmploye(cin, ch);
	}

	@Override
	public List<Conge> AfficherCongeRefuser(String ch) {
		// TODO Auto-generated method stub
		ch="Refuser";
		return congeRepository.AfficherSelonEtat(ch);
	}

	@Override
	public List<Conge> AfficheCongeRefuserParEmploye(int cin, String ch) {
		// TODO Auto-generated method stub
		ch="Refuser";
		return congeRepository.AfficheSelonEtatAndEmploye(cin, ch);
	}

	@Override
	public List<Conge> AfficherCongeAccepter(String ch) {
		// TODO Auto-generated method stub
		ch="Accepter";
		return congeRepository.AfficherSelonEtat(ch);
	}

	@Override
	public List<Conge> AfficheCongeAccepterParEmploye(int cin, String ch) {
		// TODO Auto-generated method stub
		ch="Accepter";
		return congeRepository.AfficheSelonEtatAndEmploye(cin, ch);
	}
    
	public Long soldeRestant (int id) {
		//int days = Days.daysBetween(c.getDateDeb(), c.getDateFin());
		Conge c = congeRepository.getOne(id);
		long days = ChronoUnit.DAYS.between(c.getDateDeb(), c.getDateFin());

		return days;
	}
   
	
   
	
	
}
