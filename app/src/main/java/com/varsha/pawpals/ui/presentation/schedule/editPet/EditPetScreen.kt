package com.varsha.pawpals.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.schedule.addPet.ColumnEditPet
import com.varsha.pawpals.ui.presentation.schedule.editPet.ManageEditPet
import com.varsha.pawpals.utils.SQLiteHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditPetScreen(onBackClicked: () -> Unit, navController: NavController, petId: Int?) {
    val context = LocalContext.current
    val db = SQLiteHelper(context)
    val pet = petId?.let { db.getAllPets().firstOrNull { it.id == petId } }

    if (pet != null) {
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
                        text = "Edit Pet",
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
            }
        ) { contentPadding ->
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth()
            ) {
                ManageEditPet(pet = pet)
                LazyColumn(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    item {
                        ColumnEditPet(newPetList = listOf(pet))
                    }
                }
            }
        }
    } else {
        // Handle pet not found
        Text(text = "Pet not found")
    }
}
