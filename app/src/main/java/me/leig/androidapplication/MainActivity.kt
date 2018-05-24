package me.leig.androidapplication

import android.os.Bundle
import me.leig.androidapplication.settings.SettingsFragment
import me.leig.baselibrary.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun getClassTag(): String {
        return MainActivity::class.java.name
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val bundle = Bundle()
        bundle.putString("TEXT", stringFromJNI())
        val sf = SettingsFragment()
        sf.arguments = bundle
        addFragment(R.id.fl_container, sf)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
