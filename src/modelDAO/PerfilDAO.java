/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexion.Conexion;
import interfaces.PerfilInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Perfil;

/**
 *
 * @author Jesus Enrique
 */
public class PerfilDAO implements PerfilInterface{
    
    Connection con = Conexion.conectar();
    PreparedStatement ps ;
    ResultSet rs;
    Perfil oPerfil;
    

     @Override
    public boolean perfil_agregar(Perfil perfil) {
        try {
            
            
           String sql =" insert into perfil(nombres, apellidos, correo_electronico,kv) "
                           + " value(' " + perfil.getNombres() + " ',' " 
                           + perfil.getApellidos()+  "',' " 
                           + perfil.getCorreo_electronico() + " ', " 
                           + String.valueOf(perfil.getCosto_kv())  + ")";
            
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR APP "+ex);
        }
        return false;
    }

    
    
    @Override
    public boolean perfil_editar(Perfil perfil) {
 
        try {
             
            String sql  = " update perfil set nombres = '" +  perfil.getNombres()  + "' , apellidos='" + perfil.getApellidos() + "', correo_electronico='" +  perfil.getCorreo_electronico() + "', kv= '" + String.valueOf(perfil.getCosto_kv()) + "' where codigo_perfil ="  + perfil.getCodigo_perfil();
            
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
        
    }

    @Override
    public boolean perfil_eliminar(int codigo_perfil) {
        
        try {
            String sql = "delete from perfil where codigo_perfil = "+ codigo_perfil;
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public Perfil perfil_listar_uno(int codigo_perfil) {
        
        try {
            String sql = "select * from perfil where codigo_perfil ="+ codigo_perfil;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oPerfil=new Perfil();
                oPerfil.setCodigo_perfil(rs.getInt("codigo_perfil"));
                oPerfil.setNombres(rs.getString("nombres"));
                oPerfil.setApellidos(rs.getString("apellidos"));
                oPerfil.setCorreo_electronico(rs.getString("correo_electronico"));
                oPerfil.setCosto_kv(rs.getDouble("kv"));
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR "+ex);
        }
        return oPerfil;
    }

    @Override
    public ArrayList<Perfil> perfil_listar_all() {

        
        ArrayList<Perfil> lista = new ArrayList<>();
        try {
            String sql = "select * from perfil";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oPerfil=new Perfil();
                oPerfil.setCodigo_perfil(rs.getInt("codigo_perfil"));
                oPerfil.setNombres(rs.getString("nombres"));
                oPerfil.setApellidos(rs.getString("apellidos"));
                oPerfil.setCorreo_electronico(rs.getString("correo_electronico"));
                oPerfil.setCosto_kv(rs.getDouble("kv"));
                lista.add(oPerfil);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    

}
