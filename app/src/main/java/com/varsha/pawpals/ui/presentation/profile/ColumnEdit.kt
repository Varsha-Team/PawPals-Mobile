package com.varsha.pawpals.ui.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.varsha.pawpals.ui.presentation.component.TextFieldItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnEdit(
    modifier: Modifier = Modifier
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomor by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var newpass by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(0.dp, 24.dp)
        //.background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        )
        {
            Text(
                text = "Nama",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldItem(
                value = username,
                onValueChange = { username = it },
                label = "Enter Username",
                keyboardType = KeyboardType.Text,
            )
        }

        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF030303),
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldItem(
                value = email,
                onValueChange = { email = it },
                label = "Enter Email",
                keyboardType = KeyboardType.Text,
            )
        }

        Column (
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ){
            Text(
                text = "Nomor Telp",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start,
                )
            )
            TextFieldItem(
                value = nomor,
                onValueChange = { nomor = it },
                label = "Masukkan nomor telp",
                keyboardType = KeyboardType.Text,
            )
        }

        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Kata Sandi Lama",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start
                )
            )
            TextFieldItem(
                value = password,
                onValueChange = { password = it },
                label = "Enter Password",
                keyboardType = KeyboardType.Text,
                isPassword = true
            )
        }

        Column(
            modifier = Modifier
                .padding(32.dp, 0.dp)
        ) {
            Text(
                text = "Kata Sandi Baru",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Start
                )
            )
            TextFieldItem(
                value = newpass,
                onValueChange = { newpass = it },
                label = "Enter Password New",
                keyboardType = KeyboardType.Text,
                isPassword = true
            )
        }


        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                Color(android.graphics.Color.parseColor("#D05440"))
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
                    //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ColumnEditPreview() {
    ColumnEdit()
}