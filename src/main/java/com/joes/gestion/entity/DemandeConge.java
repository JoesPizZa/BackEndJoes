package com.joes.gestion.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class DemandeConge implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3315249961882360780L;

	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numeroD;

    
    @Temporal(TemporalType.DATE)
    private Date dateD;
    
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    
    @Temporal(TemporalType.DATE)
    private Date datefin;

   
    
    private boolean etatD;

    @OneToOne(mappedBy="demandeConge",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Conge conge;
    
    

    public DemandeConge() {
	}

   


	public DemandeConge(int numeroD, Date dateD, Date dateDebut, Date datefin, boolean etatD,
			Conge conge) {
		super();
		this.numeroD = numeroD;
		this.dateD = dateD;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		
		this.etatD = etatD;
		this.conge = conge;
	}


	public DemandeConge(Date dateD, Date dateDebut, Date datefin, boolean etatD) {
		super();
		this.dateD = dateD;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.etatD = etatD;
	}


	public int getNumeroD() {
        return this.numeroD;
    }

    public void setNumeroD(int numeroD) {
        this.numeroD = numeroD;
    }

    public Date getDateD() {
        return this.dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public boolean isEtatD() {
        return this.etatD;
    }

    public void setEtatD(boolean etatD) {
        this.etatD = etatD;
    }
    
    public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@JsonIgnore
    public Conge getConge() {
        return this.conge;
    }

    public void setConge(Conge conge) {
        this.conge = conge;
    }


	

}
