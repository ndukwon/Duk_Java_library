package com.duk.lab.java.tree;

import java.util.Arrays;

import com.duk.lab.java.common.Item;
import com.duk.lab.java.input.InputGenerator;
import com.duk.lab.java.util.PrintUtil;

public class TreeTest {

    public static void treeTest() {
        final InputGenerator generator = new InputGenerator();
        final Item[] generatedArray = generator.getInputArray();
        PrintUtil.printArray("generatedArray", generatedArray);
        
        // Binary tree
        {
            final Item[] copiedArrayForBinaryTree = Arrays.copyOf(generatedArray, generatedArray.length);
            final BinaryTree binaryTree = new BinaryTree();

            final long startTime = System.currentTimeMillis();
            binaryTree.putAll(copiedArrayForBinaryTree);
            final long endTime = System.currentTimeMillis();

            System.out.println("BinaryTree time: " + (endTime - startTime) + "ms");
        }
    }
}
