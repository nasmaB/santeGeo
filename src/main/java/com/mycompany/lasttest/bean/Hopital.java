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
import javax.persistence.ManyToMany;

/**
 *
 * @author HP
 */
@Entity
public class Hopital extends Etablissement implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @ManyToMany
    private List<ServiceHopital> servicesHopital;
 

    public List<ServiceHopital> getServicesHopital() {
        return servicesHopital;
    }

    public void setServicesHopital(List<ServiceHopital> servicesHopital) {
        this.servicesHopital = servicesHopital;
    }
    


 

   
    
}
