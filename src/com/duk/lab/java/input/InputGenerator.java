package com.duk.lab.java.input;

import com.duk.lab.java.common.Item;

public class InputGenerator {
    Item[] mArray;

    public Comparable[] getInputArray() {
        if (mArray == null) {
            mArray = generateInputArray(20, 20, false);
        }
        return mArray;
    }

    private Item[] generateInputArray(int size, int range, boolean isDuplicationAllowed) {
        Item[] array = new Item[size];

        int i = 0;
        while (i < size) {
            int randomInt = (int)(Math.random() * range);
            if (!isDuplicationAllowed) {
                for (int j = 0; j < i; j++) {
                    if (array[j].getKey() == randomInt) {
                        randomInt = -1;
                        break;
                    }
                }
            }

            if (randomInt != -1) {
                array[i++] = new Item(randomInt);
            }
        }

        return array;
    }
}
