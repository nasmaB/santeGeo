/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.implementationCustom;

import com.mycompany.lasttest.util.HashageUtil;
import com.mycompany.lasttest.util.JsfUtil;
import com.mycompany.lasttest.bean.UserConnexion;
import com.mycompany.lasttest.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.lasttest.Repositery.UserConnexionRepositery;
import com.mycompany.lasttest.bean.Client;
import com.mycompany.lasttest.bean.Responsable;
import com.mycompany.lasttest.custom.UserConnexionRepositeryCustom;
import com.mycompany.lasttest.repositery.ClientRepositery;
import com.mycompany.lasttest.repositery.UserRepositery;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *
 * @author HP
 */
public class UserConnexionRepositeryImpl implements UserConnexionRepositeryCustom {
    
    @Autowired
    private UserConnexionRepositery userConnexionRepositery;
    @Autowired
    private UserRepositery userRepositery;
    @Autowired
    private ClientRepositery clientRepositery;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public Object[] seConnecter(String login, String pswrd) {
        System.out.println("hanii tanii 2222222222222222222222222");
        System.out.println("haaa le login=>"+login);
        System.out.println("haaa le mdp=>"+pswrd);
        if (login == null) {
            System.out.println("=== login null");
            return new Object[]{-1, null};
        } else {
            UserConnexion userConnexion = userConnexionRepositery.findOne(login);
            System.out.println("haa le user=>"+userConnexion.getLogin()+" et son mdp=>"+userConnexion.getMdp());
            if (userConnexion == null) { //no user 
                JsfUtil.addErrorMessage("Votre login est incorrecte !", "login");
                return new Object[]{-2, null};
          }
            else if(!passwordEncoder.matches(pswrd, userConnexion.getMdp())) {
                System.out.println("mdr ghalat");
                JsfUtil.addErrorMessage("mdp incorrect");
                return new Object[]{-3, null};
            }
            else {
                return new Object[]{1, userConnexion};
            }
        }
    }
    @Override
    public void registerNewAccount(UserConnexion userConexion,Responsable respo){
          userRepositery.save(respo);
          UserConnexion compte = new UserConnexion();
          compte.setUser(respo);
          compte.setLogin(userConexion.getLogin());
          compte.setMdp(passwordEncoder.encode(userConexion.getMdp()));
          System.out.println("hahwa l mdp hashe ----"+compte.getMdp());
          userConnexionRepositery.save(compte);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}
    
}
