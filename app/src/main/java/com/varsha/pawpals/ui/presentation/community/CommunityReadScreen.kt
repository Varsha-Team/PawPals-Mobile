package com.varsha.pawpals.ui.presentation.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.varsha.pawpals.R
import com.varsha.pawpals.data.DataCommunity
import com.varsha.pawpals.model.Community
import com.varsha.pawpals.model.FireBaseCommunity
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.component.BackIconItem
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.utils.getPostFromFirestore
import kotlinx.coroutines.launch

@Composable
fun CommunityDetail(
    modifier: Modifier = Modifier,
    navController: NavController,
    idCommunity: String?
) {
    var post by remember { mutableStateOf<FireBaseCommunity?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(idCommunity) {
        coroutineScope.launch {
            if (idCommunity != null) {
                val postFromFirestore = getPostFromFirestore(idCommunity)
                post = postFromFirestore
            }
        }
    }

    post?.let { detailPost ->
        CommunityReadScreen(
            detailCommunity = listOf(
                Community(
                    id = detailPost.timestamp.toInt(),
                    user = "Anonymous",
                    userPhoto = null,
                    title = detailPost.title,
                    content = detailPost.content,
                    picture = null,
                    muchLike = 0,
                    muchComment = 0,
                    time = (System.currentTimeMillis() - detailPost.timestamp).toInt() / 60000,
                    date = "Unknown"
                )
            ),
            navController = navController
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityReadScreen(
    detailCommunity: List<Community>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Komunitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFED6A09),
                    modifier = Modifier.align(Alignment.Center)

                )
                BackIconItem(
                    onBackClicked = { navController.navigateUp() },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        },
        floatingActionButton = {
            ButtonItem1(
                navController = navController,
                text = "Post",
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Screen.PostScreen.route) },
            )
        }
    ) { contentPaddding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(contentPaddding)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                   // .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000)).shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                       // .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_photo),
                            contentDescription = "Avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color.Gray)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = detailCommunity[0].user,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "${detailCommunity[0].time} menit yang lalu",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = detailCommunity[0].title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFFED6A09)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    if (detailCommunity[0].picture != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(data = detailCommunity[0].picture)
                                .build(),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentDescription = "Gambar Detail Drama",
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    Text(
                        text = detailCommunity[0].content,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Justify,
                        color = Color(0xFF6D6F77)
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

                        var sheetState = rememberModalBottomSheetState()
                        var showBottomSheet by remember { mutableStateOf(false) }

                        Icon(
                            imageVector = Icons.Default.Message,
                            contentDescription = "Comment",
                            tint = Color.Gray,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { showBottomSheet = true }

                        )

                        if (showBottomSheet) {
                            ModalBottomSheet(
                                onDismissRequest = { showBottomSheet = false },
                                containerColor = Color.White,
                                modifier = Modifier
                                    .imePadding()
                            ) {
                                BottomSheetContent()
                                sheetState = sheetState
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CommunityREadScreenPreview() {
    CommunityReadScreen(
        detailCommunity = DataCommunity.DataCommunity,
        navController = rememberNavController()
    )
}