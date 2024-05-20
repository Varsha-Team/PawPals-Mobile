package com.varsha.pawpals.ui.presentation.auth


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun RegisterScreen (
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmpass by rememberSaveable { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            // .padding(it)
            .background(
                color = Color(android.graphics.Color.parseColor("#f9dcd3"))
            )
    ) {
        Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
            verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            // .padding(25.sp)
        ) {
            Text(
                text = "Register",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color(android.graphics.Color.parseColor("#D05440")),
                modifier = Modifier
                    .padding(15.dp)
            )
            Column(
                modifier = Modifier
                    .padding(32.dp, 0.dp)
            ) {
                Text(
                    text = "Username",
                    modifier = Modifier
                        .width(78.dp)
                        .height(21.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF030303),
                        textAlign = TextAlign.Center,
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
            ){
                Text(
                    text = "Email",
                    modifier = Modifier
                        .width(54.dp)
                        .height(21.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF030303),
                        textAlign = TextAlign.Center,
                    )
                )
                TextFieldItem(
                    value = email,
                    onValueChange = { email = it },
                    label = "Enter Email",
                    keyboardType = KeyboardType.Text,
                )
            }

            Column(
                modifier = Modifier
                    .padding(32.dp, 0.dp)
            ) {
                Text(
                    text = "Kata Sandi",
                    modifier = Modifier
                        .width(78.dp)
                        .height(21.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center
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
                    text = "Konfirmasi Kata Sandi",
                    modifier = Modifier
                        .width(148.dp)
                        .height(21.dp),
                        style = TextStyle(
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.ibm plex sans)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center
                    )
                )
                TextFieldItem(
                    value = confirmpass,
                    onValueChange = { confirmpass = it },
                    label = "Enter Password",
                    keyboardType = KeyboardType.Text,
                    isPassword = true
                )
            }


            Button(
                onClick = { navController.navigate(Screen.Home.route) },
                colors = ButtonDefaults.buttonColors(
                    Color(android.graphics.Color.parseColor("#D05440"))
                ),
                modifier = Modifier

                    .width(194.dp)
                    .height(60.dp)
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "Register",
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

            Text(
                text = "Sudah punya akun?  Login",
                modifier = Modifier.clickable { navController.navigate(Screen.Login.route) },
                style = TextStyle(
                    fontSize = 14.sp,
                    //   fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color(0xCC000000),
                )
            )
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPrev() {
    PawPalsTheme {
        RegisterScreen(navController = rememberNavController())
    }
}