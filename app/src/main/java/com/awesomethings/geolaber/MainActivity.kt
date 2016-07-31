package com.awesomethings.geolaber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
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
        initDrawerLayout();
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

    private fun initDrawerLayout() {
        val mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout_id, toolbar_id, R.string.drawer_open, R.string.drawer_close)
        mDrawerLayout_id.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerOpened(drawerView: View) {
            }

            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerStateChanged(newState: Int) {

            }
        })
        mDrawerToggle.syncState()

    }


}
