package com.varsha.pawpals.ui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.varsha.pawpals.R


@Composable
fun HomePlanning(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xFFF18B55),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 25.dp)
        ) {
            Text(
                text = "Jadwal Kamu",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Black
                )

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFD05440)),
                modifier = Modifier
            ) {

                Text(
                    text = "Lihat",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 0.1.em,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .size(135.dp)
                .background(
                    color = Color(0xFFF8A457),
                    shape = CircleShape
                )
        ){
            Image(
                painter = painterResource(id = R.drawable.home_cat),
                contentDescription = "Gambar Kucing",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePlanningPreview() {
    HomePlanning(
        modifier = Modifier
    )
}