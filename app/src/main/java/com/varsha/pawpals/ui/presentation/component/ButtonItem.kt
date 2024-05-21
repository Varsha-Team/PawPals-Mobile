package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ButtonItem1(
    text: String,
    icon: ImageVector,
    //onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(130.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp,
                color = Color(0xFFC85440),
                shape = RoundedCornerShape(50)
            )
            .background(Color(0xFFC85440))
            //.clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Add",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
}


@Composable
fun ButtonItem2(
    text: String,
    icon: ImageVector,
    //onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(130.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 2.dp,
                color = Color(0xFFC85440),
                shape = RoundedCornerShape(50)
            )
            .background(Color.White)
            //.clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Add",
                modifier = Modifier.size(24.dp),
                tint = Color(0xFFC85440)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC85440)
                )
            )
        }
    }
}


@Preview()
@Composable
fun ButtonItemPreview1() {
    ButtonItem1(
        text = "Add Pets", icon = Icons.Default.Add,
    )
}

@Preview()
@Composable
fun ButtonItemPreview2() {
    ButtonItem2(
        text = "Pets", icon = Icons.Default.Add
    )
}
