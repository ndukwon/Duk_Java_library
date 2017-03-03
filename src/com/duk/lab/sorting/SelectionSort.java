/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

public class SelectionSort implements ISort {


    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i ++) {
            int lowestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[lowestIndex].compareTo(array[j]) > 0) {
                    lowestIndex = j;
                }
            }

            // swap
            if (i != lowestIndex) {
                Comparable temp = array[i];
                array[i] = array[lowestIndex];
                array[lowestIndex] = temp;
            }
        }
    }
}
