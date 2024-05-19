package com.varsha.pawpals.ui.presentation.article.componentArticle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.pawpals.R
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.ui.theme.PawPalsTheme

@Composable
fun TagItem(
    modifier: Modifier = Modifier,
    kategoriArtikel: KategoriArtikel,
) {
    Box(
//                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
//                verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
//                    .width(76.dp)
//                    .height(30.dp)
            .background(
                color = Color(0xFFD95D39),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .padding(start = 8.dp, top = 6.dp, end = 8.dp, bottom = 6.dp)
    ) {
        Text(
            text = kategoriArtikel.tagname,
            // xss/xxs-text-semi bold
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
            )
        )
    }
}

@Preview
@Composable
private fun TagItemPrev() {
    PawPalsTheme {
        TagItem(
            kategoriArtikel = KategoriArtikel(1,"Pet Health",
            R.drawable.article_dog,
             "Health care for your pet service")
        )
    }
}