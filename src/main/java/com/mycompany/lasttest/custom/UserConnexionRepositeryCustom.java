/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.custom;

import com.mycompany.lasttest.bean.Client;
import com.mycompany.lasttest.bean.Responsable;
import com.mycompany.lasttest.bean.User;
import com.mycompany.lasttest.bean.UserConnexion;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author HP
 */

public interface  UserConnexionRepositeryCustom {
    
    
    public Object[] seConnecter(String login, String pswrd);
    public void registerNewAccount(UserConnexion userConexion,Responsable respo);
}
