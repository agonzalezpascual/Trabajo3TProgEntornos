/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
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
    
    private ObservableList<String> grupoSang;
    
    private ObservableList<String> factorRH;
    
    private ObservableList<Donante> donantes;
    
    private ObservableList<Donante> filtroDonantes;
    
    private ObservableList<TreeItem<String>> compatiblesR;
    
    private ObservableList<TreeItem<String>> compatiblesD;
    
    @FXML
    private TextField txtCodPos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLoc;
    @FXML
    private TableColumn<Donante, String> colDonEmail;
    @FXML
    private TreeTableView<String> tablaArbolComp;
    @FXML
    private TreeTableColumn<String, String> arbolComp;
    
    private TreeItem<String> Recibe= new TreeItem<>("Recibe de");
    
    private TreeItem<String> Dona= new TreeItem<>("Dona a");
    
    private TreeItem<String> root= new TreeItem<>("Compatibilidades");
    
    private List<String> Are =new ArrayList<String>();
    private List<String> Bre =new ArrayList<String>();
    private List<String> Ore =new ArrayList<String>();
    private List<String> ABre =new ArrayList<String>();
    private List<String> Ado =new ArrayList<String>();
    private List<String> Bdo =new ArrayList<String>();
    private List<String> Odo =new ArrayList<String>();
    private List<String> ABdo =new ArrayList<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaCombos();
        iniciaTablaDon();
        iniciaLista();
        filtroDonantes = FXCollections.observableArrayList();
        compatiblesR = FXCollections.observableArrayList();
        compatiblesD = FXCollections.observableArrayList();
        
        // TODO
    }
    
    public void iniciaLista(){
    
    this.Are.add("A");
    this.Are.add("0");
    
    this.Ado.add("A");
    this.Ado.add("AB");
    
    this.Bre.add("B");
    this.Bre.add("0");
    
    this.Bdo.add("B");
    this.Bdo.add("AB");
    
    this.ABre.add("AB");
    this.ABre.add("A");
    this.ABre.add("B");
    this.ABre.add("0");
    
    this.ABdo.add("AB");
    
    this.Ore.add("0");

    
    this.Odo.add("AB");
    this.Odo.add("A");
    this.Odo.add("B");
    this.Odo.add("0");
    
    }
    
    
    public void iniciaCombos(){
    
    grupoSang = FXCollections.observableArrayList();
        grupoSang.add("AB");
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
        try{
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
    this.tablaDonantes.refresh();}
        catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Asegúrese de haber introducido correctamente todos los datos");
            alert.showAndWait();
        
        
        }
    
    
    }

    @FXML
    private void modificaDonante(ActionEvent event) {
        try{
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
            
        donantes.set(tablaDonantes.getSelectionModel().getSelectedIndex(), 
                                new Donante(dni,nom,dir,cp,loc,fecna,email,tel,grupo,rh,1));
        this.tablaDonantes.refresh();}
        
        catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Asegúrese de haber introducido correctamente todos los datos");
            alert.showAndWait();
        
        
        }
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

    @FXML
    private void compatibilidad(ActionEvent event) {
        
        this.compatiblesR.clear();
        this.compatiblesD.clear();
        
        
        String vGrup = this.comboComGrup.getValue().toString();
        String vRH = this.ComboComRH.getValue().toString();
        if (vGrup.equals("A")){
            for (String s:Are){
                if(vRH.equals("+")){
                    this.compatiblesR.add(new TreeItem<>(s+"+"));}
                this.compatiblesR.add(new TreeItem<>(s+"-"));
        
        }
            for (String s:Ado){
                if(vRH.equals("-")){
                    this.compatiblesD.add(new TreeItem<>(s+"-"));}
                this.compatiblesD.add(new TreeItem<>(s+"+"));
        
        }
        }
        else if(vGrup.equals("B")){
            
            for (String s:Bre){
                if(vRH.equals("+")){
                    this.compatiblesR.add(new TreeItem<>(s+"+"));}
                this.compatiblesR.add(new TreeItem<>(s+"-"));
        
        }   for (String s:Bdo){
                if(vRH.equals("-")){
                    this.compatiblesD.add(new TreeItem<>(s+"-"));}
                this.compatiblesD.add(new TreeItem<>(s+"+"));
        
        }
        }
         else if(vGrup.equals("AB")){
            
            for (String s:ABre){
                if(vRH.equals("+")){
                    this.compatiblesR.add(new TreeItem<>(s+"+"));}
                this.compatiblesR.add(new TreeItem<>(s+"-"));
        
        }   for (String s:ABdo){
                if(vRH.equals("-")){
                    this.compatiblesD.add(new TreeItem<>(s+"-"));}
                this.compatiblesD.add(new TreeItem<>(s+"+"));
        
        }
         
         }
         else if(vGrup.equals("0")){
            
            for (String s:Ore){
                if(vRH.equals("+")){
                    this.compatiblesR.add(new TreeItem<>(s+"+"));}
                 this.compatiblesR.add(new TreeItem<>(s+"-"));
        
        }   for (String s:Odo){
                if(vRH.equals("-")){
                    this.compatiblesD.add(new TreeItem<>(s+"-"));}
                this.compatiblesD.add(new TreeItem<>(s+"+"));
        
        }
         }
        this.Recibe.getChildren().setAll(compatiblesR);
        this.Dona.getChildren().setAll(compatiblesD);
        this.root.getChildren().setAll(Recibe,Dona);
        
        
        this.arbolComp.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
     @Override
     public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> p) {
                
         
                    return new SimpleStringProperty(p.getValue().getValue());
                
                }});
        this.tablaArbolComp.setRoot(root);
        
    
    }

    @FXML
    private void botConDon(ActionEvent event) {
        
        String DNIDonante = this.txtDonaDNI.getText();
        
        for(Donante d:this.donantes){
                if(d.getDNI().contains(DNIDonante)){
                    this.txtDonaNom.setText(d.getNombre());
                    this.txtDonaGrup.setText(d.getGrupoSang()+d.getFactorRH());
               
                }
            
            }
    }


    
    
}
