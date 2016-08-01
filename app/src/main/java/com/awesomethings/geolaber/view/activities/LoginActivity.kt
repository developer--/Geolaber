package com.awesomethings.geolaber.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.awesomethings.geolaber.R
import com.awesomethings.geolaber.interfaces.login.ILoginView
import com.awesomethings.geolaber.presenter.LoginPresenter
import com.facebook.CallbackManager
import com.facebook.FacebookSdk

class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var callbackManager : CallbackManager
    private lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        presenter = LoginPresenter(this)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        callbackManager = com.facebook.CallbackManager.Factory.create()
        presenter.loginToFacebook(callbackManager,this)
    }


    override fun navigateToMainActivity() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailed() {
        Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

}
