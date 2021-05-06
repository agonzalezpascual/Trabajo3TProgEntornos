/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Donante;

/**
 * FXML Controller class
 *
 * @author dam1
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDir;
    @FXML
    private TextField txtTel;
    @FXML
    private DatePicker Fecna;
    @FXML
    private ComboBox<String> comboGrup;
    @FXML
    private ComboBox<String> ComboRH;
    @FXML
    private TableView<Donante> tablaDonantes;
    @FXML
    private TableColumn<Donante, String> colDonDNI;
    @FXML
    private TableColumn<Donante, String> colDonNom;
    @FXML
    private TableColumn<Donante, String> colDonDir;
    @FXML
    private TableColumn<Donante, String> colDonTel;
    @FXML
    private TableColumn<Donante, String> colDonFec;
    @FXML
    private TableColumn<Donante, String> colDonGrup;
    @FXML
    private TableColumn<Donante, String> colDonRH;
    @FXML
    private Button botConDNI;
    @FXML
    private Button botConTod;
    @FXML
    private Button botIns;
    @FXML
    private Button botMod;
    @FXML
    private Button botEli;
    @FXML
    private TextField txtDonaDNI;
    @FXML
    private Button botDonaCons;
    @FXML
    private TextField txtDonaNom;
    @FXML
    private TextField txtDonaGrup;
    @FXML
    private TableView<?> tablaDonanciones;
    @FXML
    private TableColumn<?, ?> colDonaCod;
    @FXML
    private TableColumn<?, ?> colDonaNom;
    @FXML
    private TableColumn<?, ?> colDonaFec;
    @FXML
    private TableColumn<?, ?> colDonaCan;
    @FXML
    private ComboBox<String> ComboComRH;
    @FXML
    private ComboBox<String> comboComGrup;
    @FXML
    private Button botCom;
    @FXML
    private TableView<?> tabCom;
    @FXML
    private TableColumn<?, ?> colDa;
    @FXML
    private TableColumn<?, ?> colRecibe;
    
    private ObservableList<String> grupoSang;
    
    private ObservableList<String> factorRH;
    
    private ObservableList<Donante> donantes;
    
    private ObservableList<Donante> filtroDonantes;
    
    @FXML
    private TextField txtCodPos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLoc;
    @FXML
    private TableColumn<Donante, String> colDonEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaCombos();
        iniciaTablaDon();
        filtroDonantes = FXCollections.observableArrayList();
        
        // TODO
    }
    
    public void iniciaCombos(){
    
    grupoSang = FXCollections.observableArrayList();
        grupoSang.add("A");
        grupoSang.add("B");
        grupoSang.add("0");
        comboGrup.setItems(grupoSang);
        comboComGrup.setItems(grupoSang);
        
        factorRH = FXCollections.observableArrayList();
        factorRH.add("+");
        factorRH.add("-");
        ComboRH.setItems(factorRH);
        ComboComRH.setItems(factorRH);
    
    }
    
    public void iniciaTablaDon(){
    
    donantes = FXCollections.observableArrayList();
    
    
    this.colDonDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
    this.colDonNom.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    this.colDonDir.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
    this.colDonTel.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
    this.colDonFec.setCellValueFactory(new PropertyValueFactory<>("FechaNac"));
    this.colDonEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
    this.colDonGrup.setCellValueFactory(new PropertyValueFactory<>("GrupoSang"));
    this.colDonRH.setCellValueFactory(new PropertyValueFactory<>("FactorRH"));
            
    
    }
    
    @FXML
    public void meteDonante(){
        
        String dni = this.txtDNI.getText();
        String nom = this.txtNom.getText();
        String dir = this.txtDir.getText();
        String tel = this.txtTel.getText();
        String fecna = this.Fecna.getValue().toString();
        String grupo = this.comboGrup.getValue();
        String rh = this.ComboRH.getValue();
        String email = this.txtEmail.getText();
        String cp = this.txtCodPos.getText();
        String loc = this.txtLoc.getText();
        
        
        
    Donante d = new Donante(dni,nom,dir,cp,loc,fecna,email,tel,grupo,rh,1);
    donantes.addAll(d);
    this.tablaDonantes.setItems(donantes);
    this.tablaDonantes.refresh();
    
    
    }

    @FXML
    private void modificaDonante(ActionEvent event) {
        
        donantes.set(tablaDonantes.getSelectionModel().getSelectedIndex(), 
                                new Donante("54181345S","Pepito","C/Doctor Barraquer 13","41908","Castilleja de Guzmán","9/1/1999","AlfonsoGonzalezPascual@gmail.com","611435376","AB","+",1));
        this.tablaDonantes.refresh();
    }
    
    @FXML
    private void eliminarDonante(){
    
    ObservableList<Donante> allProduct,SingleProduct;
        allProduct=tablaDonantes.getItems();
        SingleProduct=tablaDonantes.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);
    
    
    }

    @FXML
    private void buscaDonante(ActionEvent event) {
        
        String filtroDNI = this.txtDNI.getText();
        
        this.filtroDonantes.clear();
            
            for(Donante d:this.donantes){
                if(d.getDNI().contains(filtroDNI)){
                    this.filtroDonantes.add(d);
               
                }
            
            }
            this.tablaDonantes.setItems(filtroDonantes);
    }

    @FXML
    private void buscaTodos(ActionEvent event) {
        
        this.tablaDonantes.setItems(donantes);
        
    }
    
    
}
