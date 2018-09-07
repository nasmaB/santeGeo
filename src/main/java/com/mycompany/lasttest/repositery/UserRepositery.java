/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.repositery;

import com.mycompany.lasttest.bean.UserConnexion;
import com.mycompany.lasttest.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.lasttest.custom.UserConnexionRepositeryCustom;
import com.mycompany.lasttest.custom.UserRepositeryCustom;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface UserRepositery extends JpaRepository<User, String>,UserRepositeryCustom {
    
    
}
