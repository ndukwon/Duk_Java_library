/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

/**
 * 
 * @author DukwonNam
 *
 */
public class BubbleSort implements ISort {

    @Override
    public void sort(Comparable[] array) {
        boolean isCompleted = true;
        while (isCompleted) {
            isCompleted = false;
            for (int i = 0; i + 1 < array.length; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    Comparable temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isCompleted = true;
                }
            }
        }
    }
}
