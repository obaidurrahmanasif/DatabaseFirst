package com.example.obaidurrahman.databasefirst;

/**
 * Created by Pavilion on 03/23/2018.
 */

public class Contacts {
    private int id;
    private String name;
    private int number;

    public Contacts() {
    }

    public Contacts(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
