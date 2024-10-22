package com.plcoding.cleanarchitecturenoteapp.presentation.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.Dp
import com.plcoding.cleanarchitecturenoteapp.domain.model.Note
import androidx.compose.ui.unit.dp

@Composable
fun NoteItem (
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
){
    Box(
        modifier =modifier
    ){
        Canvas(modifier = Modifier.matchParentSize()) {

        }
    }

}