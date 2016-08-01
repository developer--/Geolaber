package com.awesomethings.geolaber.view.base

import android.support.v4.app.Fragment

/**
 * Created by Master on 7/30/16.
 */
abstract class BaseFragment : Fragment() {
    abstract fun getTitle(): String
}