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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView<?> tablaDonantes;
    @FXML
    private TableColumn<?, ?> colDonDNI;
    @FXML
    private TableColumn<?, ?> colDonNom;
    @FXML
    private TableColumn<?, ?> colDonDir;
    @FXML
    private TableColumn<?, ?> colDonTel;
    @FXML
    private TableColumn<?, ?> colDonFec;
    @FXML
    private TableColumn<?, ?> colDonGrup;
    @FXML
    private TableColumn<?, ?> colDonRH;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaCombos();
        
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
    
}
