package com.varsha.pawpals.ui.presentation.schedule.editPlan

import CalendarRowComponent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanPetScreen(
    navController: NavController,
    petId: Int?
    //modifier: Modifier = Modifier,
    ) {

    val newPetList = DataPet.Pet.filter { pet -> pet.id == petId }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Today's Plan",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        },
        floatingActionButton = {
            ButtonItem1(
                navController = navController,
                text = "Plan",
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Screen.EditPlan.route) }
            )
        }
    ){contentPadding ->
        Column (
            modifier = Modifier
                .padding(contentPadding)
                //.background(Color(0xFFFBEDEC))
                .fillMaxSize()

        ){
            LazyColumn (
                modifier = Modifier
            ){
                item {
                    ManageEditPlan(pet = newPetList[0])

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    ) {
                        CalendarRowComponent()
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Today’s Daily Habits",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .height(21.dp),
                        style = TextStyle(
                            fontSize = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF030303),
                            textAlign = TextAlign.Center,
                        )
                    )

                    DailyPlanItem()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PlanPetScreenPreview() {
    PlanPetScreen(navController = rememberNavController(),
        petId = DataPet.Pet.first().id
    )
}