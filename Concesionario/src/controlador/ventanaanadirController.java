/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import conexiondb.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class ventanaanadirController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private DatePicker FecAlq;
    @FXML
    private DatePicker FecEnt;
    @FXML
    private Label label1;
    @FXML
    private ComboBox<String> Vehic;
    @FXML
    private ComboBox<String> Clien;
    @FXML
    private TextField txtDesc;
    @FXML
    private TextField txtMarc;
    @FXML
    private TextField txtKil;
    @FXML
    private TextField txtPre;
    @FXML
    private TextField txtPob;
    @FXML
    private TextField txtDir;
    @FXML
    private TextField txtNif;
    @FXML
    private TextField txtTot;
    @FXML
    private Button botGrab;
    
    private ObservableList <String> clientes;
    
    private ObservableList <String> vehiculos;
    
    private Servicio alta;
    
    
    ConexionMySQL conexion = new ConexionMySQL("localhost:3306","alquiler_vehiculos","root","root");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            iniciaComboCliente();
            iniciaComboVehiculo();
            
        } catch (SQLException ex) {
            Logger.getLogger(ventanaanadirController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
    public void iniciaComboCliente() throws SQLException{
    
    clientes = FXCollections.observableArrayList();
    
            conexion.ejecutarConsulta("Select NyA from clientes");
            ResultSet rs = conexion.getResultSet();
            
            while(rs.next()){
            
                clientes.add(rs.getString("NyA"));
            }
            
    Clien.setItems(clientes);
    
    }
    
    public void iniciaComboVehiculo() throws SQLException{
    
    vehiculos = FXCollections.observableArrayList();
    
            conexion.ejecutarConsulta("Select matricula from vehiculos");
            ResultSet rs = conexion.getResultSet();
            
            while(rs.next()){
            
                vehiculos.add(rs.getString("matricula"));
            }
            
    Vehic.setItems(vehiculos);
    
    }

    @FXML
    private void handlerVehiculo(ActionEvent event) throws SQLException {
        

        conexion.ejecutarConsulta("Select * from vehiculos where matricula = '"+this.Vehic.getValue().toString()+"'");
        
        ResultSet rs = conexion.getResultSet();
        
            while(rs.next()){
            
                txtDesc.setText(rs.getString("descripcion"));
                txtMarc.setText(rs.getString("marca"));
                txtKil.setText(rs.getString("kilometros"));
                txtPre.setText(rs.getString("Precio"));
            
            }
        calTot();
        
    }

    @FXML
    private void handlerClien(ActionEvent event) throws SQLException {
        
        conexion.ejecutarConsulta("Select * from clientes where NyA = '"+this.Clien.getValue().toString()+"'");
        
        ResultSet rs = conexion.getResultSet();
        
            while(rs.next()){
            
                txtNif.setText(rs.getString("NIF"));
                txtDir.setText(rs.getString("Direcion"));
                txtPob.setText(rs.getString("Poblacion"));
            
            }
        
    }
    
    public void calTot(){
    
    LocalDate inicio = this.FecAlq.getValue();
    LocalDate fin = this.FecEnt.getValue();
    Period p = Period.between(inicio,fin);
    long dias = p.getDays();
    long total = dias * Integer.parseInt(txtPre.getText());
    txtTot.setText(total+"");
    
    }
    
    public Servicio getServicio(){
    return this.alta;
    }

    @FXML
    private void handlerGrab(ActionEvent event) {
        
        this.alta = new Servicio(this.Vehic.getValue().toString(),txtNif.getText(),this.FecAlq.getValue().toString(),this.FecEnt.getValue().toString(),txtTot.getText(),txtPre.getText());
        //Falta meter en la BD
        Stage stage = (Stage) this.botGrab.getScene().getWindow();
            stage.close();
    }
    
}
