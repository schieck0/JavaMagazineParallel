package javamagazine.threads;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

    public static void main(String[] args) {
        FibonnaciForkJoin fib = new FibonnaciForkJoin(6);
        System.out.println(fib.invoke());
    }
}
