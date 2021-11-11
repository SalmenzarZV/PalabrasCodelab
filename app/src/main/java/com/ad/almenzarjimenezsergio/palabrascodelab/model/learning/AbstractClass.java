package com.ad.almenzarjimenezsergio.palabrascodelab.model.learning;

public abstract class AbstractClass {
    private int number;

    public AbstractClass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void metodoSinImplementar();
}
