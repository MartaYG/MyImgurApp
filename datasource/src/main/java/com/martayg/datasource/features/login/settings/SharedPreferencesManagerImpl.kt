package com.martayg.datasource.features.login.settings

import android.content.SharedPreferences
import com.martayg.datasource.features.login.interfaces.SharedPreferencesManager
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(
    private val preferences: SharedPreferences
): SharedPreferencesManager {

    companion object {
        private const val KEY_AUTH_TOKEN = "AuthToken"
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
}