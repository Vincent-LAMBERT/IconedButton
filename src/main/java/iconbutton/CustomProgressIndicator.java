package iconbutton;




import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 * A set of round buttons 
 */
public class CustomProgressIndicator extends AnchorPane {
    double progress1=0.75;
    double progress=270;
    Color strokeCol=Color.BLACK;
    @FXML Arc arc;

    public CustomProgressIndicator() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CustomProgressIndicator.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        actualize();
    }

    public void setProgress(double progress_value) {
        progress1=progress_value;
        progress=progress_value*360;
        actualize();
    }

    public double getProgress() {
        return progress1;
    }

    public void setColor(Color col) {
        strokeCol = col;
        actualize();
    }

    private void actualize() {
        arc.setLength(progress);
    }
}
