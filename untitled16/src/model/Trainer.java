package model;

import java.io.Serializable;

public class Trainer implements Serializable {

    private int id;
    private String name;
    private String specialization;

    public Trainer(int id,
                   String name,
                   String specialization) {

        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return id + " | " +
                name + " | " +
                specialization;
    }
}