/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jesus Enrique
 */
public class Perfil {
    
    private int codigo_perfil;
    private String nombres;
    private String apellidos;
    private String correo_electronico;
    private double costo_kv;

    public Perfil() {
    }
        
    public Perfil(int codigo_perfil, String nombres, String apellidos, String correo_electronico, double costo_kv) {
        this.codigo_perfil = codigo_perfil;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo_electronico = correo_electronico;
        this.costo_kv = costo_kv;
    }
    
    

    public int getCodigo_perfil() {
        return codigo_perfil;
    }

    public void setCodigo_perfil(int codigo_perfil) {
        this.codigo_perfil = codigo_perfil;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public double getCosto_kv() {
        return costo_kv;
    }

    public void setCosto_kv(double costo_kv) {
        this.costo_kv = costo_kv;
    }
    
    
    
}
