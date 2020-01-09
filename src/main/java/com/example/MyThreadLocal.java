package com.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
    private Map<Thread,T> map= Collections.synchronizedMap(new HashMap<>());
    public void set(T value){
        map.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread=Thread.currentThread();
        T value=map.get(thread);
        if(value == null && !map.containsKey(thread)){
            value=initValue();
            map.put(thread,value);
        }
        return value;
    }

    public void remove(){
        map.remove(Thread.currentThread());
    }

    /**
     * 由子类覆盖
     * @return
     */
    protected T initValue() {
        return null;
    }
}
