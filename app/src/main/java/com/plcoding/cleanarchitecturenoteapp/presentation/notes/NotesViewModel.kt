package com.plcoding.cleanarchitecturenoteapp.presentation.notes

import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.domain.use_case.NoteCaseUses
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteCaseUses: NoteCaseUses
) : ViewModel(){

}