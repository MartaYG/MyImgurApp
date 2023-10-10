package com.martayg.data.repository.features.login.impl

import com.martayg.data.repository.features.login.interfaz.LoginRepository
import com.martayg.datasource.features.login.interfaces.LoginDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
): LoginRepository{
    override suspend fun authenticate(username: String, password: String): Flow<Boolean> = channelFlow {
        loginDataSource.authenticate(username = username, password = password).collectLatest{ isAuthenticate ->
            send(isAuthenticate)
        }
    }
}