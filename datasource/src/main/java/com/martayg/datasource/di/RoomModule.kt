package com.martayg.datasource.di

import android.content.Context
import androidx.room.Room
import com.martayg.datasource.cache.db.MyImgurDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val MY_IMGUR_DB_NAME = "my_imgur_db"

    @Singleton
    @Provides
    fun providesDbRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyImgurDatabase::class.java,MY_IMGUR_DB_NAME).build()
}