package me.leig.baselibrary.util;

import android.util.Log;

/**
 * @author leig
 * @version 20180301
 */
public class LogTool {

    private String tag;

    public LogTool(String tag) {
        this.tag = tag;
    }

    public void i(String msg) {
        Log.i(tag, msg);
    }

    public void e(String msg) {
        Log.e(tag, msg);
    }
}
