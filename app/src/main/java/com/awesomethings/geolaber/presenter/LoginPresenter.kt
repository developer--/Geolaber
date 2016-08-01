package com.awesomethings.geolaber.presenter

import android.app.Activity
import com.awesomethings.geolaber.interfaces.login_page.ILoginView
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

/**
 * Created by Jemo on 8/1/16.
 */
class LoginPresenter  {
    lateinit var loginView : ILoginView

    constructor(loginView : ILoginView) {
        this.loginView = loginView
    }

    fun loginToFacebook(callbackManager : CallbackManager, mActivity : Activity) {
        try {
            LoginManager.getInstance().logInWithReadPermissions(mActivity, Collections.singletonList("public_profile"))
            LoginManager.getInstance().registerCallback(callbackManager,
                    object : FacebookCallback<LoginResult> {
                        override fun onSuccess(loginResult: LoginResult) {
                            loginView.navigateToMainActivity()
                        }
                        override fun onCancel() {
                            loginView.loginFailed()
                        }
                        override fun onError(exception: FacebookException) {
                            loginView.loginFailed()
                        }
                    })
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}