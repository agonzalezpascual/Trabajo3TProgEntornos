
package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Grupo2
 */
public class Proy3TFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/ventanaPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Proyecto Banco de Sangre");
        stage.setScene(scene);
        stage.show();
    }


/***
 * 
 * @param args 
 */
    public static void main(String[] args) {
        launch(args);
    }
    
}
