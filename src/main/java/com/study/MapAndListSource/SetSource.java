package com.study.MapAndListSource;

import java.util.*;

public class SetSource {

    public static void main(String[] args) {
        Set AbastractSet = new AbstractSet() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };


        Set hashSet = new HashSet();



        Set TreeSet = new TreeSet();

    }
}
