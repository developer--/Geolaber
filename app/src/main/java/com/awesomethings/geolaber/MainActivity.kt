package com.awesomethings.geolaber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import butterknife.bindView
import com.awesomethings.geolaber.ui.MainPageFragment
import com.awesomethings.geolaber.util.adapters.MyPagerAdapter

class MainActivity : AppCompatActivity() {

    val mViewPager : ViewPager by bindView(R.id.main_view_pager_id)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            initPager()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    fun initPager(){
        val mAdapter = MyPagerAdapter(supportFragmentManager)
        mAdapter.addFragment(getMainPageFragment())
        mViewPager.adapter = mAdapter
    }

    fun getMainPageFragment(): MainPageFragment {
            val mainPageFragment = MainPageFragment()
        return mainPageFragment
    }
}
