package com.example.beetlestance.benji.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.beetlestance.benji.MainActivity
import com.example.beetlestance.benji.R
import com.example.beetlestance.benji.constant.Constant.RC_SIGN_IN
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : DaggerAppCompatActivity() {

    companion object {
        const val TAG = "LoginActivity"
    }

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var auth: FirebaseAuth
    private lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this@LoginActivity).get(LoginActivityViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        setupGoogleSignIn()
    }

    private fun setupGoogleSignIn() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        sign_in_button.setSize(SignInButton.SIZE_STANDARD)
        sign_in_button.setColorScheme(SignInButton.COLOR_LIGHT)
        sign_in_button.setOnClickListener { signIn() }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startMainActivity()
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
            // Google Sign In was successful, authenticate with Firebase
            val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success")
                        val bundle = Bundle()
                        bundle.putString("newLogin", auth.currentUser!!.email)
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, Bundle())
                        startMainActivity()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        Snackbar.make(login_view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                    }
                }
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            Log.w("Login Activity", "signInResult:failed code=" + e.statusCode)
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
        finish()
    }
}
