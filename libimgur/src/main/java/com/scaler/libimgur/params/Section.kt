package com.scaler.libimgur.params

import com.squareup.moshi.Json

enum class Section {
    @Json(name = "hot") HOT,
    @Json(name = "top") TOP,
}