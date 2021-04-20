package com.scaler.libimgur

import com.scaler.libimgur.apis.ImgurAPIv3
import com.scaler.libimgur.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {
    const val API_KEY = "16abb74c6e5c7e8" // TODO: ideally should be in app not in lib

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/")
            .build()
    }

    val api: ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}