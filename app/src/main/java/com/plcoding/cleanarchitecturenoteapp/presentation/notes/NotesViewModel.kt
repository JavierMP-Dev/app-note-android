package com.plcoding.cleanarchitecturenoteapp.presentation.notes


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.NoteCaseUses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.domain.util.NoteOrder

import kotlinx.coroutines.Job
import com.plcoding.cleanarchitecturenoteapp.domain.util.OrderType
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteCaseUses: NoteCaseUses
) : ViewModel(){

    private val  _state = mutableStateOf(NotesState())
    val state:State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))

    }
    fun onEvent (event: NotesEvent){
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                    ){
                    return
                }
                getNotes(event.noteOrder)

            }
            is NotesEvent.DeleteNote->{
                viewModelScope.launch{
                    noteCaseUses.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
             }
            is NotesEvent.RestoreNote ->{
                viewModelScope.launch {
                noteCaseUses.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

        private fun getNotes(noteOrder: NoteOrder){
            getNotesJob?.cancel()
            getNotesJob =  noteCaseUses.getNotes(noteOrder)
                .onEach { notes: List<Note> ->
                    _state.value = state.value.copy(
                        notes = notes,
                        noteOrder = noteOrder
                    )
                }
                .launchIn(viewModelScope)
        }
}


