package com.awesomethings.geolaber.util.parser

import android.os.AsyncTask
import com.awesomethings.geolaber.models.EventModel
import com.awesomethings.geolaber.ui.presenter.interfaces.ParseFinishedListener
import com.facebook.GraphResponse
import org.json.JSONObject

/**
 * Created by Jemo on 8/1/16.
 */
class EventsParser : AsyncTask<GraphResponse, Void, MutableList<EventModel>> {
    private lateinit var parseListener : ParseFinishedListener

    constructor( parseListener : ParseFinishedListener) {
        this.parseListener = parseListener
    }

    override fun doInBackground(vararg p0: GraphResponse?): MutableList<EventModel> {
        val list = mutableListOf<EventModel>()
        val jsonObject = p0[0]?.jsonObject
        try {
            val jsonArray = jsonObject?.getJSONObject("events")?.getJSONArray("data")
            for (i in (0..jsonArray?.length()?.minus(1)!!)) {
                val obj = jsonArray?.get(i) as JSONObject?
                val description = obj?.getString("description") as String
                val name = obj?.getString("name") as String
                var endTime : String = ""
                if (obj?.has("end_time")!!)
                    endTime = obj?.getString("end_time") as String
                val startTime = obj?.getString("start_time") as String

                val eventModel = EventModel()
                eventModel.description = description
                eventModel.name = name
                eventModel.startTime = startTime
                eventModel.endTime = endTime
                list.add(eventModel)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
        return list
    }

    override fun onPostExecute(result: MutableList<EventModel>?) {
        super.onPostExecute(result)
        parseListener.onFinish(result!!)
    }

}