package simplebmicalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rayanbawazeer
 */
public class SimpleBmiCalculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Load the image
        Image bmiLogo = new Image("file:/Users/rayanbawazeer/Library/Mobile Documents/com~apple~CloudDocs/AlYamamah/4.SWE312/Lab/Lab3/bmi.png");
        ImageView logoView = new ImageView(bmiLogo);
        logoView.setFitWidth(70);  // Set width of the image
        logoView.setPreserveRatio(true);  // Preserve aspect ratio
        
        Text heightLabel = new Text("Height (cm): ");
        TextField heightField = new TextField();
        Text weightLabel = new Text("Weight (pounds): ");
        TextField weightField = new TextField();
        
        Text bmiLabel = new Text("BMI: ");
        Text bmiResult = new Text();
        HBox bmiBox = new HBox();
        bmiBox.getChildren().addAll(bmiLabel, bmiResult);
        
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi = (weight * 0.453592) / Math.pow(height, 2);
            bmiResult.setText(String.format("%.2f", bmi));
        });
        
        GridPane layout = new GridPane();
        layout.add(logoView, 1, 0);
        layout.add(heightLabel, 0, 1);
        layout.add(heightField, 1, 1);
        layout.add(weightLabel, 0, 2);
        layout.add(weightField, 1, 2);
        layout.add(bmiBox, 0, 3);
        layout.add(calculateButton, 1, 3);
        layout.setHgap(8);
        layout.setVgap(8);
        layout.setPadding(new Insets(16));
        
        Scene scene = new Scene(layout, 300, 250);
        
        primaryStage.setTitle("BMI Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
