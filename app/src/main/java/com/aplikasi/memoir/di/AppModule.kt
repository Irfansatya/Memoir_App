package com.aplikasi.memoir.di

import android.app.Application
import androidx.room.Room
import com.aplikasi.memoir.data.local.TaskDatabase
import com.aplikasi.memoir.data.repository.TasksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): TaskDatabase =
        Room.databaseBuilder(application, TaskDatabase::class.java, "tasksDb.db")
            .build()

    @Provides
    @Singleton
    fun provideRepository(database: TaskDatabase): TasksRepository {
        return TasksRepository(database)
    }

}