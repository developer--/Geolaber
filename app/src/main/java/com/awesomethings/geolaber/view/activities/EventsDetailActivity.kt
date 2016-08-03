package com.awesomethings.geolaber.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.EventModel
import kotlinx.android.synthetic.main.activity_events_detail.*

class EventsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_detail)

        setUpUI(intent.getSerializableExtra("event_item") as EventModel)
    }

    fun setUpUI(eventModel: EventModel){
        eventNameTextView_ID.text = eventModel.name
        eventDescriptionTextView_ID.text = eventModel.description
        eventStartTimeTextView_ID.text = eventModel.startTime
    }
}
