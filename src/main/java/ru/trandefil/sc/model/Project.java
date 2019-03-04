package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Project extends AbstractEntity {

    private String name;

    private String description;

    public Project(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

}
