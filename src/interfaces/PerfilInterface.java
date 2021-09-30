/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import model.Perfil;

/**
 *
 * @author Jesus Enrique
 */
public interface PerfilInterface {
    public boolean perfil_agregar(Perfil p);
    public boolean perfil_editar(Perfil p);
    public boolean perfil_eliminar(int codigo_perfil);
    public Perfil perfil_listar_uno(int codigo_perfil);
    public ArrayList<Perfil> perfil_listar_all();
}
