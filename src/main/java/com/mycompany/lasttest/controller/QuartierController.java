/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lasttest.controller;

import com.mycompany.lasttest.bean.Quartier;
import com.mycompany.lasttest.repositery.QuartierRepositery;
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
@Component(value = "quartierController")
@ELBeanName(value = "quartierController")
@Controller
public class QuartierController {
    private Quartier selected;
    private List<Quartier> items=null;
    @Autowired
    private QuartierRepositery quartierRepositery;
    
    public void createQuartier(){
        quartierRepositery.save(selected);
    }
    
   
    public void destroy(){
        quartierRepositery.delete(selected);
    }
    public Quartier getSelected() {
        if(selected == null){
            selected = new Quartier();
        }
        return selected;
    }

    public void setSelected(Quartier selected) {
        this.selected = selected;
    }

 
    
    public List<Quartier> getItems() {
        if(items == null){
        items = quartierRepositery.findAll();
    }
        return items;
    }

    public void setItems(List<Quartier> items) {
        this.items = items;
    }
      public Quartier getQuartier(java.lang.Long id) {
        return quartierRepositery.findOne(id);
    }
    @FacesConverter(forClass = Quartier.class)
    public static class QuartierControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuartierController controller = (QuartierController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "quartierController");
            return controller.getQuartier(getKey(value));
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
            if (object instanceof Quartier) {
                Quartier q = (Quartier) object;
                return getStringKey(q.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Quartier.class.getName()});
                return null;
            }
        }

    }
    
}
