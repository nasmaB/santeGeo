package com.mycompany.lasttest.controller;


import com.mycompany.lasttest.bean.UserConnexion;
import java.io.IOException;
import java.util.List;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.mycompany.lasttest.Repositery.UserConnexionRepositery;
import com.mycompany.lasttest.util.SessionUtil;

/**
 *
 * @author HP
 */
@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
public class UserController {

    
}
