package com.martayg.datasource.features.login.settings

import android.content.SharedPreferences
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(
    private val preferences: SharedPreferences
): SharedPreferencesManager {

    companion object {
        private const val KEY_AUTH_TOKEN = "AuthToken"
        private const val USERNAME_AUTH = "username"
    }

    override var authToken: String
        get() {
            return this.preferences.getString(KEY_AUTH_TOKEN, "")!!
        }
        set(value) {
            this.preferences.edit().apply {
                putString(KEY_AUTH_TOKEN, value)
                apply()
            }
        }

    override var usernameAuth: String
        get() {
            return this.preferences.getString(USERNAME_AUTH, "")!!
        }
        set(value) {
            this.preferences.edit().apply {
                putString(USERNAME_AUTH, value)
                apply()
            }
        }
}