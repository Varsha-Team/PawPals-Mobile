package com.varsha.pawpals.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varsha.pawpals.R

// Background Color
val backgroundColor = Brush.radialGradient(
    colors = listOf(Color(0xFFFFFFFF), Color(0xFFF2BBB6)),
    center = Offset(540f, 1170f),
    radius = 1500f
)

@Composable
fun PawPalsApp(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_pawpals),
            contentDescription = "Icon APP",
            modifier = Modifier
                .size(300.dp)
        )
    }
}

@Preview
@Composable
private fun PawPalsAppPreview() {
    PawPalsApp()
}