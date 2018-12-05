package com.joes.gestion.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidat extends Utilisateur implements Serializable {

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String etat;
	
	 @ManyToOne
	    @JoinColumn(name="type_poste_id")
	    private TypePost typePost;
		public Candidat () {
		
	}
	
	
	
	public TypePost getTypePost() {
		return typePost;
	}



	public void setTypePost(TypePost typePost) {
		this.typePost = typePost;
	}



	public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


	

	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}
}
