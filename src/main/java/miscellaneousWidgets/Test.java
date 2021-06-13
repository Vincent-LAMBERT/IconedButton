package miscellaneousWidgets;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import miscellaneousWidgets.events.CentralButtonEvent;
import miscellaneousWidgets.events.NeButtonEvent;
import miscellaneousWidgets.events.NoButtonEvent;
import miscellaneousWidgets.events.SeButtonEvent;
import miscellaneousWidgets.events.SoButtonEvent;

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
