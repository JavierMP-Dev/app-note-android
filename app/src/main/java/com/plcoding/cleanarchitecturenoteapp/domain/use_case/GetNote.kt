package com.plcoding.cleanarchitecturenoteapp.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository

class GetNote (
    private val repository: NoteRepository
){
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}