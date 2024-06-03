package com.varsha.pawpals.ui.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataCommunity
import com.varsha.pawpals.model.Community
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.component.FilterCommunity
import com.varsha.pawpals.ui.presentation.component.FilterIconItem
import com.varsha.pawpals.ui.presentation.component.PostCommunity
import com.varsha.pawpals.ui.presentation.component.SearchTextFieldItem

@Composable
fun CommunityScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    community: List<Community> = DataCommunity.DataCommunity,
) {

    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Komunitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFCE5628),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 16.dp)
                )
            }
        },
        floatingActionButton = {
            ButtonItem1(
                navController = navController,
                text = "Post",
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Screen.AddPet.route) },
                )
        }
    ) {contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
               // .background(color = Color(0xFFFBEDEC))
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SearchTextFieldItem(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = "Search",
                        keyboardType = KeyboardType.Text
                    )

                    FilterIconItem(
                        modifier = Modifier
                            .size(55.dp)
                    ) {}
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                ) {
                    FilterCommunity()
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(){
                    items(community, key = {it.id}){
                        PostCommunity(posted = it){ idCommunity ->
                            navController.navigate(Screen.CommunityDetail.route + "/$idCommunity")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }

    }
}

@Preview (showBackground = true)
@Composable
private fun CommunityScreenPreview() {
    CommunityScreen(navController = rememberNavController())
}