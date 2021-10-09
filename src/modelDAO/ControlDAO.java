/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexion.Conexion;
import interfaces.ControlInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Control;
/**
 *
 * @author Jesus Enrique
 */
public class ControlDAO implements ControlInterface{
    
    Connection con = Conexion.conectar();
    PreparedStatement ps ;
    ResultSet rs;
    Control oControl;
    

    @Override
    public boolean control_agregar(Control control) {
        
         try {
            
               String sql ="  INSERT INTO control (nombre_artefacto, cantidad, tiempo_uso, dia_uso, kv, periodo, codigo_perfil)" 
                                + "VALUES ('"  + control.getNombre_artefacto() +  "','" 
                                               + String.valueOf(control.getCantidad()) + "','" 
                                               + String.valueOf(control.getTiempo_uso()) + "','"
                                               + String.valueOf(control.getDia_uso())  +"','"
                                               + String.valueOf(control.getKv())  + "','"
                                               + control.getPeriodo() + "','"
                                               + String.valueOf(control.getCodigo_perfil()) + "')";
           
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR APP "+ex);
        }
        return false;
        
    }

    @Override
    public boolean control_editar(Control c) {
        
         try {
            
            String sql = " update control set nombre_artefacto= '" + c.getNombre_artefacto() + "'"
                                   + " cantidad = '" + String.valueOf(c.getCantidad()) + "'"
                                    + " , tiempo_uso= '" + String.valueOf(c.getTiempo_uso()) + "'"
                                    + " , dia_uso= '" + String.valueOf(c.getDia_uso()) + "'"
                                    + " , kv= '" + String.valueOf(c.getKv()) + "'"
                                    + " , periodo= '" + c.getPeriodo()+ "'"
                                    + " , codigo_perfil= '" + String.valueOf(c.getCodigo_perfil())+ "'"
                                    + "   where codigo_control= " + c.getCodigo_control();

            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public boolean control_eliminar(int codigo_control) {
        
          try {
            String sql = "delete from control where codigo_control = "+ codigo_control;
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Control control_listar_uno(int codigo_control) {
        
         try {
            String sql = "select * from control where codigo_control ="+ codigo_control;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oControl=new Control();
                oControl.setCodigo_control(rs.getInt("codigo_control"));
                oControl.setNombre_artefacto(rs.getString("nombre_artefacto"));
                oControl.setCantidad(rs.getInt("cantidad"));
                oControl.setTiempo_uso(rs.getInt("tiempo_uso"));
                oControl.setDia_uso(rs.getInt("dia_uso"));
                oControl.setKv(rs.getInt("costo_kv"));
                oControl.setPeriodo(rs.getDate("periodo"));
                oControl.setCodigo_perfil(rs.getInt("codigo_perfil"));
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR "+ex);
        }
        return oControl;
    }

    @Override
    public ArrayList<Control> perfil_control_all(int codigo_perfil) {
         ArrayList<Control> lista = new ArrayList<>();
        try {
            String sql = "select * from control where codigo_perfil ="+ codigo_perfil;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oControl=new Control();
                oControl.setCodigo_control(rs.getInt("codigo_control"));
                oControl.setNombre_artefacto(rs.getString("nombre_artefacto"));
                oControl.setCantidad(rs.getInt("cantidad"));
                oControl.setTiempo_uso(rs.getInt("tiempo_uso"));
                oControl.setDia_uso(rs.getInt("dia_uso"));
                oControl.setKv(rs.getInt("kv"));
                oControl.setPeriodo(rs.getDate("periodo"));
                oControl.setCodigo_perfil(rs.getInt("codigo_perfil"));
                lista.add(oControl);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    @Override
    public ArrayList<Control> perfil_control_por_mes(int codigo_perfil, String año, String mes) {
         ArrayList<Control> lista = new ArrayList<>();
        try {
            String sql = "select * from control where codigo_perfil ="+ codigo_perfil +" and extract(month from periodo)="+ mes +" and extract(year from periodo)=" + año;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                oControl=new Control();
                oControl.setCodigo_control(rs.getInt("codigo_control"));
                oControl.setNombre_artefacto(rs.getString("nombre_artefacto"));
                oControl.setCantidad(rs.getInt("cantidad"));
                oControl.setTiempo_uso(rs.getInt("tiempo_uso"));
                oControl.setDia_uso(rs.getInt("dia_uso"));
                oControl.setKv(rs.getInt("kv"));
                oControl.setPeriodo(rs.getDate("periodo"));
                oControl.setCodigo_perfil(rs.getInt("codigo_perfil"));
                lista.add(oControl);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    @Override
    public double total_por_mes(int codigo_perfil, int mes) {
        double total = 0;
         try {
            String sql = "select SUM(cantidad*tiempo_uso*kv*dia_uso/1000) as total from control where extract(month from periodo)="+mes+" and codigo_perfil ="+codigo_perfil;
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               total = rs.getDouble(1);
                
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR "+ex);
        }
        return total;
    }
    
}
