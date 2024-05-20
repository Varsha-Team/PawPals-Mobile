package com.varsha.pawpals.ui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.varsha.pawpals.R
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.navigation.Screen

@Composable
fun HomeArticle(
    modifier: Modifier = Modifier,
    navController: NavController,
    article: List<KategoriArtikel> = DataArticle.kategoriArtikel,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(Screen.Article.route) }
        ) {
            Text(
                text = "Artikel",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier

            ) {
                Text(text = "Semua")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Icon Panah Kanan",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
        ) {
            items(article){
                LazyArticle(article = it)
            }
        }

    }
}

@Composable
fun LazyArticle(
    article: KategoriArtikel,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(end = 16.dp)
            .clickable {  }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(200.dp)
                .width(300.dp)
                .fillMaxWidth()
                .border(1.dp, Color.Transparent, RoundedCornerShape(25.dp))
        ) {
            Box(
                modifier = Modifier
                    .background(
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        ), color = Color.Gray
                    )
                    .fillMaxWidth()
                    .size(150.dp)
            ) {
                Image(
                    painter = painterResource(id = article.photo),
                    contentDescription = "Gambar Sampul Artikel",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        )
                        .fillMaxSize()
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 14.dp)
            ) {
                Spacer(modifier = modifier.width(16.dp))
                Text(
                    text = article.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(end = 16.dp)
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun HomeArticlePreview() {
 //   HomeArticle()
    LazyArticle(article = KategoriArtikel(
        1,
        "a",
        R.drawable.article_dog,
        "Cara Merawat Anak Anjing Seperti Anak Sendiri"
    ))
}