/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasededatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author franncode <github.com/franncode>
 */
public class Test {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/universidad";
        String usuario = "root";
        String password = "";
        Connection conexion;
        PreparedStatement ps;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
//            // CREATE
//            ps = conexion.prepareStatement("INSERT INTO alumno (nombre, fechaNacimiento, activo) VALUES ( ? , ? , ? );");
//            // 1
//            ps.setString(1, "Manuel");
//            // 2
//            LocalDate fecha1 = LocalDate.of(1985, 10, 15);
//            Date fecha = Date.valueOf(fecha1);
//            ps.setDate(2, fecha);
//            // 3
//            ps.setBoolean(3, true);
//            // Send and close
//            ps.executeUpdate();
//            ps.close();

//            // UPDATE
//            ps = conexion.prepareStatement("UPDATE alumno SET activo = 0");
//            ps.executeUpdate();
//            ps.close();

//                // DELETE
//                ps = conexion.prepareStatement("DELETE FROM `alumno` WHERE id_alumno > ? ;");
//                ps.setInt(1, 4);
//                ps.executeUpdate();
//                ps.close();

                // SELECT
                ps = conexion.prepareStatement("SELECT * FROM `alumno`");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.print("Nombre: " + rs.getString(2) + ", nacimiento: " + rs.getDate(3));
                    if (rs.getBoolean(4)) {
                        System.out.println(", alumno ACTIVO.");
                    } else {
                        System.out.println(" , alumno INACTIVO.");
                    }
                    
                }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
