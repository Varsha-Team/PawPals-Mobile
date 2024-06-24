package com.varsha.pawpals.ui.presentation.schedule.editPlan

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.model.PetData
import java.time.LocalDate

@Composable
fun ManageEditPlan(
    pet: PetData,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp, 24.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Manage ${pet.nama}'s Plan",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
            )
            Text(
                text = "Take a look at how ${pet.nama}'s day was planned.",
                fontSize = 12.sp,
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = pet.photo),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(110.dp)
                    .border(
                        width = 3.dp, Color(0xFFED6A09), shape = RoundedCornerShape(size = 110.dp)
                    )
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .border(3.dp, Color(0xFFED6A09), RoundedCornerShape(16.dp))
                    .align(Alignment.BottomEnd)
            ) {
                IconButton(
                    onClick = { /* ToDO */ },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        Icons.Filled.Image,
                        contentDescription = "Back",
                        tint = Color(0xFFED6A09)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ManageEditPlanPrev() {
    ManageEditPlan(pet = PetData(id = 1,
            nama = "Bjir",
            photo = R.drawable.pet_photo1,
            jenis = "kucing oren",
            gender = "tidak tau",
            birthday = LocalDate.of(2020, 5, 18),
            type = "gacor"
        )
    )

}