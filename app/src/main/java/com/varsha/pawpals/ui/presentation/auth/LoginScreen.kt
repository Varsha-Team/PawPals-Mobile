package com.varsha.pawpals.ui.presentation.auth


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.TextFieldItem
import com.varsha.pawpals.ui.theme.PawPalsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen (
    modifier: Modifier = Modifier,
    navController: NavController
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
                    color = Color.White
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
                    color = Color(0xFFED6A09),
                    modifier = Modifier
                        .padding(15.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(32.dp, 0.dp)
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
                    TextFieldItem(
                        value = textInput,
                        onValueChange = { textInput = it },
                        label = "Enter Username",
                        keyboardType = KeyboardType.Text,
                    )
                }

                Column (
                    modifier = Modifier
                        .padding(32.dp, 0.dp)
                ){
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
                                checkedColor = Color(0xFFED6A09),
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
                    onClick = { navController.navigate(Screen.Home.route) },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFED6A09)
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

                Row {
                    Text(
                        text = "Belum punya akun ? ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            //   fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xCC000000),

                            )
                    )
                    Text(
                        text = "Daftar",
                        modifier = Modifier
                            .clickable { navController.navigate(Screen.Register.route) },
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                            color = Color(0xCC000000)
                            ),
                        color = Color(0xFFED6A09)
                    )
                }

            }

        }

//    }
}

@Preview
@Composable
private fun LoginScreenPrev() {
    PawPalsTheme {
        LoginScreen(navController = rememberNavController())
    }
}