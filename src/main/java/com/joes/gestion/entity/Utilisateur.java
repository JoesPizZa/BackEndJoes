package com.joes.gestion.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Utilisateur {
    @Id

    public int cin;

    public String nom,prenom,adresse,login;
    public Date dateNaiss;
    public int tel;

    public Utilisateur(int cin, String nom, String prenom, String adresse, String login, Date dateNaiss, int tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.login= login;
        this.dateNaiss = dateNaiss;
        this.tel = tel;
    }

    public Utilisateur() {
    }


}
