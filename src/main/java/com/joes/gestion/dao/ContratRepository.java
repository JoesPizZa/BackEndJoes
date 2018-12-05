package com.joes.gestion.dao;

import com.joes.gestion.entity.Contrat;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
	
	@Query(value="SELECT * from contrat where employe_id=?",nativeQuery=true)
	public List<Contrat> findContratByCin(int cin);
}
