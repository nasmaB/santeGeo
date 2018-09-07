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

/**
 *
 * @author Client
 */
@Entity
public class Client extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public Client(String cin, String nom, String prenom, Long tel, String mail) {
        super(cin, nom, prenom, tel, mail);
    }

    public Client() {
        super();
    }
    
    
}
