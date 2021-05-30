package iconbutton;



import java.io.IOException;
import java.net.URL;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

/**
 * A set of round buttons 
 */
public class MultipleButtons extends AnchorPane {
    @FXML protected Button centralButton;
    @FXML protected Button soButton;
    @FXML protected Button seButton;
    @FXML protected Button neButton;
    @FXML protected Button noButton;


    public MultipleButtons() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MultipleButtons.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.minWidthProperty().bind(this.heightProperty().multiply(1));
    }
    
    public void setCentralImage(URL url) {
        centralButton.setGraphic(new ImageView(url.toString()));
    }
    
    public void setSoImage(URL url) {
        soButton.setGraphic(new ImageView(url.toString()));
    }
    
    public void setSeImage(URL url) {
        seButton.setGraphic(new ImageView(url.toString()));
    }
    
    public void setNeImage(URL url) {
        neButton.setGraphic(new ImageView(url.toString()));
    }
    
    public void setNoImage(URL url) {
        noButton.setGraphic(new ImageView(url.toString()));
    }


    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() { return onAction; }
    public final void setOnAction(EventHandler<ActionEvent> value) { onActionProperty().set(value); }
    public final EventHandler<ActionEvent> getOnAction() { return onActionProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
