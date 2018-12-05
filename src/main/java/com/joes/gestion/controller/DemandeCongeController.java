package com.joes.gestion.controller;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joes.gestion.entity.DemandeConge;
import com.joes.gestion.service.DemandeCongeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeCongeController {

	private final DemandeCongeService demandecongeService;

    @Autowired
    public DemandeCongeController(DemandeCongeService demandecongeService) {
        this.demandecongeService = demandecongeService;
    }
    
    @RequestMapping(value="/Demandes",method= RequestMethod.GET)
    public List<DemandeConge> getConges(){

        return demandecongeService.getDemandeConges();
    }

    @RequestMapping(value="/Demandes/{c}",method=RequestMethod.GET)
    public DemandeConge find(@PathVariable int c) {
        return demandecongeService.find(c);
    }

    @RequestMapping(value="/Demandes/{code}",method=RequestMethod.PUT)
    public DemandeConge update (@PathVariable int code , @RequestBody DemandeConge c) {

        return demandecongeService.update(code, c);
    }

    @RequestMapping(value="/Demandes",method=RequestMethod.POST)
    public DemandeConge save(@RequestBody DemandeConge c) {
        return demandecongeService.save(c);
    }

    @RequestMapping(value="/Demandes/{c}",method=RequestMethod.DELETE)
    public void delete (@PathVariable int c) {
    	demandecongeService.delete(c);
    }

}
*/
