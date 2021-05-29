package iconbutton;



import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * Sample custom control hosting a text field and a button.
 */
public class IconedButton extends AnchorPane {
    @FXML protected Button button;
    @FXML protected ImageView icon;

    public IconedButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/IconedButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public String getText() {
        return button.getText();
    }
    
    public void setText(String value) {
        button.setText(value);
    }
    
    public void setIcon(Image img) {
        icon.setImage(img);
    }
    
    @FXML
    protected void buttonClicked() {
        System.out.println("The button was clicked!");
    }
}
