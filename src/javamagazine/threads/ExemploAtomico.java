package javamagazine.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExemploAtomico {

    private static AtomicInteger varCompartilhada = new AtomicInteger(0);
    private static final Integer QUANTIDADE = 1000;
    private static final List<Integer> VALORES = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(varCompartilhada.incrementAndGet());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(varCompartilhada.incrementAndGet());
                }
            }
        });
        
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(varCompartilhada.incrementAndGet());
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int soma = 0;
        for (Integer valor : VALORES) {
            soma += valor;
        }
        System.out.println("Soma: " + soma);
    }
}
