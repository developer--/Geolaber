package com.awesomethings.geolaber.ui.presenter.interfaces

import com.awesomethings.geolaber.models.EventModel

/**
 * Created by Jemo on 8/1/16.
 */
interface IEventListView {
    fun onEventsLoadedSuccess(eventsList : MutableList<EventModel>)
    fun onEventsLoadedFailure(errorMsg : String)
}