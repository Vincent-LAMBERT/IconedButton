package iconbutton;



import java.io.IOException;


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
import javafx.scene.layout.StackPane;

/**
 * A button with image at its left
 */
public class InsideLeftIconButton extends AnchorPane {
    @FXML protected Button btn;
    @FXML protected Label label;
    @FXML protected ImageView icon;


    public InsideLeftIconButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InsideLeftIconButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        icon.fitWidthProperty().bind(btn.heightProperty().subtract(10));
        icon.fitHeightProperty().bind(btn.heightProperty().subtract(10));
    }
    
    public String getText() {
        return label.getText();
    }
    
    public void setText(String value) {
        label.setText(value);
    }
    
    public String getImg() {
        return label.getText();
    }
    
    public void setImg(String value) {
        icon.setImage(new Image(value));
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
