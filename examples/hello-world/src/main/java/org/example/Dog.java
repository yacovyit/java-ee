package org.example;

public class Dog extends Animal{
    @Override
    public void talk() {
        System.out.println("Hav hav");
    }

    public void sleep() {
        try {
            System.out.println("Dog Before sleep");
            Thread.sleep(5000);
            super.sleep();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}