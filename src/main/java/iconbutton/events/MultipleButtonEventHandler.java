package iconbutton.events;

import javafx.event.EventHandler;

public abstract class MultipleButtonEventHandler implements EventHandler<MultipleButtonEvent> {

    public abstract void onEvent();

    @Override
    public void handle(MultipleButtonEvent event) {
        event.invokeHandler(this);
    }
}