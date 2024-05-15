package com.varsha.pawpals.ui.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeCommunityText(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            Text(text = "Community")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyArticle()
    }
}

@Composable
fun LazyCommunity(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .fillMaxWidth()
//            .padding(10.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(25.dp))
    ) {
        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    ), color = Color.Gray
                )
                .fillMaxWidth()
                .size(150.dp)
        ) {

        }
        Row(
            modifier = Modifier
                .padding(vertical = 15.dp)
        ) {
            Spacer(modifier = modifier.width(16.dp))
            Text(text = "Judul")
        }
    }
}

@Preview
@Composable
private fun HomeCommunityPreview() {
    HomeCommunityText()
}