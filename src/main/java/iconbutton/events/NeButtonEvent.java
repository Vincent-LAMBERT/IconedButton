package iconbutton.events;

import javafx.event.EventType;

public class NeButtonEvent extends MultipleButtonEvent {

    public static final EventType<MultipleButtonEvent> ACTION = new EventType(CUSTOM_EVENT_TYPE, "NeButtonEvent");


    public NeButtonEvent() {
        super(ACTION);
    }

    @Override
    public void invokeHandler(MultipleButtonEventHandler handler) {
        handler.onEvent();
    }

}