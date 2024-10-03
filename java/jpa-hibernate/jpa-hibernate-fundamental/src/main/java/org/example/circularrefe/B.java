package org.example.circularrefe;

public class B {
    private A a;
    private String name;
    public B(String name) {
        this.name = name;
    }
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                ", name='" + name + '\'' +
                '}';
    }
}
