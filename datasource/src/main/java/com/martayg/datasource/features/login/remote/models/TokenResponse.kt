package com.martayg.datasource.features.login.remote.models

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access_token") val accessToken: String,
)
