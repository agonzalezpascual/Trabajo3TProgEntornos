/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Donacion;
import modelo.IOBaseDatos;

/**
 *
 * @author dam1
 */
public class IODonantesDat {

    public FileOutputStream ficheroSalida;
    public DataOutputStream datosSalida;
    public RandomAccessFile fichero;
    public LeerXML X = new LeerXML();
    public IOBaseDatos IO = new IOBaseDatos();
 

    public void introDatos(String dniDonante, int codigoSanitario, String fechaDonacionWapilla, float cantidadMl, boolean incidencia) throws IOException {

        try {
            ficheroSalida = new FileOutputStream("src/Donantes.dat", true);
            datosSalida = new DataOutputStream(ficheroSalida);

            datosSalida.writeUTF(dniDonante);
            datosSalida.writeInt(codigoSanitario);
            datosSalida.writeUTF(fechaDonacionWapilla);
            datosSalida.writeFloat(cantidadMl);
            datosSalida.writeBoolean(incidencia);

            System.out.println("\t\nDatos incorporados al fichero\n");

        } catch (IOException fnfe) {
            System.out.println(fnfe.getMessage());
        } finally {
            if (ficheroSalida != null) {
                ficheroSalida.close();
            }
            if (datosSalida != null) {
                datosSalida.close();
            }
        }
    }

    public ObservableList<Donacion> leerDatosDat(String dniDeseado) throws FileNotFoundException, IOException {

        boolean encontrado = false;

        RandomAccessFile fichero = new RandomAccessFile("src/Donantes.dat", "r");
        fichero.seek(0);
        int contador = 0;
        Donacion Don = null;
        boolean cont = true;
        ObservableList<Donacion> listaDona = FXCollections.observableArrayList();

        
            while (cont) {
                try{

                String dni = fichero.readUTF();
                String codigoSanitarioDat = Integer.toString(fichero.readInt());
                String fechaDonacion = fichero.readUTF();
                String cantidadMl = Float.toString(fichero.readFloat());
                String incidencia = Boolean.toString(fichero.readBoolean());

                if (dni.equals(dniDeseado)) {
                    System.out.print("Encontrado");
                Don = new Donacion(dni, codigoSanitarioDat, cantidadMl, "true", X.leerDatosXML(codigoSanitarioDat, 2), X.leerDatosXML(codigoSanitarioDat, 3), X.leerDatosXML(codigoSanitarioDat, 1), fechaDonacion);
                listaDona.add(Don);
                    
                    
                    try {
                        IO.actualizaRegistros("INSERT INTO SANITARIOSBANCO(CodSanitario, NombreSanitario, FechaDonacion, Cantidad, Incidencia, DniDonante) "
                                + "VALUES ('" + codigoSanitarioDat
                                + "', '"
                                + X.leerDatosXML(codigoSanitarioDat, 3)
                                + "', '"
                                + fechaDonacion
                                + "', '" + cantidadMl
                                + "', '" + 1
                                + "', '" + dni + "')");
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(IODonantesDat.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }}
            
            
            catch (EOFException f){
            
                break;
            }}

        
        return listaDona;
    }
}
