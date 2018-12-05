package com.joes.gestion.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeContrat implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1394151079752445784L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idC;
    private String descriptionC;
    @OneToMany(mappedBy="typeContrat",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Contrat> contrats;

    public TypeContrat(int idC, String descriptionC) {
        this.idC = idC;
        this.descriptionC = descriptionC;
    }

    public TypeContrat() {
    }

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
        contrat.setTypeContrat(this);
    }

    public void removeContrat(Contrat contrat) {
        getContrats().remove(contrat);
        contrat.setTypeContrat(null);
   
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getDescriptionC() {
        return descriptionC;
    }

    public void setDescriptionC(String descriptionC) {
        this.descriptionC = descriptionC;
    }
}
