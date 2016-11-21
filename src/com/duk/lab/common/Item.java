/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.common;

/**
 * 
 * @author DukwonNam
 *
 */
public class Item implements Comparable<Item> {
    private final int mKey;
    public Item(int key) {
        mKey = key;
    }

    public int getKey() {
        return mKey;
    }

    @Override
    public int compareTo(Item itemToCompare) {
        return mKey - itemToCompare.getKey();
    }
}
