package com.duk.lab.java.tree;

import com.duk.lab.java.common.Item;

/**
 * @author dukwonnam
 *
 */
public class BinaryNode {
    private Item item;
    private BinaryNode leftChild;
    private BinaryNode rightChild;

    public BinaryNode(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public int compareTo(BinaryNode node) {
        return compareTo(node.getItem());
    }

    public int compareTo(Item item) {
        return item.compareTo(item);
    }
}
