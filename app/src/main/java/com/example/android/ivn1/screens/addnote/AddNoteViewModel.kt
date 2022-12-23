package com.example.android.ivn1.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.ivn1.REPOSITORY
import com.example.android.ivn1.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel(){

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY!!.insertNote(noteModel){
                onSuccess()
            }
        }
}