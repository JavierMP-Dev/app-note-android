package com.plcoding.cleanarchitecturenoteapp.presentation.notes

import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order (val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote:  NotesEvent()
    object ToggleOrderSection: NotesEvent()
}