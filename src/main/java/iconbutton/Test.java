package iconbutton;

import java.net.URL;
import java.util.ResourceBundle;

import iconbutton.events.CentralButtonEvent;
import iconbutton.events.NeButtonEvent;
import iconbutton.events.NoButtonEvent;
import iconbutton.events.SeButtonEvent;
import iconbutton.events.SoButtonEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

public class Test implements Initializable {
    @FXML
    protected MultipleButtons multiple;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
    @FXML
    protected void progressAct(ActionEvent event){
        prog.setProgress(0.5);
        prog.setColor(Color.RED);
    }
    
    @FXML CustomProgressIndicator prog;
}
