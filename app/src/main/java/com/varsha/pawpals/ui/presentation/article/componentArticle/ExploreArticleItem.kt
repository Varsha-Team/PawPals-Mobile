package com.varsha.pawpals.ui.presentation.article.componentArticle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun ExploreArticleItem(
    modifier: Modifier = Modifier,
    artikel: Artikel,
    onItemClicked: (Int) -> Unit
    ) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(25.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable { onItemClicked(artikel.id) }
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(240.dp)
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
                        painter = painterResource(id = artikel.photo),
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
                Column(
                    modifier = Modifier
                        .padding(vertical = 14.dp)
                        .fillMaxSize()
                ) {
                    Spacer(modifier = modifier.width(16.dp))
                    Text(
                        text = artikel.title,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 2.dp, bottom = 4.dp, end = 4.dp)
                    )
                    Text(
                        text = artikel.description,
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 0.dp, end = 4.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA9ACB8),
                            textAlign = TextAlign.Justify,
                        )
                    )
                }
            }
        }



    }
}

@Preview
@Composable
private fun ExploreArticleItemPrev() {
    PawPalsTheme {
        ExploreArticleItem(artikel =Artikel(
            1, "Cara Memberi Makan Kucing Unik", R.drawable.article_dog,
           "Bagaimana Cara Merencanakan Jadwal Makan Kucing Saya?\n" +
                    "Anda  dapat membagi diet harian kucing Anda menjadi dua bagian utama dengan  jeda tidak lebih dari 12 jam. Atau, Anda dapat membagi waktu makan  mereka menjadi beberapa kali  mulai dari sarapan, makan siang, dan makan  malam. Namun, pastikan bahwa makanan yang Anda berikan dapat memenuhi  kalori dan nutrisi lainnya, tidak lebih atau kurang dari yang  direkomendasikan."

        ),
            onItemClicked =  { artikelId -> println("Artikel Id : $artikelId") }
            )
    }
}