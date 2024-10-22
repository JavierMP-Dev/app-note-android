package com.plcoding.cleanarchitecturenoteapp.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
@Composable
fun DefaultRadioButton (

        text: String,
        selected: Boolean,
        onSelect: () -> Unit,
        modifier: Modifier = Modifier
){
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = selected,
                onClick = onSelect,
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colors.primary,
                    unselectedColor = MaterialTheme.colors.onBackground
                )
            )
        Spacer(modifier = Modifier.widthIn(8.dp))
        Text(text = text, style = MaterialTheme.typography.body1)
        }

}

