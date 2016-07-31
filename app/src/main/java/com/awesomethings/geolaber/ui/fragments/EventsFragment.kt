package com.awesomethings.geolaber.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.ui.base.BaseFragment
import com.facebook.AccessToken
import com.facebook.GraphRequest
import kotlinx.android.synthetic.main.events_fragment.*

/**
 * Created by Jemo on 7/31/16.
 */
class EventsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView = inflater?.inflate(R.layout.events_fragment,container,false)
        getEvents()
        return fragmentView!!
    }

    override fun getTitle(): String {
        return "შმივენთები"
    }

    fun getEvents(){
        val request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/1458720214418272"
        ) { response ->
            events_tmp_text_view_id.text = response.toString()
        }
        val parameters = Bundle()
        parameters.putString("fields", "events")
        request.parameters = parameters
        request.executeAsync()
    }

}