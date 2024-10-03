package org.example.circularrefe;

public class A {
    private B b;
    private String name;
    public A(String name) {
        this.name = name;
    }
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                ", name='" + name + '\'' +
                '}';
    }
}
