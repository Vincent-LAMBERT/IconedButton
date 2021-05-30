package iconbutton.events;

import javafx.event.EventType;

public class NoButtonEvent extends MultipleButtonEvent {

    public static final EventType<MultipleButtonEvent> ACTION = new EventType(CUSTOM_EVENT_TYPE, "NoButtonEvent");


    public NoButtonEvent() {
        super(ACTION);
    }

    @Override
    public void invokeHandler(MultipleButtonEventHandler handler) {
        handler.onEvent();
    }

}