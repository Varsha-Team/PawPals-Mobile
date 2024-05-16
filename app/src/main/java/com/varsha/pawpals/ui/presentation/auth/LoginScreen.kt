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
fun LoginScreen (
    modifier: Modifier = Modifier
) {
    var textInput by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val checkedState = remember { mutableStateOf(true) }

  //  Scaffold(
//        floatingActionButton = {
//            LargeFloatingActionButton(
//                onClick = { /*do something*/ },
//                shape = CircleShape
//            ) {
//                IconButton(onClick = { /*do something*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.Add,
//                        contentDescription = "Add Icon"
//                    )
//                }
//            }
//        },
//        modifier = modifier
  //  ) {
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
                    text = "Login",
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


                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(android.graphics.Color.parseColor("#D05440")),
                                //uncheckedColor = Color.White
                            )
                        )
                        Text(
                            text = "Ingat saya",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    Text(
                        text = "Lupa Kata Sandi?",
//                      fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {  }
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
                        text = "Login",
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

                Row(
                    horizontalArrangement = Arrangement.spacedBy(11.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Child views.

                    Text(
                        text = "atau dengan",
                        style = TextStyle(
                            fontSize = 18.sp,
                            //   fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xCC000000),

                            )
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .width(120.dp)
                        .height(52.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_fb),
                        contentDescription = "icon fb",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            //.shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                            .padding(0.dp)
                            .width(52.dp)
                            .height(52.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logo_google),
                        contentDescription = "icon fb",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            // .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                            .padding(0.dp)
                            .width(52.dp)
                            .height(52.dp)
                            .clip(CircleShape)
                    )
                }

                Text(
                    text = "Belum punya akun?  Daftar",
                    style = TextStyle(
                        fontSize = 14.sp,
                        //   fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(400),
                        color = Color(0xCC000000),
                    )
                )

            }

        }

//    }
}

@Preview
@Composable
private fun LoginScreenPrev() {
    PawPalsTheme {
        LoginScreen()
    }
}