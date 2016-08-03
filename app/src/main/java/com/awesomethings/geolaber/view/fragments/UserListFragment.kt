package com.awesomethings.geolaber.view.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.models.database.DummyData
import com.awesomethings.geolaber.view.activities.DetailPageActivity
import com.awesomethings.geolaber.view.base.BaseFragment
import com.awesomethings.geolaber.util.adapters.GeolaberListAdapter
import kotlinx.android.synthetic.main.main_page_fragment.*
import java.util.*

/**
 * Created by Jemo on 7/30/16.
 */
class UserListFragment : BaseFragment(), GeolaberListAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = inflater?.inflate(R.layout.main_page_fragment,container,false)
        return fragmentView!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListView()
    }

    private lateinit var mAdapterGeolaberList: GeolaberListAdapter
    fun initListView(){
        mAdapterGeolaberList = GeolaberListAdapter(getGeolabers())
        listView_Id.layoutManager = LinearLayoutManager(context)
        listView_Id.adapter = mAdapterGeolaberList
        mAdapterGeolaberList.setItemClickListener(this)
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

            geolaber.gallery.add(geolaber.imageUrl)
            for (j in DummyData.GALLERY[i].indices) {
                geolaber.gallery.add(DummyData.GALLERY[i][j])
            }
            labers.add(geolaber)
        }
        return labers
    }

    /**
     * item click listener callback
     */
    override fun onItemClick(item: Geolaber) {
        val intent = Intent(context,DetailPageActivity::class.java)
        intent.putExtra("clickedItem",item)
        startActivity(intent)
    }

    /**
     * returns the page title
     */
    override fun getTitle(): String {
        return "შმასტავი"
    }

}