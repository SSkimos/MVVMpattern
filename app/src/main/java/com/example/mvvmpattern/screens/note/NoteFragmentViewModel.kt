package com.example.mvvmpattern.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpattern.models.AppNote
import com.example.mvvmpattern.utilits.REPOSITORY
import com.example.mvvmpattern.utilits.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.delete(note) {
                onSuccess()
            }
        }
}