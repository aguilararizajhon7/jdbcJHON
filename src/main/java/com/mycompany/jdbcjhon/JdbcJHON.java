/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcjhon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class JdbcJHON {

    public static void main(String[] args) {
      String usuario="root";
      String password="";
      String url="jdbc:mysql://localhost:3306/jdbcJHON";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement =conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `contraseña`) VALUES (NULL, 'didier aguilar', 'aguilardidier10@gmail.com', '12356');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'johan camacho', `correo` = 'camachojohan7@gmail.com', `contraseña` = '123467' WHERE `usuarios`.`id` = 2;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //borrado o eliminacion de datos
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 4\"?s");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.getLogger(JdbcJHON.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
