package com.scaler.libimgur.apis

import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Tests {

    private val client = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID 16abb74c6e5c7e8")
                .build()
            it.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()
    private val api = retrofit.create(ImgurAPIv3::class.java)

    @Test
    fun `get tags working`() {

        val response = api.getTags().execute()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries working`() {
        val response = api.getGallery().execute()
        assertNotNull(response.body())
    }

}