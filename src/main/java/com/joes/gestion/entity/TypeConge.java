package com.joes.gestion.entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class TypeConge implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7311623029256862605L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String descriptionCN;

    @OneToMany( mappedBy = "typeConge")
    @JsonIgnore
    private List<Conge> conges;
    
    

    public TypeConge() {
    	
	}

	public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionCN() {
        return this.descriptionCN;
    }

    public void setDescriptionCN(String descriptionCN) {
        this.descriptionCN = descriptionCN;
    }

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
        conge.setTypeConge(this);
    }

    public void removeConge(Conge conge) {
        getConges().remove(conge);
        conge.setTypeConge(null);
    }

}