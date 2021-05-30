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

public class Test implements Initializable {
    @FXML
    protected MultipleButtons multiple;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
    @FXML
    protected void handleCentral(CentralButtonEvent event){
        System.out.println("Central");
    }
    
    @FXML 
    protected void handleSo(SoButtonEvent event){
        System.out.println("So");
    }
    
    @FXML 
    protected void handleSe(SeButtonEvent event){
        System.out.println("Se");
    }
    
    @FXML 
    protected void handleNe(NeButtonEvent event){
        System.out.println("Ne");
    }
    
    @FXML 
    protected void handleNo(NoButtonEvent event){
        System.out.println("No");
    }

    @FXML
    protected void disableCentral(ActionEvent event) {
        multiple.setVisibleCentral(!multiple.isVisibleCentral());
    }

    @FXML
    protected void disableSo(ActionEvent event) {
        multiple.setVisibleSo(!multiple.isVisibleSo());
    }

    @FXML
    protected void disableSe(ActionEvent event) {
        multiple.setVisibleSe(!multiple.isVisibleSe());
    }

    @FXML
    protected void disableNe(ActionEvent event) {
        multiple.setVisibleNe(!multiple.isVisibleNe());
    }

    @FXML
    protected void disableNo(ActionEvent event) {
        multiple.setVisibleNo(!multiple.isVisibleNo());
    }
}
