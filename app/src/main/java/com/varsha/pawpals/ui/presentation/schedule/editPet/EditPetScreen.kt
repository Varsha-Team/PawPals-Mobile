package com.varsha.pawpals.ui.screen

import android.os.Build
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.schedule.DeletePet.DeletePetComponent
import com.varsha.pawpals.ui.presentation.schedule.DeletePet.PetViewModel
import com.varsha.pawpals.ui.presentation.schedule.addPet.ColumnEditPet
import com.varsha.pawpals.ui.presentation.schedule.editPet.ManageEditPet
import com.varsha.pawpals.utils.SQLiteHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditPetScreen(
    onBackClicked: () -> Unit,
    navController: NavController,
    petId: Int?,
    petViewModel: PetViewModel = viewModel()
) {
    val context = LocalContext.current
    val db = SQLiteHelper(context)

    // Mengambil data pet dari ViewModel
    val pet by petViewModel.petLiveData.observeAsState()

    // Mendapatkan pet berdasarkan petId
    LaunchedEffect(petId) {
        if (petId != null) {
            petViewModel.fetchPetById(petId)
        }
    }

    // Jika petId null, kita bisa handle secara terpisah atau menampilkan pesan kesalahan.
    if (petId == null) {
        Text("Pet ID is missing", color = Color.Red)
        return
    }

    // Jika pet null, berarti tidak ada pet dengan ID yang diberikan
    if (pet == null) {
        Text("No pet found with the given ID", color = Color.Red)
        return
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
                DeletePetComponent(
                    petId = petId,
                    petViewModel = petViewModel,
                    onDeleted = {
                        //  navController.navigate(Screen.Schedule.route)
                        Handler(Looper.getMainLooper()).post {
                            Toast.makeText(context, "Pet deleted successfully", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
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
            ManageEditPet(pet = pet!!)
            LazyColumn(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
            ) {
                item {
                    ColumnEditPet(
                        pet = pet!!,
                        onUpdated = {
                            // Handle what happens after the pet is updated
                            Handler(Looper.getMainLooper()).post {
                                Toast.makeText(context, "Pet updated successfully", Toast.LENGTH_SHORT).show()
                            }
                        },
                        petViewModel = petViewModel,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview
//@Composable
//private fun EditPetPrev() {
//    EditPetScreen(onBackClicked = { /*TODO*/ }, navController = rememberNavController(), petId = Int)
//}