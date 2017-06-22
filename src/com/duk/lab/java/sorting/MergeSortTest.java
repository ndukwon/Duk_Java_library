/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.duk.lab.java.input.InputGenerator;

public class MergeSortTest {

    @Test
    public void testSort() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();

        final Comparable[] copiedArrayForMergeSort = Arrays.copyOf(generatedArray, generatedArray.length);
        final MergeSort mergeSortUnit = new MergeSort();

        mergeSortUnit.sort(copiedArrayForMergeSort);

        for (int i = 0; i + 1 < copiedArrayForMergeSort.length; i++) {
            final Comparable item = copiedArrayForMergeSort[i];
            final Comparable nextItem = copiedArrayForMergeSort[i + 1];
            if (item.compareTo(nextItem) > 0) {
                fail("sorting failed");
            }
        }
    }

}
