package miscellaneousWidgets.events;

import javafx.event.EventType;

public class SeButtonEvent extends MultipleButtonEvent {

    public static final EventType<MultipleButtonEvent> ACTION = new EventType(CUSTOM_EVENT_TYPE, "SeButtonEvent");

    public SeButtonEvent() {
        super(ACTION);
    }

    @Override
    public void invokeHandler(MultipleButtonEventHandler handler) {
        handler.onEvent();
    }

}