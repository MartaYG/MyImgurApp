package com.martayg.datasource.features.login.remote.api

import com.martayg.datasource.BuildConfig
import com.martayg.datasource.features.login.remote.models.TokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("oauth2/token")
    suspend fun requestToken(
        @Field("username") username:String = "",
        @Field("password") password: String = "",
        @Field("grant_type") grantType: String = "password",
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET
    ): Response<TokenResponse>
}

