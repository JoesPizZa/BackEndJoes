package com.joes.gestion.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joes.gestion.dao.TypeCongeRepository;
import com.joes.gestion.entity.TypeConge;

@Service
@Transactional
public class TypeCongeService {

	 private final TypeCongeRepository typeCongeRepository;

	  @Autowired
	public TypeCongeService(TypeCongeRepository typeCongeRepository) {
		
		this.typeCongeRepository = typeCongeRepository;
	}
	  
	  public TypeConge update (int code ,  TypeConge d) {

	        return typeCongeRepository.save(d);
	    }

	  public TypeConge find(String d) {
	    
	        return typeCongeRepository.findByDescriptionCN(d);
	        
	    }

}
