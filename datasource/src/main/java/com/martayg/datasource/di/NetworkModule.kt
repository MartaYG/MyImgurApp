package com.martayg.datasource.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.martayg.datasource.BuildConfig
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.datasource.features.login.remote.api.LoginService
import com.martayg.datasource.features.login.settings.SharedPreferencesManagerImpl
import com.martayg.datasource.remote.service.interceptors.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return  OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesSharedPreferences(application: Application): SharedPreferences=
        application.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesSharedPreferencesManager(sharedPreferences: SharedPreferences): SharedPreferencesManager=
        SharedPreferencesManagerImpl(sharedPreferences)

    @Singleton
    @Provides
    fun providesLoginServiceClient(retrofit: Retrofit) : LoginService =
        retrofit.create(LoginService::class.java)
}