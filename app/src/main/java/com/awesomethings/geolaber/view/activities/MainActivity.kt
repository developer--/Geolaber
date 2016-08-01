package com.awesomethings.geolaber.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.util.adapters.MyFragmentPagerAdapter
import com.awesomethings.geolaber.view.fragments.EventsFragment
import com.awesomethings.geolaber.view.fragments.MainPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUI()
    }

    fun setUpUI(){
        initPager()
        initToolbar()
    }

    fun initToolbar(){
        setSupportActionBar(toolbar_id)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    fun initPager(){
        val mAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        mAdapter.addFragment(MainPageFragment())
        mAdapter.addFragment(EventsFragment())
        main_view_pager_id.adapter = mAdapter
        tab_layout_id.setupWithViewPager(main_view_pager_id)
    }



}
