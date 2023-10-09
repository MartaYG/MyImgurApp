package com.martayg.datasource.features.login.interfaces

import kotlinx.coroutines.flow.Flow

interface LoginDataSource {
    suspend fun authenticate(username:String, password: String): Flow<Boolean>
}