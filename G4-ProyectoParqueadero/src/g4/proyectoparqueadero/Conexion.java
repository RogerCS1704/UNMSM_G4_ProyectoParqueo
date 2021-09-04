/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.proyectoparqueadero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
String user;
String password;
String nombre_bd;
// Establecemos la conexión con la base de datos.
Connection conexion;

//Modificar las credenciales de ser necesario para poder conectarse a la BD en MySQL
    public Conexion() throws SQLException {
        this.password = "Orestes05";
        this.user = "Orekies";
        this.nombre_bd = "proyecto_parqueo";
        this.conexion = DriverManager.getConnection ("jdbc:mysql://localhost/" + nombre_bd, user, password);
    }
    
    public Connection getConexion(){
        return this.conexion;
    }
}

