package com.joes.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joes.gestion.entity.Conge;
import com.joes.gestion.service.CongeService;


@RestController
@CrossOrigin("*")
public class CongeController {
	String etat;
	private final CongeService congeService;

    @Autowired
    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }
    
    @RequestMapping(value="/solde/{id}",method=RequestMethod.GET)
    public Long solde(@PathVariable int id) {
        return congeService.soldeRestant(id);
    }
    
    @RequestMapping(value="/CongesEnAttente",method=RequestMethod.GET)
    public List<Conge> congesEnAttente() {
        return congeService.AfficherCongeEnAttente(etat);
    }
    
    @RequestMapping(value="/CongesEnAttenteParEmploye/{cin}",method=RequestMethod.GET)
    public List<Conge> congesEnAttenteParEmploye(@PathVariable int cin) {
        return congeService.AfficheCongeEnAttenteParEmploye(cin, etat);
    }
    
    @RequestMapping(value="/CongesRefuser",method=RequestMethod.GET)
    public List<Conge> congesRefuser() {
        return congeService.AfficherCongeRefuser(etat);
    }
    
    @RequestMapping(value="/CongesRefuserParEmploye/{cin}",method=RequestMethod.GET)
    public List<Conge> congesRefuserParEmploye(@PathVariable int cin) {
        return congeService.AfficheCongeRefuserParEmploye(cin, etat);
    }

    @RequestMapping(value="/CongesAccepter",method=RequestMethod.GET)
    public List<Conge> congesAccpeter() {
        return congeService.AfficherCongeAccepter(etat);
    }
    
    @RequestMapping(value="/CongesAccepterParEmploye/{cin}",method=RequestMethod.GET)
    public List<Conge> congesAccpeterParEmploye(@PathVariable int cin) {
        return congeService.AfficheCongeAccepterParEmploye(cin, etat);
    }
    
    
    @RequestMapping(value="/Conges/{code}",method=RequestMethod.PUT)
    public Conge update (@PathVariable int code , @RequestBody Conge c) {

        return congeService.update(code, c);
    }
    
    @RequestMapping(value="/CongesAccepter/{code}",method=RequestMethod.PUT)
    public Conge Accepter ( @RequestBody Conge c) {

        return congeService.AccepterConge(c);
    }

    @RequestMapping(value="/CongesRefuser/{code}",method=RequestMethod.PUT)
    public Conge Refuser (@PathVariable int code , @RequestBody Conge c) {

        return congeService.RefuserConge(c);
    }
    

    @RequestMapping(value="/Conges",method=RequestMethod.POST)
    public Conge save(@RequestBody Conge c) {
        return congeService.save(c);
    }
    
    
    @RequestMapping(value="/Conges/{c}",method=RequestMethod.DELETE)
    public void delete (@PathVariable int c) {
    	congeService.delete(c);
    }

}
