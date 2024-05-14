package com.varsha.pawpals.ui.presentation.auth


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.ui.theme.PawPalsTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen (
    modifier: Modifier = Modifier
) {
    var textInput by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

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
                    .width(315.dp)
                    .height(75.dp)
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
                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    label = { Text(
                        "Enter Username",
                        fontSize = 12.sp,
                    ) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = androidx.compose.ui.graphics.Color.White
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0x66000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .width(312.dp)
                        .height(48.dp)
                        .padding(0.5.dp)
                )
            }

            Column(
                modifier = Modifier
                    .width(315.dp)
                    .height(75.dp)
            ) {
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
                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    label = { Text(
                        "Enter Email",
                        fontSize = 12.sp,
                    ) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = androidx.compose.ui.graphics.Color.White
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0x66000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .width(312.dp)
                        .height(48.dp)
                        .padding(0.5.dp)
                )
            }

            Column {
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
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(
                        "Enter Password",
                        fontSize = 12.sp,
                    ) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = androidx.compose.ui.graphics.Color.White
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0x66000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .width(312.dp)
                        .height(48.dp)
                        .padding(0.5.dp)
                )
            }

            Column {
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
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(
                        "Enter Password",
                        fontSize = 12.sp,
                    ) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = androidx.compose.ui.graphics.Color.White
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0x66000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .width(312.dp)
                        .height(48.dp)
                        .padding(0.5.dp)
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
        RegisterScreen()
    }
}