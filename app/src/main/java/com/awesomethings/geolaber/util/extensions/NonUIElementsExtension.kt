package com.awesomethings.geolaber.util.extensions

/**
 * Created by Jemo on 8/1/16.
 */
fun String.showOneParagraph() : String{
    val finalString = StringBuilder()
    for (i in this.indices) {
        if (this[i].equals('\n'))
            return finalString.toString()
        finalString.append(this[i])
    }
    return finalString.toString()
}