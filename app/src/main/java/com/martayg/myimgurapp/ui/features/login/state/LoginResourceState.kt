package com.martayg.myimgurapp.ui.features.login.state

sealed class LoginResourceState<T> {
    object Idle: LoginResourceState<Boolean>()
    object Loading: LoginResourceState<Boolean>()
    object Success: LoginResourceState<Boolean>()
    data class Error<Throwable>(val throwable: Throwable): LoginResourceState<Throwable>()
}