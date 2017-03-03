/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

import java.util.Arrays;

public class MergeSort implements ISort {

    @Override
    public void sort(Comparable[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(Comparable[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex < 1) {
            return;
        }

        int middleIndex = (endIndex + startIndex) / 2;
        mergeSort(array, startIndex, middleIndex);
        mergeSort(array, middleIndex + 1, endIndex);

        merge(array, startIndex, middleIndex, endIndex);
    }

    private void merge(Comparable[] array, int startIndex, int middleIndex, int endIndex) {
//        System.out.println("startIndex=" + startIndex + ", middleIndex=" + middleIndex + ", endIndex=" + endIndex);
//        printArray("A", array, startIndex, middleIndex);
//        printArray("B", array, middleIndex + 1, endIndex);
        Comparable[] mergedArray = new Comparable[endIndex - startIndex + 1];
        int indexA = startIndex;
        int indexB = middleIndex + 1;

        for (int i = 0; i < mergedArray.length; i++) {
            if (indexB > endIndex || (indexA <= middleIndex && array[indexA].compareTo(array[indexB]) < 0)) {
                mergedArray[i] = array[indexA++];
            } else {
                mergedArray[i] = array[indexB++];
            }
        }

        for (int i = 0, j = startIndex; i < mergedArray.length; i++, j++) {
            array[j] = mergedArray[i];
//            System.out.println("array[" + j + "]=" + array[j]);
        }
//        printArray("merged", array, 0, array.length - 1);
    }

    private void printArray(String text, Comparable[] arrayToPrint, int startIndex, int endIndex) {
        System.out.print(text + "(" + arrayToPrint.length + ") [");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arrayToPrint[i] + ", ");
        }
        System.out.print("]\n");
    }
}
