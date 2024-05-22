package com.varsha.pawpals.ui.presentation.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.article.componentArticle.ArticleItem
import com.varsha.pawpals.ui.presentation.component.SearchTextFieldItem
import com.varsha.pawpals.ui.theme.PawPalsTheme
@Composable
fun ArticleScreen(
    navController: NavController,
    kategoriArtikels: List<KategoriArtikel> = DataArticle.kategoriArtikel,
) {
    var searchQuery by remember { mutableStateOf("") }

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
                    text = "Artikel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .background(color = Color(0xFFFBEDEC))
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextFieldItem(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = "Search",
                keyboardType = KeyboardType.Text,
                modifier = Modifier.padding(start = 18.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier
                    .background(color = Color(0xFFFBEDEC))
            ) {
                items(kategoriArtikels, key = { it.id }) {
                    ArticleItem(kategoriArtikel = it) { kategoriArtikelId ->
                        navController.navigate(Screen.ExploreArticle.route + "/$kategoriArtikelId")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ArticleScreenPrev() {
    PawPalsTheme {
        ArticleScreen(
            navController = rememberNavController(),
            kategoriArtikels = DataArticle.kategoriArtikel
        )
    }
}