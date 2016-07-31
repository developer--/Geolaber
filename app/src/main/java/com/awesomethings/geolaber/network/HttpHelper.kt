package com.awesomethings.geolaber.network

/**
 * Created by Master on 7/31/16.
 */
class HttpHelper private constructor(){
    lateinit var instance : HttpHelper
    private object Holder { val INSTANCE = HttpHelper() }

    companion object {
        val instance: HttpHelper by lazy { Holder.INSTANCE }
    }



}