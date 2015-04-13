package me.dilek.izlek.util;

import android.util.Log;

/**
 * @author Hakan Dilek on 13.04.2015.
 */
public class LogUtils {

    public static void logw(String message) {
        String tagName = tagName();
        Log.w(tagName, message);
    }

    public static void loge(String message) {
        String tagName = tagName();
        Log.e(tagName, message);
    }

    public static void logd(String message) {
        String tagName = tagName();
        Log.d(tagName, message);
    }

    public static void logi(String message) {
        String tagName = tagName();
        Log.i(tagName, message);
    }

    public static void logw(String message, Throwable t) {
        String tagName = tagName();
        Log.w(tagName, message, t);
    }

    public static void loge(String message, Throwable t) {
        String tagName = tagName();
        Log.e(tagName, message, t);
    }

    public static void logd(String message, Throwable t) {
        String tagName = tagName();
        Log.d(tagName, message, t);
    }

    public static void logi(String message, Throwable t) {
        String tagName = tagName();
        Log.i(tagName, message, t);
    }

    private static int MIN_STACK_LEN = 5, IDX_STACK_ELM = MIN_STACK_LEN - 1;

    private static String tagName() {
        String result = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements != null && stackTraceElements.length > MIN_STACK_LEN) {
            StackTraceElement element = stackTraceElements[IDX_STACK_ELM];
            result = element.getClassName() + "@" + element.getLineNumber();
        }
        return result;
    }

}
