package me.leig.androidapplication.settings.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.leig.androidapplication.R

/**
 *
 *
 * @author leig
 * @version 20180301
 *
 */

open class SettingsViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    open val textView = itemView.findViewById<TextView>(R.id.tv_title)!!

}