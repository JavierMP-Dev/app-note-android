package com.plcoding.cleanarchitecturenoteapp.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note

class DeleteNote (
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}