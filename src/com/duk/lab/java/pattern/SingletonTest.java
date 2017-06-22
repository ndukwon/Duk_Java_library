/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void testGetInstance() {
        System.out.println("testGetInstance");
        
        for (int i = 0; i < 100; i++) {
            Singleton.release();
            
            SingletonThread t1 = new SingletonThread("SingletonThread1");
            SingletonThread t2 = new SingletonThread("SingletonThread2");
            SingletonThread t3 = new SingletonThread("SingletonThread3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }
    
    class SingletonThread extends Thread {
        Singleton singletonInstance;
        String taskName;
        SingletonThread (String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            super.run();

            long start = System.nanoTime();
            gettingInstance();
            long end = System.nanoTime();
            System.out.println(taskName + "[" + (end - start) + "ns]ID=" + Thread.currentThread().getId() + " singletonInstance=" + singletonInstance);
        }
        
        protected void gettingInstance() {
            singletonInstance = Singleton.getInstance();
        }

        public Singleton getOwnSingleton() {
            return singletonInstance;
        }
    }
    
    @Test
    public void testGetInstanceSync() {
        System.out.println("testGetInstanceSync");
        
        for (int i = 0; i < 100; i++) {
            Singleton.release();
            
            SingletonThread t1 = new SingletonThreadSync("SingletonThreadSync1");
            SingletonThread t2 = new SingletonThreadSync("SingletonThreadSync2");
            SingletonThread t3 = new SingletonThreadSync("SingletonThreadSync3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }

    class SingletonThreadSync extends SingletonThread {

        SingletonThreadSync(String taskName) {
            super(taskName);
        }

        @Override
        protected void gettingInstance() {
            singletonInstance = Singleton.getInstanceSync();
        }
    }
    
    @Test
    public void testGetInstanceStatic() {
        System.out.println("testGetInstanceStatic");
        
        for (int i = 0; i < 100; i++) {
            Singleton.release();
            
            SingletonThread t1 = new SingletonThreadStatic("SingletonThreadStatic1");
            SingletonThread t2 = new SingletonThreadStatic("SingletonThreadStatic2");
            SingletonThread t3 = new SingletonThreadStatic("SingletonThreadStatic3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }

    class SingletonThreadStatic extends SingletonThread {

        SingletonThreadStatic(String taskName) {
            super(taskName);
        }

        @Override
        protected void gettingInstance() {
            singletonInstance = Singleton.getInstanceSync();
        }
    }
}
