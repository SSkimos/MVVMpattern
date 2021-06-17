package com.example.mvvmpattern.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmpattern.database.room.AppRoomDatabase
import com.example.mvvmpattern.database.room.AppRoomRepository
import com.example.mvvmpattern.utilits.REPOSITORY
import com.example.mvvmpattern.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess:()->Unit){
        when (type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}