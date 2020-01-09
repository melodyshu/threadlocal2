package com.example;

import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {
    private Sequence sequence;

    public ClientThread(Sequence sequence){
        this.sequence=sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" => "+sequence.getNumber());
        }
    }
}
