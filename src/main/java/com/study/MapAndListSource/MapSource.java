package com.study.MapAndListSource;

import org.junit.Test;

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



        Map Hashtable = new Hashtable();
        //  1.extends Dictionary


        Map TreeMap = new TreeMap();



        Map conMap = new ConcurrentHashMap();

    }

    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);
    @Test
    public void HashMapNotSynchronizeTest(){
            map.put(5, "C");
            new Thread("Thread1") {
                public void run() {
                    map.put(7, "B");
                    System.out.println(map);
                }
            }.start();
            new Thread("Thread2") {
                public void run() {
                    map.put(3, "A");
                            System.out.println(map);
                }
            }.start();
    }
}

