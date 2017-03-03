/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

public class QuickSort implements ISort {

    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
        printArray("A", array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int startIndex, int endIndex) {
        System.out.println("startIndex=" + startIndex + ", endIndex=" + endIndex);
        if (startIndex >= endIndex) {
            return;
        }

        final Comparable pivot = array[startIndex];
        int left = startIndex + 1;
        int right = endIndex;

        while (left < right) {
            while (pivot.compareTo(array[left]) < 0) {
                left++;
                System.out.println("left=" + left);
            }
            while (pivot.compareTo(array[right]) > 0) {
                right--;
                System.out.println("right=" + right);
            }

            if (left < right) {
                swap(array, left, right);
            }

            printArray("A", array, startIndex, endIndex);
        }
        swap(array, startIndex, right);

        quickSort(array, startIndex, right - 1);
        quickSort(array, right + 1, endIndex);
    }

    private void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void printArray(String text, Comparable[] arrayToPrint, int startIndex, int endIndex) {
        System.out.print(text + "(" + arrayToPrint.length + ") [");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arrayToPrint[i] + ", ");
        }
        System.out.print("]\n");
    }
}
