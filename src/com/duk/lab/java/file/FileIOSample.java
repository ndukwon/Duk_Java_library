package com.duk.lab.java.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIOSample {
    private static final int MAX_LINE = 30;

    public static void writeByFileOutputStream() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("test_FileOutputStream.txt");
        for (int i = 0; i < MAX_LINE; i++) {
            String line = "[" + i + "] line \n";
            fos.write(line.getBytes());
        }
        fos.close();
    }
    
    public static void writeByFileWriter() throws IOException {
        FileWriter fw = new FileWriter("test_FileWriter.txt");
        for (int i = 0; i < MAX_LINE; i++) {
            String line = "[" + i + "] line \n";
            fw.write(line);
        }
        fw.close();
    }
    
    public static void writeByPrintWriter() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("test_PrintWriter.txt");
        for (int i = 0; i < MAX_LINE; i++) {
//            String line = "[" + i + "] line \r\n";
            pw.println("[" + i + "] line");
        }
        pw.close();
    }
    
    public static void readByFileInputStream() throws FileNotFoundException, IOException {
        System.out.println();
        FileInputStream fis = new FileInputStream("test_FileOutputStream.txt");
        byte[] buffer = new byte[30];
        int size = 0;
        while ((size = fis.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, size));
        }
        fis.close();
    }
    
    public static void readByBufferedReader() throws FileNotFoundException, IOException {
        System.out.println();
        BufferedReader bf = new BufferedReader(new FileReader("test_FileWriter.txt"));
        String line = null;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
