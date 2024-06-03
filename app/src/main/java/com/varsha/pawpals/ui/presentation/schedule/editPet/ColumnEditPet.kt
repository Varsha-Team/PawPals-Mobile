package com.varsha.pawpals.ui.presentation.schedule.addPet

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.ui.presentation.component.ScheduleTimeTextField
import com.varsha.pawpals.ui.presentation.component.TextFieldDropdowns
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnEditPet(
    modifier: Modifier = Modifier,
    newPetList: List<PetData>
) {
    val context = LocalContext.current

    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date = remember { Calendar.getInstance().timeInMillis }

    val pet = newPetList[0]

    var namepet by remember { mutableStateOf(pet.nama) }
    var breed by remember { mutableStateOf(pet.jenis) }
    var type by remember { mutableStateOf(pet.type) }
    var gender by remember { mutableStateOf(pet.gender) }

    var scheduleDate by remember { mutableStateOf(pet.birthday.format(dateFormatter)) }

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        scheduleDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(selectedDate.time)
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }
                ) { Text("Cancel") }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Start,
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldDropdowns(
                list = listOf("Cat", "Dog"),
                selectedValue = type,
                onValueChange = { type = it }
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Breed",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldItem(
                value = breed,
                onValueChange = { breed = it },
                label = pet.jenis,
            )
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Gender",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start
                )
            )
            TextFieldDropdowns(
                list = listOf("Male", "Female"),
                selectedValue = gender,
                onValueChange = { gender = it }
            )
        }

        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Birthday",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start
                )
            )
            ScheduleTimeTextField(
                value = scheduleDate,
                onValueChange = { scheduleDate = it },
                label = "Atur Tanggal",
                icon = Icons.Default.DateRange,
                onIconClick = {
                    showDatePicker = true
                }
            )
        }

        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(Color(0xFFED6A09)),
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

@SuppressLint("NewApi")
@Preview(showBackground = true)
@Composable
private fun ColumnEditPetPreview() {
    ColumnEditPet(newPetList = DataPet.Pet)
}
