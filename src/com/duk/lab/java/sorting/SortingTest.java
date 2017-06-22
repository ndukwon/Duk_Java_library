/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

import java.util.Arrays;

import com.duk.lab.java.input.InputGenerator;
import com.duk.lab.java.util.PrintUtil;

public class SortingTest {

    public static void sortingTest() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();
        PrintUtil.printArray("generatedArray", generatedArray);

        // Insertion sort
        {
            final Comparable[] copiedArrayForInsertionSort = Arrays.copyOf(generatedArray, generatedArray.length);
            PrintUtil.printArray("InsertionSort", copiedArrayForInsertionSort);
            final InsertionSort insertionSortUnit = new InsertionSort();

            final long startTime = System.currentTimeMillis();
            insertionSortUnit.sort(copiedArrayForInsertionSort);
            final long endTime = System.currentTimeMillis();

            PrintUtil.printArray("InsertionSort", copiedArrayForInsertionSort);
            System.out.println("InsertionSort time: " + (endTime - startTime) + "ms");
        }

        // Bubble sort
        {
            final Comparable[] copiedArrayForBubbleSort = Arrays.copyOf(generatedArray, generatedArray.length);
            PrintUtil.printArray("BubbleSort", copiedArrayForBubbleSort);
            final BubbleSort bubbleSortUnit = new BubbleSort();

            final long startTime = System.currentTimeMillis();
            bubbleSortUnit.sort(copiedArrayForBubbleSort);
            final long endTime = System.currentTimeMillis();

            PrintUtil.printArray("BubbleSort", copiedArrayForBubbleSort);
            System.out.println("BubbleSort time: " + (endTime - startTime) + "ms");
        }

        // Selection sort
        {
            final Comparable[] copiedArrayForSelectionSort = Arrays.copyOf(generatedArray, generatedArray.length);
            PrintUtil.printArray("SelectionSort", copiedArrayForSelectionSort);
            final SelectionSort selectionSortUnit = new SelectionSort();

            final long startTime = System.currentTimeMillis();
            selectionSortUnit.sort(copiedArrayForSelectionSort);
            final long endTime = System.currentTimeMillis();

            PrintUtil.printArray("SelectionSort", copiedArrayForSelectionSort);
            System.out.println("SelectionSort time: " + (endTime - startTime) + "ms");
        }

        // Merge sort
        {
            final Comparable[] copiedArrayForMergeSort = Arrays.copyOf(generatedArray, generatedArray.length);
            PrintUtil.printArray("MergeSort", copiedArrayForMergeSort);
            final MergeSort mergeSortUnit = new MergeSort();

            final long startTime = System.currentTimeMillis();
            mergeSortUnit.sort(copiedArrayForMergeSort);
            final long endTime = System.currentTimeMillis();

            PrintUtil.printArray("MergeSort", copiedArrayForMergeSort);
            System.out.println("MergeSort time: " + (endTime - startTime) + "ms");
        }

        // Quick sort
        {
            final Comparable[] copiedArrayForQuickSort = Arrays.copyOf(generatedArray, generatedArray.length);
            PrintUtil.printArray("QuickSort", copiedArrayForQuickSort);
            final QuickSort quickSortUnit = new QuickSort();

            final long startTime = System.currentTimeMillis();
            quickSortUnit.sort(copiedArrayForQuickSort);
            final long endTime = System.currentTimeMillis();

            PrintUtil.printArray("QuickSort", copiedArrayForQuickSort);
            System.out.println("QuickSort time: " + (endTime - startTime) + "ms");
        }
    }
}
