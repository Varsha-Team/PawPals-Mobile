package com.varsha.pawpals.ui.presentation.article

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.varsha.pawpals.ui.theme.PawPalsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreArticleScreen(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier,
    kategoriArtikelId: Int?,
    //kategoriArtikels: List<KategoriArtikel> = DataArticle.kategoriArtikel,
//    newKategoriList: List<KategoriArtikel>,
//    artikels: List<Artikel> = DataArticle.DataArtikel,

) {
    val newKategoriList = DataArticle.kategoriArtikel.filter {
        kategoriArtikel -> kategoriArtikel.id == kategoriArtikelId
    }
    Column(modifier = modifier) {
        ExploreArticleScreenContent(navController = navController, newKategoriList = newKategoriList)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreArticleScreenContent(
    modifier: Modifier = Modifier,
    newKategoriList: List<KategoriArtikel>,
    artikels: List<Artikel> = DataArticle.DataArtikel,
    navController: NavController,
    //onBackClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(86.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp),
            ) {
                Box (
                    modifier = Modifier
                        .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                ){
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back")
                    }
                }
                TopAppBar(title = { Text(
                    text = "Article",
                    textAlign = TextAlign.Center
                ) })
            }
        }
    ) {contentPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
                .padding(2.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = newKategoriList[0].tagname,

                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF010911),
                    )
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier

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
private fun ExploreArticleScreenPrev() {
    PawPalsTheme {
        ExploreArticleScreenContent(
            navController = rememberNavController(),
            newKategoriList = DataArticle.kategoriArtikel,
            artikels = DataArticle.DataArtikel
        )
    }
}