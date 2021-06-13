package miscellaneousWidgets.events;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public abstract class MultipleButtonEvent extends Event {

    public static final EventType<MultipleButtonEvent> CUSTOM_EVENT_TYPE = new EventType(ANY);

    public MultipleButtonEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public abstract void invokeHandler(MultipleButtonEventHandler handler);

}
