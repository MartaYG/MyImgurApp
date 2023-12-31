package com.martayg.data.repository.features.login.interfaz

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun authenticate(username:String, password: String): Flow<Boolean>
}