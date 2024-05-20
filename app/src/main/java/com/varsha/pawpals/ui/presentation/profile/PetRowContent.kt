package com.varsha.pawpals.ui.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R

@Composable
fun PetRowContent(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        //border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(32.dp, 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_pawpals),
                contentDescription = "Profil Photo",
                modifier = Modifier
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Jumlah Pets",
                    fontSize = 25.sp,
                    lineHeight = 19.sp,
                    color = Color(0xFF973B2C),
                    fontWeight = FontWeight(600),
                )
                Text(
                    text = "2",
                    fontSize = 42.sp,
                    lineHeight = 19.sp,
                    color = Color(0xFF973B2C),
                    fontWeight = FontWeight(600),
                )
            }
        }
    }
}

@Preview
@Composable
private fun PetRowContentPreview() {
    PetRowContent()
}