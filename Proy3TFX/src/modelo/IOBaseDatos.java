/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dam1
 */
public class IOBaseDatos {
    
    public void actualizaRegistros(String actualiza) throws SQLException{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String urlCon = "jdbc:mariadb://localhost:3306/proy3te5";
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "");
            Statement encapsulaCons = conexBd.createStatement();

            int filActualizadas = encapsulaCons.executeUpdate(actualiza);
            if(filActualizadas > 0){System.out.print("Hola");}

            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    
    
    }
    
    public ResultSet introduceRegistros(String consulta) {
        ResultSet resulCons = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String urlCon = "jdbc:mariadb://localhost:3306/proy3te5";
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "");
            Statement encapsulaCons = conexBd.createStatement();

            //"INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('" + dni + "', '" + nomDonante + "', '" + direccionDonante + "', '" + codPostal + "', '" + localidad + "', '" + fechaNac + "', '" + mail + "', '" + telefono + "', '" + grupoSang + "', '" + factorRH + "')
            resulCons = encapsulaCons.executeQuery(consulta);

            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resulCons;
    }
    
    
    
    
}
