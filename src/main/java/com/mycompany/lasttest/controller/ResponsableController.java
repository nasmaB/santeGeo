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
import com.mycompany.lasttest.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@Scope(value = "session")
@Component(value = "responsableController")
@ELBeanName(value = "responsableController")
public class ResponsableController {

    

}
