package com.varsha.pawpals.ui.presentation.schedule.addPet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ManageAddPet(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp, 24.dp)
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .background(Color.White)
                .weight(1f)
        ) {
            Text(
                text = "Manage Your Pet Profile" ,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
            )
            Text(
                text = "Change your pet’s personal details whenever you want.",
                fontSize = 12.sp,
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Box(
            modifier = Modifier
        ) {
            Card(
                modifier = Modifier
                    .border(3.dp, Color(0xFFD05440), RoundedCornerShape(16.dp))
                    .align(Alignment.BottomEnd)
            ) {
                IconButton(
                    onClick = { /* ToDO */ },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        Icons.Filled.Image,
                        contentDescription = "Back",
                        tint = Color(0xFFD05440)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ManageEditPetPreview() {
    ManageAddPet(
//        pet = PetData(id = 1,
//            nama = "Bjir",
//            photo = R.drawable.pet_photo1,
//            jenis = "kucing oren",
//            gender = "tidak tau",
//            birthday = LocalDate.of(2020, 5, 18))
    )
}