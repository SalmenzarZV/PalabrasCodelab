package com.ad.almenzarjimenezsergio.palabrascodelab.model.learning;



public class NonAbstractClass extends AbstractClass implements  ExampleInterface{

    public NonAbstractClass(int number) {
        super(number);
    }

    @Override
    public void metodoSinImplementar() {
        System.out.println("implementao");
    }

    public static void main(String[] args) {
        NonAbstractClass object = new NonAbstractClass(1);
        //HERENCIA DE CLASE ABSTRACTA
        object.getLenghtTimes3("pene");
        //IMPLEMENTACION DE UNA INTERFAZ
        object.metodoSinImplementar();
    }

    @Override
    public int getLenghtTimes3(String string) {
        return string.length() *3;
    }
}
