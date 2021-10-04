package com.shodiq.todolistapp

import android.app.Application
import com.shodiq.todolistapp.data.datasource.TaskDataSource

class App : Application() {
    private var dataSource : TaskDataSource? = null

    override fun onCreate() {
        super.onCreate()
        dataSource = TaskDataSource()
    }

    override fun onTerminate() {
        super.onTerminate()
        dataSource = null
    }

    fun getDataSource() : TaskDataSource? = dataSource
}