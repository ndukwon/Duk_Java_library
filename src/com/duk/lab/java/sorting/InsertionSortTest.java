/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.duk.lab.java.input.InputGenerator;

public class InsertionSortTest {

    @Test
    public void testSort() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();

        final Comparable[] copiedArrayForInsertionSort = Arrays.copyOf(generatedArray, generatedArray.length);
        final InsertionSort insertionSortUnit = new InsertionSort();

        insertionSortUnit.sort(copiedArrayForInsertionSort);

        for (int i = 0; i + 1 < copiedArrayForInsertionSort.length; i++) {
            final Comparable item = copiedArrayForInsertionSort[i];
            final Comparable nextItem = copiedArrayForInsertionSort[i + 1];
            if (item.compareTo(nextItem) > 0) {
                fail("sorting failed");
            }
        }
    }

}
