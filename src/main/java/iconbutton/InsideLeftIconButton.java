package iconbutton;



import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.css.CssMetaData;
import javafx.css.StyleableStringProperty;
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
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * A button with image at its left
 */
public class InsideLeftIconButton extends AnchorPane {
    @FXML protected Button btn;
    @FXML protected Label label;
    @FXML protected AnchorPane internAnch;
    @FXML protected AnchorPane img;
    @FXML protected HBox hbox;


    public InsideLeftIconButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InsideLeftIconButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        img.minWidthProperty().bind(internAnch.heightProperty().multiply(1));
        DoubleBinding db = new DoubleBinding() {
            {
                super.bind(btn.heightProperty(), btn.widthProperty());
            }
            @Override
            protected double computeValue() {
                return (btn.widthProperty().get() - btn.heightProperty().get());
            }
        };
        label.minWidthProperty().bind(db.subtract(50));
    }
    
    public String getText() {
        return label.getText();
    }
    
    public void setText(String value) {
        label.setText(value);
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



    private ObjectProperty<Image> image;

    public final void setImage(Image image) {
        Background backgrnd = new Background(new BackgroundImage(image, null, null, null, null));
        img.setBackground(backgrnd);
    }
    public final Image getImage() {
        return img.getBackground().getImages().get(0).getImage();
    }

    private Image oldImage;
    public final ObjectProperty<Image> imageProperty() {
        if (image == null) {
            image = new ObjectPropertyBase<Image>() {

                @Override
                public Object getBean() {
                    return img;
                }

                @Override
                public String getName() {
                    return "image";
                }
            };
        }
        return image;
    }

    private StringProperty imageUrl = null;
    /**
     * The imageUrl property is set from CSS and then the image property is
     * set from the invalidated method. This ensures that the same image isn't
     * reloaded.
     */
    private StringProperty imageUrlProperty() {
        if (imageUrl == null) {
            imageUrl = new StyleableStringProperty() {
                @Override
                public Object getBean() {
                    return img;
                }

                @Override
                public String getName() {
                    return "imageUrl";
                }

                @Override
                public CssMetaData<ImageView,String> getCssMetaData() {
                    return null;
                }

            };
        }
        return imageUrl;
    }

}
