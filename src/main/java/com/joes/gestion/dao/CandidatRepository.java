package com.joes.gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joes.gestion.entity.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Integer>{
	@Query(value = "SELECT * FROM candidat  WHERE etat = ?", nativeQuery = true)
	List<Candidat> AfficherSelonEtat(String etat);
}
