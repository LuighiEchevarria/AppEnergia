/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import model.Control;

/**
 *
 * @author Jesus Enrique
 */
public interface ControlInterface {
    public boolean control_agregar(Control control);
    public boolean control_editar(Control p);
    public boolean control_eliminar(int codigo_control);
    public Control control_listar_uno(int codigo_control);
    public ArrayList<Control> perfil_control_all(int codigo_perfil);    
    public ArrayList<Control> perfil_control_por_mes(int codigo_perfil, String año, String mes);
    public double total_por_mes(int codigo_perfil, int mes);
    
}
