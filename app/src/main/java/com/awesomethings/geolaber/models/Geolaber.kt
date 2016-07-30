package com.awesomethings.geolaber.models

import com.awesomethings.geolaber.util.enums.JobTypeEnum

/**
 * Created by Master on 7/30/16.
 */
open class Geolaber(
        val name : String,
        val lastName : String,
        val phoneNumber : String,
        val imageUrl : String,
        val jobType : String,
        val age : Int
)