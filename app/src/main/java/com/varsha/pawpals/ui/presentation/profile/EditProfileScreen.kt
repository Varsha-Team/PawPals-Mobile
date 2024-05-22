package com.varsha.pawpals.ui.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.DataUser
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.theme.PawPalsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun EditProfileScreen(
    navController: NavController,
    //onBackClicked: () -> Unit
    //profile: UserData

) {
    val profil = DataUser.User

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEDEC))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Edit Profil",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .background(color = Color(0xFFFBEDEC)),
            ) {
                ManageProfile()
                LazyColumn (
                    modifier = Modifier
                        //.padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        //.background(Color(0xFFFBEDEC))
                        .background(Color.White)
                ){
                    item {
                        ColumnEdit(userData = DataUser.User)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditProfilPreview() {
    PawPalsTheme {
        EditProfileScreen(navController = rememberNavController())
    }
}