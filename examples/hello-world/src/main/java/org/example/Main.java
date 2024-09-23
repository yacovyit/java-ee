package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        //
//        int n = 70;
//        long[] arr = new long[n+1];
//        Arrays.fill(arr, -1);
//
//        long fibCalculatedValue = Fibonnaci.fibMem(n, arr);
//        System.out.println(fibCalculatedValue);
//
//        for (long l : arr) {
//            System.out.println(l);
//        }

        Dog dog = new Dog();
        Cat cat = new Cat();

        List<Animal> animals = new ArrayList<>();

        animals.add(dog);
        animals.add(cat);

        for(Animal animal : animals) {
            animal.talk();
        }
    }
}