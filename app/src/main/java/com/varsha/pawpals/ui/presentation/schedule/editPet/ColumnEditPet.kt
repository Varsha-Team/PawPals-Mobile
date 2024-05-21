package com.varsha.pawpals.ui.presentation.schedule.addPet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.ui.presentation.component.TextFieldItem

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnEditPet(
    modifier: Modifier = Modifier,
    newPetList: List<PetData>
) {
    var namepet by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var birthday by rememberSaveable { mutableStateOf("") }

  //  if (newPetList.isNotEmpty()) {
        val pet = newPetList[0] // Assuming you want to edit the first pet in the list
//        namepet = pet.nama
//        type = pet.jenis
//       // breed = pet.breed
//        gender = pet.gender
//        birthday = pet.birthday.toString()
   // }

    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Pet Details",
                modifier = Modifier.height(21.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Nama",
                modifier = Modifier.width(78.dp).height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Center,
                )
            )
            TextFieldItem(
                value = namepet,
                onValueChange = { namepet = it },
                label = pet.nama,
                keyboardType = KeyboardType.Text,
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Type",
                modifier = Modifier.width(54.dp).height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Center,
                )
            )
            TextFieldItem(
                value = type,
                onValueChange = { type = it },
                label = pet.jenis,
                keyboardType = KeyboardType.Text,
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Breed",
                modifier = Modifier.width(78.dp).height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            TextFieldItem(
                value = breed,
                onValueChange = { breed = it },
                label = "Breed",
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Gender",
                modifier = Modifier.width(78.dp).height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            )
            TextFieldItem(
                value = gender,
                onValueChange = { gender = it },
                label = pet.gender,
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Birthday",
                modifier = Modifier.width(78.dp).height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center
                )
            )
            TextFieldItem(
                value = birthday,
                onValueChange = { birthday = it },
                label = pet.birthday.toString(),
            )
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#D05440"))),
            modifier = Modifier
                .width(194.dp)
                .height(60.dp)
                .padding(10.dp)
        ) {
            Text(
                text = "Simpan",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun ColumnEditPetPreview() {
    ColumnEditPet(newPetList = DataPet.Pet)
}
