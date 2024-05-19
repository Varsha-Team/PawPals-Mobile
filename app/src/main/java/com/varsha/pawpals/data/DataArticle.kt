package com.varsha.pawpals.data

import com.varsha.pawpals.R
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel

object DataArticle {
    val DataArtikel = listOf(
        Artikel(
                id = 1,
                title = "Cara Memberi Makan Kucing Unik",
                photo = R.drawable.mrfresh,
                description = "Bagaimana Cara Merencanakan Jadwal Makan Kucing Saya?\n" +
                        "Anda  dapat membagi diet harian kucing Anda menjadi dua bagian utama dengan  jeda tidak lebih dari 12 jam. Atau, Anda dapat membagi waktu makan  mereka menjadi beberapa kali  mulai dari sarapan, makan siang, dan makan  malam. Namun, pastikan bahwa makanan yang Anda berikan dapat memenuhi  kalori dan nutrisi lainnya, tidak lebih atau kurang dari yang  direkomendasikan."
        ),
        Artikel(
            id = 2,
            title = "Kucing",
            photo = R.drawable.article_food,
            description = "Bagaimana Cara Merencanakan Jadwal Makan Kucing Saya?\n" +
                    "Anda  dapat membagi diet harian kucing Anda menjadi dua bagian utama dengan  jeda tidak lebih dari 12 jam. Atau, Anda dapat membagi waktu makan  mereka menjadi beberapa kali  mulai dari sarapan, makan siang, dan makan  malam. Namun, pastikan bahwa makanan yang Anda berikan dapat memenuhi  kalori dan nutrisi lainnya, tidak lebih atau kurang dari yang  direkomendasikan."

        ),
        Artikel(
            id = 3,
            title = "Anjind",
            photo = R.drawable.article_dog,
            description = "Bagaimana Cara Merencanakan Jadwal Makan Kucing Saya?\n" +
                    "Anda  dapat membagi diet harian kucing Anda menjadi dua bagian utama dengan  jeda tidak lebih dari 12 jam. Atau, Anda dapat membagi waktu makan  mereka menjadi beberapa kali  mulai dari sarapan, makan siang, dan makan  malam. Namun, pastikan bahwa makanan yang Anda berikan dapat memenuhi  kalori dan nutrisi lainnya, tidak lebih atau kurang dari yang  direkomendasikan."

        ),
    )

    val kategoriArtikel = listOf(
        KategoriArtikel(
            id = 1,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Health care for your pet service"
        ),
        KategoriArtikel(
            id = 2,
            tagname = "Pet Food",
            photo = R.drawable.article_food,
            title = "Health food for your pets"
        ),
        KategoriArtikel(
            id = 3,
            tagname = "Pet Fashion",
            photo = R.drawable.article_fashion,
            title = "High fashion for your pets"
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