package com.martayg.datasource.remote.service.interceptors

import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sharedPreferences: SharedPreferencesManager
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPreferences.authToken
        val request:Request = chain.request()

        return if(token.isNotEmpty()){
            val authorizedRequest = request
                .newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(authorizedRequest)
        }else{
            chain.proceed(request)
        }
    }
}