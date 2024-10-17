package com.plcoding.cleanarchitecturenoteapp.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.NoteCaseUses
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteCaseUses: NoteCaseUses
) : ViewModel(){

    private val  _state = mutableStateOf(NotesState())
    val state:State<NotesState> = _state
    fun onEvent (event: NotesEvent){
        when (event) {
            is NotesEvent.Order -> {

            }
            is NotesEvent.DeleteNote->{


             }
            is NotesEvent.RestoreNote ->{

            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

}