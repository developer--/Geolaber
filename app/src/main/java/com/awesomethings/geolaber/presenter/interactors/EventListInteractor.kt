package com.awesomethings.geolaber.presenter.interactors

import android.os.Bundle
import com.awesomethings.geolaber.models.EventModel
import com.awesomethings.geolaber.interfaces.events_page.IEventsFinishedListener
import com.awesomethings.geolaber.interfaces.events_page.ParseFinishedListener
import com.awesomethings.geolaber.util.parser.EventsParser
import com.facebook.AccessToken
import com.facebook.GraphRequest

/**
 * Created by Jemo on 8/1/16.
 */
class EventListInteractor : ParseFinishedListener {

    private lateinit var listener : IEventsFinishedListener
    constructor(listener : IEventsFinishedListener){
        this.listener = listener
    }

    fun getPageEventsByID(pageId : String) {
        val request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + pageId
            ) {
                response ->
                EventsParser(this).execute(response)
            }
        val parameters = Bundle()
        parameters.putString("fields", "events")
        request.parameters = parameters
        request.executeAsync()
    }

    override fun onFinish(list : MutableList<EventModel>) {
        listener.onSuccess(list)
    }

}