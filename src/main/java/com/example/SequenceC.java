package com.example;


public class SequenceC implements Sequence {
    private MyThreadLocal<Integer> myThreadLocal=new MyThreadLocal<Integer>(){
        @Override
        protected Integer initValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        myThreadLocal.set(myThreadLocal.get()+1);
        return myThreadLocal.get();
    }

    public static void main(String[] args) {
        Sequence sequence=new SequenceC();
        ClientThread clientThread1 = new ClientThread(sequence);
        ClientThread clientThread2 = new ClientThread(sequence);
        ClientThread clientThread3 = new ClientThread(sequence);
        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
    }
}
