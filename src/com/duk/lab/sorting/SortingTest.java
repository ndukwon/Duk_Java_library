/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

import java.util.Arrays;

import com.duk.lab.java.input.InputGenerator;

public class SortingTest {

    public static void sortingTest() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();
        printArray("generatedArray", generatedArray);

        // Insertion sort
        {
            final Comparable[] copiedArrayForInsertionSort = Arrays.copyOf(generatedArray, generatedArray.length);
            printArray("InsertionSort", copiedArrayForInsertionSort);
            final InsertionSort insertionSortUnit = new InsertionSort();

            final long startTime = System.currentTimeMillis();
            insertionSortUnit.sort(copiedArrayForInsertionSort);
            final long endTime = System.currentTimeMillis();

            printArray("InsertionSort", copiedArrayForInsertionSort);
            System.out.println("InsertionSort time: " + (endTime - startTime) + "ms");
        }

        // Bubble sort
        {
            final Comparable[] copiedArrayForBubbleSort = Arrays.copyOf(generatedArray, generatedArray.length);
            printArray("BubbleSort", copiedArrayForBubbleSort);
            final BubbleSort bubbleSortUnit = new BubbleSort();

            final long startTime = System.currentTimeMillis();
            bubbleSortUnit.sort(copiedArrayForBubbleSort);
            final long endTime = System.currentTimeMillis();

            printArray("BubbleSort", copiedArrayForBubbleSort);
            System.out.println("BubbleSort time: " + (endTime - startTime) + "ms");
        }

        // Selection sort
        {
            final Comparable[] copiedArrayForSelectionSort = Arrays.copyOf(generatedArray, generatedArray.length);
            printArray("SelectionSort", copiedArrayForSelectionSort);
            final SelectionSort selectionSortUnit = new SelectionSort();

            final long startTime = System.currentTimeMillis();
            selectionSortUnit.sort(copiedArrayForSelectionSort);
            final long endTime = System.currentTimeMillis();

            printArray("SelectionSort", copiedArrayForSelectionSort);
            System.out.println("SelectionSort time: " + (endTime - startTime) + "ms");
        }

        // Merge sort
        {
            final Comparable[] copiedArrayForMergeSort = Arrays.copyOf(generatedArray, generatedArray.length);
            printArray("MergeSort", copiedArrayForMergeSort);
            final MergeSort mergeSortUnit = new MergeSort();

            final long startTime = System.currentTimeMillis();
            mergeSortUnit.sort(copiedArrayForMergeSort);
            final long endTime = System.currentTimeMillis();

            printArray("MergeSort", copiedArrayForMergeSort);
            System.out.println("MergeSort time: " + (endTime - startTime) + "ms");
        }

        // Quick sort
        {
            final Comparable[] copiedArrayForQuickSort = Arrays.copyOf(generatedArray, generatedArray.length);
            printArray("QuickSort", copiedArrayForQuickSort);
            final QuickSort quickSortUnit = new QuickSort();

            final long startTime = System.currentTimeMillis();
            quickSortUnit.sort(copiedArrayForQuickSort);
            final long endTime = System.currentTimeMillis();

            printArray("QuickSort", copiedArrayForQuickSort);
            System.out.println("QuickSort time: " + (endTime - startTime) + "ms");
        }
    }

    private static void printArray(String text, Comparable[] arrayToPrint) {
//        System.out.print(text + "(" + arrayToPrint.length + ") [");
//        for (Comparable item : arrayToPrint) {
//            System.out.print(item + ", ");
//        }
//        System.out.print("]\n");
    }
}
