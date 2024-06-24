package com.varsha.pawpals.ui.presentation.schedule.editPlan

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.model.alarm.scheduleNotification
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.component.ButtonItem2
import com.varsha.pawpals.ui.presentation.component.ScheduleTimeTextField
import com.varsha.pawpals.ui.presentation.component.SwitchItem
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import com.varsha.pawpals.ui.presentation.component.TimePickerDialog
import com.varsha.pawpals.utils.AlarmData
import com.varsha.pawpals.utils.SQLiteHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnEditPlan(
    navController: NavController,
    petId: Int,
    modifier: Modifier = Modifier
) {
    Log.d("ColumnEditPlan", "Received petId: $petId")
    val context = LocalContext.current
    val dbHelper = remember { SQLiteHelper(context) }

    var planname by remember { mutableStateOf("") }
    var scheduleTime by rememberSaveable { mutableStateOf("") }
    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }
    var daysSelected by rememberSaveable { mutableStateOf(List(7) { false }) }
    val daysOfWeek = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 8.dp
            ) {
                TimePickerDialog(
                    onDismissRequest = { showTimePicker = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                scheduleTime = String.format("%02d:%02d", timePickerState.hour, timePickerState.minute)
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
                text = "Pilih Waktu",
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
                text = "Waktu",
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
            ScheduleTimeTextField(
                value = scheduleTime,
                onValueChange = { scheduleTime = it },
                label = "00:00",
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
                                daysSelected = daysSelected.toMutableList().apply { this[index] = checked }
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
                modifier = Modifier.fillMaxWidth()
            ) {
                ButtonItem2(
                    text = "Batal",
                    icon = Icons.Default.Add,
                    onClick = { navController.navigateUp() },
                    navController = rememberNavController(),
                )
                Spacer(modifier = Modifier.weight(1f))
                ButtonItem1(
                    text = "Simpan",
                    icon = Icons.Default.Add,
                    onClick = {
                        if (planname.isNotEmpty() && scheduleTime.isNotEmpty()) {
                            val alarmData = AlarmData(
                                petId = petId,
                                name = planname,
                                time = scheduleTime,
                                days = daysSelected
                            )
                            dbHelper.addAlarm(alarmData)
                            scheduleNotification(
                                context = context,
                                timePickerState = timePickerState,
                                daysSelected = daysSelected,
                                title = planname
                            )
                            Toast.makeText(context, "Alarm berhasil disimpan", Toast.LENGTH_SHORT).show()
                            navController.navigateUp()
                        } else {
                            Toast.makeText(context, "Nama plan dan waktu tidak boleh kosong", Toast.LENGTH_SHORT).show()
                        }
                    },
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
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Notification",
            modifier = Modifier.height(21.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFED6A09),
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
    ColumnEditPlan(navController = rememberNavController(), petId = 1)

}