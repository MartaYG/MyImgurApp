package com.martayg.datasource.features.gallery.remote.models

import com.google.gson.annotations.SerializedName

data class RemoteImages(
    @SerializedName("data") val dataImages: List<RemoteSingleImage>
)