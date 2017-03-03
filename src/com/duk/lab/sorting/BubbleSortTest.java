/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.duk.lab.java.input.InputGenerator;

public class BubbleSortTest {

    @Test
    public void testSort() {
        final InputGenerator generator = new InputGenerator();
        final Comparable[] generatedArray = generator.getInputArray();

        final Comparable[] copiedArrayForBubbleSort = Arrays.copyOf(generatedArray, generatedArray.length);
        final BubbleSort bubbleSortUnit = new BubbleSort();

        bubbleSortUnit.sort(copiedArrayForBubbleSort);

        for (int i = 0; i + 1 < copiedArrayForBubbleSort.length; i++) {
            final Comparable item = copiedArrayForBubbleSort[i];
            final Comparable nextItem = copiedArrayForBubbleSort[i + 1];
            if (item.compareTo(nextItem) > 0) {
                fail("sorting failed");
            }
        }
    }

}
