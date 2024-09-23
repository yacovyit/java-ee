package org.example;

public class Fibonnaci {
    // 0, 1 ,1 ,2, 3, 5, 8
    // [0,1,2,3, ...
    //f(n) : f(n-1) + f(n-2)
    public static long fib(int n) {
        if (n <=1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static long fibMem(int n, long[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        // arr[0] = 0
        // arr[1] = 1
        if (n<=1) {
            arr[n] = n;
            return arr[n];
        }
        arr[n] = fibMem(n-1, arr) + fibMem(n-2, arr);
        return arr[n];
    }


}
