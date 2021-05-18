/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Donacion;
import modelo.Donante;
import modelo.IOBaseDatos;
import modelo.IODonantesDat;

/**
 * FXML Controller class
 *
 * @author Grupo2
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private TextField txtDNI;
    private ComboBox<String> comboGrup;
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
    private TableView<Donacion> tablaDonanciones;
    @FXML
    private TableColumn<Donacion, String> colDonaCod;
    @FXML
    private TableColumn<Donacion, String> colDonaNom;
    @FXML
    private TableColumn<Donacion, String> colDonaFec;
    @FXML
    private TableColumn<Donacion, String> colDonaCan;
    @FXML
    private TableColumn<Donacion, String> colDonaNomS;
    @FXML
    private TableColumn<Donacion, String> colDonaTel;

    
    private ObservableList<Donacion> donaciones;
    
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
    
    private IOBaseDatos IO = new IOBaseDatos();
    private IODonantesDat IOD = new IODonantesDat();
    
    /***
     * Método que inicia la clase controladora
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        iniciaCombos();
        iniciaTablaDon();
        iniciaLista();
        try {
            iniciaRegistros();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       /*try {
            this.IOD.introDatos("12345698F", 2, "2015-01-26", 501,false);
            this.IOD.introDatos("12345698F", 2, "2016-01-26", 530,false);
            this.IOD.introDatos("12345698F", 2, "2017-01-26", 530,false);
            this.IOD.introDatos("12345666R", 1, "2015-02-20", 400,false);
            this.IOD.introDatos("54181245S", 3, "2015-03-29", 450,true);
            this.IOD.introDatos("32547698P", 1, "2012-01-26", 400,false);
            this.IOD.introDatos("32547698P", 2, "2015-01-26", 450,false);
            this.IOD.introDatos("54181245S", 2, "2015-06-29", 350,false);
            this.IOD.introDatos("54181245S", 2, "2017-04-20", 520,true);
            this.IOD.introDatos("54181245S", 1, "2019-01-29", 500,false);
            this.IOD.introDatos("54545454Y", 1, "2019-05-10", 450,false);
            this.IOD.introDatos("54545454Y", 2, "2020-08-15", 420,false);
            this.IOD.introDatos("66655578G", 3, "2019-02-2", 400,false);
            this.IOD.introDatos("66655578G", 1, "2019-03-10", 500,true);
            this.IOD.introDatos("66655578G", 3, "2020-09-15", 440,false);
            this.IOD.introDatos("98765432H", 2, "2018-04-15", 520,true);
            this.IOD.introDatos("98765432H", 2, "2020-03-12", 400,false);
            
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
    /***
     * Método que introduzce los registros en la tabla y la refresca
     * @throws SQLException 
     */
    public void iniciaRegistros() throws SQLException{
    
    ResultSet r = IO.introduceRegistros("SELECT * FROM DONANTES");
    
    System.out.print(r);
    
    while (r.next()) {
        Donante d = new Donante(r.getString("DNI"),r.getString("Nombre"),r.getString("Direccion"),r.getString("CodPostal"),r.getString("Localidad"),LocalDate.parse(r.getString("FechaNac")),r.getString("Correo"),r.getString("Telefono"),r.getString("GrupoSang"),r.getString("FactorRH"));
 
        if (d != null) {

                // Añado la persona
                this.donantes.add(d);
                
                }

                // Refresco la tabla
                this.tablaDonantes.setItems(donantes);
                this.tablaDonantes.refresh();
            }
        
}
    
    
    
    /***
     * Método que inicia el combobox de los grupos sanguíneos
     */
    public void iniciaCombos(){
    
    grupoSang = FXCollections.observableArrayList();
        grupoSang.add("AB");
        grupoSang.add("A");
        grupoSang.add("B");
        grupoSang.add("0");
        //comboGrup.setItems(grupoSang);
        comboComGrup.setItems(grupoSang);
        
        factorRH = FXCollections.observableArrayList();
        factorRH.add("+");
        factorRH.add("-");
        //ComboRH.setItems(factorRH);
        ComboComRH.setItems(factorRH);
    
    }
    /***
     * Método que inicia la tabla Donantes y la tabla Donaciones
     */
    public void iniciaTablaDon(){
    
    //Inicia la tabla Donantes
    donantes = FXCollections.observableArrayList();
    
    
    this.colDonDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
    this.colDonNom.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    this.colDonDir.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
    this.colDonTel.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
    this.colDonFec.setCellValueFactory(new PropertyValueFactory<>("FechaNac"));
    this.colDonEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
    this.colDonGrup.setCellValueFactory(new PropertyValueFactory<>("GrupoSang"));
    this.colDonRH.setCellValueFactory(new PropertyValueFactory<>("FactorRH"));
            
    
    //Inicia la tabla Donaciones
    this.donaciones  = FXCollections.observableArrayList();
    this.colDonaCan.setCellValueFactory(new PropertyValueFactory<>("cant"));
    this.colDonaCod.setCellValueFactory(new PropertyValueFactory<>("codSan"));
    this.colDonaFec.setCellValueFactory(new PropertyValueFactory<>("fecDon"));
    this.colDonaNom.setCellValueFactory(new PropertyValueFactory<>("nomCen"));
    this.colDonaNomS.setCellValueFactory(new PropertyValueFactory<>("nomSan"));
    this.colDonaTel.setCellValueFactory(new PropertyValueFactory<>("telSan"));
    
    this.tablaDonanciones.setItems(donaciones);
    this.tablaDonanciones.refresh();
    
    
    
    
    }
    /***
     * Método que inserta un donante en la tabla Donantes
     * @throws IOException Lanza una excepción que controlamos con un try-catch si no se añade al donante correctamente.
     */
    @FXML
    public void meteDonante() throws IOException{
        /*try{
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
        
        
        }*/
        
        try{  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ventanaanadir.fxml"));
        Parent root = loader.load();
        VentanaanadirController controlador = loader.getController();
        controlador.initAttributtes(donantes);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    
        Donante d = controlador.getDonante();
            if (d != null) {

                // Añado la persona
                this.donantes.add(d);
                /*if(d.getNom().contains(this.textFiltro.getText())){
                this.filtroPersonas.add(d);*/
                
                }

                // Refresco la tabla
                this.tablaDonantes.setItems(donantes);
                this.tablaDonantes.refresh();
            }
                
                 catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    
    
    }
    /***
     * Método para modificar una entrada de la tabla Donantes
     * @param event ActionEvent
     */
    @FXML
    private void modificaDonante(ActionEvent event) {
        /*try{
            String dni = this.txtDNI.getText();
        String nom = this.txtNom.getText();
        String dir = this.txtDir.getText();
        String tel = this.txtTel.getText();
        LocalDate fecna = this.Fecna.getValue();
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
        
        
        }*/
        
        Donante d = this.tablaDonantes.getSelectionModel().getSelectedItem();                  
                    try{  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ventanaanadir.fxml"));
        Parent root = loader.load();
        VentanaanadirController controlador = loader.getController();
        controlador.initAttributtes(donantes, d);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    
        Donante aux = controlador.getDonante();
            if (aux != null) {

                this.tablaDonantes.refresh();
                /*if(!d.getNom().contains(this.textFiltro.getText())){
                
                
                }*/
                
                this.tablaDonantes.refresh();
            }
                
                } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        
    }
    /***
     * Método para eliminar una entrada de la tabla donantes
     * @throws SQLException 
     */
    @FXML
    private void eliminarDonante() throws SQLException{

        
        
        ObservableList<Donante> allProduct,SingleProduct;
        allProduct=tablaDonantes.getItems();
        SingleProduct=tablaDonantes.getSelectionModel().getSelectedItems();
        String dniBorrar = SingleProduct.get(0).getDNI();
        this.IO.actualizaRegistros("DELETE FROM DONANTES where DNI ='" + dniBorrar+ "'");
        System.out.print("DELETE FROM Donantes where id ='" + dniBorrar+ "'");
               
        SingleProduct.forEach(allProduct::remove);
    


    
    }
    /***
     * Método para buscar una entrada en la tabla Donantes
     * @param event ActionEvent
     */
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
    /***
     * Actualiza los datos de la tabla Donantes
     * @param event ActionEvent
     */
    @FXML
    private void buscaTodos(ActionEvent event) {
        
        this.tablaDonantes.setItems(donantes);
        
    }
    /***
     * Método para comprobar la compatibilidad entre los grupos sanguíneos
     * @param event ActionEvent
     */
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
    /***
     * Método que agrega la entrada a la tabla Donantes al pulsar el botón
     * @param event ActionEvent
     * @throws IOException 
     */
    @FXML
    private void botConDon(ActionEvent event) throws IOException {
        
        donaciones.clear();
        
        String DNIDonante = this.txtDonaDNI.getText();
    
        
         for(Donacion d:IOD.leerDatosDat(DNIDonante)){
                
                    this.donaciones.add(d);
               
                }
        
        
        this.tablaDonanciones.refresh();
        
        
        for(Donante d:this.donantes){
                if(d.getDNI().equals(DNIDonante)){
                    this.txtDonaNom.setText(d.getNombre());
                    this.txtDonaGrup.setText(d.getGrupoSang()+d.getFactorRH());
               
                }
            
            }
    }


    
    
}

