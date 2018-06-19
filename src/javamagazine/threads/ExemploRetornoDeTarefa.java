package javamagazine.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExemploRetornoDeTarefa {

    public static void main(String[] args) {
        List<ExemploCallable> tarefas = Arrays.asList(
                new ExemploCallable(8000),
                new ExemploCallable(4000),
                new ExemploCallable(6000));

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);

        //executa as tarefas
        for (ExemploCallable tarefa : tarefas) {
            completionService.submit(tarefa);
        }
        System.out.println("Tarefas iniciadas, aguardando conclusão");
        
        //aguarda e printa o retorno de cada uma
        for (int i = 0; i < tarefas.size(); i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}
