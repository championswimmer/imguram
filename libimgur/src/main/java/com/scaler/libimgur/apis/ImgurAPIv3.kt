package com.scaler.libimgur.apis

import com.scaler.libimgur.models.GalleryResponse
import com.scaler.libimgur.models.TagResponse
import com.scaler.libimgur.models.TagsResponse
import com.scaler.libimgur.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {

    @GET("gallery/{section}") // TODO: use path params
    suspend fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag: String
    ): Response<TagResponse>
}