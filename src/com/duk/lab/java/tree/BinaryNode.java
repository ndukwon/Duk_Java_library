package com.duk.lab.java.tree;

import com.duk.lab.java.common.Item;

/**
 * @author dukwonnam
 *
 */
public class BinaryNode {
    private Item mItem;
    private BinaryNode mLeftChild;
    private BinaryNode mRightChild;

    public BinaryNode(Item item) {
        mItem = item;
    }

    public Item getItem() {
        return mItem;
    }

    public BinaryNode getLeftChild() {
        return mLeftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        mLeftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return mRightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        mRightChild = rightChild;
    }

    public int compareTo(BinaryNode node) {
        return compareTo(node.getItem());
    }

    public int compareTo(Item item) {
        return mItem.compareTo(item);
    }

    @Override
    public String toString() {
        return mItem.toString();
    }
}
