package me.leig.androidapplication.settings

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.leig.androidapplication.R
import me.leig.androidapplication.settings.adapter.SettingsAdapter
import me.leig.androidapplication.settings.adapter.SettingsData
import me.leig.baselibrary.fragment.BaseFragment

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class SettingsFragment: BaseFragment() {

    private val dataList = mutableListOf<SettingsData>()

    override fun getClassTag(): String {
        return SettingsFragment::class.java.name
    }

    override fun getFragmentId(): Int {
        return R.layout.fragment_settings
    }

    override fun initData() {
        val text = arguments.getString("TEXT")
        dataList.add(SettingsData(text))
    }

    override fun initView() {
        val mRecyclerView = getView(R.id.rv_list) as RecyclerView
        val sa = SettingsAdapter(activity, dataList)
        mRecyclerView.adapter = sa
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
    }

}