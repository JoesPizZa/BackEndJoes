package com.joes.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joes.gestion.entity.TypeConge;


public interface TypeCongeRepository extends  JpaRepository<TypeConge, Integer> {
	 @Query(value="SELECT * FROM type_conge  WHERE descriptioncn = ? ",nativeQuery=true)
	 TypeConge findByDescriptionCN(String d);


}
