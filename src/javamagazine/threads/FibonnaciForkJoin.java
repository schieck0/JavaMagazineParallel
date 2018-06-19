package javamagazine.threads;

import java.util.concurrent.RecursiveTask;

public class FibonnaciForkJoin extends RecursiveTask<Integer> {

    private final int n;

    FibonnaciForkJoin(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        FibonnaciForkJoin f1 = new FibonnaciForkJoin(n - 1);
        f1.fork();
        FibonnaciForkJoin f2 = new FibonnaciForkJoin(n - 2);
        return f2.compute() + f1.join();
    }
}
