package com.aplikasi.memoir.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.aplikasi.memoir.data.local.TaskItem
import com.aplikasi.memoir.data.repository.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TasksRepository) : ViewModel() {
    fun getAllTasks() = repository.getAllTasks()

    fun insert(task: TaskItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(task)
    }

    fun delete(task: TaskItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(task)
    }
}