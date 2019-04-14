package com.example.beetlestance.benji.di.modules.networkModule

import android.content.Context
import androidx.annotation.NonNull
import com.example.beetlestance.benji.constant.Constant
import com.example.beetlestance.benji.constant.Constant.BASE_URL
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.constant.Constant.CACHE_CONTROL
import com.example.beetlestance.benji.constant.Constant.IS_ONLINE
import com.example.beetlestance.benji.di.modules.AppModule
import com.example.beetlestance.benji.data.RetrofitApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
/**
 * Defines all the network classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like [retrofitInstanceProvider].
 * If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@Module(includes = [AppModule::class, ConnectionCheckModule::class])
class NetworkModule : Interceptor {

    private var isOnline: Boolean = false
    private lateinit var context: Context
    /**
     * Single instance is created of Retrofit RetrofitApiService through out the Application
     */

    @Singleton
    @Provides
    fun retrofitInstanceProvider(@Named(APPLICATION_CONTEXT) context: Context,
                                 @Named(IS_ONLINE) isOnline: Boolean): RetrofitApiService {
        this.isOnline = isOnline
        this.context = context
        return retrofitProvider().create(RetrofitApiService::class.java)
    }

    @Singleton
    private fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient())
            .build()

    }

    /*
    * Provides Cache mechanism for retrofit
    */
    private fun okHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(provideHttpLoggingInterceptor())
            .addInterceptor(provideOfflineCacheInterceptor())
            .addNetworkInterceptor(provideCacheInterceptor())
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .cache(provideCache())
            .build()
    }

    /*
    * Provides Http Logs.
    */

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor {}
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }

    /*
    * Check for whether cache is provide or not for current request
    */
    private fun provideOfflineCacheInterceptor() =
        Interceptor { chain ->
            var request = chain.request()
            request = if (isOnline) {
                val cacheControl = CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build()
                request.newBuilder().cacheControl(cacheControl).build()
            } else {
                val cacheHeaderValue = if (isOnline)
                    "public, max-age=2419200"       // if online check for cache is expired or not if not provide from cache else make network request
                else
                    "public, only-if-cached, max-stale=2419200" // only-if-cached now no network request will be made response will be provided only from cache.
                request.newBuilder().header("Cache-Control", cacheHeaderValue)
                    .build()
            }
            chain.proceed(request)
        }

    private fun provideCacheInterceptor() = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        val cacheControl = CacheControl.Builder().maxStale(2, TimeUnit.DAYS).build()

        response.newBuilder().removeHeader("Pragma").header(CACHE_CONTROL, cacheControl.toString()).build() // remove header pragma in case http header contains value no-cache
    }

    /*
    * Store cache in local storage
    * */
    private fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(File(context.cacheDir, "http-cache"), (10 * 1024 * 1024).toLong())

        } catch (e: Exception) {
            println("Error " + e.message)
        }
        return cache
    }

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        if (!isOnline) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}
