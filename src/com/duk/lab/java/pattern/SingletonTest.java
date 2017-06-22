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
            
            SingletonThread t1 = new SingletonSyncThread("SingletonSyncThread1");
            SingletonThread t2 = new SingletonSyncThread("SingletonSyncThread2");
            SingletonThread t3 = new SingletonSyncThread("SingletonSyncThread3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }

    class SingletonSyncThread extends SingletonThread {

        SingletonSyncThread(String taskName) {
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
            
            SingletonThread t1 = new SingletonStaticThread("SingletonStaticThread1");
            SingletonThread t2 = new SingletonStaticThread("SingletonStaticThread2");
            SingletonThread t3 = new SingletonStaticThread("SingletonStaticThread3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }

    class SingletonStaticThread extends SingletonThread {

        SingletonStaticThread(String taskName) {
            super(taskName);
        }

        @Override
        protected void gettingInstance() {
            singletonInstance = Singleton.getInstanceStatic();
        }
    }
    
    @Test
    public void testGetInstanceLazyHolder() {
        System.out.println("testGetInstanceLazyHolder");
        
        for (int i = 0; i < 100; i++) {
            Singleton.release();
            
            SingletonThread t1 = new SingletonLazyHolderThread("SingletonLazyHolderThread1");
            SingletonThread t2 = new SingletonLazyHolderThread("SingletonLazyHolderThread2");
            SingletonThread t3 = new SingletonLazyHolderThread("SingletonLazyHolderThread3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }

    class SingletonLazyHolderThread extends SingletonThread {

        SingletonLazyHolderThread(String taskName) {
            super(taskName);
        }

        @Override
        protected void gettingInstance() {
            singletonInstance = Singleton.getInstanceLazyHolder();
        }
    }

    @Test
    public void testGetInstanceEnum() {
        System.out.println("testGetInstanceEnum");
        
        for (int i = 0; i < 100; i++) {
            Singleton.release();
            
            SingletonEnumThread t1 = new SingletonEnumThread("SingletonEnumThread1");
            SingletonEnumThread t2 = new SingletonEnumThread("SingletonEnumThread2");
            SingletonEnumThread t3 = new SingletonEnumThread("SingletonEnumThread3");
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            assertEquals(t1.getOwnSingleton(), t2.getOwnSingleton());
            assertEquals(t2.getOwnSingleton(), t3.getOwnSingleton());
        }
    }
    
    class SingletonEnumThread extends Thread {
        SingletonEnum singletonInstance;
        String taskName;
        
        SingletonEnumThread (String taskName) {
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
            singletonInstance = SingletonEnum.INSTANCE;
        }

        public SingletonEnum getOwnSingleton() {
            return singletonInstance;
        }
    }
}
