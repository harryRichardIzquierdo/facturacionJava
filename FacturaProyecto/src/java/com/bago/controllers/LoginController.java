package com.bago.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean( name = "login" )
@SessionScoped
public class LoginController {
    @PostConstruct
    public void init() {
        setAdmin(true);
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
//<editor-fold defaultstate="collapsed" desc="atributos">
        private String user;
        private String password;
        private boolean admin;
        
        private HttpServletRequest httpServletRequest;
        private FacesContext faceContext;
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc="propiedades">
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="acciones">
    public void validateUser(){
        httpServletRequest.getSession().setAttribute("usr", "nombre");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
//</editor-fold>
}
