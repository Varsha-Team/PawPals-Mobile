package com.varsha.pawpals.ui.presentation.schedule.editPet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.varsha.pawpals.DataUser
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.schedule.addPet.ColumnEditPet
import com.varsha.pawpals.ui.theme.PawPalsTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable

fun EditPetScreen(
    onBackClicked: () -> Unit
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
                    text = "Edit Pet",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { /*TODO*/ },
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
                //ManageEditPet()
                LazyColumn (
                    modifier = Modifier
                        //.padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        //.background(Color(0xFFFBEDEC))
                        .background(Color.White)
                ){
                    item {
                        ColumnEditPet()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditPetScreenPreview() {
    PawPalsTheme {
        EditPetScreen(onBackClicked = {})
    }
}