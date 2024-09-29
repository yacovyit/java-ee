package org.example.datatypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class DataTypes {
    @Id
    private Long id;

    private byte byteField;
    private short shortField;
    private int intField;
    private long longField;
    private float floatField;
    private double doubleField;
    private boolean booleanField;
    private char charField;
    private String stringField;

}
