package com.varsha.pawpals.ui.presentation.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.ButtonItem2
import java.time.LocalDate

@Composable
fun PetProfilContent(
    navController: NavController,
    pet : PetData,
   // modifier: Modifier = Modifier
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .width(500.dp)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = pet.photo),
                contentDescription = pet.nama,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(62.dp)
                    .clip(CircleShape)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .width(20.dp)
                    .weight(1f)
                    .padding(end = 0.dp)
            ) {
                Text(
                    text = pet.nama,
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF010911),
                        textAlign = TextAlign.Start
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                )      {
                    Text(
                        text = pet.type,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6D6F77),
                            textAlign = TextAlign.Start,
                        )
                    )

                    Text(
                        text = " - ${pet.jenis}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 19.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6D6F77),
                            textAlign = TextAlign.Start,
                        )
                    )
                }
            }

            ButtonItem2(
                navController = navController,
                text = "Plan",
                icon = Icons.Default.Edit,
                onClick = { navController.navigate(Screen.PlanPet.route) }
            )
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
private fun PetProfilContentPreview() {
    PetProfilContent(
        pet = PetData(id = 1,
            nama = "Basuki",
            photo = R.drawable.pet_photo1,
            type = "Cat",
            jenis = "kucing oren",
            gender = "tidak tau",
            birthday = LocalDate.of(2020, 5, 18)
        ),
        onItemClicked = {petId -> println("pet Id : $petId")},
        navController = rememberNavController()
    )
}