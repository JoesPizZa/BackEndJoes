package com.joes.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joes.gestion.entity.TypePost;

public interface TypePostRepository  extends  JpaRepository<TypePost, Integer> {
	 @Query("SELECT t FROM TypePost t WHERE t.description = ?1 ")
	 TypePost findByDescriptionr(String d);

}
