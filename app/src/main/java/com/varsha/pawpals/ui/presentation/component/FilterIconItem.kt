package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.FilterList
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
fun FilterIconItem(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
    ) {
    Box(
        modifier = modifier
            //.padding(16.dp, 8.dp)
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFD05440))
    ) {
        IconButton(
            onClick = onBackClicked,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                imageVector = Icons.Filled.FilterList,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterIconItemPreview() {
    FilterIconItem {}
}