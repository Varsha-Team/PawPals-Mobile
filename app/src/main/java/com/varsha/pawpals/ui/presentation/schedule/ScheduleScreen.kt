package com.varsha.pawpals.ui.presentation.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.schedule.PetProfilContent
import com.varsha.pawpals.utils.SQLiteHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val db = SQLiteHelper(context)
    var pets by remember { mutableStateOf(listOf<PetData>()) }

    LaunchedEffect(Unit) {
        pets = db.getAllPets()
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
                    color = Color(0xFFC85440),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        floatingActionButton = {
            ButtonItem1(
                navController = navController,
                text = "Add Pets",
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Screen.AddPet.route) }
            )
        }
    ) { contentPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(color = Color.White),
        ) {
            if (pets.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lying_cat), // Make sure to add your image in drawable
                            contentDescription = "jika no pet",
                            modifier = Modifier.size(250.dp)
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "No pet found",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFFC85440),
                            )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Please add a new pet", fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                items(pets, key = { it.id }) { pet ->
                    PetProfilContent(
                        navController = navController,
                        pet = pet,
                    ) { petId ->
                        navController.navigate(Screen.EditPet.route + "/$petId")
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ScheduleScreenPrev() {
    ScheduleScreen(navController = rememberNavController())
}