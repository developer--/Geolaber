package com.awesomethings.geolaber.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.view.base.BaseFragment

/**
 * Created by Jemo on 8/3/16.
 */
class CourseListFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater?.inflate(R.layout.course_list_fragment,container,false)

        return fragmentView
    }

    override fun getTitle(): String {
        return "შკურსები"
    }
}