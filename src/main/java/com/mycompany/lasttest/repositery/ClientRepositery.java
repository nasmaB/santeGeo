/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.repositery;

import com.mycompany.lasttest.bean.Client;
import com.mycompany.lasttest.custom.ClientRepositeryCustom;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ClientRepositery extends JpaRepository<Client, String>,ClientRepositeryCustom{
    
}
