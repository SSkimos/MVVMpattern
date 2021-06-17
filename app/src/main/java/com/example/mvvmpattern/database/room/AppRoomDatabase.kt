package com.example.mvvmpattern.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmpattern.models.AppNote

@Database(entities = [AppNote::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    //привет синглтон, давно не виделись
    companion object {

        @Volatile //означает, что база данных не должна кэшироватсья
        private var database: AppRoomDatabase? = null

        @Synchronized //запрещаем обращаться к функции нескольким экземплярам класса одновременно
        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase
        }
    }
}