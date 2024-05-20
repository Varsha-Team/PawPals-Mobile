package com.varsha.pawpals.ui.presentation.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.profile.AddPetScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    petProfil: List<PetData> = DataPet.Pet,
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEDEC))
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
                    onBackClicked = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        },
        floatingActionButton = {
            ButtonItem1(
                text = "Add Pets",
                icon = Icons.Default.Add,
                onClick = { navController.navigate("addPetScreen") }
            )
        }
    ) { contentPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(color = Color(0xFFFBEDEC)),
        ) {
            items(petProfil, key = { it.id }) {
                PetProfilContent(pet = it)
            }
        }
    }
}

@Composable
fun PetScreenNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { /* Your Home Screen Content */ }
        composable("addPetScreen") { AddPetScreen(onBackClicked = {}) }
        composable("editPetScreen") { /* Your Edit Pet Screen Content */ }
        composable("editPlanScreen") { /* Your Edit Plan Screen Content */ }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun ScheduleScreenPreview() {
    ScheduleScreen(navController = rememberNavController())
}