package iconbutton.events;

import javafx.event.EventType;

public class CentralButtonEvent extends MultipleButtonEvent {

    public static final EventType<MultipleButtonEvent> ACTION = new EventType(CUSTOM_EVENT_TYPE, "CentralButtonEvent");


    public CentralButtonEvent() {
        super(ACTION);
    }

    @Override
    public void invokeHandler(MultipleButtonEventHandler handler) {
        handler.onEvent();
    }

}