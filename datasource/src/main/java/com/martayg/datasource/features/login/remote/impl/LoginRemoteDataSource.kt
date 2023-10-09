package com.martayg.datasource.features.login.remote.impl

import com.martayg.datasource.features.login.interfaces.LoginDataSource
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import com.martayg.datasource.features.login.remote.api.LoginService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(
    private val loginService: LoginService,
    private val sharedPreferencesManager: SharedPreferencesManager
):LoginDataSource{
    override suspend fun authenticate(username: String, password: String): Flow<Boolean> = flow {
       val loginResponse = loginService.requestToken(username = username, password = password)
        if(loginResponse.isSuccessful){
            loginResponse.body()?.let { tokenResponse ->
                sharedPreferencesManager.authToken = tokenResponse.accessToken
            }
            emit(true)
        }else{
            emit(false)
        }
    }
}