package net.gjg.systemapi.event.model;

public class Event {
    public final String id;
    public final String description;
    public final Option optionA;
    public final Option optionB;

    public Event(String id, String description, Option optionA, Option optionB) {
        this.id = id;
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
    }
}
