package com.joes.gestion.dao;

import com.joes.gestion.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DossierRepository extends JpaRepository<Dossier,Integer> {

	@Query(value="SELECT * from dossier WHERE employe_cin=?",nativeQuery=true)
	public Dossier findDossierByCin(int cin);
}
