/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexiondb.ConexionMySQL;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Servicio;

/**
 *
 * @author Cliente
 */
public class ventanaprincipalController implements Initializable {
    
    private Label label;
    @FXML
    private DatePicker filtFecIn;
    @FXML
    private DatePicker FiltEnt;
    @FXML
    private ComboBox<String> FiltCli;
    @FXML
    private TableView<Servicio> TabAlq;
    @FXML
    private TableColumn<Servicio, String> ColMat;
    @FXML
    private TableColumn<Servicio, String> ColMar;
    @FXML
    private TableColumn<Servicio, String> ColPre;
    @FXML
    private TableColumn<Servicio, String> ColFecAL;
    @FXML
    private TableColumn<Servicio, String> ColFecEn;
    @FXML
    private TableColumn<Servicio, String> ColTot;
    @FXML
    private Button botIns;
    
    private ObservableList<Servicio> servicios;
    //Crear Filtro por NIF
    private ObservableList<Servicio> filtroservicios;
    private ObservableList<String> filtservicios;
    ConexionMySQL conexion = new ConexionMySQL("localhost:3306","alquiler_vehiculos","root","root");
    //Hasta aquí
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        servicios = FXCollections.observableArrayList();
        //Crear Filtro por NIF
        filtservicios = FXCollections.observableArrayList();
        filtroservicios = FXCollections.observableArrayList();
        //Hasta aquí
        iniciatablas();
        try {
            iniciacombo();
        } catch (SQLException ex) {
            Logger.getLogger(ventanaprincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Crear Filtro por NIF
    public void iniciacombo() throws SQLException{
    conexion.ejecutarConsulta("Select NIF from clientes");
            ResultSet rs = conexion.getResultSet();
            
            while(rs.next()){
            
                filtservicios.add(rs.getString("NIF"));
            }
            
    FiltCli.setItems(filtservicios);
    
    }
    
    public void iniciatablas(){
    
    TabAlq.setItems(servicios);
    this.ColMat.setCellValueFactory(new PropertyValueFactory<>("matricula_vehiculo"));
    this.ColMar.setCellValueFactory(new PropertyValueFactory<>("nif_cliente"));
    this.ColPre.setCellValueFactory(new PropertyValueFactory<>("precio"));
    this.ColFecAL.setCellValueFactory(new PropertyValueFactory<>("fecha_alquiler"));
    this.ColFecEn.setCellValueFactory(new PropertyValueFactory<>("fecha_entrega"));
    this.ColTot.setCellValueFactory(new PropertyValueFactory<>("total"));
    TabAlq.refresh();
    
    
    }

    @FXML
    private void handlerInsertar(ActionEvent event) {
        

        try {
            FXMLLoader anadir = new FXMLLoader(getClass().getResource("/vista/ventanaanadir.fxml"));
            Parent root = anadir.load();
            ventanaanadirController controlador = anadir.getController(); 
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
            Servicio s = controlador.getServicio();
            servicios.add(s);
            TabAlq.refresh();
        } catch (IOException ex) {
            Logger.getLogger(ventanaprincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //Crear Filtro por NIF
    @FXML
    private void handlerfiltro(ActionEvent event) {
        filtroservicios.clear();
        for(Servicio f:servicios){
            if(f.getNif_cliente().equals(this.FiltCli.getValue().toString())){
                 filtroservicios.add(f);
            } 
        }
        TabAlq.setItems(filtroservicios);
        TabAlq.refresh();
        
    }

    
}
