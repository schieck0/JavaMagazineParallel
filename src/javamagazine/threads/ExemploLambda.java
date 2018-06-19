package javamagazine.threads;

public class ExemploLambda {


    public static void main(String[] args) {

        new Thread(() -> {
            //CÒDIGO AQUI
        }).start();
    }
}
