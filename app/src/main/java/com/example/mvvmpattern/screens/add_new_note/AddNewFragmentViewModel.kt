package com.example.mvvmpattern.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpattern.models.AppNote
import com.example.mvvmpattern.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewFragmentViewModel(application: Application) : AndroidViewModel(application) {
    //используется специальная корутина, которая помогает рабоатать в режиме life cycle
    fun insert(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(note) {
                onSuccess()
            }
        }
}