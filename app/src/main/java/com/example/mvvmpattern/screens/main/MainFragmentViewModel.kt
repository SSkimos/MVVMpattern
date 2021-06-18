package com.example.mvvmpattern.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmpattern.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes


}