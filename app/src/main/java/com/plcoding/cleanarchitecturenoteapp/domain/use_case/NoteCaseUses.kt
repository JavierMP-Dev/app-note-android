package com.plcoding.cleanarchitecturenoteapp.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.domain.repository.NoteRepository

data class NoteCaseUses(
    val getNotes: NoteRepository,
    val deleteNote: DeleteNote
)
