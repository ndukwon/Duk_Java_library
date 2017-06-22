/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.duk.lab.java.input.InputGenerator;

public class QuickSortTest {

    @Test
    public void testSort() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();

        final Comparable[] copiedArrayForQuickSort = Arrays.copyOf(generatedArray, generatedArray.length);
        final QuickSort quickSortUnit = new QuickSort();

        quickSortUnit.sort(copiedArrayForQuickSort);

        for (int i = 0; i + 1 < copiedArrayForQuickSort.length; i++) {
            final Comparable item = copiedArrayForQuickSort[i];
            final Comparable nextItem = copiedArrayForQuickSort[i + 1];
            if (item.compareTo(nextItem) > 0) {
                fail("sorting failed");
            }
        }
    }

}
