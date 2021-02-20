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



public class EmpleadoDAO {
       Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
       
       public Empleado validar(String user, String pass){
           Empleado em= new Empleado();
           String sql = "Select * from empleados where usuario=? and pass=?";
           try{
               con=cn.conexion();
               ps = con.prepareStatement(sql);
               ps.setString(1, user);
               ps.setString(2, pass);
               rs=ps.executeQuery();
               while(rs.next()){
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   
               }
           }catch(Exception e){
               
           }
           return em;
       }
       
       public List listar(){
           String sql= "select * from empleados inner join tipoemp on empleados.tipo=tipoemp.id ORDER BY empleados.id asc";
           List<Empleado> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Empleado em = new Empleado();
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   em.setRango(rs.getString("rango"));
                   lista.add(em);
               }
           }catch(Exception e){   
           }
           return lista;
       }
       public int agregar(Empleado em){
           String sql="INSERT INTO empleados VALUES (null,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, em.getNombre());
               ps.setString(2, em.getPass());
               ps.setString(3, em.getCorreo());
               ps.setInt(4, em.getTipo());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       
       public Empleado listarId(int id){
           Empleado em = new Empleado();
           String sql ="select * from empleados inner join tipoemp on empleados.tipo=tipoemp.id where empleados.id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   em.setNombre(rs.getString("usuario"));
                   em.setPass(rs.getString("pass"));
                   em.setTipo(rs.getInt("tipo"));
                   em.setId(rs.getInt("id"));
                   em.setCorreo(rs.getString("correo"));
                   em.setRango(rs.getString("rango"));
               }
            }catch(Exception e){   
           }
           return em;
       }
       
       public int actualizar(Empleado em){
            String sql="UPDATE empleados SET usuario=?, pass=?, correo=?, tipo=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, em.getNombre());
               ps.setString(2, em.getPass());
               ps.setString(3, em.getCorreo());
               ps.setInt(4, em.getTipo());
               ps.setInt(5, em.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       public void delete(int id){
           String sql ="delete from empleados where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
       }
}
