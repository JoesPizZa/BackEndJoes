package com.joes.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joes.gestion.entity.TypeContrat;


public interface TypeContratRepository extends  JpaRepository<TypeContrat, Integer> {
	 @Query("SELECT t FROM TypeContrat t WHERE t.descriptionC = ?1 ")
	 TypeContrat findByDescriptionr(String d);

}
