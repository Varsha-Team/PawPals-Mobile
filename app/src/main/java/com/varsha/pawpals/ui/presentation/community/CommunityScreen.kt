package com.varsha.pawpals.ui.presentation.community

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varsha.pawpals.data.DataCommunity
import com.varsha.pawpals.model.Community
import com.varsha.pawpals.ui.presentation.component.FilterCommunity
import com.varsha.pawpals.ui.presentation.component.PostCommunity
import com.varsha.pawpals.ui.presentation.component.ScaffoldProfile
import com.varsha.pawpals.ui.presentation.component.SearchTextFieldItem

@Composable
fun CommunityScreen(
    community: List<Community> = DataCommunity.DataCommunity,
    modifier: Modifier = Modifier
) {

    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            ScaffoldProfile()
        }
    ) {contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .background(color = Color(0xFFFBEDEC))
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                SearchTextFieldItem(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = "Search",
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                ) {
                    FilterCommunity()
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(){
                    items(community){
                        PostCommunity(posted = it)

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
    CommunityScreen()
}