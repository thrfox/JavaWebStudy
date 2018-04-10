package com.study.MapAndListSource;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap和
 */
public class MapSource {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashAppendTest test = new hashAppendTest(hashMap);
        Thread t1 = new Thread(test,"thread1");
        Thread t2 = new Thread(test,"thread2");
        t1.start();
        t2.start();

        System.out.println(hashMap.toString());
        //  1.extends AbstractMap


        Map Hashtable = new Hashtable();
        //  1.extends Dictionary


        Map TreeMap = new TreeMap();



        Map conMap = new ConcurrentHashMap();



    }
}

class hashAppendTest implements Runnable {

    Map hashMap;

    hashAppendTest(Map hashMap){
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        this.hashMap  = hashAppend(hashMap);
        System.out.println(this.hashMap);
    }

    Map hashAppend(Map hashMap) {
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i + "-");
        }
        return hashMap;
    }
}
