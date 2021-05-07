/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javafx.scene.control.TableView;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dam1
 */
public class LeerXML {
    
    /*protected void leerDatosXML(String dni, TableView tablilla, int contador) {
        File fichXML = new File("sanitarios.xml");

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
    }*/
    
    
}
