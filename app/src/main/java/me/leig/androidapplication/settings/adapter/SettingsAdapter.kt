package me.leig.androidapplication.settings.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.leig.androidapplication.R

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

class SettingsAdapter constructor(private val context: Context, var dataList: List<SettingsData>): RecyclerView.Adapter<SettingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SettingsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_settings, parent, false)
        return SettingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SettingsViewHolder?, position: Int) {
        holder!!.textView.text = dataList[position].title
    }


}