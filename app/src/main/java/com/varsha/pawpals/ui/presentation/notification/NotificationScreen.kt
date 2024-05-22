package com.varsha.pawpals.ui.presentation.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.data.DataArticle
import com.varsha.pawpals.data.DataNotification
import com.varsha.pawpals.model.KategoriArtikel
import com.varsha.pawpals.model.Notification
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.article.componentArticle.ArticleItem
import com.varsha.pawpals.ui.presentation.component.BackIconItem

@Composable
fun NotificationScreen(
    navController: NavController,
    notifications: List<Notification> = DataNotification.DataNotification,
    modifier: Modifier = Modifier,

    ) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBEDEC))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Notifikasi",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF973B2C),
                    modifier = Modifier.align(Alignment.Center)
                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    ){contentPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
               // .background(Color(0xFFFBEDEC))
                .padding(16.dp)
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Box(
                modifier = Modifier,
                ){
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    modifier = Modifier
                        .background(color = Color(0xFFFBEDEC))
                ) {
                    items(notifications, key = { it.id }) {
                        SystemNotificationItem(notification = it, modifier = Modifier)
                        Divider(
                            color = Color(0xFFEB8479),
                            modifier = Modifier
                            .padding(vertical = 8.dp, )
                        )
                    }
                }
            }

        }
    }


}

@Preview (showBackground = true)
@Composable
private fun NotificationScreenPreview() {
    NotificationScreen(navController = rememberNavController())
}