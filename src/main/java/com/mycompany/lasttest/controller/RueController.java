package com.mycompany.lasttest.controller;


import com.mycompany.lasttest.bean.UserConnexion;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.mycompany.lasttest.Repositery.UserConnexionRepositery;
import com.mycompany.lasttest.bean.Quartier;
import com.mycompany.lasttest.bean.Rue;
import com.mycompany.lasttest.bean.Ville;
import com.mycompany.lasttest.repositery.QuartierRepositery;
import com.mycompany.lasttest.repositery.RueRepositery;
import com.mycompany.lasttest.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@Scope(value = "session")
@Component(value = "rueController")
@ELBeanName(value = "rueController")
@Controller
public class RueController {
   private Rue selected;
   private List<Rue> items=null;
   private Ville villeForCreate;
   private List<Quartier> quartiers; 
   @Autowired
   private RueRepositery rueRepositery;
   @Autowired
   private QuartierRepositery quartierRepositery;
   
   public void create(){
       rueRepositery.save(selected);
   }
   public void findByVille(){
       System.out.println("hani dkhelt l controler");
       System.out.println("hahouma quartier 9bel ---"+quartiers);
      quartiers = quartierRepositery.findByVille(villeForCreate);
       System.out.println("hahouma men be3d-----"+quartiers);
   }

    public Rue getSelected() {
        if(selected == null){
            selected = new Rue();
        }
        return selected;
    }

    public void setSelected(Rue selected) {
        this.selected = selected;
    }

    public Ville getVilleForCreate() {
        return villeForCreate;
    }

    public void setVilleForCreate(Ville villeForCreate) {
        this.villeForCreate = villeForCreate;
    }

    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }
    
    public List<Rue> getItems() {
        if(items == null){
            items = rueRepositery.findAll();
        }
        return items;
    }

    public void setItems(List<Rue> items) {
        this.items = items;
    }
   
   
   

}
