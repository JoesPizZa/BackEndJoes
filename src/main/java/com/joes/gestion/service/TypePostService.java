package com.joes.gestion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.joes.gestion.dao.TypePostRepository;
import com.joes.gestion.entity.TypePost;

@Service
@Transactional
public class TypePostService {
	  private final TypePostRepository typePostRepository;

	  @Autowired
	public TypePostService(TypePostRepository typePostRepository) {
		
		this.typePostRepository = typePostRepository;
	}
	  
	  public TypePost update (int code ,  TypePost d) {

	        return typePostRepository.save(d);
	    }

	  public TypePost find(String d) {
	     return typePostRepository.findByDescriptionr(d);
	        
	        
	    }

}
