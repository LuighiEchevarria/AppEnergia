/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.util.Date;
/**
 *
 * @author Jesus Enrique
 */
public class Control {
    
    
    private int codigo_control;
    private String nombre_artefacto;
    private int cantidad;
    private int tiempo_uso;
    private int dia_uso;
    private double kv;
    private Date periodo;
    private int codigo_perfil;

    public Control() {
    }

    public Control(int codigo_control, String nombre_artefacto, int cantidad, int tiempo_uso, int dia_uso, double kv, Date periodo, int codigo_perfil) {
        this.codigo_control = codigo_control;
        this.nombre_artefacto = nombre_artefacto;
        this.cantidad = cantidad;
        this.tiempo_uso = tiempo_uso;
        this.dia_uso = dia_uso;
        this.kv = kv;
        this.periodo = periodo;
        this.codigo_perfil = codigo_perfil;
    }
    
    
    public int getCodigo_control() {
        return codigo_control;
    }

    public void setCodigo_control(int codigo_control) {
        this.codigo_control = codigo_control;
    }

    public String getNombre_artefacto() {
        return nombre_artefacto;
    }

    public void setNombre_artefacto(String nombre_artefacto) {
        this.nombre_artefacto = nombre_artefacto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTiempo_uso() {
        return tiempo_uso;
    }

    public void setTiempo_uso(int tiempo_uso) {
        this.tiempo_uso = tiempo_uso;
    }

    public int getDia_uso() {
        return dia_uso;
    }

    public void setDia_uso(int dia_uso) {
        this.dia_uso = dia_uso;
    }

    public double getKv() {
        return kv;
    }

    public void setKv(double kv) {
        this.kv = kv;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public int getCodigo_perfil() {
        return codigo_perfil;
    }

    public void setCodigo_perfil(int codigo_perfil) {
        this.codigo_perfil = codigo_perfil;
    }
    
    

  
    
    
}
