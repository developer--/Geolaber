package com.awesomethings.geolaber.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.ui.base.BaseFragment

/**
 * Created by Master on 7/30/16.
 */
class MainPageFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = View.inflate(context, R.layout.main_page_fragment,container)
        return fragmentView
    }
}