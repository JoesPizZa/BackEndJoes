package com.joes.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joes.gestion.dao.TypeContratRepository;

import com.joes.gestion.entity.TypeContrat;


@Service
@Transactional
public class TypeContratService {
	  private final TypeContratRepository typeContratRepository;

	  @Autowired
	public TypeContratService(TypeContratRepository typeContratRepository) {
		
		this.typeContratRepository = typeContratRepository;
	}
	  
	  public TypeContrat update (int code ,  TypeContrat d) {

	        return typeContratRepository.save(d);
	    }

	  public TypeContrat find(String d) {
	    
	        return typeContratRepository.findByDescriptionr(d);
	        
	    }

}