package com.joes.gestion.service;

import java.util.List;

import com.joes.gestion.entity.Candidat;
import com.joes.gestion.entity.Employe;

public interface ICandidatService {

	public Candidat ajouterCandidat(Candidat c);
	public List<Candidat> afficherCandidatRefuser (String etat);
	public void accepterCandidat(Employe e);
	public Candidat rechercheCandidatById(int id);
	
}
