package com.example.mvvmpattern.database.room

import androidx.lifecycle.LiveData
import com.example.mvvmpattern.database.DatabaseRepository
import com.example.mvvmpattern.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao):DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess() //коллбэк, что задача была выполнена
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
    }
}