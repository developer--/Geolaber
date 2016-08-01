package com.awesomethings.geolaber.interfaces

import com.awesomethings.geolaber.models.EventModel

/**
 * Created by Jemo on 8/1/16.
 */
interface ParseFinishedListener {
    fun onFinish(list : MutableList<EventModel>)
}