package javamagazine.threads;

import java.util.HashSet;
import java.util.Set;

public class ExemploAssincrono2 {

    private static int varCompartilhada = 0;
    private static final Integer QUANTIDADE = 1000;
    private static final Set<Integer> VALORES = new HashSet<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    boolean novo = VALORES.add(++varCompartilhada);
                    if (!novo) {
                        System.out.println("Já existe: " + varCompartilhada);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    boolean novo = VALORES.add(++varCompartilhada);
                    if (!novo) {
                        System.out.println("Já existe: " + varCompartilhada);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    boolean novo = VALORES.add(++varCompartilhada);
                    if (!novo) {
                        System.out.println("Já existe: " + varCompartilhada);
                    }
                }
            }
        }).start();
    }
}
