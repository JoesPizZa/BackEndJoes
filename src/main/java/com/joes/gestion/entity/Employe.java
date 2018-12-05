package com.joes.gestion.entity;



import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Employe extends Utilisateur  {

	private String login,mdp;
    private double salaire;
    private float solde;
    private Boolean isAdmin;
    
    @OneToOne(mappedBy="employe",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    
    private Dossier dossier;

    @ManyToOne
    @JoinColumn(name="type_poste_id")
    private TypePost typePost;

    @OneToMany(mappedBy="employe",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
   
    private List<Contrat> contrats;

    @OneToMany( mappedBy = "employe",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Conge> conges;

    
    public List<Conge> getConges() {
        if (conges == null) {
            conges = new ArrayList<>();
        }
        return this.conges;
    }

    public void setConges(List<Conge> conges) {
        this.conges = conges;
    }

    public void addConge(Conge conge) {
        getConges().add(conge);
        conge.setEmployee(this);
    }

    public void removeConge(Conge conge) {
        getConges().remove(conge);
        conge.setEmployee(null);
    }

	public Employe(int cin, String nom, String prenom, String adresse, String login, String mdp, Date dateNaiss, int tel,double salaire) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.dateNaiss = dateNaiss;
        this.tel = tel;
        this.salaire=salaire;
    }

    public Employe() {

    }
    //@JsonIgnore
    public TypePost getTypePost() {
        return typePost;
    }
    //@JsonSetter
    public void setTypePost(TypePost typePost) {
        this.typePost = typePost;
    }
    @JsonIgnore
    public List<Contrat> getContrats() {
        if (contrats == null) {
            contrats = new ArrayList<>();
        }
        return this.contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public void addContrat(Contrat contrat) {
        getContrats().add(contrat);
        contrat.setEmploye(this);
    }

    public void removeContrat(Contrat contrat) {
        getContrats().remove(contrat);
        contrat.setEmploye(null);
    }

    //@JsonIgnore
    public Dossier getDossier() {
        return dossier;
    }
    
    @JsonSetter
    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateNaiss() {
        return dateNaiss;
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

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
}
