
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {
    Conexion cn = new Conexion();
       Connection con;
       PreparedStatement ps;
       ResultSet rs;
       int respuesta;
       
        public Pedido buscar(int id){
           Pedido p=new Pedido();
           String sql ="select * from pedidosview where idpedido="+id;
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   p.setIdpedido(rs.getInt("idpedido"));
                   p.setIdproducto(rs.getInt("idproducto"));
                   p.setFechapedido(rs.getString("fechapedido"));
                   p.setFechaentrega(rs.getString("fechaentrega"));
                   p.setCantidad(rs.getInt("cantidad"));
                   p.setEstado(rs.getString("nombre"));
               }
           }catch(Exception e){
               
           }
           return p;
       }
       
       public List listar(){
           String sql= "select * from pedidosview";
           List<Pedido> lista=new ArrayList<>();
           try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               rs= ps.executeQuery();
               while(rs.next()){
                   Pedido p = new Pedido();
                   p.setIdpedido(rs.getInt("idpedido"));
                   p.setIdproducto(rs.getInt("idproducto"));
                   p.setFechapedido(rs.getString("fechapedido"));
                   p.setFechaentrega(rs.getString("fechaentrega"));
                   p.setCantidad(rs.getInt("cantidad"));
                   p.setEstado(rs.getString("nombre"));
                   lista.add(p);
               }
           }catch(Exception e){   
           }
           return lista;
       }
       public int agregar(Pedido pe){
           String sql="INSERT INTO pedidos VALUES (null,?,default,default,?,1)";
           
            try{
               con=cn.conexion();
               ps=con.prepareStatement(sql);
               ps.setInt(1, pe.getIdproducto());
               ps.setInt(2, pe.getCantidad());
               ps.executeUpdate();
            }catch(Exception i){   
           }     
           
           return respuesta;
       }
       
}
