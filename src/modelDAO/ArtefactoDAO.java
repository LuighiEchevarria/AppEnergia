/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexion.Conexion;
import interfaces.ArtefactoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Artefacto;

/**
 *
 * @author Jesus Enrique
 */
public class ArtefactoDAO implements ArtefactoInterface{

    Connection con = Conexion.conectar();
    PreparedStatement ps ;
    ResultSet rs;
    Artefacto oArtefacto;
    
    
    @Override
    public Artefacto artefacto_listar_uno(int codigo_artefacto) {
        
        
          try {
            String sql = "select * from artefactos where codigo_artefacto ="+ codigo_artefacto;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oArtefacto=new Artefacto();
                oArtefacto.setCodigo_artefacto(rs.getInt("codigo_artefacto"));
                oArtefacto.setNombre_artefacto(rs.getString("nombre_artefacto"));
                oArtefacto.setKv_artefacto_prom(rs.getDouble("kv_artefacto_prom"));
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtefactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR "+ex);
        }
        return oArtefacto;
        
        
        
    }
    
}
