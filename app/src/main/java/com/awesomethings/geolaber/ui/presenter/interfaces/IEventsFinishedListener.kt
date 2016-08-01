package com.awesomethings.geolaber.ui.presenter.interfaces

import com.awesomethings.geolaber.models.EventModel

/**
 * Created by Jemo on 8/1/16.
 */
interface IEventsFinishedListener {
    fun onSuccess(list: MutableList<EventModel>)
    fun onError(error: String)
}