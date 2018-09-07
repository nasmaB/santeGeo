/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.Repositery;

import com.mycompany.lasttest.bean.UserConnexion;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.lasttest.custom.UserConnexionRepositeryCustom;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface UserConnexionRepositery extends JpaRepository<UserConnexion, String>,UserConnexionRepositeryCustom {
    
 public UserConnexion findByMdp(String mdp);
    
}
