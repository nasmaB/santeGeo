package com.mycompany.lasttest.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author HP
 */
@Entity
public class UserConnexion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String login;
    private String mdp;
    private Boolean blocked;
    private String questionSecrete;
    private String reponseSecrete;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "userConnexion")
    private List<Device> devices;

    public UserConnexion() {
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }

    public String getReponseSecrete() {
        return reponseSecrete;
    }

    public void setReponseSecrete(String reponseSecrete) {
        this.reponseSecrete = reponseSecrete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserConnexion(String login, String mdp, Boolean blocked, String questionSecrete, String reponseSecrete, User user) {
        this.login = login;
        this.mdp = mdp;
        this.blocked = blocked;
        this.questionSecrete = questionSecrete;
        this.reponseSecrete = reponseSecrete;
        this.user = user;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the login fields are not set
        if (!(object instanceof UserConnexion)) {
            return false;
        }
        UserConnexion other = (UserConnexion) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "userConnexion[ id=" + login + " ]";
    }
    
}
