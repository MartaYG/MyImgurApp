package com.martayg.myimgurapp.ui.navigation.state

sealed class ScreensRoute(val route:String) {
    object LoginScreen: ScreensRoute("login_screen")
    object GalleryScreen: ScreensRoute("gallery_screen")
}