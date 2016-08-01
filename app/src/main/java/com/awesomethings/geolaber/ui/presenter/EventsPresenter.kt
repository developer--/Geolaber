package com.awesomethings.geolaber.ui.presenter

import com.awesomethings.geolaber.models.EventModel
import com.awesomethings.geolaber.ui.presenter.interactors.EventListInteractor
import com.awesomethings.geolaber.ui.presenter.interfaces.IEventListView
import com.awesomethings.geolaber.ui.presenter.interfaces.IEventsListViewPresenter
import com.awesomethings.geolaber.ui.presenter.interfaces.IEventsFinishedListener

/**
 * Created by Jemo on 8/1/16.
 */
class EventsPresenter  : IEventsListViewPresenter, IEventsFinishedListener {
    private lateinit var view: IEventListView
    private lateinit var interactor : EventListInteractor

    constructor(listView : IEventListView) {
        this.view = listView
        this.interactor = EventListInteractor(this)
    }

    override fun loadEvents(pageId : String) {
        interactor.getPageEventsByID(pageId)
    }

    override fun onSuccess(list: MutableList<EventModel>) {
        view.onEventsLoadedSuccess(list)
    }

    override fun onError(error: String) {
        view.onEventsLoadedFailure(error)
    }
}