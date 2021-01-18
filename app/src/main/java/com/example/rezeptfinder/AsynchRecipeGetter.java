package com.example.rezeptfinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchRecipeGetter {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future sayHello(String hello) {
        return executor.submit(() -> {
            try {
                System.out.println("HELLO THERE!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}
