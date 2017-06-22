/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.pattern;

/**
 * @author ndukwon@gmail.com
 * 
 * reference:
 * - http://jusungpark.tistory.com/16
 * - https://blog.seotory.com/post/2016/03/java-singleton-pattern
 */

public class Singleton {

    private Singleton() {
        // Do nothing
    }

    private static Singleton sInstance;
    public static Singleton getInstance() {
        if (sInstance == null) {
            sInstance = new Singleton();
        }

        return sInstance;
    }

    private static Singleton sInstanceSync;
    public static synchronized Singleton getInstanceSync() {
        if (sInstanceSync == null) {
            sInstanceSync = new Singleton();
        }

        return sInstanceSync;
    }

    public static void release() {
        sInstance = null;
        sInstanceSync = null;
    }
    
    private static Singleton sInstanceStatic = new Singleton();
    public static synchronized Singleton getInstanceStatic() {
        return sInstanceSync;
    }
}
