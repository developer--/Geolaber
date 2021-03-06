package com.awesomethings.geolaber.util.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.awesomethings.geolaber.view.base.BaseFragment
import java.util.*

/**
 * Created by Jemo on 7/30/16.
 */
class MyFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    var fragments = Factory.create()

    companion object Factory {
        fun create(): ArrayList<BaseFragment> = ArrayList()
    }

    init {
        fragments = ArrayList()
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].getTitle();
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(baseFragment: BaseFragment){
        fragments.add(baseFragment)
    }

}