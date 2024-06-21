package com.varsha.pawpals.ui.presentation.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.article.componentArticle.ExploreArticleItem
import com.varsha.pawpals.ui.presentation.component.FilterArticle
import com.varsha.pawpals.ui.presentation.component.SearchTextFieldItem
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun ArticleScreen(
    navController: NavController,
    kategoriArtikels: List<KategoriArtikel> = DataArticle.kategoriArtikel,
    artikels: List<Artikel> = DataArticle.DataArtikel,
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val filteredArticles = artikels.filter { artikel ->
        val matchesCategory = selectedCategory == "All" || artikel.category == selectedCategory
        val matchesQuery = artikel.title.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesQuery
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Artikel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFCE5628),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextFieldItem(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = "Search",
                keyboardType = KeyboardType.Text,
                modifier = Modifier.padding(horizontal = 18.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "For you",
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF010911),
                )
            )
            FilterArticle(selectedCategory = selectedCategory, onCategorySelected = { selectedCategory = it })
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(filteredArticles, key = { it.id }) { artikel ->
                    ExploreArticleItem(artikel = artikel) { artikelId ->
                        navController.navigate(Screen.DetailArticle.route + "/$artikelId")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ArticleScreenPrev() {
    PawPalsTheme {
        ArticleScreen(
            navController = rememberNavController(),
            kategoriArtikels = DataArticle.kategoriArtikel
        )
    }
}
