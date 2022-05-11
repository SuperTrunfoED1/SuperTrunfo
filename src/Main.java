package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // classe de teste para os arquivos .fxml
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
    
            loader.setLocation(this.getClass().getResource("/view/MainMenu.fxml"));
            //loader.setController(LoginController.class);
    
            Parent parent = loader.load();
    
            // Show the scene containing the root layout.
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}