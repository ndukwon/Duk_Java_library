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
 * - http://changsuk.me/?p=1433
 * - https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */

public class Singleton {

    private Singleton() {
        // to check time
        for (int i = 0; i < 1000; i++);
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
    
    private static final Singleton STATIC_INSTANCE = new Singleton();
    public static Singleton getInstanceStatic() {
        return STATIC_INSTANCE;
    }
    
    private static class LazyHolder {
        public static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstanceLazyHolder() {
        return LazyHolder.INSTANCE;
    }
}
