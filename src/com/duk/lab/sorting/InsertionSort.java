/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

/**
 * @author DukwonNam
 */

public class InsertionSort implements ISort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int insertPosition = -1;
            for (int j = 0; j < i; j++) {
                if (array[i].compareTo(array[j]) < 0) {
                    // swap
                    insertPosition = j;
                    break;
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
