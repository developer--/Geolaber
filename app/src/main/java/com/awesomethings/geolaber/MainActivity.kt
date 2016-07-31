package com.awesomethings.geolaber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.awesomethings.geolaber.ui.fragments.EventsFragment
import com.awesomethings.geolaber.ui.fragments.MainPageFragment
import com.awesomethings.geolaber.util.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPager()
        initToolbar()
    }

    fun initToolbar(){
        setSupportActionBar(toolbar_id)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    fun initPager(){
        val mAdapter = MyPagerAdapter(supportFragmentManager)
        mAdapter.addFragment(MainPageFragment())
        mAdapter.addFragment(EventsFragment())
        main_view_pager_id.adapter = mAdapter
        tab_layout_id.setupWithViewPager(main_view_pager_id)
    }


}
