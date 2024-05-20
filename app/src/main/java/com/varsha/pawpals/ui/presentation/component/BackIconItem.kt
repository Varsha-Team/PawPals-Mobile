package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BackIconItem(
    onBackClicked: () -> Unit, // Add this parameter for the click action
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            //.padding(16.dp, 8.dp)
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        IconButton(
            onClick = onBackClicked, // Use the parameter here
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
}

@Preview
@Composable
private fun BackIconItemPrefiew() {
    BackIconItem(onBackClicked={})
}
