/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.sorting;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author DukwonNam
 *
 */
public class InsertingSortList {

    private List<Comparable> mList = new LinkedList<>();
    public boolean start(List<Comparable> inputList) {
        System.out.println("InsertSort has started.");

        for (Comparable item : inputList) {
            insert(item);
        }

        return true;
    }

    public void insert(Comparable item) {
        boolean isInserted = false;
        for (int i = 0; i < mList.size(); i++) {
            if (item.compareTo(mList.get(i)) < 0) {
                mList.add(i, item);
                isInserted = true;
                break;
            }
        }

        if (isInserted == false) {
            mList.add(item);
        }
    }
}
