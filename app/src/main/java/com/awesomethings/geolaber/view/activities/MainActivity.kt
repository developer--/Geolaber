package com.awesomethings.geolaber.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.util.adapters.MyFragmentPagerAdapter
import com.awesomethings.geolaber.view.fragments.CourseListFragment
import com.awesomethings.geolaber.view.fragments.EventListFragment
import com.awesomethings.geolaber.view.fragments.UserListFragment
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
        mAdapter.addFragment(UserListFragment())
        mAdapter.addFragment(EventListFragment())
        mAdapter.addFragment(CourseListFragment())
        main_view_pager_id.adapter = mAdapter
        tab_layout_id.setupWithViewPager(main_view_pager_id)
    }

    override fun onBackPressed() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }

}
