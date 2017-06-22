/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.duk.lab.java.input.InputGenerator;

public class SelectionSortTest {

    @Test
    public void testSort() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();

        final Comparable[] copiedArrayForSelectionSort = Arrays.copyOf(generatedArray, generatedArray.length);
        final SelectionSort selectionSortUnit = new SelectionSort();

        selectionSortUnit.sort(copiedArrayForSelectionSort);

        for (int i = 0; i + 1 < copiedArrayForSelectionSort.length; i++) {
            final Comparable item = copiedArrayForSelectionSort[i];
            final Comparable nextItem = copiedArrayForSelectionSort[i + 1];
            if (item.compareTo(nextItem) > 0) {
                fail("sorting failed");
            }
        }
    }

}
