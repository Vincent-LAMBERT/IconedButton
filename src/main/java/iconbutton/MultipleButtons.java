package iconbutton;



import java.io.IOException;
import java.net.URL;

import iconbutton.events.CentralButtonEvent;
import iconbutton.events.MultipleButtonEvent;
import iconbutton.events.NeButtonEvent;
import iconbutton.events.NoButtonEvent;
import iconbutton.events.SeButtonEvent;
import iconbutton.events.SoButtonEvent;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * A set of round buttons 
 */
public class MultipleButtons extends AnchorPane {
    @FXML protected AnchorPane main;
    @FXML protected AnchorPane pane;
    @FXML protected StackPane stackpane;
    @FXML protected Button centralButton;
    @FXML protected Button soButton;
    @FXML protected Button seButton;
    @FXML protected Button neButton;
    @FXML protected Button noButton;
    @FXML protected ImageView centralImg;
    @FXML protected ImageView soImg;
    @FXML protected ImageView seImg;
    @FXML protected ImageView neImg;
    @FXML protected ImageView noImg;


    public MultipleButtons() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MultipleButtons.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        ReadOnlyDoubleProperty size = main.widthProperty();
        pane.minHeightProperty().bind(size.multiply(1));
        pane.minWidthProperty().bind(size.multiply(1));
        centralButton.minHeightProperty().bind(size.multiply(0.80));
        centralButton.minWidthProperty().bind(size.multiply(0.80));
        soButton.minHeightProperty().bind(size.multiply(0.33));
        soButton.minWidthProperty().bind(size.multiply(0.33));
        seButton.minHeightProperty().bind(size.multiply(0.33));
        seButton.minWidthProperty().bind(size.multiply(0.33));
        neButton.minHeightProperty().bind(size.multiply(0.33));
        neButton.minWidthProperty().bind(size.multiply(0.33));
        noButton.minHeightProperty().bind(size.multiply(0.33));
        noButton.minWidthProperty().bind(size.multiply(0.33));
        centralImg.fitWidthProperty().bind(centralButton.widthProperty().subtract(15));
        centralImg.fitHeightProperty().bind(centralButton.heightProperty().subtract(15));
        soImg.fitWidthProperty().bind(soButton.widthProperty().subtract(10));
        soImg.fitHeightProperty().bind(soButton.heightProperty().subtract(10));
        seImg.fitWidthProperty().bind(seButton.widthProperty().subtract(10));
        seImg.fitHeightProperty().bind(seButton.heightProperty().subtract(10));
        noImg.fitWidthProperty().bind(noButton.widthProperty().subtract(10));
        noImg.fitHeightProperty().bind(noButton.heightProperty().subtract(10));
        neImg.fitWidthProperty().bind(neButton.widthProperty().subtract(10));
        neImg.fitHeightProperty().bind(neButton.heightProperty().subtract(10));
        centralButton.setPickOnBounds(false);
        soButton.setPickOnBounds(false);
        seButton.setPickOnBounds(false);
        neButton.setPickOnBounds(false);
        noButton.setPickOnBounds(false);
    }

    public void setVisibleCentral(boolean bool) {
        centralButton.setVisible(bool);
    }

    public void setVisibleSo(boolean bool) {
        soButton.setVisible(bool);
    }

    public void setVisibleSe(boolean bool) {
        seButton.setVisible(bool);
    }

    public void setVisibleNe(boolean bool) {
        neButton.setVisible(bool);
    }

    public void setVisibleNo(boolean bool) {
        noButton.setVisible(bool);
    }

    public boolean isVisibleCentral() {
        return centralButton.isVisible();
    }

    public boolean isVisibleSo() {
        return soButton.isVisible();
    }

    public boolean isVisibleSe() {
        return seButton.isVisible();
    }

    public boolean isVisibleNe() {
        return neButton.isVisible();
    }

    public boolean isVisibleNo() {
        return noButton.isVisible();
    }
    
    public void setCentralImage(URL url) {
        centralImg.setImage(new Image(url.toString()));
    }
    
    public void setSoImage(URL url) {
        soImg.setImage(new Image(url.toString()));
    }
    
    public void setSeImage(URL url) {
        seImg.setImage(new Image(url.toString()));
    }
    
    public void setNeImage(URL url) {
        neImg.setImage(new Image(url.toString()));
    }
    
    public void setNoImage(URL url) {
        noImg.setImage(new Image(url.toString()));
    }

    @FXML
    public void handleCentralButton(ActionEvent event) {
        this.fireEvent(new CentralButtonEvent());
    }

    @FXML
    public void handleSoButton(ActionEvent event) {
        this.fireEvent(new SoButtonEvent());
    }

    @FXML
    public void handleSeButton(ActionEvent event) {
        this.fireEvent(new SeButtonEvent());
    }

    @FXML
    public void handleNeButton(ActionEvent event) {
        this.fireEvent(new NeButtonEvent());
    }

    @FXML
    public void handleNoButton(ActionEvent event) {
        this.fireEvent(new NoButtonEvent());
    }



    public final ObjectProperty<EventHandler<MultipleButtonEvent>> onCentralActionProperty() { return onCentralAction; }
    public final void setOnCentralAction(EventHandler<MultipleButtonEvent> value) { onCentralActionProperty().set(value); }
    public final EventHandler<MultipleButtonEvent> getOnCentralAction() { return onCentralActionProperty().get(); }
    private ObjectProperty<EventHandler<MultipleButtonEvent>> onCentralAction = new ObjectPropertyBase<EventHandler<MultipleButtonEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(CentralButtonEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onCentralAction";
        }
    };

    public final ObjectProperty<EventHandler<MultipleButtonEvent>> onSoActionProperty() { return onSoAction; }
    public final void setOnSoAction(EventHandler<MultipleButtonEvent> value) { onSoActionProperty().set(value); }
    public final EventHandler<MultipleButtonEvent> getOnSoAction() { return onSoActionProperty().get(); }
    private ObjectProperty<EventHandler<MultipleButtonEvent>> onSoAction = new ObjectPropertyBase<EventHandler<MultipleButtonEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(SoButtonEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onSoAction";
        }
    };

    public final ObjectProperty<EventHandler<MultipleButtonEvent>> onSeActionProperty() { return onSeAction; }
    public final void setOnSeAction(EventHandler<MultipleButtonEvent> value) { onSeActionProperty().set(value); }
    public final EventHandler<MultipleButtonEvent> getOnSeAction() { return onSeActionProperty().get(); }
    private ObjectProperty<EventHandler<MultipleButtonEvent>> onSeAction = new ObjectPropertyBase<EventHandler<MultipleButtonEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(SeButtonEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onSeAction";
        }
    };

    public final ObjectProperty<EventHandler<MultipleButtonEvent>> onNeActionProperty() { return onNeAction; }
    public final void setOnNeAction(EventHandler<MultipleButtonEvent> value) { onNeActionProperty().set(value); }
    public final EventHandler<MultipleButtonEvent> getOnNeAction() { return onNeActionProperty().get(); }
    private ObjectProperty<EventHandler<MultipleButtonEvent>> onNeAction = new ObjectPropertyBase<EventHandler<MultipleButtonEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(NeButtonEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onNeAction";
        }
    };

    public final ObjectProperty<EventHandler<MultipleButtonEvent>> onNoActionProperty() { return onNoAction; }
    public final void setOnNoAction(EventHandler<MultipleButtonEvent> value) { onNoActionProperty().set(value); }
    public final EventHandler<MultipleButtonEvent> getOnNoAction() { return onNoActionProperty().get(); }
    private ObjectProperty<EventHandler<MultipleButtonEvent>> onNoAction = new ObjectPropertyBase<EventHandler<MultipleButtonEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(NoButtonEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "onNoAction";
        }
    };
}
