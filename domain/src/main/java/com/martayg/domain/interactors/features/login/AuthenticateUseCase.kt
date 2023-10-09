package com.martayg.domain.interactors.features.login

import com.martayg.data.repository.feature.login.interfaz.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthenticateUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke(username: String, password: String): Flow<Boolean> =
        loginRepository.authenticate(username = username, password = password)
}