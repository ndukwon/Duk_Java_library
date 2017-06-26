/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.annotation;

import com.sun.istack.internal.NotNull;

public class CustomAnnotationImpl {
    @NotNull
    @CustomAnnotation("aaa")
    private String name;
    
    @NotNull
    @CustomAnnotation("bbb")
    private String value;

    CustomAnnotationImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getValue() {
        return value;
    }

    @NotNull
    public void setValue(String value) {
        this.value = value;
    }

    @NotNull
    @CustomAnnotation("print")
    public void printNameAndValue() {
        System.out.println("name=" + name + ", value=" + value);
    }
}
