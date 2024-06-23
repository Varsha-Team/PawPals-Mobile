package com.varsha.pawpals.ui.presentation.community

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.pawpals.model.Community
import com.varsha.pawpals.model.FireBaseCommunity
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.community.component.FilterCommunity
import com.varsha.pawpals.ui.presentation.component.ButtonItem1
import com.varsha.pawpals.ui.presentation.component.PostCommunity
import com.varsha.pawpals.ui.presentation.component.SearchTextFieldItem
import com.varsha.pawpals.utils.deletePostFromFirestore
import com.varsha.pawpals.utils.getPostsFromFirestore
import kotlinx.coroutines.launch

@Composable
fun CommunityScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    community: List<Community> = emptyList(),
) {
    var selectedCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }
    var posts by remember { mutableStateOf<List<FireBaseCommunity>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(selectedCategory, searchQuery) {
        coroutineScope.launch {
            Log.d("CommunityScreen", "Fetching posts for category: $selectedCategory and search query: $searchQuery")
            val newPosts = getPostsFromFirestore(selectedCategory, searchQuery)
            posts = newPosts
            Log.d("CommunityScreen", "Fetched ${newPosts.size} posts")
        }
    }


    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Komunitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFED6A09),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 16.dp)
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
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                SearchTextFieldItem(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = "Search",
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Integrasi FilterCommunity
                FilterCommunity(
                    selectedCategory = selectedCategory,
                    onCategorySelected = { category ->
                        selectedCategory = category
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(posts, key = { it.timestamp }) { post ->
                        Column {
                            PostCommunity(
                                posted = Community(
                                    id = post.timestamp.toInt(), // Asumsi timestamp sebagai ID unik
                                    user = "Anonymous", // Ganti dengan user sebenarnya jika tersedia
                                    userPhoto = null,
                                    title = post.title,
                                    content = post.content,
                                    picture = null,
                                    muchLike = 0,
                                    muchComment = 0,
                                    time = (System.currentTimeMillis() - post.timestamp).toInt() / 60000, // Hitung waktu dalam menit
                                    date = "Unknown" // Ganti dengan tanggal sebenarnya jika tersedia
                                )
                            ) { idCommunity ->
                                navController.navigate(Screen.CommunityDetail.route + "/$idCommunity")
                            }

                            // Tombol untuk menghapus post
                            Button(
                                onClick = {
                                    val postId = post.id
                                    Log.d("CommunityScreen", "Deleting post with ID: $postId")

                                    deletePostFromFirestore(postId,
                                        onSuccess = {
                                            coroutineScope.launch {
                                                posts = getPostsFromFirestore(
                                                    selectedCategory,
                                                    searchQuery
                                                )
                                            }
                                        },
                                        onFailure = { e ->
                                            Log.e("CommunityScreen", "Failed to delete post: ", e)
                                        })
                                },
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Text("Delete")
                            }

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}
