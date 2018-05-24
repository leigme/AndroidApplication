package me.leig.androidapplication

import me.leig.baselibrary.application.BaseApplication

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class App: BaseApplication() {

    override fun getClassTag(): String {
        return App::class.java.name
    }

    override fun initData() {
        log.i("初始化数据...")
    }

    override fun initServer() {
        log.i("初始化服务...")
    }

}