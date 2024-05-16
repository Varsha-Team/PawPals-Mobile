package com.varsha.pawpals.data

import com.varsha.pawpals.R
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel

object DataArticle {
    val DataArtikel = listOf(
        Artikel(
                id = 1,
                title = "Kucing",
                photo = R.drawable.logo_pawpals,
                description = "Sangat Menggemaskan"
        ),
        Artikel(
            id = 2,
            title = "Kucing",
            photo = R.drawable.logo_pawpals,
            description = "Sangat Menggemaskan"
        ),
    )

    val kategoriArtikel = listOf(
        KategoriArtikel(
            id = 1,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        ),
        KategoriArtikel(
            id = 2,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        ),
        KategoriArtikel(
            id = 3,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        ),
        KategoriArtikel(
            id = 4,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        ),
        KategoriArtikel(
            id = 5,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        )
    )
}