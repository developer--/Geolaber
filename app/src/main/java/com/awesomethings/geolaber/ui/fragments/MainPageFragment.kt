package com.awesomethings.geolaber.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.models.database.DummyData
import com.awesomethings.geolaber.ui.base.BaseFragment
import com.awesomethings.geolaber.util.adapters.MyRecyclerAdapter
import kotlinx.android.synthetic.main.main_page_fragment.*
import java.util.*

/**
 * Created by Jemo on 7/30/16.
 */
class MainPageFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = inflater?.inflate(R.layout.main_page_fragment,container,false)
        return fragmentView!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListView()
    }


    private lateinit var mAdapter : MyRecyclerAdapter
    fun initListView(){
        mAdapter = MyRecyclerAdapter(getGeolabers())
        listView.layoutManager = LinearLayoutManager(context)
        listView.adapter = mAdapter
        setItemClickListener()
    }

    fun setItemClickListener() {
        mAdapter.setItemClickListener(object : MyRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(item: Geolaber) {
                Toast.makeText(context,item.name,Toast.LENGTH_SHORT).show()
            }
        })
    }

    /**
     * returns list of geolabers
     */
    fun getGeolabers() : List<Geolaber> {
        val labers = ArrayList<Geolaber>()
        for (i in DummyData.NAMES.indices) {
            val geolaber = Geolaber()
            geolaber.name = DummyData.NAMES[i]
            geolaber.jobType = DummyData.JOB_TYPES[i]
            geolaber.imageUrl = DummyData.PROFILE_PICTURES[i]
            labers.add(geolaber)
        }
        return labers
    }

    /**
     * returns the page title
     */
    override fun getTitle(): String {
        return "შმასტავი"
    }

}