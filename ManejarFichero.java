package nombrepaquete;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ManejarFichero {

    private Scanner teclado = new Scanner(System.in);
    private FileOutputStream ficheroSalida = null;
    private FileInputStream ficheroLectura = null;
    private DataOutputStream datosSalida = null;
    private DataInputStream datosEntrada = null;
    private RandomAccessFile fichero = null;
    private String rutaArchivoDat = "src/donaciones.dat";
    private String rutaArchivoXml = "src/sanitarios.xml";

    protected String dni;
    protected int codigoSanitario;
    protected String fechaDonacionWapilla;
    protected float cantidadMl;
    protected boolean incidencia;

    Donaciones donaciones = new Donaciones();

    protected void introDatos(String dniDonante, int codigoSanitario, String fechaDonacionWapilla, float cantidadMl, boolean incidencia) throws IOException {

        try {
            ficheroSalida = new FileOutputStream(rutaArchivoDat, true);
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
            try {
                if (ficheroSalida != null) {
                    ficheroSalida.close();
                }
                if (datosSalida != null) {
                    datosSalida.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    protected void leerDatosDat(String dniDeseado, JTable tablilla, JLabel labelNombre, JLabel labelOtro) {

        boolean encontrado = false;

        try {
            fichero = new RandomAccessFile(rutaArchivoDat, "r");
            fichero.seek(0);
            int contador = 0;

            while (true) {

                donaciones.dni = fichero.readUTF();
                donaciones.codigoSanitarioDat = fichero.readInt();
                donaciones.fechaDonacion = fichero.readUTF();
                donaciones.cantidadMl = fichero.readFloat();
                donaciones.incidencia = fichero.readBoolean();

                if (donaciones.dni.equals(dniDeseado)) {

                    encontrado = true;

                    leerDatosDB(dniDeseado, labelNombre, labelOtro);

                    tablilla.setValueAt(donaciones.codigoSanitarioDat, contador, 0);
                    tablilla.setValueAt(donaciones.fechaDonacion, contador, 2);
                    tablilla.setValueAt(donaciones.cantidadMl, contador, 3);

                    leerDatosXML(dniDeseado, tablilla, contador);

                    if (donaciones.incidencia) {
                        // ✔ ❌
                        tablilla.setValueAt("Incidencia encontrada ❌", contador, 4);

                    } else {
                        tablilla.setValueAt("Ninguna incidencia ✔", contador, 4);
                    }

                    // Metemos los datos en la base de datos
                    String inc = donaciones.incidencia ? "Sí" : "No";
                    introDatosDB(String.valueOf(donaciones.codigoSanitarioDat), donaciones.nombreSanitario, donaciones.fechaDonacion, String.valueOf(donaciones.cantidadMl), inc, donaciones.dni);
                    contador++;
                }
            }

        } catch (EOFException eofe) {
            if(!encontrado) JOptionPane.showMessageDialog(null, "DNI introducido erróneo", "Consultar DNI", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException fnfe) {
            System.out.println(fnfe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
    }

    protected void leerDatosXML(String dni, JTable tablilla, int contador) {
        File fichXML = new File(rutaArchivoXml);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichXML);
            doc.getDocumentElement().normalize();

            doc.getDocumentElement();

            NodeList sanitarios = doc.getElementsByTagName("sanitario");

            for (int cont = 0; cont < sanitarios.getLength(); cont++) {

                Node nodo = sanitarios.item(cont);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodo;

                    if (donaciones.codigoSanitarioDat == Integer.parseInt(element.getElementsByTagName("codsan").item(0).getTextContent())) {
                        donaciones.codigoSanitarioXML = donaciones.codigoSanitarioDat;
                        donaciones.nombreSanitario = element.getElementsByTagName("nomap").item(0).getTextContent();
                        donaciones.correo = element.getElementsByTagName("correo").item(0).getTextContent();
                        donaciones.telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                        if (donaciones.dni.equals(dni)) {
                            tablilla.setValueAt(donaciones.nombreSanitario, contador, 1);
                            contador++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    protected void leerDatosDB(String dniDonante, JLabel nombre, JLabel grupoSang) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Cargamos el driver en el programa
            String urlCon = "jdbc:mariadb://localhost:3306/Proy3TE5"; // Creamos la cadena de conexión
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "root"); // La cadena se pasa como parámetro al método para generar la conexión
            Statement encapsulaCons = conexBd.createStatement(); // Creamos el flujo de consultas (queries) hacia la BD

            ResultSet resulCons = encapsulaCons.executeQuery("SELECT * FROM DONANTES WHERE DNI = '" + dniDonante + "'");

            while (resulCons.next()) {
                if (resulCons.getString(1).equals(donaciones.dni)) {

                    donaciones.nombreDonante = resulCons.getString(2);
                    donaciones.grupoSang = resulCons.getString(9);
                    donaciones.factorRH = resulCons.getString(10);


                    nombre.setText(donaciones.nombreDonante);
                    grupoSang.setText(donaciones.grupoSang + donaciones.factorRH);
                }
            }
            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected boolean introDatosDB(String codSanitario, String nombreSanitario, String fechaDonacion, String cantidad, String incidencia, String dniDonante){
        boolean control = false;
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Cargamos el driver en el programa
            String urlCon = "jdbc:mariadb://localhost:3306/Proy3TE5"; // Creamos la cadena de conexión
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "root"); // La cadena se pasa como parámetro al método para generar la conexión
            Statement encapsulaCons = conexBd.createStatement(); // Creamos el flujo de consultas (queries) hacia la BD

            int filActualizadas = encapsulaCons.executeUpdate("INSERT INTO SANITARIOSBANCO(CodSanitario, NombreSanitario, FechaDonacion, Cantidad, Incidencia, DniDonante) VALUES('" + codSanitario + "', '" + nombreSanitario + "', '" + fechaDonacion + "', '" + cantidad + "', '" + incidencia + "', '" + dniDonante + "')"); // Ejecutamos la actualización anterior
            control = filActualizadas > 0;

            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        }
        return control;
    }

    Donaciones getDonaciones() {
        return donaciones;
    }
}
