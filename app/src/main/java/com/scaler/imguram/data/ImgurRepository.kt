package com.scaler.imguram.data

import com.scaler.libimgur.ImgurClient
import com.scaler.libimgur.models.Image
import com.scaler.libimgur.params.Section

class ImgurRepository {
    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>? { // TODO: return a proper error object if null
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }
}