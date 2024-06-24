package com.varsha.pawpals.ui.presentation.community.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.community.component.CategoryPost
import com.varsha.pawpals.utils.savePostToFirestore

@Composable
fun PostComponent(navController: NavController) {
    val profilePicture = painterResource(id = R.drawable.profile_photo)
    var textState by remember { mutableStateOf("") }
    var titleState by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = profilePicture,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Hi Varsha",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // TextField for Title
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                BasicTextField(
                    value = titleState,
                    onValueChange = { titleState = it },
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            if (titleState.isEmpty()) {
                                Text(
                                    text = "Masukkan judul ...",
                                    style = TextStyle(color = Color.Gray)
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }

        // TextField for Content
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(300.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                BasicTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .height(240.dp)
                                .padding(top = 8.dp)
                        ) {
                            if (textState.isEmpty()) {
                                Text(
                                    text = "Apa yang ingin anda posting? ...",
                                    style = TextStyle(color = Color.Gray)
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(
                        imageVector = Icons.Default.AddPhotoAlternate,
                        contentDescription = "Icon Tambah",
                        tint = Color(0xFFED6A09)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.EmojiEmotions,
                        contentDescription = "Logo Emoji",
                        tint = Color(0xFFED6A09)
                    )
                }
            }
        }

        CategoryPost(selectedCategory = selectedCategory, onCategorySelected = { selectedCategory = it })
    }

    // Floating Action Button
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = {
                if (titleState.isEmpty() || textState.isEmpty()) {
                    showSnackbar = true
                } else {
                    savePostToFirestore(titleState, textState, selectedCategory)
                    navController.navigate(Screen.Community.route)
                }
            },
            containerColor = Color(0xFFED6A09),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kirim",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }

        if (showSnackbar) {
            Snackbar(
                modifier = Modifier.padding(8.dp),
                action = {
                    TextButton(onClick = { showSnackbar = false }) {
                        Text("OK", color = Color.White)
                    }
                },
                content = {
                    Text("Judul atau Konten tidak boleh kosong", color = Color.White)
                },
                containerColor = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostComponent() {
    PostComponent(navController = rememberNavController())
}
