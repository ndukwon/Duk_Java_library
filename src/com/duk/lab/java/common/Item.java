/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.common;

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

    @Override
    public String toString() {
        return Integer.toString(mKey);
    }
}
