package com.awesomethings.geolaber.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.bindView
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.models.database.DummyData
import com.awesomethings.geolaber.ui.base.BaseFragment
import com.awesomethings.geolaber.util.adapters.MyResyclerAdapter
import java.util.*

/**
 * Created by Jemo on 7/30/16.
 */
class MainPageFragment : BaseFragment() {

//    val listView : RecyclerView by bindView(R.id.main_page_fragment_recycler_list_view_id)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = View.inflate(context, R.layout.main_page_fragment,container)
        ButterKnife.bind(this,fragmentView)

        val listView = fragmentView.findViewById(R.id.main_page_fragment_recycler_list_view_id) as RecyclerView
        val mAdapter = MyResyclerAdapter(getGeolabers())
        listView.layoutManager = LinearLayoutManager(context)
        listView.adapter = mAdapter
//        initListView()

        return fragmentView
    }



//    fun initListView(){
//        val mAdapter = MyResyclerAdapter(getGeolabers())
//        listView.layoutManager = LinearLayoutManager(context)
//        listView.adapter = mAdapter
//    }

    fun getGeolabers(): List<Geolaber> {
        val labers = ArrayList<Geolaber>()
        for (i in DummyData.NAMES.indices) {
            val geolaber = Geolaber()
            geolaber.name = DummyData.NAMES[i]
            geolaber.jobType = DummyData.JOB_TYPES[i]

            labers.add(geolaber)
        }
        return labers
    }
}