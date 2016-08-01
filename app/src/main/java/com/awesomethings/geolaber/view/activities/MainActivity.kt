package com.awesomethings.geolaber.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.view.fragments.EventsFragment
import com.awesomethings.geolaber.view.fragments.MainPageFragment
import com.awesomethings.geolaber.util.adapters.MyPagerAdapter
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_main)
        callbackManager = com.facebook.CallbackManager.Factory.create()
        loginToFacebook()
        setUpUI()
    }

    fun setUpUI(){
        initPager()
        initToolbar()
    }

    fun initToolbar(){
        setSupportActionBar(toolbar_id)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    fun initPager(){
        val mAdapter = MyPagerAdapter(supportFragmentManager)
        mAdapter.addFragment(MainPageFragment())
        mAdapter.addFragment(EventsFragment())
        main_view_pager_id.adapter = mAdapter
        tab_layout_id.setupWithViewPager(main_view_pager_id)
    }




    /**
     * facebook ლოგინი
     */
    private fun loginToFacebook() {

        try {
            LoginManager.getInstance().logInWithReadPermissions(this, Collections.singletonList("public_profile"))

            LoginManager.getInstance().registerCallback(callbackManager,
                    object : FacebookCallback<LoginResult> {

                        override fun onSuccess(loginResult: LoginResult) {

                            val profile = Profile.getCurrentProfile()
                            if (profile != null) {
                                Log.e("authoirization log", profile.name)
                            } else {
                                Log.e("authoirization log", "profile is null " + loginResult.accessToken)
                            }

                        }

                        override fun onCancel() {
                        }

                        override fun onError(exception: FacebookException) {
                            if (exception is FacebookAuthorizationException) {
                                if (AccessToken.getCurrentAccessToken() != null) {
                                    LoginManager.getInstance().logOut()
                                }
                            }
                            Log.e("authoirization log", exception.toString())
                        }
                    })
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    private lateinit var callbackManager : CallbackManager
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

}
