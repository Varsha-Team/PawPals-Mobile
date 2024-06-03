package com.varsha.pawpals.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.pawpals.model.Community

@Composable
fun PostCommunity(
    posted: Community,
    onItemClicked: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(20.dp))
            .clickable { onItemClicked(posted.id) }
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
        ) {
            Text(
                text = posted.user,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = "${posted.time} Menit Yang Lalu",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = posted.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            color = Color(0xFFCE5628)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = posted.content,
            maxLines = 3,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Like",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.Message,
                contentDescription = "Comment",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PostCommunityReview() {
    PostCommunity(
        posted = Community(
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
        ),
        onItemClicked = {}
    )
}