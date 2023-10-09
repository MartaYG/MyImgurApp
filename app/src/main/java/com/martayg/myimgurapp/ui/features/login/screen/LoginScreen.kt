package com.martayg.myimgurapp.ui.features.login.screen

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martayg.myimgurapp.ui.features.login.state.LoginResourceState
import com.martayg.myimgurapp.ui.features.login.viewmodels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val appContext = LocalContext.current
    val textColor = MaterialTheme.colorScheme.onSurface

    val loadingState by loginViewModel.loadingState.collectAsState()
    var hasPressedLoginButton by remember { mutableStateOf(false) }
    val username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val usernameText = username.value.text
    val passwordText = password.value.text

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black)
                    .height(60.dp),

                value = username.value,
                onValueChange = { newValue ->
                    username.value = newValue
                },
                textStyle = TextStyle(
                    color = textColor,
                    fontSize = 16.sp
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (username.value.text.isEmpty()) {
                            Text(
                                text = "usuario",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black)
                    .height(60.dp),

                value = password.value,
                onValueChange = { newValue ->
                    password.value = newValue
                },
                textStyle = TextStyle(
                    color = textColor,
                    fontSize = 16.sp
                ),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (password.value.text.isEmpty()) {
                            Text(
                                text = "contraseña",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .height(40.dp),
                onClick = {
                    hasPressedLoginButton = true
                    loginViewModel.authenticate(username = usernameText, password = passwordText)

                },
            ) {
                Text("Iniciar sesión")
            }

            if (hasPressedLoginButton) {
                when (loadingState) {
                    is LoginResourceState.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }

                    is LoginResourceState.Success -> {
                        Toast.makeText(appContext, "Autenticación exitosa", Toast.LENGTH_SHORT).show()
                        hasPressedLoginButton = false
                    }

                    is LoginResourceState.Error -> {
                        Toast.makeText(appContext, "Autenticación erronea", Toast.LENGTH_SHORT).show()
                        hasPressedLoginButton = false
                    }

                    else -> {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {}

