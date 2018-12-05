package com.joes.gestion.service;

import java.util.List;

import com.joes.gestion.entity.Conge;

public interface ICongeService {

	public Conge AccepterConge(Conge c);
	public Conge RefuserConge(Conge c);
	
	public List<Conge> AfficherCongeEnAttente(String ch);
	public List<Conge> AfficheCongeEnAttenteParEmploye(int cin,String ch);
	
	public List<Conge> AfficherCongeRefuser(String ch);
	public List<Conge> AfficheCongeRefuserParEmploye(int cin,String ch);
	
	public List<Conge> AfficherCongeAccepter(String ch);
	public List<Conge> AfficheCongeAccepterParEmploye(int cin,String ch);
}
