package com.duk.lab.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FundamentalTest {
    
    List<Integer> linkedList;
    List<Integer> arrayList;
    
    @Before
    public void beforeLoop() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
    }

    @Test
    public void testLinkedList() {
        System.out.println("testLinkedList list");
        System.out.println();
        testList(linkedList);
    }
    
    @Test
    public void testArrayList() {
        System.out.println("testArrayList list");
        System.out.println();
        testList(arrayList);
    }
    
    private void testList(List<Integer> list) {
        long startTime;
        long endTime;
        
        // list 'for + i' test
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
//            System.out.print(String.valueOf(value));
        }
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("list 'for + i' test time=" + (endTime - startTime) + "ms");
        
        // list 'for each' test
        startTime = System.currentTimeMillis();
        for (Integer value : list) {
//            System.out.print(String.valueOf(value));
        }
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("list 'for each' test time=" + (endTime - startTime) + "ms");
        
        // list 'while' test
        startTime = System.currentTimeMillis();
        int i = 0;
        while (i < list.size()) {
            Integer value = list.get(i++);
//            System.out.print(String.valueOf(value));
        }
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("list 'while' test time=" + (endTime - startTime) + "ms");
        
        // list 'while + iterator' test
        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
//            System.out.print(String.valueOf(value));
        }
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("list 'while + iterator' test time=" + (endTime - startTime) + "ms");
        
        // list 'forEach()' test for Java 8
        startTime = System.currentTimeMillis();
        list.forEach((value) -> {
//            System.out.print(String.valueOf(value));
        });
        endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("list 'forEach()' test time=" + (endTime - startTime) + "ms");
    }

}
