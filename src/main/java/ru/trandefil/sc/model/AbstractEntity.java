package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {

    protected String id = UUID.randomUUID().toString();

}
