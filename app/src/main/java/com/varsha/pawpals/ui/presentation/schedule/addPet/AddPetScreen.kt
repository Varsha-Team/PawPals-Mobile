package com.varsha.pawpals.ui.presentation.profile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.DataUser
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.schedule.addPet.ColumnAddPet
import com.varsha.pawpals.ui.presentation.schedule.addPet.ManageAddPet
import com.varsha.pawpals.ui.theme.PawPalsTheme

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AddPetScreen(
    onBackClicked: () -> Unit,
    navController: NavController
) {
    val profil = DataUser.User

    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
            ) {
                Text(
                    text = "Add Pet",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFED6A09),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .background(color = Color.White),
            ) {
                ManageAddPet()
                LazyColumn (
                    modifier = Modifier
                        //.padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
//                        .background(Color(0xFFFBEDEC))
                        .background(Color.White)
                ){
                    item {
                        ColumnAddPet(navController = navController)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun AddPetScreenPreview() {
    PawPalsTheme {
        AddPetScreen(onBackClicked = {},
            navController = rememberNavController()
        )
    }
}