package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchItem(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(false) }
    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Color(0xFFED6A09),
            uncheckedThumbColor = Color.Gray,
            uncheckedTrackColor = Color(0xFFFBEDEC)
        )
    )
}

@Preview
@Composable
private fun SwitchItemPreview() {
    SwitchItem()
}
