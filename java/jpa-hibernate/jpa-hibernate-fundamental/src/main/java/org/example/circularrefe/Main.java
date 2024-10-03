package org.example.circularrefe;

public class Main {
    public static void main(String[] args) {
        A a = new A("A");
        B b = new B("B");

        a.setB(b);
        b.setA(a);

        System.out.println(a);
        System.out.println(b);

    }
}
