package com.varsha.pawpals.ui.presentation.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.pawpals.R
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.ui.presentation.component.ButtonItem2
import java.time.LocalDate

@Composable
fun PetProfilContent(
    pet : PetData,
    //navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Column(
            modifier = Modifier
//                .shadow(
//                    elevation = 4.dp,
//                    spotColor = Color(0x40000000),
//                    ambientColor = Color(0x40000000)
//                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    //.padding(24.dp)
                    //.height(IntrinsicSize.Min) // Allow height to wrap content
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = pet.photo),
                    contentDescription = pet.nama,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(62.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = pet.nama,
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF010911),
                        textAlign = TextAlign.Center
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                ButtonItem2(
                    text = "Edit Pet", icon = Icons.Default.Edit
                )
                ButtonItem2(
                    text = "Edit Plan", icon = Icons.Default.Edit
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
private fun PetProfilContentPreview() {
    PetProfilContent(
        pet = PetData(id = 1,
            nama = "Bjir",
            photo = R.drawable.pet_photo1,
            jenis = "kucing oren",
            gender = "tidak tau",
            birthday = LocalDate.of(2020, 5, 18))
    )
}