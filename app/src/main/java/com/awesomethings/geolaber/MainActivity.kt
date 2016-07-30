package com.awesomethings.geolaber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import butterknife.Bind
import butterknife.ButterKnife
import com.awesomethings.geolaber.presenter.MainPagePresenter
import com.awesomethings.geolaber.util.adapters.MyPagerAdapter

class MainActivity : AppCompatActivity() {
    @Bind(R.id.main_view_pager_id) val mViewPager : ViewPager = null!!

    private var mPresenter : MainPagePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        mPresenter = MainPagePresenter()
        initPager()
    }

    fun initPager(){
        val mAdapter = MyPagerAdapter(supportFragmentManager)
        mViewPager.adapter = mAdapter
    }



}
