package com.varsha.pawpals.ui.presentation.schedule.editPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.varsha.pawpals.R

@Composable
fun DailyPlanItem() {
    var isChecked by remember { mutableStateOf(false) }
    Card (
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp)
                .background(Color.White)
                .clip(MaterialTheme.shapes.medium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Delete, // Ganti dengan ikon delete yang sesuai
                contentDescription = "Delete",
                tint = Color.Red,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        // Aksi untuk menghapus item
                    }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text("Give Breakfast", fontSize = 16.sp, color = Color.Black)
                Spacer(modifier = Modifier.padding(8.dp))
                Text("08:30", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Column {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                        .background(if (isChecked) Color.Red else Color.Transparent)
                        .align(Alignment.End)
                        .clickable { isChecked = !isChecked },
                    contentAlignment = Alignment.Center,
                ) {
                    if (isChecked) {
                        Icon(
                            imageVector = Icons.Default.Check, // Ganti dengan ikon centang yang sesuai
                            contentDescription = "Checked",
                            tint = Color.Black,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    listOf("Sn", "Sl", "R", "K", "J", "Sb", "M").forEach { day ->
                        Text(
                            text = day,
                            fontSize = 16.sp,
                            color = Color.Red,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
private fun DailyPlanItemPreview() {
    DailyPlanItem()
}