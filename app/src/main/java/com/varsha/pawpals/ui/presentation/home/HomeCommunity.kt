package com.varsha.pawpals.ui.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeCommunity(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xFFD05440),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 20.dp)
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .size(51.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.Accessibility,
                contentDescription = "Icon Community",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Text(
            text = "Komunitas",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Black
            )
        )

        Icon(
            imageVector = Icons.Default.ArrowForwardIos,
            contentDescription = "Panah Kanan")
    }
}

@Preview (showBackground = true)
@Composable
private fun HomeCommunityPreview() {
    HomeCommunity()
}