package numberadder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberAdderApp extends Application {

    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    @Override
    public void start(Stage primaryStage) {
        TextField num1Field = new TextField();
        num1Field.setPromptText("Enter first number");

        TextField num2Field = new TextField();
        num2Field.setPromptText("Enter second number");

        TextField resultField = new TextField();
        resultField.setEditable(false);
        resultField.setPromptText("Result will appear here");
        resultField.getStyleClass().add("result-field");

        Button addButton = new Button("Add Numbers");
        addButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                double sum = NumberAdderLogic.add(num1, num2);
                String inputLine = num1 + "," + num2;
                String outputLine = "Result: " + sum;

                // Save input and output with only last 10 entries
                updateFileWithLastEntries(INPUT_FILE, inputLine);
                updateFileWithLastEntries(OUTPUT_FILE, outputLine);

                resultField.setText(outputLine);

            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input. Please enter numbers.");
            } catch (IOException ioEx) {
                resultField.setText("File error: " + ioEx.getMessage());
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(num1Field, num2Field, addButton, resultField);
        layout.getStyleClass().add("main-container");

        Scene scene = new Scene(layout, 350, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Number adder with file save");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to update a file and keep only the last 10 entries
    private void updateFileWithLastEntries(String filePath, String newEntry) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);

        // Read existing lines
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }

        // Add the new entry
        lines.add(newEntry);

        // Keep only the last 10
        int fromIndex = Math.max(0, lines.size() - 10);
        List<String> lastTen = lines.subList(fromIndex, lines.size());

        // Write back the last 10
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lastTen) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
