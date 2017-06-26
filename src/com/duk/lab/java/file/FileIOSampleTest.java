package com.duk.lab.java.file;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FileIOSampleTest {
    
    @Test
    public void testFileIO() {
        try {
            FileIOSample.writeByFileOutputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("writeByFileOutputStream FileNotFoundException failed");
        } catch (IOException e) {
            e.printStackTrace();
            fail("writeByFileOutputStream IOException failed");
        }
        
        try {
            FileIOSample.writeByFileWriter();
        } catch (IOException e) {
            e.printStackTrace();
            fail("writeByFileWriter IOException failed");
        }
        
        try {
            FileIOSample.writeByPrintWriter();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("writeByPrintWriter FileNotFoundException failed");
        }
        
        try {
            FileIOSample.readByFileInputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("readByFileInputStream FileNotFoundException failed");
        } catch (IOException e) {
            e.printStackTrace();
            fail("readByFileInputStream IOException failed");
        }
        
        try {
            FileIOSample.readByBufferedReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("readByBufferedReader FileNotFoundException failed");
        } catch (IOException e) {
            e.printStackTrace();
            fail("readByBufferedReader IOException failed");
        }
    }
}
