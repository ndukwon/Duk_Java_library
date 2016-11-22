package com.duk.lab.sorting;

public class InsertionSort {

    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int insertPosition = -1;
            for (int j = 0; j < i; j++) {
                if (array[i].compareTo(array[j]) < 0) {
                    // swap
                    insertPosition = j;
                }
            }

            if (insertPosition != -1) {
                Comparable temp = array[i];
                for (int j = i; j > insertPosition; j--) {
                    array[j] = array[j -1];
                }
                array[insertPosition] = temp;
            }
        }
    }
}
