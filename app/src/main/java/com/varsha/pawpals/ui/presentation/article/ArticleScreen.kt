package com.varsha.pawpals.ui.presentation.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.article.componentArticle.ArticleItem
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

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //  .background(Color(0xFFFBEDEC))
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
                //.background(color = Color(0xFFFBEDEC))
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Breaking news",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF010911),
                    )
                )
                // Spacer(modifier = Modifier.padding(end = 40.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                ) {
                    Text(
                        text = "Semua",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF010911),
                        )
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "Back",
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    )

                }





            }
//            LazyRow(
//               // verticalArrangement = Arrangement.spacedBy(0.dp),
//                modifier = Modifier
//                  //  .background(color = Color(0xFFFBEDEC))
//            ) {
//                items(kategoriArtikels, key = { it.id }) {
//                    ArticleItem(kategoriArtikel = it) { kategoriArtikelId ->
//                        navController.navigate(Screen.ExploreArticle.route + "/$kategoriArtikelId")
//                    }
//                }
//            }

            Text(
                text = "For you",
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF010911),
                )
            )
            FilterArticle()
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                items(artikels, key = { it.id }) { artikel ->
                    ExploreArticleItem(artikel = artikel) { artikelId ->
                        navController.navigate(Screen.DetailArticle.route + "/$artikelId")
                    }
                }
//                items(artikels, key = { it.id }) { artikel ->
//                    ExploreArticleItem(artikel = artikel, kategoriArtikelId = kategoriArtikelId!!) { artikelId, kategoriId ->
//                        navController.navigate(Screen.DetailArticle.route + "/$artikelId/$kategoriId")
//                    }
//                }
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