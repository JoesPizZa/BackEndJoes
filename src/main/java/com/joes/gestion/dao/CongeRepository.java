package com.joes.gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.joes.gestion.entity.Conge;


public interface CongeRepository extends JpaRepository<Conge, Integer> {
	@Query(value = "SELECT * FROM conge  WHERE etat = ?", nativeQuery = true)
	List<Conge> AfficherSelonEtat(String etat);
	
	@Query(value = "SELECT * FROM conge  WHERE employe_cin = ?1 AND etat = ?2", nativeQuery = true)
	public List<Conge> AfficheSelonEtatAndEmploye(int cin,String ch);
	
	
}
