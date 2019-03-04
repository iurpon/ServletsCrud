package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task extends AbstractEntity {

    private String name;

    private String description;

    private Project project;

    public Task(String id, String name, String description, Project project) {
        super(id);
        this.name = name;
        this.description = description;
        this.project = project;
    }

}
