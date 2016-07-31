package com.awesomethings.geolaber.models

import java.io.Serializable

/**
 * Created by Master on 7/30/16.
 */
open class Geolaber : Serializable {
    var name : String = ""
    var phoneNumber : String = ""
    var imageUrl : String = ""
    var age : Int = 0
    var gallery = mutableListOf<String>()
    var jobType : String = ""
}
