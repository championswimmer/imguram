package com.scaler.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data")
    val `data`: List<Image>,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "success")
    val success: Boolean
)