/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactmanager;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField idField, nameField, contactField, searchIdField;
    @FXML
    private Button saveButton, searchButton;
    @FXML
    private Label resultLabel;

    // Create a simple backend model (for demo, this can be a List or Map)
    private Backend backend = new Backend();

    @FXML
    private void initialize() {
        saveButton.setOnAction(e -> saveData());
        searchButton.setOnAction(e -> searchData());
    }

    // Save data to backend
    private void saveData() {
        String id = idField.getText();
        String name = nameField.getText();
        String contact = contactField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !contact.isEmpty()) {
            backend.addPerson(id, name, contact);
            resultLabel.setText("Data saved successfully!");
            idField.clear();
            nameField.clear();
            contactField.clear();
        } else {
            resultLabel.setText("Please fill all fields.");
        }
    }

    // Search for data in the backend
    private void searchData() {
        String searchId = searchIdField.getText();
        if (searchId.isEmpty()) {
            resultLabel.setText("Please enter an ID to search.");
            return;
        }

        Person person = backend.getPerson(searchId);
        if (person != null) {
            resultLabel.setText("Name: " + person.getName() + "\nContact: " + person.getContact());
        } else {
            resultLabel.setText("Person not found.");
        }
    }
}