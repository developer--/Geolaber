package com.awesomethings.geolaber.util.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import butterknife.bindView
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.ui.custom.CTextView
import com.awesomethings.geolaber.util.extensions.setImage

/**
 * Created by Jemo on 7/30/16.
 */
open class MyRecyclerAdapter(val myData: List<Geolaber>) : RecyclerView.Adapter<MyRecyclerAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder? {
        val itemView = View.inflate(parent!!.context, R.layout.geolaber_list_item, null)
        return MyHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyRecyclerAdapter.MyHolder?, position: Int) {
        holder?.geolaber = myData[position]
        holder?.bind(holder.geolaber )
    }

    inner class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var geolaber = Geolaber()
        val cardView : CardView by bindView(R.id.list_item_card_view_id)
        val holderNameTextView: CTextView by bindView(R.id.list_item_geolaber_name_text_view_id)
        val holderJobTypeTextView : CTextView by bindView(R.id.list_item_geolaber_job_type_text_view_id)
        val holderImageView: ImageView by bindView(R.id.list_item_geolaber_profile_pic_image_view_id)

        fun bind(geolaber: Geolaber){
            this.geolaber = geolaber
            holderNameTextView.text = geolaber.name
            holderJobTypeTextView.text = geolaber.jobType
            holderImageView.setImage(geolaber.imageUrl)

            cardView.setOnClickListener {
                itemClickListener.onItemClick(geolaber)
            }
        }



    }

    private var itemClickListener : OnItemClickListener = null!!
    companion object fun setItemClickListener(listener:OnItemClickListener) {
        this.itemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(item: Geolaber)
    }

}