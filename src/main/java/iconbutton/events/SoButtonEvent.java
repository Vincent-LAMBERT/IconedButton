package iconbutton.events;

import javafx.event.EventType;

public class SoButtonEvent extends MultipleButtonEvent {

    public static final EventType<MultipleButtonEvent> ACTION = new EventType(CUSTOM_EVENT_TYPE, "SoButtonEvent");

    public SoButtonEvent() {
        super(ACTION);
    }

    @Override
    public void invokeHandler(MultipleButtonEventHandler handler) {
        handler.onEvent();
    }

}