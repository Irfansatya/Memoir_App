package com.aplikasi.memoir.data.repository

import com.aplikasi.memoir.data.local.TaskDatabase
import com.aplikasi.memoir.data.local.TaskItem
import javax.inject.Inject

class TasksRepository @Inject constructor(private val database: TaskDatabase) {
    suspend fun insert(task: TaskItem) = database.getTasksDao().insert(task)
    suspend fun delete(task: TaskItem) = database.getTasksDao().delete(task)
    fun getAllTasks() = database.getTasksDao().getAllTasks()
}