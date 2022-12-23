package com.example.android.ivn1.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android.ivn1.REPOSITORY
import com.example.android.ivn1.db.NoteDatabase
import com.example.android.ivn1.db.repository.NoteRealization
import com.example.android.ivn1.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY!!.allNotes
    }
}