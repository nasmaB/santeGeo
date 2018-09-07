/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.bean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */
@Entity
public class Responsable extends User implements Serializable {

   

    private static final long serialVersionUID = 1L;
   
     @OneToMany(mappedBy = "responsable")
    private List<Etablissement> etablissements;


    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }

    public Responsable(List<Etablissement> etablissements, String cin, String nom, String prenom, Long tel, String mail) {
        super(cin, nom, prenom, tel, mail);
        this.etablissements = etablissements;
    }

    public Responsable() {
        super();
    }
    
   

  

    
}
