package com.joes.gestion.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Contrat implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5559617729104224293L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codec;
    private Date debutC;
    private Date finC;
    
    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name="type_contrat_id")
    
    private TypeContrat typeContrat;


    public Contrat(int codec, Date debutC, Date finC) {
        this.codec = codec;
        this.debutC = debutC;
        this.finC = finC;
    }

    public Contrat() {
    }
    @JsonIgnore

    public Employe getEmploye() {
        return employe;
    }
    @JsonSetter
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    //@JsonIgnore
    public TypeContrat getTypeContrat() {
        return typeContrat;
    }
    @JsonSetter
    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public int getCodec() {
        return this.codec;
    }

    public void setCodec(int codec) {
        this.codec = codec;
    }

    public Date getDebutC() {
        return this.debutC;
    }

    public void setDebutC(Date debutC) {
        this.debutC = debutC;
    }

    public Date getFinC() {
        return this.finC;
    }

    public void setFinC(Date finC) {
        this.finC = finC;
    }



}
