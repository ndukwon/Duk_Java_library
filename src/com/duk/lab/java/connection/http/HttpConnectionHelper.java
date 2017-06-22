/*
 * Copyright @ DukwonNam
 * email: ndukwon@gmail.com
 */

package com.duk.lab.java.connection.http;

public class HttpConnectionHelper {

    public interface HttpConnectionCallback {
        void onResponse(String responseStr);
    }
}
