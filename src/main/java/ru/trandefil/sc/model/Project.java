package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Project extends AbstractEntity {

    private String name;

    public Project(String id, String name) {
        super(id);
        this.name = name;
    }

}
