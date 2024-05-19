package com.varsha.pawpals.ui.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ReadCommunity

@Composable
fun CommunityReadScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEDEC))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Komunitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)

                )
                BackIconItem(
                    onBackClicked = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ) { contentPaddding ->
        Column(
            modifier = Modifier
                .background(Color(0xFFFBEDEC))
                .fillMaxSize()
                .padding(contentPaddding)
                .verticalScroll(rememberScrollState())
        ) {
            ReadCommunity()
        }
    }
}

@Preview
@Composable
private fun CommunityREadScreenPreview() {
    CommunityReadScreen()
}