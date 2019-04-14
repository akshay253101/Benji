package com.example.beetlestance.benji.ui.login

import android.os.Bundle
import android.view.View
import com.example.beetlestance.benji.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.SignInButton
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.constant.Constant
import com.example.beetlestance.benji.constant.Constant.RC_SIGN_IN
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class LoginActivity : DaggerAppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient
    @Inject
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sign_in_button.setSize(SignInButton.SIZE_STANDARD)
        sign_in_button.setColorScheme(SignInButton.COLOR_LIGHT)
        sign_in_button.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            startMainActivity()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.sign_in_button -> signIn()
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            editor.putString(Constant.CURRENT_USER, account!!.email).apply()
            startMainActivity()
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            Log.w("Login Activity", "signInResult:failed code=" + e.statusCode);
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
        finish()
    }
}
