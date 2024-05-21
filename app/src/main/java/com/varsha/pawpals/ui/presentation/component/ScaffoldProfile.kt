package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.DataUser
import com.varsha.pawpals.R
import com.varsha.pawpals.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldProfile(
    navController: NavController,
    modifier: Modifier = Modifier

) {
    val profile = DataUser.User
    TopAppBar(
        title = {
            Text(
                text = "Hi " + profile.nama,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.profile_photo),
                contentDescription = "Foto Profile User",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .clip(CircleShape)
                    .size(50.dp)
                    .fillMaxSize()
                    .clickable { navController.navigateUp() }
            )
        },
        actions = {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.Notification.route) },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Outlined.NotificationsNone,
                        contentDescription = "Icon Notifikasi",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFFBEDEC)
            //containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
    )
}

@Preview (showBackground = true)
@Composable
private fun ScaffoldProfilePreview() {
    ScaffoldProfile(navController = rememberNavController())
}