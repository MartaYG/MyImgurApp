package com.martayg.datasource.features.gallery.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteSingleImage(
    @SerializedName("id") val imageId: String,
    @SerializedName("link") val link: String,
    @SerializedName("account_url") val username: String
)
