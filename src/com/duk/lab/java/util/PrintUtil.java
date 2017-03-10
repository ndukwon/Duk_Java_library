package com.duk.lab.java.util;

public class PrintUtil {

    public static void printArray(String text, Comparable[] arrayToPrint) {
      System.out.print(text + "(" + arrayToPrint.length + ") [");
      for (Comparable item : arrayToPrint) {
          System.out.print(item + ", ");
      }
      System.out.print("]\n");
  }
}
