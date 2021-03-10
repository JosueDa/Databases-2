/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class ClienteDAO {
       Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
       
        public Cliente buscar(int id){
           Cliente c=new Cliente();
           String sql ="select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id where clientes.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   c.setNombre(rs.getString("nombre"));
                   c.setNit(rs.getInt("nit"));
                   c.setCorreo(rs.getString("email"));
                   c.setCelular(rs.getInt("telefono"));
                   c.setPatente(rs.getString("patente"));
                   c.setSuscripcion(rs.getInt("suscripcion"));
                   c.setId(rs.getInt("id"));
                   c.setRango(rs.getString("nombretipo"));
               }
           }catch(Exception e){
               
           }
           return c;
       }
       
       public List listar(){
           String sql= "select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id ORDER BY clientes.id asc";
           List<Cliente> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Cliente cl = new Cliente();
                   cl.setNombre(rs.getString("nombre"));
                   cl.setNit(rs.getInt("nit"));
                   cl.setCorreo(rs.getString("email"));
                   cl.setCelular(rs.getInt("telefono"));
                   cl.setPatente(rs.getString("patente"));
                   cl.setSuscripcion(rs.getInt("suscripcion"));
                   cl.setId(rs.getInt("id"));
                   cl.setRango(rs.getString("nombretipo"));
                   lista.add(cl);
               }
           }catch(Exception e){   
           }
           return lista;
       }
       public int agregar(Cliente cl){
           String sql="INSERT INTO clientes VALUES (?,?,?,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, cl.getId());
               ps.setString(2, cl.getNombre());
               ps.setInt(3, cl.getNit());
               ps.setString(4, cl.getCorreo());
               ps.setInt(5, cl.getCelular());
               ps.setInt(6, cl.getSuscripcion());
               ps.setString(7, cl.getPatente());
               
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       
       public Cliente listarId(int id){
           Cliente cl = new Cliente();
           String sql ="select * from clientes inner join suscripciones on clientes.suscripcion=suscripciones.id where clientes.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   cl.setNombre(rs.getString("nombre"));
                   cl.setNit(rs.getInt("nit"));
                   cl.setCorreo(rs.getString("email"));
                   cl.setCelular(rs.getInt("telefono"));
                   cl.setPatente(rs.getString("patente"));
                   cl.setSuscripcion(rs.getInt("suscripcion"));
                   cl.setId(rs.getInt("id"));
                   cl.setRango(rs.getString("nombretipo"));
               }
            }catch(Exception e){   
           }
           return cl;
       }
       
       public int actualizar(Cliente cl){
            String sql="UPDATE clientes SET nombre=?, nit=?, email=?, telefono=?, patente=?, suscripcion=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, cl.getNombre());
               ps.setInt(2, cl.getNit());
               ps.setString(3, cl.getCorreo());
               ps.setInt(4, cl.getCelular());
               ps.setString(5, cl.getPatente());
               ps.setInt(6, cl.getSuscripcion());
               ps.setInt(7, cl.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       public void delete(int id){
           String sql ="delete from clientes where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
           
           
    }
       
}
