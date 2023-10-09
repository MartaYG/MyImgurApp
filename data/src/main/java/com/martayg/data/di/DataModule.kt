package com.martayg.data.di

import com.martayg.data.repository.feature.login.impl.LoginRepositoryImpl
import com.martayg.data.repository.feature.login.interfaz.LoginRepository
import com.martayg.datasource.features.login.interfaces.LoginDataSource
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.datasource.features.login.remote.api.LoginService
import com.martayg.datasource.features.login.remote.impl.LoginRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesLoginRemoteDataSource(loginService: LoginService, sharedPreferencesManager: SharedPreferencesManager): LoginDataSource =
        LoginRemoteDataSource(loginService,sharedPreferencesManager)

    @Provides
    fun providesLoginRepository(loginDataSource: LoginDataSource): LoginRepository =
        LoginRepositoryImpl(loginDataSource)
}