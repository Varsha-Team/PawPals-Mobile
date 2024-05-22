package com.varsha.pawpals.ui.presentation.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.model.Notification

object Variables {
    val primary100: Color = Color(0xFFFBEDEC)
    val primary300: Color = Color(0xFFEB8479)
}
@Composable
fun SystemNotificationItem(
    notification: Notification,
    modifier: Modifier
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
        modifier = Modifier
           // .border(width = 1.dp, color = Variables.primary300,)
            .width(320.dp)
            .height(110.dp)
            .background(color = Variables.primary100)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_pawpals),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(2.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .width(252.dp)
                        .height(22.dp)
                ) {
                    Text(
                        text = notification.user,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.sp,
                           // fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA09BA3),
                        )
                    )
                    Text(
                        text = "${notification.time} Menit Yang Lalu",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 19.6.sp,
                           // fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA09BA3),
                            letterSpacing = 0.14.sp,
                        )
                    )
                }
                Spacer(modifier = modifier.padding(8.dp))
                Text(
                    text = notification.content,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                      //  fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1B141F),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun SystemNotificationPrev() {
    SystemNotificationItem(
        notification =
        Notification(1,
            "PawPals",
            "Give pet to Lily",
            R.drawable.logo_pawpals,
             1
            ), modifier = Modifier
    )
}