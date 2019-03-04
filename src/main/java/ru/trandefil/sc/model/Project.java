package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Project extends AbstractEntity {

    private String name;

    public Project(String name) {
        this.name = name;
    }

}
