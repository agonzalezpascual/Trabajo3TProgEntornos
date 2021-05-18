/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import modelo.Donante;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.IOBaseDatos;
/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class VentanaanadirController implements Initializable {
    
    private ObservableList<Donante> donantes;
    
    private Donante donante;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDir;
    @FXML
    private TextField txtTel;
    @FXML
    private DatePicker selFecNa;
    @FXML
    private ComboBox<String> comboSang;
    @FXML
    private ComboBox<String> comboRH;
    @FXML
    private Button botGuar;
    @FXML
    private Button botSal;
    @FXML
    private TextField txtLoc;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCodPos;
    
    private ObservableList<String> grupoSang;
    
    private ObservableList<String> factorRH;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciaCombos();
    }    
    
    /***
     * Inicia el combobox
     */
     public void iniciaCombos(){
    
    grupoSang = FXCollections.observableArrayList();
        grupoSang.add("AB");
        grupoSang.add("A");
        grupoSang.add("B");
        grupoSang.add("0");
        comboSang.setItems(grupoSang);
        
        
        factorRH = FXCollections.observableArrayList();
        factorRH.add("+");
        factorRH.add("-");
        comboRH.setItems(factorRH);
    
    }
    
    /***
     * 
     * @param donantes ObservableList
     */
     public void initAttributtes(ObservableList<Donante> donantes) {
        this.donantes = donantes;
    }
     
     public void initAttributtes(ObservableList<Donante> donantes, Donante d) {
        this.donantes = donantes;
        this.donante = d;
        this.txtDNI.setText(d.getDNI());
        this.txtNom.setText(d.getNombre());
        this.txtDir.setText(d.getSoloDireccion());
        this.txtTel.setText(d.getTelefono());
        this.selFecNa.setValue(d.getFechaNac());
        this.comboSang.setValue(d.getGrupoSang());
        this.comboRH.setValue(d.getFactorRH());
        this.txtEmail.setText(d.getCorreo());
        this.txtCodPos.setText(d.getCodPostal());
        this.txtLoc.setText(d.getLocalidad());
        
        
    }
     
     
    public Donante getDonante() {
        return donante;
    }

    @FXML
    private void handlerGuardar(ActionEvent event) throws SQLException {
        
        String dni = this.txtDNI.getText();
        String nom = this.txtNom.getText();
        String dir = this.txtDir.getText();
        String tel = this.txtTel.getText();
        LocalDate fecna = this.selFecNa.getValue();
        String grupo = this.comboSang.getValue();
        String rh = this.comboRH.getValue();
        String email = this.txtEmail.getText();
        String cp = this.txtCodPos.getText();
        String loc = this.txtLoc.getText();

        

// Creo la persona
         Donante d = new Donante(dni,nom,dir,cp,loc,fecna,email,tel,grupo,rh);
         IOBaseDatos IO = new IOBaseDatos();

        // Compruebo si la persona existe
        if (!donantes.contains(d)) {

            // Modificar
            if (this.donante != null) {

                // Modifico el objeto
                this.donante.setNombre(nom);
                this.donante.setDNI(dni);
                this.donante.setDireccion(dir);
                this.donante.setTelefono(tel);
                this.donante.setFechaNac(fecna);
                this.donante.setGrupoSang(grupo);
                this.donante.setFactorRH(rh);
                this.donante.setCorreo(email);
                this.donante.setCodPosatal(cp);
                this.donante.setLocalidad(loc);
                
                IO.actualizaRegistros("UPDATE DONANTES set"
                        + " Nombre = '" + nom
                        + "', Direccion = '" + dir 
                        + "', CodPostal = '" + cp 
                        + "', Localidad = '" + loc
                        + "', FechaNac = '" + fecna.toString() 
                        + "', Correo = '" + email 
                        + "', Telefono = '" + tel 
                        + "', GrupoSang = '" + grupo 
                        + "', FactorRH = '" + rh 
                        + "' WHERE DNI = '" + dni + "'");
                System.out.print("UPDATE DONANTES set"
                        + " Nombre = '" + nom
                        + "', Direccion = '" + dir 
                        + "', CodPostal = '" + cp 
                        + "', Localidad = '" + loc
                        + "', FechaNac = '" + fecna.toString() 
                        + "', Correo = '" + email 
                        + "', Telefono = '" + tel 
                        + "', GrupoSang = '" + grupo 
                        + "', FactorRH = '" + rh 
                        + "' WHERE DNI = '" + dni + "'");
                

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();

            } else {
                // insertando

                this.donante = d;
                IO.actualizaRegistros("INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) "
                        + "VALUES ('" + dni 
                        + "', '" 
                        + nom
                        + "', '" 
                        + dir 
                        + "', '" + cp 
                        + "', '" + loc
                        + "', '" + fecna.toString() 
                        + "', '" + email 
                        + "', '" + tel 
                        + "', '" + grupo 
                        + "', '" + rh + "')");         
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();

            }

            // Cerrar la ventana
            Stage stage = (Stage) this.botGuar.getScene().getWindow();
            stage.close();
        
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
        
        
    }

    @FXML
    private void handlerSalir(ActionEvent event) {
    
    this.donante = null;
        Stage stage = (Stage) this.botGuar.getScene().getWindow();
        stage.close();
    
    
    }
    
}
