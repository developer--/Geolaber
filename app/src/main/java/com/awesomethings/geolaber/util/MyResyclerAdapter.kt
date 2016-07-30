package com.awesomethings.geolaber.util.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.Bind
import butterknife.ButterKnife
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.ui.custom.CTextView
import com.awesomethings.geolaber.util.extensions.setImage

/**
 * Created by Jemo on 7/30/16.
 */
open class MyResyclerAdapter (var myData: List<Geolaber>) : RecyclerView.Adapter<MyResyclerAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder? {
        val itemView = View.inflate(parent!!.context, R.layout.geolaber_list_item,parent)
        return MyHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyResyclerAdapter.MyHolder?, position: Int) {
        holder?.geolaber = myData[position]
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var geolaber : Geolaber = null!!
        @Bind(R.id.list_item_geolaber_name_text_view_id) var holderNameTextView: CTextView
        @Bind(R.id.list_item_geolaber_profile_pic_image_view_id) var holderImageView: ImageView
        @Bind(R.id.list_item_geolaber_job_type_text_view_id) var holderJobTypeTextView : CTextView

        init {
            ButterKnife.bind(this,itemView)
            holderNameTextView.text = geolaber.name + " " + geolaber.lastName
            holderImageView.setImage(geolaber.imageUrl)
            holderJobTypeTextView.text = geolaber.jobType
        }

    }

}