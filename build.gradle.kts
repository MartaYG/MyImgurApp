buildscript {
    extra["compose_ui_version"] = "1.3.3"
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

allprojects {
    extra["androidApplicationId"] = "com.martayg.myimgurapp"
    extra["androidVersionCode"] = 1
    extra["androidVersionName"] = "1.0"
    extra["androidMinSdkVersion"] = 24
    extra["androidTargetSdkVersion"] = 33
    extra["androidCompileSdkVersion"] = 33
}