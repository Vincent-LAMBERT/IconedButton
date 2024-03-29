package miscellaneousWidgets;



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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
  * Custom CheckButton
  */
public class NeoCheckButton extends AnchorPane {
    @FXML protected Button button;
    @FXML protected ImageView icon;
    private int userValue;
    private Image checked = new Image(getClass().getResource("/images/check.png").toString());
    private Image unchecked = new Image(getClass().getResource("/images/uncheck.png").toString());
    private boolean check = false;


    public NeoCheckButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NeoCheckButton.fxml"));
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

    public void setUserValue(int value) {
        userValue=value;
    }

    public int getUserValue() {
        return userValue;
    }
    
    @FXML
    protected void buttonClicked() {
        if (check) {
            uncheck();
        } else {
            check();
        }
    }

    public void check() {
        icon.setImage(checked);
        check=true;
    }

    public void uncheck() {
        icon.setImage(unchecked);
        check=false;
    }

    public boolean isChecked() {
        return check;
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
