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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.pawpals.R
import com.varsha.pawpals.data.DataCommunity
import com.varsha.pawpals.model.Community
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.utils.getPostsFromFirestore
import kotlinx.coroutines.launch

@Composable
fun HomeCommunityText(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var communityPosts by remember { mutableStateOf<List<Community>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val posts = getPostsFromFirestore()
            communityPosts = posts.map {
                Community(
                    id = it.timestamp.toInt(),
                    user = "Anonymous", // Ganti dengan user sebenarnya jika tersedia
                    userPhoto = null,
                    title = it.title,
                    content = it.content,
                    picture = null,
                    muchLike = 0,
                    muchComment = 0,
                    time = (System.currentTimeMillis() - it.timestamp).toInt() / 60000, // Hitung waktu dalam menit
                    date = "Unknown" // Ganti dengan tanggal sebenarnya jika tersedia
                )
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Komunitas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { }
            ) {
                Text(text = "Semua")
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "Icon Panah Kanan",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.background(color = Color.White)
        ) {
            items(communityPosts) { post ->
                LazyCommunity(community = post)
            }
        }
    }
}


@Composable
fun LazyCommunity(
    community : Community,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
//            .padding(16.dp)
            .padding(horizontal = 8.dp)
            .width(325.dp)
            .height(160.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.profile_photo), // Replace with your image resource
                    contentDescription = "Foto Profil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(24.dp))
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = community.user,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .height(46.dp)
                    .border(1.dp, Color.Transparent, RectangleShape)
            ) {
                Text(
                    text = community.content,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = community.date,
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeCommunityPreview() {
    LazyCommunity(
        community = Community(
            id = 1,
            user = "Danir",
            userPhoto = null,
            title = "Cara Merawat Anjing Yang Menjengkelkan Hingga Mau Dibuang Ke laut",
            content = "Merawat anjing bisa menjadi pengalaman yang memuaskan, meskipun mungkin ada tantangan yang harus dihadapi. Namun, membuang anjing ke laut bukanlah pilihan yang baik dan bahkan bisa menjadi ilegal di banyak tempat. Sebagai gantinya, berikut adalah beberapa tips untuk merawat anjing yang mungkin membuatnya kurang menjengkelkan...",
            time = 1,
            picture = null,
            muchLike = 100,
            muchComment = 200,
            date = "5 Mei 2024"
        )
    )
}