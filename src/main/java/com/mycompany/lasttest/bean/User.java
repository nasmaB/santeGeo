/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.bean;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author HP
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String cin;
    private String nom;
    private String prenom;
    private Long tel;
    private String mail;
    @OneToOne(mappedBy = "user")
    private UserConnexion userConnexion;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserConnexion getUserConnexion() {
        return userConnexion;
    }

    public void setUserConnexion(UserConnexion userConnexion) {
        this.userConnexion = userConnexion;
    }

    public User() {
    }
    
    public User(String cin, String nom, String prenom, Long tel, String mail) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cin != null ? cin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the cin fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.cin == null && other.cin != null) || (this.cin != null && !this.cin.equals(other.cin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.bean.User[ id=" + cin + " ]";
    }
    
}
