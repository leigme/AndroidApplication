package me.leig.baselibrary.application;

import android.app.Application;
import android.util.Log;

import me.leig.baselibrary.util.LogTool;

/**
 * 启动基类
 *
 * @author leig
 * @version 20180301
 */
public abstract class BaseApplication extends Application {

    protected LogTool log = new LogTool(getClassTag());

    protected abstract String getClassTag();

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
        initServer();
    }

    protected abstract void initData();

    protected abstract void initServer();


}
