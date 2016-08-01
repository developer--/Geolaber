package com.awesomethings.geolaber.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.models.Geolaber
import com.awesomethings.geolaber.util.adapters.ImageSliderAdapter
import kotlinx.android.synthetic.main.activity_detail_page.*

class DetailPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        setUpUI(intent.getSerializableExtra("clickedItem") as Geolaber)
    }

    fun setUpUI(geolaber: Geolaber){
        geolaberNameTextView_Id.text = geolaber.name
        val sliderAdapter = ImageSliderAdapter(geolaber.gallery)
        sliderViewPager_Id.adapter = sliderAdapter
    }

}
