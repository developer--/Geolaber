package com.awesomethings.geolaber.view.custom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.awesomethings.geolaber.R

/**
 * Created by Jemo on 7/30/16.
 */
class CTextView : TextView {

    var fontNumberPosition : Int = 0

    constructor(context: Context?, attributes: AttributeSet) : super(context, attributes) {
        val attrs : TypedArray = context?.theme?.obtainStyledAttributes(attributes, R.styleable.CTextView,0,0)!!
        fontNumberPosition = attrs.getInt(R.styleable.CTextView_font_name,0)
        typeface = getFont(fontNumberPosition)
    }

    private fun getFont(fontTypeNumber: Int) : Typeface?{
        try {
            when (fontTypeNumber) {
                1 -> return Typeface.createFromAsset(context.assets, "BPG_GEL_Excelsior_Caps.ttf")
                2 -> return Typeface.createFromAsset(context.assets, "BPG_GEL_Excelsior.ttf")
                else -> return Typeface.createFromAsset(context.assets, "BPG_GEL_Excelsior.ttf")
            }
        }catch ( e: Exception){
            e.printStackTrace();
        }
        return null
    }


}