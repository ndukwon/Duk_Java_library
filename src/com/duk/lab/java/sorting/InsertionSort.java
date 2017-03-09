/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.java.sorting;

/**
 * @author DukwonNam
 */

public class InsertionSort implements ISort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            final Comparable currentItem = array[i];
            int insertPosition = i - 1;
            while (insertPosition >= 0 && currentItem.compareTo(array[insertPosition]) < 0) {
                array[insertPosition + 1] = array[insertPosition];
                insertPosition--;
            }

            insertPosition++;
            if (insertPosition < i) {
                array[insertPosition] = currentItem;
            }
        }
    }
}
