package com.joes.gestion.entity;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Conge implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4133521753809343423L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codeconges;

	 @Temporal(TemporalType.DATE)
	    private Date dateD;
	
  //  @Temporal(TemporalType.DATE)
    private LocalDate dateDeb;

    
  //  @Temporal(TemporalType.DATE)
    private LocalDate dateFin;

  
   // private float solde;
    
    //Accepter Refuser En attente
    @Value("En attente") 
    private String etat;

    @OneToOne()
    @JsonIgnore
    private DemandeConge demandeConge;

    @ManyToOne()
    
    private Employe employe;

    @ManyToOne()
    
    private TypeConge typeConge;

    
    
    public Conge() {
		
	}
    
    
    
	public int getCodeconges() {
        return this.codeconges;
    }

    public void setCodeconges(int codeconges) {
        this.codeconges = codeconges;
    }

    
    
    public Date getDateD() {
		return dateD;
	}



	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}



	public LocalDate getDateDeb() {
        return this.dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
/*
    public float getSolde() {
        return this.solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }
    
*/
    public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}



	@JsonIgnore
	public DemandeConge getDemandeConges() {
        return this.demandeConge;
    }

    public void setDemandeConges(DemandeConge demandeConges) {
        this.demandeConge = demandeConges;
    }
    @JsonIgnore
    public Employe getEmployee() {
        return this.employe;
    }
    @JsonSetter
    public void setEmployee(Employe employee) {
        this.employe = employee;
    }
 //   @JsonIgnore
    public TypeConge getTypeConge() {
        return this.typeConge;
    }
    @JsonSetter
    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
    }



	

}
