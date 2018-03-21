package net.gjg.systemapi.event.model;

public class Option {
    public final String choiceDescription;
    public final String effectDescription;
    public final String effect;

    public Option(String choiceDescription, String effectDescription, String effect) {
        this.choiceDescription = choiceDescription;
        this.effectDescription = effectDescription;
        this.effect = effect;
    }

}
