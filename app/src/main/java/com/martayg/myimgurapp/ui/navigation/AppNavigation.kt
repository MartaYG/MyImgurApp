package com.martayg.myimgurapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.martayg.myimgurapp.ui.features.gallery.screen.GalleryScreen
import com.martayg.myimgurapp.ui.features.gallery.viewmodels.GalleryViewModel
import com.martayg.myimgurapp.ui.features.login.screen.LoginScreen
import com.martayg.myimgurapp.ui.features.login.viewmodels.LoginViewModel
import com.martayg.myimgurapp.ui.navigation.state.ScreensRoute

@Composable
fun AppNavigation(loginViewModel: LoginViewModel, galleryViewModel: GalleryViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreensRoute.LoginScreen.route){
        composable(route=ScreensRoute.LoginScreen.route){
            LoginScreen(loginViewModel = loginViewModel, navController = navController)
        }
        composable(route=ScreensRoute.GalleryScreen.route){
            GalleryScreen(galleryViewModel=galleryViewModel,navController = navController)
        }
    }
}