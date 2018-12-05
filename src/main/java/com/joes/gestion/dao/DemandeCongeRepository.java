package com.joes.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joes.gestion.entity.DemandeConge;

public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Integer> {

}
