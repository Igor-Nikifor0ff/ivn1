package com.example.android.ivn1.db.repository

import androidx.lifecycle.LiveData
import com.example.android.ivn1.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData <List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() ->Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() ->Unit)
}