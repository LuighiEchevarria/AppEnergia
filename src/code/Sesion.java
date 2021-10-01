/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import model.Perfil;

/**
 *
 * @author Jesus Enrique
 */
public class Sesion {
    
    private Perfil userSesion;
    
    public Sesion(){
        this.userSesion = null;
    }
    
    public Sesion(Perfil userSesion) {
        this.userSesion = userSesion;
    }

    public void setUserSesion(Perfil userSesion) {
        this.userSesion = userSesion;
    }

    public Perfil getUserSesion() {
        return userSesion;
    }
    
    public void cerrarSesion(){
        this.userSesion = null;
    }
    
    @Override
    public String toString() {
        return "Sesion{" + "userSesion=" + userSesion + '}';
    }
    
    
    
}
