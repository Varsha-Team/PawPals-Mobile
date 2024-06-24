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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.schedule.PetProfilContent
import com.varsha.pawpals.ui.presentation.schedule.editPlan.ManageEditPlan
import com.varsha.pawpals.utils.AlarmData
import com.varsha.pawpals.utils.SQLiteHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanPetScreen(
    navController: NavController,
    petId: Int?,

) {
    // Periksa apakah petId null, jika iya, navigasikan kembali
    if (petId == null) {
        navController.navigateUp()
        return
    }

    // Konteks lokal dan SQLiteHelper untuk mengakses database
    val context = LocalContext.current
    val db = SQLiteHelper(context)

    // State untuk menyimpan PetData saat ini
    var pet by remember { mutableStateOf<PetData?>(null) }
    var alarms by remember { mutableStateOf<List<AlarmData>?>(null) }

    // Ambil data pet saat komponen dimuat
    LaunchedEffect(petId) {
        pet = db.getPetById(petId)
    }

    // Ambil data alarm saat komponen dimuat
    LaunchedEffect(petId) {
        alarms = db.getAlarmsByPetId(petId)
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
                onClick = { navController.navigate("edit_plan/$petId") }
            )
        }
    ) { contentPadding ->
        // Tampilkan loading jika data alarm belum tersedia
        if (alarms == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Not Found", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    item {
                        pet?.let { ManageEditPlan(pet = it) }

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
                    }

                    items(alarms!!, key = { it.id }) { alarm ->
                        DailyPlanItem(alarm = alarm)
                    }
                }
            }
        }
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PlanPetScreenPreview() {
    PlanPetScreen(
        navController = rememberNavController(),
        petId = 1 // Replace with a valid pet ID for preview
    )
}
