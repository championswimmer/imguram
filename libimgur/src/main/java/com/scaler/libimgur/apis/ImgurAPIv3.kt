package com.scaler.libimgur.apis

import com.scaler.libimgur.models.GalleryResponse
import com.scaler.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {

    @GET("gallery/hot?album_previews=true") // TODO: use path params
    fun getGallery() : Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>
}