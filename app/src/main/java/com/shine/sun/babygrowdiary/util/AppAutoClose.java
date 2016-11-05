package com.shine.sun.babygrowdiary.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Steven on 2016/6/29 0029.
 */

public class AppAutoClose {
    public static void quietClose(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
