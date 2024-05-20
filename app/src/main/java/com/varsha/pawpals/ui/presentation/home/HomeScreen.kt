package com.varsha.pawpals.ui.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.ui.presentation.component.ScaffoldProfile
import com.varsha.pawpals.ui.theme.backgroundDark
import com.varsha.pawpals.ui.theme.backgroundDarkHighContrast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            ScaffoldProfile()
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .background(color =  Color(0xFFFBEDEC))
                .verticalScroll(scrollState)
                .padding(contentPadding)
        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                HomePlanning()

                Spacer(modifier = Modifier.height(16.dp))

                HomeCommunity()

                Spacer(modifier = Modifier.height(16.dp))

                HomeArticle()

                Spacer(modifier = Modifier.height(16.dp))

                HomeCommunityText()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController(), modifier = Modifier)
}