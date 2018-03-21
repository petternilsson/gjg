package net.gjg.systemapi.campaign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Campaign() {

    }

    public Campaign(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[id='%s', name='%s']", id, name);
    }
}

