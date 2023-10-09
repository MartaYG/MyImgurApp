package com.martayg.myimgurapp.ui.features.login.viewmodels

import androidx.lifecycle.ViewModel
import com.martayg.domain.interactors.features.login.AuthenticateUseCase
import androidx.lifecycle.viewModelScope
import com.martayg.myimgurapp.ui.features.login.state.LoginResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
): ViewModel(){

    private val _loadingState by lazy { MutableStateFlow<LoginResourceState<*>>(LoginResourceState.Idle) }
    val loadingState: StateFlow<LoginResourceState<*>> get() = _loadingState

    fun authenticate(username: String, password: String){
        _loadingState.update { LoginResourceState.Loading }
        viewModelScope.launch(Dispatchers.IO) {

            authenticateUseCase(username = username, password = password)
                .catch { error ->
                    _loadingState.update { LoginResourceState.Error(error) }
                }
                .collectLatest { result ->
                    _loadingState.update {
                        if(result){
                            LoginResourceState.Success
                        }else{
                            LoginResourceState.Error(IllegalAccessException("Unauthorized"))
                        }
                    }
                }
        }
    }
}