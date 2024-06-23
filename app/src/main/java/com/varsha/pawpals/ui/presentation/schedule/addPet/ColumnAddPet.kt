package com.varsha.pawpals.ui.presentation.schedule.addPet

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.varsha.pawpals.R
import com.varsha.pawpals.utils.SQLiteHelper
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.ScheduleTimeTextField
import com.varsha.pawpals.ui.presentation.component.TextFieldDropdowns
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import okhttp3.Route
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnAddPet(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    val db = SQLiteHelper(context)

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    var namepet by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var scheduleDate by remember { mutableStateOf("") }

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
                        scheduleDate = selectedDate.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDate().format(formatter)
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
            .fillMaxWidth(1f)
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
                label = "Enter Name Pet",
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
            TextFieldDropdowns(list = listOf("Cat", "Dog"), selectedValue = type, onValueChange = { type = it })
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
                label = "Masukkan Jenis Hewan",
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
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldDropdowns(
                list = listOf("Male", "Female"),
                selectedValue = gender,
                onValueChange = { gender = it })
        }

        Column(
            modifier = Modifier.padding(32.dp, 0.dp)
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
                    textAlign = TextAlign.Start,
                )
            )
            ScheduleTimeTextField(
                value = scheduleDate,
                onValueChange = {},
                onIconClick = { showDatePicker = true },
                label = "DD-MM-YYYY",
                icon = Icons.Default.DateRange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            )
        }

        Button(
            onClick = {
                val newPet = PetData(
                    id = 0, // ID will be auto-generated
                    nama = namepet,
                    photo = R.drawable.profile_photo, // Replace with actual photo ID
                    type = type,
                    jenis = breed,
                    gender = gender,
                    birthday = LocalDate.parse(scheduleDate, formatter)
                )
                val status = db.addPet(newPet)
                if (status > -1) {
                    Toast.makeText(context, "Pet Added", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.Schedule.route)
                } else {
                    Toast.makeText(context, "Error Adding Pet", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFC85440)
            ),
            modifier = Modifier
                .width(194.dp)
                .height(60.dp)
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Simpan",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
