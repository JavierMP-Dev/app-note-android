
package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.domain.use_case.AddNote
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.GetNotes

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,

)