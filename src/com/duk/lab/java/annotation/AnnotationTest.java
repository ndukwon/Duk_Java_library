/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 
 * @author ndukwon@gmail.com
 * 
 * Reference:
 * - https://medium.com/@ggikko/java-%EC%BB%A4%EC%8A%A4%ED%85%80-annotation-436253f395ad
 * - https://www.javatpoint.com/custom-annotation
 *
 */
public class AnnotationTest {

    @Test
    public void testAnnotationOfClass() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method[] methodArray = CustomAnnotationImpl.class.getDeclaredMethods();
        Field[] fieldArray = CustomAnnotationImpl.class.getDeclaredFields();
        
        testAnnotationInMethod(null, methodArray);
        testAnnotationInField(null, fieldArray);
    }

    @Test
    public void testAnnotationOfObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        CustomAnnotationImpl test = new CustomAnnotationImpl("dododo", "donedonedone");
        Method[] methodArray = test.getClass().getDeclaredMethods();
        Field[] fieldArray = test.getClass().getDeclaredFields();
        
        testAnnotationInMethod(test, methodArray);
        testAnnotationInField(test, fieldArray);
    }
    
    private void testAnnotationInMethod(Object obj, Method[] methodArray) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Method method : methodArray) {
            String methodName = method.getName();
            CustomAnnotation testAnnotation = method.getAnnotation(CustomAnnotation.class);
            Annotation[] annotationArray = method.getDeclaredAnnotations();
            boolean isAnnotationPresent = method.isAnnotationPresent(CustomAnnotation.class);
            
            System.out.println();
            System.out.println("methodName=" + methodName);
            System.out.println("isAnnotationPresent=" + isAnnotationPresent);
            System.out.println("testAnnotation=" + testAnnotation);

            if (testAnnotation != null) {
                System.out.println("testAnnotation.name()=" + testAnnotation.name());
                System.out.println("testAnnotation.value()=" + testAnnotation.value());
                
                if (obj != null) {
                    method.invoke(obj);
                }
            }

            for (Annotation annotation : annotationArray) {
                System.out.println("annotation=" + annotation);
                System.out.println("annotation.annotationType()=" + annotation.annotationType());
            }
        }
    }
    
    private void testAnnotationInField(Object obj, Field[] fieldArray) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : fieldArray) {
            String fieldName = field.getName();
            CustomAnnotation testAnnotation = field.getAnnotation(CustomAnnotation.class);
            Annotation[] annotationArray = field.getDeclaredAnnotations();
            boolean isAnnotationPresent = field.isAnnotationPresent(CustomAnnotation.class);
            
            System.out.println();
            System.out.println("fieldName=" + fieldName);
            System.out.println("isAnnotationPresent=" + isAnnotationPresent);
            System.out.println("testAnnotation=" + testAnnotation);

            if (testAnnotation != null) {
                System.out.println("testAnnotation.name()=" + testAnnotation.name());
                System.out.println("testAnnotation.value()=" + testAnnotation.value());
                field.setAccessible(true);
                
                if (obj != null) {
                    String fieldValue = (String)field.get(obj);
                    System.out.println("fieldValue=" + fieldValue);
                    field.set(obj, "33");
                    fieldValue = (String)field.get(obj);
                    System.out.println("fieldValue=" + fieldValue);
                }
            }

            for (Annotation annotation : annotationArray) {
                System.out.println("annotation=" + annotation);
                System.out.println("annotation.annotationType()=" + annotation.annotationType());
            }
        }
    }
}
