/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.repositery;

import com.mycompany.lasttest.bean.Quartier;
import com.mycompany.lasttest.bean.Ville;
import com.mycompany.lasttest.custom.QuartierRepositeryCustom;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface QuartierRepositery extends JpaRepository<Quartier, Long>,QuartierRepositeryCustom {
 List<Quartier> findByVille(Ville ville); 
}
