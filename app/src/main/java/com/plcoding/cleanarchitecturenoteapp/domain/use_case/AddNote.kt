package com.plcoding.cleanarchitecturenoteapp.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note


class AddNote (
    private  val repository: NoteRepository
){

    @Throws(InvalidNoteException::class)
    suspend operator  fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("El titulo de la nota no puede estar vacio")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("El contenido de la nota no puede estar vacio")
        }
        repository.insertNote(note)
    }
}