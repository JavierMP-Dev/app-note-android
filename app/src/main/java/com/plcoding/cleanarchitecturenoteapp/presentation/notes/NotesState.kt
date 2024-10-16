package com.plcoding.cleanarchitecturenoteapp.presentation.notes

import androidx.annotation.VisibleForTesting
import com.plcoding.cleanarchitecturenoteapp.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.domain.util.OrderType
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note


data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder= NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
