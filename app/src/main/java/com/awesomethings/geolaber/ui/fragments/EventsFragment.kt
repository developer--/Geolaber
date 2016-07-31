package com.awesomethings.geolaber.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.ui.base.BaseFragment

/**
 * Created by Jemo on 7/31/16.
 */
class EventsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = inflater?.inflate(R.layout.events_fragment,container,false)
        return fragmentView!!
    }

    override fun getTitle(): String {
        return "შმივენთები"
    }

}