package com.varsha.pawpals.ui.presentation.article

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.varsha.pawpals.R
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.data.DataArticle.kategoriArtikel
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.ui.presentation.article.componentArticle.TagItem
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun DetailArticleScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    artikelId: Int?,
   // kategoriArtikelId: Int?
) {
    val newArtikelList = DataArticle.DataArtikel.filter {
        artikel -> artikel.id == artikelId
    }
//    val newKategoriList = DataArticle.kategoriArtikel.filter {
//        kategoriArtikel -> kategoriArtikel.id == kategoriArtikelId
//    }
    Column(modifier = modifier) {
        DetailArticleContent(
            newArtikelList = newArtikelList,
            //newKategoriList = newKategoriList,
            navController = navController
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailArticleContent(
    newArtikelList: List<Artikel>,
//    kategoriArtikels: List<KategoriArtikel> = DataArticle.kategoriArtikel,
//    newKategoriList: List<KategoriArtikel>,

    modifier: Modifier = Modifier,
    navController: NavController
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
    ){contentPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(17.4384765625.dp, Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
                .padding(contentPadding)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newArtikelList[0].photo)
                    .build(),
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    )
                    .width(302.dp)
                    .height(155.dp),
                contentDescription = "Ilustrasi artikel",
                contentScale = ContentScale.FillBounds

            )
            // Spacer(modifier = modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                TagItem(
                    kategoriArtikel = KategoriArtikel(1,"Pet Health",
                        R.drawable.article_dog,
                        "Health care for your pet service")
                )
//                Box(
////                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
////                verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
////                    .width(76.dp)
////                    .height(30.dp)
//                        .background(
//                            color = Color(0xFFD95D39),
//                            shape = RoundedCornerShape(size = 5.dp)
//                        )
//                        .padding(start = 8.dp, top = 6.dp, end = 8.dp, bottom = 6.dp)
//                ) {
//                    Text(
//                        text =  newKategoriList[0].tagname,
//                        // xss/xxs-text-semi bold
//                        style = TextStyle(
//                            fontSize = 10.sp,
//                            fontWeight = FontWeight(600),
//                            color = Color(0xFFFFFFFF),
//                        )
//                    )
//                }
                Text(
                    text = newArtikelList[0].title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF272727),
                    )
                )
                Text(
                    text = "03 Maret 2024",

                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6D6F77),
                        textAlign = TextAlign.Center,
                    )
                )
            }
            //Spacer(modifier = modifier.padding(0.dp))
            Text(
                text = newArtikelList[0].description,
                // sm/text/sm-text-regular
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Justify,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                // .width(323.dp)
                //.height(1218.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailArticlePrev() {
    PawPalsTheme {
        DetailArticleContent(
            navController = rememberNavController(),
            newArtikelList = DataArticle.DataArtikel,
            //newKategoriList = DataArticle.kategoriArtikel
        )
    }
}