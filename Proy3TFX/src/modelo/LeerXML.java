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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dam1
 */
public class LeerXML {
    
    protected String leerDatosXML(String codSan, int opc) {
        File fichXML = new File("sanitarios.xml");
        String retorno = null;

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
                    
                    if(opc==1){

                    if (codSan.equals(element.getElementsByTagName("codsan").item(0).getTextContent())) {

                       
                        String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();
                        retorno = telefono;
                    }}
                    if(opc==2){

                    if (codSan.equals(element.getElementsByTagName("codsan").item(0).getTextContent())) {

                        String correo = element.getElementsByTagName("correo").item(0).getTextContent();
                        
                        retorno = correo;
                    }}
                    if(opc==3){

                    if (codSan.equals(element.getElementsByTagName("codsan").item(0).getTextContent())) {

                        String nom = element.getElementsByTagName("nomap").item(0).getTextContent();
                        
                        retorno = nom;
                    }}
                    
                    
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
        return retorno;
    }
    
    
}
