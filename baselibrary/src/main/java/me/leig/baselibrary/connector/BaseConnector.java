package me.leig.baselibrary.connector;

import android.view.View;

/**
 * @author leig
 * @version 20180301
 */
public interface BaseConnector {

    String getClassTag();

    void initData();

    void initView();

    void initEvent();

    View getView(int viewId);
}
