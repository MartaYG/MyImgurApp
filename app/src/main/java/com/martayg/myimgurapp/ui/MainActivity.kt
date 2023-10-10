package com.martayg.myimgurapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.martayg.myimgurapp.ui.features.gallery.viewmodels.GalleryViewModel
import com.martayg.myimgurapp.ui.features.login.viewmodels.LoginViewModel
import com.martayg.myimgurapp.ui.navigation.AppNavigation
import com.martayg.myimgurapp.ui.theme.MyImgurAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val galleryViewModel: GalleryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyImgurAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(loginViewModel=loginViewModel,galleryViewModel=galleryViewModel)
                }
            }
        }
    }
}
