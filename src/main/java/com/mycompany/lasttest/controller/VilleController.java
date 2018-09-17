/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.controller;

import com.mycompany.lasttest.bean.Ville;
import com.mycompany.lasttest.repositery.VilleRepositery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
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
@Component(value = "villeController")
@ELBeanName(value = "villeController")
@Controller
public class VilleController {
    private Ville selected;
    private List<Ville> items=null;
    @Autowired
    private VilleRepositery villeRepositery;
    
    public void createVille(){
        System.out.println("hani dkhelt");
        villeRepositery.save(selected);
    }
    public void destroy(){
        villeRepositery.delete(selected);
    }
    public Ville getSelected() {
        if(selected == null){
            selected = new Ville();
        }
        return selected;
    }

    public void setSelected(Ville selected) {
        this.selected = selected;
    }

    public List<Ville> getItems() {
        if(items == null){
            items = villeRepositery.findAll();
        }
        return items;
    }

    public void setItems(List<Ville> items) {
        this.items = items;
    }
      public Ville getVille(java.lang.Long id) {
        return villeRepositery.findOne(id);
    }
       @FacesConverter(forClass = Ville.class)
    public static class VilleControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VilleController controller = (VilleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "villeController");
            return controller.getVille(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ville) {
                Ville v = (Ville) object;
                return getStringKey(v.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ville.class.getName()});
                return null;
            }
        }

       
       

    }
    
    
}
