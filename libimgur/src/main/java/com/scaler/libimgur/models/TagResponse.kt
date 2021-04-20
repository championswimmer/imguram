package com.scaler.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagResponse(
    @Json(name = "data")
    val `data`: Tag?,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "success")
    val success: Boolean?
)