package com.martayg.datasource.features.gallery.remote.api

import com.martayg.datasource.features.gallery.remote.models.RemoteImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GalleryService {
    @GET("/3/account/{username}/images/{page}.json")
    suspend fun getAllImages(
        @Path("username") username:String,
        @Path("page") page:Int,
        @Query("perPage") perPage:Int
    ): Response<RemoteImages>
}