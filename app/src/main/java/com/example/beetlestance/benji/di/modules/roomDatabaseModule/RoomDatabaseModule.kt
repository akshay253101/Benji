package com.example.beetlestance.benji.di.modules.roomDatabaseModule

import android.content.Context
import androidx.room.Room
import com.example.beetlestance.benji.di.modules.AppModule
import com.example.beetlestance.benji.data.RoomApiService
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class RoomDatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@Named("AppContext") context: Context): RoomApiService {
        return Room.databaseBuilder(context, AppDatabase::class.java, "benji").build().daoProvider()
    }
}