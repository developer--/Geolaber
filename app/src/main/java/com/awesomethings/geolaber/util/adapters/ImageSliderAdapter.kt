package com.awesomethings.geolaber.util.adapters

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.util.extensions.inflate
import com.awesomethings.geolaber.util.extensions.setImage

/**
 * Created by Master on 7/31/16.
 */
class ImageSliderAdapter : PagerAdapter {
    private lateinit var listOfImages : MutableList<String>

    constructor(listOfImages: MutableList<String>) : super() {
        this.listOfImages = listOfImages
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val view = container!!.inflate(R.layout.slider_layout,false)
        val imageView : ImageView = view.findViewById(R.id.slider_geolaber_image_view_id) as ImageView
        imageView.setImage(listOfImages[position])
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return listOfImages.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container!!.removeView(`object` as LinearLayout?)
    }
}