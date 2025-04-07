/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package numberadder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberAdder extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the TextFields for entering numbers
        TextField num1Field = new TextField();
        num1Field.setPromptText("Enter first number");

        TextField num2Field = new TextField();
        num2Field.setPromptText("Enter second number");

        // Create a read-only TextField to show result
        TextField resultField = new TextField();
        resultField.setEditable(false); // Prevent the user from editing the result
        resultField.setPromptText("Result will appear here");
        
        // Add some styling to make the result look like a box
        resultField.setStyle("-fx-background-color: lightgray; -fx-font-size: 14px; -fx-padding: 10px;");

        // Create the button to calculate sum
        Button addButton = new Button("Add Numbers");
        addButton.setOnAction(e -> {
            try {
                // Get the values from text fields
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                // Calculate sum and update result
                double sum = num1 + num2;
                resultField.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input, please enter numbers!");
            }
        });

        // Create a layout (VBox)
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(num1Field, num2Field, addButton, resultField);

        // Create Scene
        Scene scene = new Scene(layout, 300, 250);
        // Load CSS (if any)
System.out.println(getClass().getResource("/style.css"));

        // Set up Stage
        primaryStage.setTitle("Number Adder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
