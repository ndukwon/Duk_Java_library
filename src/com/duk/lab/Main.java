package com.duk.lab;

import java.util.Arrays;

import com.duk.lab.input.InputGenerator;
import com.duk.lab.sorting.InsertionSort;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!!");
        InputGenerator generator = new InputGenerator();
        Comparable[] generatedArray = generator.getInputArray();

        // Insertion sort
        Comparable[] copiedArrayForInsertionSort = Arrays.copyOf(generatedArray, generatedArray.length);
        System.out.println("InsertionSort");
        printArray(copiedArrayForInsertionSort);
        InsertionSort insertionSortUnit = new InsertionSort();
        insertionSortUnit.sort(copiedArrayForInsertionSort);
        printArray(copiedArrayForInsertionSort);
    }

    private static void printArray(Comparable[] copiedArray) {
        System.out.print(copiedArray.length + "[");
        for (Comparable item : copiedArray) {
            System.out.print(item + ", ");
        }
        System.out.print("]\n");
    }
}
