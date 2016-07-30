package com.awesomethings.geolaber.util.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.awesomethings.geolaber.ui.base.BaseFragment

/**
 * Created by Master on 7/30/16.
 */
class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var fragments : List<BaseFragment> = null!!

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}