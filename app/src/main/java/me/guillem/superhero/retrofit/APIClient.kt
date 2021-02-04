package me.guillem.superhero.retrofit.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 ** Created by Guillem on 04/02/21.
 */
class ApiClient {
    companion object {
        private const val REQUEST_TIMEOUT = 30
        private const val BASE_URL = "https://www.superheroapi.com/api.php/3967874703275099"
        private var retrofit: Retrofit? = null
        private var okHttpClient: OkHttpClient? = null

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(Companion.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }


}