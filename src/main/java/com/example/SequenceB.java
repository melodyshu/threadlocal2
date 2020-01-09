package com.example;

public class SequenceB implements Sequence {
    private ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        threadLocal.set(threadLocal.get()+1);
        return threadLocal.get();
    }

    public static void main(String[] args) {
        Sequence sequence=new SequenceB();
        ClientThread clientThread1 = new ClientThread(sequence);
        ClientThread clientThread2 = new ClientThread(sequence);
        ClientThread clientThread3 = new ClientThread(sequence);
        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
    }
}
