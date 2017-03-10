/*
 * Copyright @ DukwonNam
 * email: ndukwon@google.com
 */

package com.duk.lab.java.tree;

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
//        System.out.println("item=" + item);

        BinaryNode currentNode = mRoot;
        BinaryNode childNode = null;
        do {
//            System.out.println("currentNode=" + currentNode + ", currentNode.compareTo(item)=" + currentNode.compareTo(item));
            if (currentNode.compareTo(item) > 0) {
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
        int currentLevel = 0;
        while (printNthNodes(currentLevel++));
    }

    private boolean printNthNodes(int nodeLevel) {
        boolean result = false;
        final BinaryNode dummyNode = new BinaryNode(null);
        int currentLevel = 0;
        Queue<BinaryNode> currentQueue = new LinkedList<BinaryNode>();
        currentQueue.offer(mRoot);

        while (currentLevel < nodeLevel) {
            currentLevel++;
            final Queue<BinaryNode> nextQueue = new LinkedList<BinaryNode>();
            while (!currentQueue.isEmpty()) {
                final BinaryNode node = currentQueue.poll();
                BinaryNode leftChild = node.getLeftChild();
                BinaryNode rightChild = node.getRightChild();
                if (leftChild == null) {
                    leftChild = dummyNode;
                }
                if (rightChild == null) {
                    rightChild = dummyNode;
                }
                
                nextQueue.offer(leftChild);
                nextQueue.offer(rightChild);
            }
            currentQueue = nextQueue;
        }
        
        while (!currentQueue.isEmpty()) {
            final BinaryNode node = currentQueue.poll();
            if (node == dummyNode) {
                System.out.print(" null");
            } else {
                System.out.print(" " + node.getItem());
                result = true;
            }
        }
        System.out.print("\n");
        
        return result;
    }
}
