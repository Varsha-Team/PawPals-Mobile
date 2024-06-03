package com.varsha.pawpals.ui.presentation.article.componentArticle

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun ArticleItem(
    kategoriArtikel: KategoriArtikel,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
  //  modifier: (Any) -> Unit = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onItemClicked(kategoriArtikel.id) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = kategoriArtikel.tagname,
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
                    contentDescription = "Back"
                )

            }





        }

        Card(
            shape = RoundedCornerShape(25.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .padding(bottom = 16.dp, end = 16.dp)
                .clickable { onItemClicked(kategoriArtikel.id) }
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(200.dp)
                    .width(328.dp)
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
                        painter = painterResource(id = kategoriArtikel.photo),
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
                        text = kategoriArtikel.title,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(end = 16.dp)
                    )
                }
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
private fun ArticleItemPrev() {
    PawPalsTheme {
        ArticleItem(
            kategoriArtikel = KategoriArtikel(
                1,
                "Pet Health",
                R.drawable.article_dog,
                "Health care for your pets service"
            ),
            onItemClicked = { kategoriArtikelId -> println("Kategori Id : $kategoriArtikelId") }
        )
    }
    
}