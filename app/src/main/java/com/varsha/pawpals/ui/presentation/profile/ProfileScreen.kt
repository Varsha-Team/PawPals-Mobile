package com.varsha.pawpals.ui.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.DataUser
import com.varsha.pawpals.R
import com.varsha.pawpals.model.UserData
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackClicked: () -> Unit
) {
    val profil = DataUser.User

    Scaffold(
        modifier = Modifier.padding(16.dp),
        topBar = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(86.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box (
                    modifier = Modifier.border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                ){
                    IconButton(onClick = onBackClicked) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back")
                    }
                }
                TopAppBar(title = { Text(text = "Profil") })
            }
        },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = profil.photo),
                    contentDescription = "Profil Photo",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = profil.nama,
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 40.dp)
                )
                PetRowContent()
                ProfilContent()
            }
        }
    }
}

@Composable
fun ProfilContent(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 0.dp)
//            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
//            .width(324.dp)
//            .height(192.dp)
//            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
//            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row (
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Edit Profil",
                        modifier = Modifier.width(180.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                )
            }

            Row (
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Notification",
                        modifier = Modifier.width(180.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                )
            }

            Row (
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Logout,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Logout",
                        modifier = Modifier.width(180.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun PetRowContent(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(32.dp, 16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_pawpals),
                contentDescription = "Profil Photo",
                //contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Jumlah Pets",
                    fontSize = 25.sp,
                    lineHeight = 19.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm)),
                    fontWeight = FontWeight(600),
                )
                Text(
                    text = "2",
                    fontSize = 42.sp,
                    lineHeight = 19.sp,
                    //fontFamily = FontFamily(Font(R.font.ibm)),
                    fontWeight = FontWeight(600),
                )
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(onBackClicked = {})
}