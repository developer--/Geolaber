package com.awesomethings.geolaber.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.EventModel
import com.awesomethings.geolaber.view.base.BaseFragment
import com.awesomethings.geolaber.presenter.EventsPresenter
import com.awesomethings.geolaber.interfaces.events.IEventListView
import com.awesomethings.geolaber.util.adapters.EventListAdapter
import kotlinx.android.synthetic.main.events_fragment.*

/**
 * Created by Jemo on 7/31/16.
 */
class EventsFragment : BaseFragment() , IEventListView {

    private lateinit var mAdapter : EventListAdapter
    private lateinit var presenter : EventsPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = inflater?.inflate(R.layout.events_fragment,container,false)
        presenter = EventsPresenter(this)
        return fragmentView!!
    }

    override fun onResume() {
        super.onResume()
        presenter.loadEvents("1458720214418272")
    }

    override fun onEventsLoadedSuccess(eventsList: MutableList<EventModel>) {
        mAdapter = EventListAdapter(eventsList)
        events_list_view_id.layoutManager = LinearLayoutManager(context)
        events_list_view_id.adapter = mAdapter
        mAdapter.setItemClickListener(object : EventListAdapter.OnItemClickListener {
            override fun onItemClick(item: EventModel) {

            }
        })
    }

    override fun onEventsLoadedFailure(errorMsg: String) {
        presenter.onError(errorMsg)
    }

    override fun getTitle(): String {
        return "შმივენთები"
    }

}