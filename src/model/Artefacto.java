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
public class Artefacto {
    
    private int codigo_artefacto;
    private String nombre_artefacto;
    private double kv_artefacto_prom;

    public Artefacto() {
    }

    public Artefacto(int codigo_artefacto, String nombre_artefacto, double kv_artefacto_prom) {
        this.codigo_artefacto = codigo_artefacto;
        this.nombre_artefacto = nombre_artefacto;
        this.kv_artefacto_prom = kv_artefacto_prom;
    }
    
    
    public int getCodigo_artefacto() {
        return codigo_artefacto;
    }

    public void setCodigo_artefacto(int codigo_artefacto) {
        this.codigo_artefacto = codigo_artefacto;
    }

    public String getNombre_artefacto() {
        return nombre_artefacto;
    }

    public void setNombre_artefacto(String nombre_artefacto) {
        this.nombre_artefacto = nombre_artefacto;
    }

    public double getKv_artefacto_prom() {
        return kv_artefacto_prom;
    }

    public void setKv_artefacto_prom(double kv_artefacto_prom) {
        this.kv_artefacto_prom = kv_artefacto_prom;
    }
    
    
    
    
}
