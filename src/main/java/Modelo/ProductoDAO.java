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

public class ProductoDAO {
     Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
       
       
       public List listar(){
           String sql= "select * from producto";
           List<Producto> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Producto pro = new Producto();
                   pro.setId(rs.getInt("id"));
                   pro.setNombre(rs.getString("nombre"));
                   pro.setPrecioL(rs.getInt("precio_lista"));
                   pro.setMemoria(rs.getInt("memoria"));
                   pro.setAlmacenamiento(rs.getInt("almacenamiento"));
                   pro.setProcesador(rs.getString("procesador"));
                   pro.setCores(rs.getInt("cores"));
                   pro.setDescripcion(rs.getString("descripcion"));
                   pro.setColor(rs.getString("color"));
                   pro.setPrecioV(rs.getInt("precio_venta"));
                   pro.setImagen1(rs.getString("imagen1"));
                   pro.setImagen2(rs.getString("imagen2"));
                   pro.setImagen3(rs.getString("imagen3"));
                   lista.add(pro);
               }
           }catch(Exception e){   
           }
           return lista;
       }
       public int agregar(Producto pro){
           String sql="INSERT INTO producto VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, pro.getNombre());
               ps.setInt(2, pro.getPrecioL());
               ps.setInt(3, pro.getMemoria());
               ps.setInt(4, pro.getAlmacenamiento());
               ps.setString(5, pro.getProcesador());
               ps.setInt(6, pro.getCores());
               ps.setString(7, pro.getDescripcion());
               ps.setString(8, pro.getColor());
               ps.setInt(9, pro.getPrecioV());
               ps.setString(10, pro.getImagen1());
               ps.setString(11, pro.getImagen2());
               ps.setString(12, pro.getImagen3());
               
               ps.executeUpdate();
               
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       
       public Producto listarId(int id){
           Producto pro = new Producto();
           String sql ="select * from producto where id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   pro.setNombre(rs.getString("nombre"));
                   pro.setPrecioL(rs.getInt("precio_lista"));
                   pro.setMemoria(rs.getInt("memoria"));
                   pro.setAlmacenamiento(rs.getInt("almacenamiento"));
                   pro.setProcesador(rs.getString("procesador"));
                   pro.setCores(rs.getInt("cores"));
                   pro.setDescripcion(rs.getString("descripcion"));
                   pro.setColor(rs.getString("color"));
                   pro.setPrecioV(rs.getInt("precio_venta"));
                   pro.setImagen1(rs.getString("imagen1"));
                   pro.setImagen2(rs.getString("imagen2"));
                   pro.setImagen3(rs.getString("imagen3"));
               }
            }catch(Exception e){   
           }
           return pro;
       }
       
       public int actualizar(Producto pro){
            String sql="UPDATE producto SET nombre=?, precio_lista=?, memoria=?, almacenamiento=?, procesador=?, cores=?, descripcion=?, color=?, precio_venta=?, imagen1=?, imagen2=?, imagen3=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setString(1, pro.getNombre());
               ps.setInt(2, pro.getPrecioL());
               ps.setInt(3, pro.getMemoria());
               ps.setInt(4, pro.getAlmacenamiento());
               ps.setString(5, pro.getProcesador());
               ps.setInt(6, pro.getCores());
               ps.setString(7, pro.getDescripcion());
               ps.setString(8, pro.getColor());
               ps.setInt(9, pro.getPrecioV());
               ps.setString(10, pro.getImagen1());
               ps.setString(11, pro.getImagen2());
               ps.setString(12, pro.getImagen3());
               ps.setInt(13, pro.getId());
               
               ps.executeUpdate();
               
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       public void delete(int id){
           String sql ="delete from producto where ID="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.executeUpdate();
            }catch(Exception e){   
           }
       }
}
