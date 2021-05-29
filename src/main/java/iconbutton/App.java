package iconbutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        IconedButton iconedbutton = new IconedButton();
        iconedbutton.setText("Hello!");
        
        stage.setScene(new Scene(iconedbutton));
        stage.setTitle("Iconed Button");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}