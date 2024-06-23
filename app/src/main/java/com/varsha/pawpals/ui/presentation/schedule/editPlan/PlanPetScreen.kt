package com.varsha.pawpals.ui.presentation.schedule.editPlan

import CalendarRowComponent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.schedule.editPlan.ManageEditPlan
import com.varsha.pawpals.utils.AlarmData
import com.varsha.pawpals.utils.SQLiteHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanPetScreen(
    navController: NavController,
    petId: Int?

) {
    // Check if petId is null, if so, navigate back
    if (petId == null) {
        navController.navigateUp()
        return
    }

    // Local context and SQLiteHelper to access the database
    val context = LocalContext.current
    val db = SQLiteHelper(context)


    // State to hold the current PetData
    var pet by remember { mutableStateOf<PetData?>(null) }

    // Fetch pet data on load
    LaunchedEffect(petId) {
        pet = db.getPetById(petId)
    }

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
    ) { contentPadding ->
        // Show loading if pet data is not yet available
        if (pet == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Loading...", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                ) {
                    item {
                        ManageEditPlan(pet = pet!!)

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
                                fontWeight = FontWeight(600),
                                color = Color(0xFF030303),
                                textAlign = TextAlign.Center,
                            )
                        )

                        DailyPlanItem() // Replace with actual plan display logic
                    }

                }
            }
        }
    }
}


//@RequiresApi(Build.VERSION_CODES.O)
//@Preview
//@Composable
//private fun PlanPetScreenPreview() {
//    PlanPetScreen(
//        navController = rememberNavController(),
//        petId = 1 // Replace with a valid pet ID for preview
//    )
//}
