package com.example.beetlestance.benji.di.modules.googleSignInModule

import android.content.Context
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.di.modules.AppModule
import com.google.android.gms.auth.api.signin.*
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppModule::class])
class GoogleSignInModule {

    @Provides
    fun googleSignInClient(@Named(APPLICATION_CONTEXT) context: Context): GoogleSignInClient {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(context, googleSignInOptions)
    }
}