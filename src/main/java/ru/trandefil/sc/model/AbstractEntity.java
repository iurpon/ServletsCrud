package ru.trandefil.sc.model;

import java.util.UUID;

public abstract class AbstractEntity {

    protected String id = UUID.randomUUID().toString();

}
