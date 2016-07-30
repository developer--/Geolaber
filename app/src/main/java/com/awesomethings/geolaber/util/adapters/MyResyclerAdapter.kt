package com.awesomethings.geolaber.util.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.awesomethings.geolaber.models.Geolaber

/**
 * Created by Master on 7/30/16.
 */
open class MyResyclerAdapter (var myData: List<Geolaber>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        throw Exception();
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }

}