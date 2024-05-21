package com.varsha.pawpals.ui.presentation.schedule.editPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1

@Composable
fun PlanPetScreen(
    modifier: Modifier = Modifier,
    navController: NavController
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
                text = "Plan",
                icon = Icons.Default.Add,
                onClick = { navController.navigate("addPetScreen") }
            )
        }
    ){contentPadding ->
        Column (
            modifier = Modifier
                .padding(contentPadding)
                .background(Color(0xFFFBEDEC))
                .fillMaxSize()
        ){
            LazyColumn (
                modifier = Modifier
            ){
                item {
                    DailyPlanItem()
                }
            }
        }
    }
}

@Preview
@Composable
private fun PlanPetScreenPreview() {
    PlanPetScreen(navController = rememberNavController())
}