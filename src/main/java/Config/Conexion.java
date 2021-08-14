/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
   
      Connection con; 

    public Connection conexion(){

        try {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              con=DriverManager.getConnection("jdbc:oracle:thin:@ventas.falcorp.net:51521:XE","system","oracle");
        } catch (Exception e) {
            
        }
        return con;
    }
}
