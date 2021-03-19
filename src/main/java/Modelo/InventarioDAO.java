
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
       
        public Inventario buscar(int id){
           Inventario i=new Inventario();
           String sql ="select * from inventarios where id="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   i.setId(rs.getInt("id"));
                   i.setIdProducto(rs.getInt("idproducto"));
                   i.setCantidad(rs.getInt("cantidad"));
               }
           }catch(Exception e){
               
           }
           return i;
       }
       
       
       public List listar(){
           String sql= "select nombre, inventarios.id, cantidad, idproducto from inventarios inner join producto on inventarios.idproducto=producto.id";
           List<Inventario> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Inventario i = new Inventario();
                   i.setId(rs.getInt("id"));
                   i.setIdProducto(rs.getInt("idproducto"));
                   i.setCantidad(rs.getInt("cantidad"));
                   i.setNombreProducto(rs.getString("nombre"));
                   lista.add(i);
               }
           }catch(Exception e){   
           }
           return lista;
       }
       
       public int actualizar(Inventario in){
            String sql="UPDATE inventarios SET cantidad=? where ID=?";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, in.getCantidad());
               ps.setInt(2, in.getId());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
          
}
