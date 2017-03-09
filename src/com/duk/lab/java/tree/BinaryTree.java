/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.duk.lab.java.common.Item;

public class BinaryTree {

    private BinaryNode mRoot;
    
    public void putAll(Item[] array) {
        for (Item item : array) {
            put(item);
        }
    }

    public void put(Item item) {
        if (mRoot == null) {
            mRoot = new BinaryNode(item);
            return;
        }

        BinaryNode currentNode = mRoot;
        BinaryNode childNode = null;
        do {
            if (currentNode.compareTo(item) < 0) {
                childNode = currentNode.getLeftChild();
                if (childNode == null) {
                    currentNode.setLeftChild(new BinaryNode(item));
                    break;
                } else {
                    currentNode = childNode;
                }
            } else {
                childNode = currentNode.getRightChild();
                if (childNode == null) {
                    currentNode.setRightChild(new BinaryNode(item));
                    break;
                } else {
                    currentNode = childNode;
                }
            }
        } while (currentNode != null);
    }

    public void printTree() {
        
    }
    
    private void printNthNodes(int nodeLevel) {
        final BinaryNode dummyNode = new BinaryNode(null);
        int currentLevel = 0;
        final Queue<BinaryNode> currentQueue = new LinkedList<BinaryNode>();
        currentQueue.offer(mRoot);

        while (currentLevel < nodeLevel) {
            currentLevel++;
            final Queue<BinaryNode> nextQueue = new LinkedList<BinaryNode>();
            while (!currentQueue.isEmpty()) {
                final BinaryNode node = currentQueue.poll();
                
            }
        }
    }
}
