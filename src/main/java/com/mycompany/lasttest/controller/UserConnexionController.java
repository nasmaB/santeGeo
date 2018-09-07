package com.mycompany.lasttest.controller;

import com.mycompany.lasttest.Repositery.UserConnexionRepositery;
import com.mycompany.lasttest.bean.Client;
import com.mycompany.lasttest.bean.Responsable;
import com.mycompany.lasttest.bean.User;
import com.mycompany.lasttest.bean.UserConnexion;
import com.mycompany.lasttest.util.SessionUtil;
import java.io.IOException;
import java.util.List;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author HP
 */
@Scope(value = "session")
@Component(value = "userConnexionController")
@ELBeanName(value = "userConnexionController")
@Controller
public class UserConnexionController {

    private List<UserConnexion> items = null;
    private UserConnexion selected;
    private User user;
    private Client client;
    private Responsable respo;
    @Autowired
    private UserConnexionRepositery facade;

    //connexion 
    public void connect() throws IOException {
        Object[] res = getFacade().seConnecter(selected.getLogin(), selected.getMdp());
        int resEnt = (int) res[0];
        selected = (UserConnexion) res[1];
        if (resEnt < 0) {
            System.out.println(" ++++++ " + resEnt);
        } else {
            // User Connecter
            System.out.println("----- controllerInscrit connected");
            System.out.println("=== inscrit information : " + selected.getUser().getNom());
            SessionUtil.redirect("../etablissement/Create.jsf");
        }
    }
    public void registerAccount(){
        System.out.println("hani dkhelt l controller");
        System.out.println("hahwa id dial user---"+respo.getCin());
       getFacade().registerNewAccount(selected, respo);
               
    }
//getter and setter
    public UserConnexionRepositery getFacade() {
        return facade;
    }

    public void setFacade(UserConnexionRepositery facade) {
        this.facade = facade;
    }

    public Responsable getRespo() {
        if(respo == null){
            respo = new Responsable();
        }
        return respo;
    }

    public void setRespo(Responsable respo) {
        this.respo = respo;
    }

  
   
    public Client getClient() {
        if(client == null){
            client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public List<UserConnexion> getItems() {
        if (items == null) {
            items = facade.findAll();
        }
        return items;
    }

    public UserConnexion getSelected() {
        if (selected == null) {
            selected = new UserConnexion();
        }
        return selected;
    }

    public void setSelected(UserConnexion selected) {
        this.selected = selected;
    }

}
