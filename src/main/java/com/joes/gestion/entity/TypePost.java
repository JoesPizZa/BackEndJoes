package com.joes.gestion.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypePost implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @OneToMany(mappedBy="typePost",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Employe> employes;
    
    @OneToMany(mappedBy="typePost",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Candidat> candidats;

    public TypePost(String description) {
        this.description = description;
    }

    public TypePost() {
    }

    public List<Employe> getEmployes() {
        if (employes == null) {
        	employes = new ArrayList<>();
        }
        return this.employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void addEmploye(Employe employe) {
        getEmployes().add(employe);
        employe.setTypePost(this);
    }

    public void removeEmploye(Employe employe) {
        getEmployes().remove(employe);
        employe.setTypePost(null);
   
    }
    
    
    public List<Candidat> getCandidats() {
        if (candidats == null) {
        	candidats = new ArrayList<>();
        }
        return this.candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }

    public void addCandidat(Candidat candidat) {
    	getCandidats().add(candidat);
        candidat.setTypePost(this);
    }

    public void removeCandidat(Candidat candidat) {
    	getCandidats().remove(candidat);
        candidat.setTypePost(null);
   
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
