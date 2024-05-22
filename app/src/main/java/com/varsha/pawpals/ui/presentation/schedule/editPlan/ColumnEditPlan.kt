package com.varsha.pawpals.ui.presentation.schedule.editPlan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
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
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.component.ButtonItem2
import com.varsha.pawpals.ui.presentation.component.ScheduleTimeTextField
import com.varsha.pawpals.ui.presentation.component.SwitchItem
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import com.varsha.pawpals.ui.presentation.component.TimePickerDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnEditPlan(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var planname by remember { mutableStateOf("") }

    var scheduleTime by rememberSaveable { mutableStateOf("") }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }

    var daysSelected by rememberSaveable { mutableStateOf(List(7) { false }) }
    val daysOfWeek = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")


    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                        showTimePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showTimePicker = false }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            TimePicker(state = timePickerState)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 24.dp)
        //.background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        )
        {
            Text(
                text = "Pilih Waktu",
                modifier = Modifier
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.padding(16.dp))

            ScheduleTimeTextField(
                value = scheduleTime,
                onValueChange = { scheduleTime = it },
                label = "Atur Tanggal",
                icon = Icons.Default.AccessTime,
                onIconClick = {
                    showTimePicker = true
                }
            )

            Spacer(modifier = Modifier.padding(8.dp))


            Text(
                text = "Nama Plan",
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
                value = planname,
                onValueChange = { planname = it },
                label = "Masukkan Nama Plan",
                keyboardType = KeyboardType.Text,
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Column {
                Text(
                    text = "Pilih Hari",
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
                daysOfWeek.forEachIndexed { index, day ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = daysSelected[index],
                            onCheckedChange = { checked ->
                                daysSelected = daysSelected.toMutableList().apply {
                                    this[index] = checked
                                }
                            }
                        )
                        Text(
                            text = day,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF030303),
                                textAlign = TextAlign.Start,
                            )
                        )
                    }
                }
            }
            NotificationRowItem()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ButtonItem2(
                    text = "Batal",
                    icon = Icons.Default.Close,
                    onClick = {},
                    navController = rememberNavController(),
                )
                Spacer(modifier = Modifier.weight(1f))
                ButtonItem1(
                    text = "Simpan",
                    icon = Icons.Default.Add,
                    onClick = {},
                    navController = rememberNavController(),
                )
            }
        }
    }
}

@Composable
fun NotificationRowItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        //.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Notification",
            modifier = Modifier.height(21.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF030303),
                textAlign = TextAlign.Start,
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        SwitchItem()
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationRowItemPreview() {
    NotificationRowItem()
}

@Preview(showBackground = true)
@Composable
private fun ColumnEditPlanPreview() {
    ColumnEditPlan()
}