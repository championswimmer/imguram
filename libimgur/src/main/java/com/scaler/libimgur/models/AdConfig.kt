package com.scaler.libimgur.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class AdConfig(
    @Json(name = "highRiskFlags")
    val highRiskFlags: List<Any>,
    @Json(name = "safeFlags")
    val safeFlags: List<String>,
    @Json(name = "showsAds")
    val showsAds: Boolean?,
    @Json(name = "unsafeFlags")
    val unsafeFlags: List<String>,
    @Json(name = "wallUnsafeFlags")
    val wallUnsafeFlags: List<Any>
)
