package com.awesomethings.geolaber.util.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.EventModel
import com.awesomethings.geolaber.util.extensions.showOneParagraph
import com.awesomethings.geolaber.view.custom.CTextView

/**
 * Created by Master on 7/31/16.
 */
class EventListAdapter(val myData: List<EventModel>) : RecyclerView.Adapter<EventListAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder? {
        val itemView = View.inflate(parent!!.context, R.layout.events_list_item, null)
        return MyHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: EventListAdapter.MyHolder?, position: Int) {
        holder?.eventModel = myData[position]
        holder?.bind(holder.eventModel )
    }

    inner class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var eventModel = EventModel()
        val cardView : CardView by bindView(R.id.events_list_item_cardview_id)
        val holderNameTextView: CTextView by bindView(R.id.event_item_name_text_view_id)
        val holderDescription: CTextView by bindView(R.id.eventDescriptionTextView_ID)
        val startTime: CTextView by bindView(R.id.eventStartTimeTextView_ID)

        fun bind(eventModel: EventModel){
            this.eventModel = EventModel()
            holderNameTextView.text = eventModel.name
            startTime.text = eventModel.startTime
            holderDescription.text = eventModel.description.showOneParagraph()

            cardView.setOnClickListener {
                itemClickListener.onItemClick(eventModel)
            }
        }

    }

    private lateinit var itemClickListener : OnItemClickListener
    companion object fun setItemClickListener(listener:OnItemClickListener) {
        this.itemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(item: EventModel)
    }
}