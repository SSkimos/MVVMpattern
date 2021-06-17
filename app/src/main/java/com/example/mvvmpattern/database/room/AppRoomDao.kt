package com.example.mvvmpattern.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmpattern.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT *from note_tables")
    fun getAllNotes(): LiveData<List<AppNote>>

    //в случае, если будут какие то конфликты, то мы будем игнорировать эту операцию
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}