package com.scaler.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagsResponse(
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "success")
    val success: Boolean
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "featured")
        val featured: Any?,
        @Json(name = "galleries")
        val galleries: List<Gallery>,
        @Json(name = "tags")
        val tags: List<Tag>
    )
}