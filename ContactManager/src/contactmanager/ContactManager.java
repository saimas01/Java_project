/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package contactmanager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ContactManager extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Main.fxml"));
        AnchorPane root = loader.load();

        // Create a scene with the loaded root
        Scene scene = new Scene(root);

        // Set the title and the scene for the stage
        primaryStage.setTitle("Contact Manager");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
   
    
}